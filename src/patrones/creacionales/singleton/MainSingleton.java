package patrones.creacionales.singleton;

// Clase principal para probar el patrón Singleton de forma secuencial y sencilla
public class MainSingleton {
    // Método de entrada principal de la aplicación Java
    public static void main(String[] args) {
        // Título de la prueba en consola
        System.out.println("--- Prueba de Singleton Básico Secuencial ---");
        
        // 1. Simulamos un módulo del programa pidiendo la base de datos por primera vez
        System.out.println("Solicitando la primera conexión (Módulo de Ventas)...");
        // Llamamos al método estático. Como es la primera vez, el objeto se creará.
        ConexionBaseDatos conexionVentas = ConexionBaseDatos.getInstancia();
        // Usamos la conexión obtenida para ejecutar una operación
        conexionVentas.ejecutarQuery("SELECT * FROM facturas");
        
        // Salto de línea visual
        System.out.println("");
        
        // 2. Simulamos otro módulo totalmente distinto pidiendo conexión tiempo después
        System.out.println("Solicitando la segunda conexión (Módulo de Recursos Humanos)...");
        // Llamamos al mismo método. Esta vez, NO debe crearse un objeto nuevo, devolverá el mismo.
        ConexionBaseDatos conexionRRHH = ConexionBaseDatos.getInstancia();
        // Usamos esta "nueva" variable para ejecutar otra operación
        conexionRRHH.ejecutarQuery("SELECT * FROM empleados");
        
        // Salto de línea visual
        System.out.println("");
        
        // 3. Comprobación matemática para confirmar la teoría del Singleton
        System.out.println("¿Ambas variables apuntan a la MISMA instancia en memoria?");
        
        // En Java, el operador '==' en objetos compara sus referencias (direcciones de memoria)
        if (conexionVentas == conexionRRHH) {
            // Si entra aquí, significa que ambas variables controlan exactamente al mismo objeto
            System.out.println("-> SÍ. ¡El patrón Singleton funciona correctamente!");
            // Imprimimos el "Hash Code" (ID de memoria) de ambos para dar evidencia visual
            System.out.println("-> ID de Memoria (Ventas): " + conexionVentas.hashCode());
            System.out.println("-> ID de Memoria (RRHH)  : " + conexionRRHH.hashCode());
        } else {
            // Si el Singleton estuviera mal programado, entraría aquí
            System.out.println("-> NO. Hay un error, se crearon múltiples instancias.");
        }
    }
}
