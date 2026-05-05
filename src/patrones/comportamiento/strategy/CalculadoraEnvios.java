package patrones.comportamiento.strategy;

// Clase "Contexto" (Context). Es la que usará el cliente final para operar
// Posee una referencia a la Estrategia y puede intercambiarla dinámicamente en tiempo de ejecución
public class CalculadoraEnvios {
    // Referencia polimórfica a la estrategia de envío a utilizar
    private EstrategiaEnvio estrategia;

    // Constructor vacío opcional; la estrategia se puede inyectar luego
    public CalculadoraEnvios() {
    }

    // Método setter esencial en el patrón Strategy para permitir cambiar de algoritmo "on the fly" (al vuelo)
    public void setEstrategia(EstrategiaEnvio estrategia) {
        // Reemplaza la estrategia actual por la nueva recibida por parámetro
        this.estrategia = estrategia;
    }

    // Método expuesto al cliente que orquesta la ejecución, delegando el cálculo matemático a la estrategia
    public double procesarCotizacion(double peso, double distancia) {
        // Verificación de seguridad: comprueba si la estrategia no ha sido configurada
        if (this.estrategia == null) {
            // Lanza una excepción en tiempo de ejecución para advertir del mal uso de la clase
            throw new IllegalStateException("¡Debe establecer una estrategia de envío primero!");
        }
        // Delega la responsabilidad de calcular el número exacto al objeto estrategia actual
        return this.estrategia.calcularCosto(peso, distancia);
    }
}
