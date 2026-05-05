package patrones.resiliencia.circuitbreaker;

// Clase principal del patrón Circuit Breaker que sirve de proxy o envoltura protectora para servicios frágiles
public class CircuitBreaker {
    // Referencia al servicio remoto real (propenso a fallar) que estamos protegiendo
    private ServicioRemoto servicioInterno;
    // Variable de control del estado actual de la compuerta (Empieza CERRADO para permitir tráfico normal)
    private EstadoCircuito estadoActual = EstadoCircuito.CERRADO;
    
    // Configuración clave: Cuántas fallas continuas toleramos antes de abrir el circuito y detener el tráfico
    private final int UMBRAL_FALLAS = 3;
    // Variable de estado: Contador de fallas consecutivas acumuladas actualmente
    private int contadorFallas = 0;
    
    // Configuración clave: Cuánto tiempo (en milisegundos) esperamos en estado ABIERTO antes de probar suerte
    private final long TIEMPO_ESPERA_MS = 3000; // 3 segundos fijos de enfriamiento
    // Variable de estado: Guarda la marca de tiempo (timestamp) en la que el circuito colapsó por última vez
    private long ultimoTiempoFallo = 0;

    // Constructor que exige inyectar la dependencia del servicio inestable
    public CircuitBreaker(ServicioRemoto servicio) {
        // Guarda la referencia del servicio a proteger
        this.servicioInterno = servicio;
    }

    // Método expuesto al cliente. Nunca deben llamar a la API real, siempre a este método.
    public String llamarServicio(String idTransaccion) {
        // Regla de transición de tiempo: verificamos si es hora de pasar de ABIERTO a SEMI-ABIERTO
        evaluarEstadoTiempo();

        // FAIL-FAST: Si el circuito está ABIERTO, rechazamos la petición inmediatamente sin consumir hilos de red
        if (this.estadoActual == EstadoCircuito.ABIERTO) {
            // Retornamos de inmediato salvando a nuestra aplicación de quedarse colgada esperando
            return "[CircuitBreaker] CIRCUITO ABIERTO -> Rechazo rápido preventivo. Servicio caído.";
        }

        // Bloque de ejecución segura controlando excepciones del exterior
        try {
            // Intentamos ejecutar la llamada de red sincrónica hacia el servicio problemático
            String respuesta = servicioInterno.procesarPago(idTransaccion);
            // Si el código llega aquí, fue un éxito. Invocamos lógica de limpieza.
            exitoAlLlamar();
            // Retornamos el éxito al cliente
            return "[ÉXITO API] " + respuesta;
        } catch (Exception e) {
            // Si el servicio remoto reventó o hizo timeout, atrapamos el error
            falloAlLlamar(e.getMessage());
            // Aplicamos un Fallback básico (o retornamos el error controlado)
            return "[FALLO API] Intento fallido: " + e.getMessage();
        }
    }

    // Lógica privada para manejar estadísticamente los fallos ocurridos
    private void falloAlLlamar(String mensajeError) {
        // Incrementamos el contador de alertas
        contadorFallas++;
        // Verificamos si alcanzamos el punto de quiebre (umbral)
        if (contadorFallas >= UMBRAL_FALLAS) {
            // Abrimos el circuito (levantamos la barrera)
            this.estadoActual = EstadoCircuito.ABIERTO;
            // Registramos la hora exacta en que se detuvo el tráfico para calcular el enfriamiento luego
            this.ultimoTiempoFallo = System.currentTimeMillis();
            // Alerta crítica de sistema
            System.err.println(">>>> [CRÍTICO] Múltiples fallos detectados. Cambiando a estado ABIERTO.");
        }
    }

    // Lógica privada para resetear la salud del sistema tras una petición exitosa
    private void exitoAlLlamar() {
        // Un éxito limpia el historial de fallas completamente
        contadorFallas = 0;
        // Si el estado era de prueba (SEMI_ABIERTO), y funcionó, significa que el servicio "sanó"
        if (this.estadoActual == EstadoCircuito.SEMI_ABIERTO) {
            // Restauramos el flujo normal cerrando la barrera
            this.estadoActual = EstadoCircuito.CERRADO;
            // Emitimos aviso de salud restaurada
            System.out.println(">>>> [RECUPERACIÓN] El servicio de prueba fue exitoso. Circuito nuevamente CERRADO.");
        }
    }

    // Lógica privada para la auto-curación del sistema basada en el paso del tiempo
    private void evaluarEstadoTiempo() {
        // Solo aplica si el sistema está colapsado actualmente
        if (this.estadoActual == EstadoCircuito.ABIERTO) {
            // Calculamos los milisegundos desde el último desastre
            long tiempoTranscurrido = System.currentTimeMillis() - ultimoTiempoFallo;
            // Si ya cumplió su condena de tiempo de espera...
            if (tiempoTranscurrido > TIEMPO_ESPERA_MS) {
                // Pasamos a fase de prueba para dejar colar un par de peticiones "conejillo de indias"
                this.estadoActual = EstadoCircuito.SEMI_ABIERTO;
                // Aviso de transición de estado
                System.out.println(">>>> [TIMEOUT] El tiempo de espera concluyó. Circuito en SEMI_ABIERTO, iniciando prueba de carga...");
            }
        }
    }
}
