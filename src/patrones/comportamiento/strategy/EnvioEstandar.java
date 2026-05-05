package patrones.comportamiento.strategy;

// Clase que representa una estrategia concreta (algoritmo A) para un envío tradicional o estándar
public class EnvioEstandar implements EstrategiaEnvio {

    // Implementa la fórmula de cálculo específica de la logística por camiones regulares
    @Override
    public double calcularCosto(double pesoKilogramos, double distanciaKilometros) {
        // Imprime un rastro visual para denotar qué estrategia está en ejecución
        System.out.println("[Estrategia] Utilizando algoritmo de Envío Estándar (Camión)");
        // El costo base del servicio es de 5 dólares fijos
        double tarifaBase = 5.0;
        // Se cobra 0.1 dólares por cada kilómetro recorrido
        double costoDistancia = distanciaKilometros * 0.1;
        // Retorna la suma total que cuesta enviar mediante esta modalidad
        return tarifaBase + costoDistancia;
    }
}
