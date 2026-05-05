package patrones.estructurales.adapter;

// Interfaz moderna u objetivo (Target) que espera utilizar el nuevo sistema de E-Commerce
public interface ProcesadorPagosNuevo {
    // Método estandarizado para cobrar, usa un tipo de dato 'double' estándar en dólares
    // y un identificador de cuenta o tarjeta
    void cobrar(double montoDolares, String cuentaCliente);
}
