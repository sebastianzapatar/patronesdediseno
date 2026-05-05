package patrones.estructurales.decorator;

// Componente concreto que implementa la interfaz base simulando un sistema de archivos real
public class ArchivoFuenteDatos implements FuenteDatos {
    // Atributo privado que simulará el nombre físico del archivo guardado en el disco
    private String nombreArchivo;
    // Atributo privado para simular el almacenamiento y persistencia del contenido en la memoria ram
    private String contenidoSimulado;

    // Constructor de la clase que exige definir el nombre del archivo al ser instanciado
    public ArchivoFuenteDatos(String nombreArchivo) {
        // Asigna el valor proporcionado al atributo correspondiente del objeto
        this.nombreArchivo = nombreArchivo;
        // Inicializa el contenido simulado como una cadena de texto vacía (archivo en blanco)
        this.contenidoSimulado = "";
    }

    // Implementación concreta del método para escribir datos, simulando persistencia en disco
    @Override
    public void escribirDatos(String datos) {
        // Muestra en consola una traza para evidenciar que la escritura básica está ocurriendo
        System.out.println("Escribiendo datos básicos en el archivo físico: " + nombreArchivo + "...");
        // Reemplaza el contenido simulado existente por los nuevos datos proporcionados
        this.contenidoSimulado = datos;
    }

    // Implementación concreta del método para leer datos, simulando una carga desde el disco duro
    @Override
    public String leerDatos() {
        // Muestra en consola una traza para evidenciar que la lectura básica está ocurriendo
        System.out.println("Leyendo datos básicos desde el archivo físico: " + nombreArchivo + "...");
        // Retorna el contenido de texto que había sido guardado previamente
        return this.contenidoSimulado;
    }
}
