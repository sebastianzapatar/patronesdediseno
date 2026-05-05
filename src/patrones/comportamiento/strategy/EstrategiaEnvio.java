package patrones.comportamiento.strategy;

// Interfaz genérica que define la "Estrategia" o algoritmo encapsulado
// Se encarga de definir un contrato común para cualquier fórmula de cálculo de envíos
public interface EstrategiaEnvio {
    // Método que cada tipo de envío (Estándar, Express, etc.) implementará a su manera
    // Recibe el peso del paquete (kg) y la distancia al destino (km)
    double calcularCosto(double pesoKilogramos, double distanciaKilometros);
}
