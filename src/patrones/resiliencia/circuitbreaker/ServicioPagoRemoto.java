package patrones.resiliencia.circuitbreaker;

// Importamos la utilidad de aleatoriedad
import java.util.Random;

// Implementación concreta de un microservicio de terceros (Ej: Pasarela bancaria) muy inestable
public class ServicioPagoRemoto implements ServicioRemoto {
    // Generador de números aleatorios para simular fallas intermitentes en la red o base de datos
    private Random random = new Random();

    // Sobrescritura de la función de procesamiento de pagos
    @Override
    public String procesarPago(String idTransaccion) throws Exception {
        // Generamos un número aleatorio entero entre 0 y 9
        int probabilidadFallo = random.nextInt(10);
        
        // Simulamos que el 70% de las veces la API externa está caída o devolviendo Timeout
        if (probabilidadFallo < 7) {
            // Forzamos el lanzamiento de una excepción para simular el fallo catastrófico (Error 500/504)
            throw new Exception("Error 504: Gateway Timeout o saturación en el servicio del banco.");
        }
        
        // Si sobrevivimos a la probabilidad de fallo, retornamos la cadena de éxito
        return "Transacción " + idTransaccion + " procesada exitosamente en el servidor del banco.";
    }
}
