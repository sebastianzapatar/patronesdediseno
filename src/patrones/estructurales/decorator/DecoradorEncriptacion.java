package patrones.estructurales.decorator;

// Decorador concreto que extiende la clase envoltorio abstracta para añadir capacidades criptográficas
public class DecoradorEncriptacion extends DecoradorFuenteDatos {

    // Constructor que recibe el componente fuente a envolver y se lo pasa a la superclase
    public DecoradorEncriptacion(FuenteDatos envoltorio) {
        // Llama al constructor de DecoradorFuenteDatos para registrar el envoltorio internamente
        super(envoltorio);
    }

    // Sobrescribe el comportamiento base para interceptar los datos y alterarlos ANTES de escribirlos
    @Override
    public void escribirDatos(String datos) {
        // Ejecuta un método privado auxiliar para transformar y encriptar los datos de entrada
        String datosEncriptados = encriptar(datos);
        // Imprime un log informativo de que la capa de encriptación está actuando
        System.out.println(">> DecoradorEncriptacion actuando: Encriptando los datos antes de guardarlos...");
        // Llama al método original de la superclase (el objeto envuelto) para continuar la cadena, pero con datos encriptados
        super.escribirDatos(datosEncriptados);
    }

    // Sobrescribe el comportamiento base para interceptar los datos DESPUÉS de ser leídos y restaurarlos
    @Override
    public String leerDatos() {
        // Primero, delega la lectura cruda al componente original (obteniendo un texto cifrado)
        String datosLeidos = super.leerDatos();
        // Imprime un log informativo de que la capa de desencriptación está restaurando la información
        System.out.println("<< DecoradorEncriptacion actuando: Desencriptando los datos recién leídos...");
        // Pasa los datos leídos por la rutina de desencriptación y devuelve el resultado en texto claro al cliente
        return desencriptar(datosLeidos);
    }

    // Método privado auxiliar que simula un algoritmo complejo de cifrado (invirtiendo la cadena)
    private String encriptar(String datos) {
        // Usamos StringBuilder para invertir los caracteres del texto original como simulación básica
        String datosAlReves = new StringBuilder(datos).reverse().toString();
        // Añade una etiqueta de cabecera 'ENCR_' para identificar que el string está cifrado y lo retorna
        return "ENCR_" + datosAlReves;
    }

    // Método privado auxiliar que simula el algoritmo para descifrar y restaurar los datos
    private String desencriptar(String datos) {
        // Comprueba si los datos recuperados tienen la marca de agua de nuestra encriptación
        if (datos.startsWith("ENCR_")) {
            // Elimina la cabecera 'ENCR_' cortando los primeros 5 caracteres usando substring
            String sinPrefijo = datos.substring(5);
            // Vuelve a invertir la cadena para recuperar el sentido original y legible del texto
            return new StringBuilder(sinPrefijo).reverse().toString();
        }
        // Si la cadena no estaba encriptada (por algún motivo), la devolvemos intacta para evitar errores
        return datos;
    }
}
