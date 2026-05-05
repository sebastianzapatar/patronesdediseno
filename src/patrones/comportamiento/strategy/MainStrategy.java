package patrones.comportamiento.strategy;

// Clase principal ejecutable para probar el funcionamiento dinámico del patrón Strategy
public class MainStrategy {
    // Método principal de Java para arrancar la simulación
    public static void main(String[] args) {
        // Datos de muestra: un paquete pesado a una distancia lejana
        double pesoPaquete = 10.0; // kilos
        double distanciaRuta = 500.0; // kilometros

        // Creamos nuestro "Contexto", el motor de cálculo de nuestra tienda online
        CalculadoraEnvios calculadora = new CalculadoraEnvios();

        System.out.println("--- Cotización 1: Cliente elige opción barata ---");
        // Configuramos la calculadora con el algoritmo de costo Estándar
        calculadora.setEstrategia(new EnvioEstandar());
        // Solicitamos la cotización y almacenamos el resultado
        double costoEstandar = calculadora.procesarCotizacion(pesoPaquete, distanciaRuta);
        // Imprimimos el total formateado
        System.out.println("Total a pagar: $" + costoEstandar + "\n");

        System.out.println("--- Cotización 2: Cliente tiene prisa y cambia a Express ---");
        // ¡Magia del patrón Strategy! Cambiamos el comportamiento en tiempo de ejecución sin alterar el contexto
        calculadora.setEstrategia(new EnvioExpress());
        // Volvemos a cotizar exactamente el mismo paquete, pero ahora el cálculo interno es diferente
        double costoExpress = calculadora.procesarCotizacion(pesoPaquete, distanciaRuta);
        // Imprimimos el nuevo total formateado
        System.out.println("Total a pagar: $" + costoExpress + "\n");
    }
}
