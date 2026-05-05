package patrones.estructurales.adapter;

// El Adaptador (Adapter): Esta clase hace de puente o traductor entre el sistema moderno y el antiguo
// Debe implementar la interfaz moderna (Target) para que el E-Commerce pueda usarlo sin problemas
public class AdaptadorCobroAntiguo implements ProcesadorPagosNuevo {
    // Composición: Mantiene una referencia al sistema antiguo (Adaptee) que debe envolver
    private SistemaCobroAntiguo sistemaViejo;

    // Constructor que exige inyectar la instancia del sistema viejo a adaptar
    public AdaptadorCobroAntiguo(SistemaCobroAntiguo sistemaViejo) {
        // Asigna la dependencia recibida a la variable de clase local
        this.sistemaViejo = sistemaViejo;
    }

    // Implementa el método moderno que exige la interfaz ProcesadorPagosNuevo
    @Override
    public void cobrar(double montoDolares, String cuentaCliente) {
        // Lógica de traducción o adaptación de datos
        // El sistema viejo requiere el monto en centavos (int), así que convertimos los dólares
        int montoEnCentavos = (int) Math.round(montoDolares * 100);
        
        // Imprime un registro para evidenciar que el adaptador está traduciendo los formatos
        System.out.println(">> (Adaptador) Traduciendo petición: $" + montoDolares + " USD -> " + montoEnCentavos + " centavos");
        
        // Delega la ejecución real al sistema legacy, ahora pasando los datos en el formato que este entiende
        this.sistemaViejo.procesarCobroLegacy(cuentaCliente, montoEnCentavos);
    }
}
