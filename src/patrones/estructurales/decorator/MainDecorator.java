package patrones.estructurales.decorator;

// Clase principal ejecutable para probar el funcionamiento robusto del patrón Decorator
public class MainDecorator {
    // Método principal de ejecución (entry point de la aplicación Java)
    public static void main(String[] args) {
        // Definimos una variable con datos confidenciales en texto plano que queremos asegurar
        String informacionSensible = "Contraseña de la base de datos: admin123";

        // 1. Instanciamos el componente "Base" concreto, simulando un archivo común de texto plano
        FuenteDatos fuenteBasica = new ArchivoFuenteDatos("configuracion_segura.txt");
        
        // 2. Instanciamos un Decorador y le "envolvemos" nuestra fuente básica de archivos
        // A partir de aquí, interactuamos con la capa decorada como si fuera el archivo normal
        FuenteDatos fuenteCifrada = new DecoradorEncriptacion(fuenteBasica);

        // Imprimimos en consola un divisor para identificar la fase de escritura
        System.out.println("--- Inicio del Proceso de Escritura Estructurado ---");
        // Mandamos a escribir usando el decorador: este atrapará el texto, lo cifrará y luego lo mandará al archivo
        fuenteCifrada.escribirDatos(informacionSensible);

        // Imprimimos en consola un divisor para identificar la fase de lectura y recuperación
        System.out.println("\n--- Inicio del Proceso de Lectura Estructurado ---");
        // Mandamos a leer usando el decorador: este pedirá el texto al archivo (cifrado) y luego lo descifrará para nosotros
        String textoRecuperado = fuenteCifrada.leerDatos();
        
        // Finalmente mostramos en la terminal el resultado descifrado transparente para el usuario final
        System.out.println("\nDatos recuperados con éxito: " + textoRecuperado);
    }
}
