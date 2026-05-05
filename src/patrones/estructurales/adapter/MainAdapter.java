package patrones.estructurales.adapter;

// Clase principal que hace las veces de Cliente para testear el patrón Adapter
public class MainAdapter {
    // Función main para ejecutar la demostración
    public static void main(String[] args) {
        // Creamos una instancia del sistema antiguo que está en producción y es funcional
        SistemaCobroAntiguo legacyBank = new SistemaCobroAntiguo();

        // Creamos nuestro adaptador y le "pasamos" el sistema antiguo para que lo envuelva
        // A partir de este momento, el E-Commerce (cliente) ve al adaptador como un sistema Moderno
        ProcesadorPagosNuevo adaptador = new AdaptadorCobroAntiguo(legacyBank);

        System.out.println("--- Ejecutando pasarela de pagos desde el nuevo E-Commerce ---");
        // El nuevo E-Commerce solicita un cobro usando su contrato moderno (Dólares, double)
        // El cliente (Main) ignora completamente la existencia del sistema en centavos
        double facturaTotal = 49.99;
        String cuentaUsuario = "ACC-998877";

        // Invocamos el método moderno en la interfaz adaptada. El puente hará la magia
        adaptador.cobrar(facturaTotal, cuentaUsuario);
    }
}
