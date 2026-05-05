package patrones.resiliencia.circuitbreaker;

// Interfaz que simula el contrato de una llamada a un microservicio o API externa frágil
public interface ServicioRemoto {
    // Método que intenta procesar una operación crítica. Al lanzar Exception, declara que es propenso a fallos
    String procesarPago(String idTransaccion) throws Exception;
}
