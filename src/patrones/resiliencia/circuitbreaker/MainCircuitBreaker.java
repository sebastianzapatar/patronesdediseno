package patrones.resiliencia.circuitbreaker;

// Clase ejecutable principal para simular una ráfaga agresiva de peticiones y ver al Circuit Breaker trabajar
public class MainCircuitBreaker {
    // Entrada principal de la JVM
    public static void main(String[] args) {
        // Instanciamos nuestro servicio simulado que falla el 70% de las veces
        ServicioRemoto bancoInestable = new ServicioPagoRemoto();
        // Le colocamos la coraza protectora del Circuit Breaker envolviéndolo
        CircuitBreaker breaker = new CircuitBreaker(bancoInestable);

        System.out.println("--- Iniciando Simulación de Tráfico con Circuit Breaker ---");
        // Hacemos un bucle for simulando 15 peticiones web consecutivas entrando a nuestro servidor
        for (int i = 1; i <= 15; i++) {
            // Hacemos que el hilo duerma medio segundo para no saturar la consola y simular peticiones reales
            try { Thread.sleep(500); } catch (Exception ignored) {}
            
            // Imprimimos el ID de la petición en curso
            System.out.print("Petición #" + i + " -> ");
            // En vez de llamar a 'bancoInestable.procesarPago()', llamamos a nuestra capa protectora
            String resultado = breaker.llamarServicio("TXN-100" + i);
            // Mostramos si falló por la API, si tuvo éxito, o si el Breaker la rechazó (Fail-Fast)
            System.out.println(resultado);
            
            // Al llegar a la petición número 8, forzamos un parón global simulando que los usuarios dejaron de intentar
            if (i == 8) {
                System.out.println("\n[PAUSA SIMULADA] Parando el tráfico 4 segundos para dejar que el circuito inicie prueba de curación...\n");
                // Dormimos 4 segundos (supera el umbral de 3 seg de TIEMPO_ESPERA_MS del Breaker)
                try { Thread.sleep(4000); } catch (Exception ignored) {}
            }
        }
    }
}
