package patrones.comportamiento.strategy;

// Clase que representa una estrategia concreta (algoritmo B) para un envío ultra rápido o express
public class EnvioExpress implements EstrategiaEnvio {

    // Implementa la fórmula de cálculo específica, que suele ser más costosa (ej. Avión o Camioneta exclusiva)
    @Override
    public double calcularCosto(double pesoKilogramos, double distanciaKilometros) {
        // Imprime un rastro visual para denotar qué estrategia prioritaria está en ejecución
        System.out.println("[Estrategia] Utilizando algoritmo de Envío Express (Aéreo)");
        // El costo base es más alto, 15 dólares fijos
        double tarifaBase = 15.0;
        // Se cobra más caro por kilómetro (0.3) y existe un recargo por peso del paquete
        double costoDistancia = distanciaKilometros * 0.3;
        double recargoPeso = pesoKilogramos * 2.0;
        // Retorna la suma total de variables correspondientes al servicio premium
        return tarifaBase + costoDistancia + recargoPeso;
    }
}
