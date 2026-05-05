package patrones.estructurales.decorator;

// Interfaz componente principal que define las operaciones estándar que todo origen de datos debe soportar
public interface FuenteDatos {
    // Método abstracto que define la firma para escribir un bloque de datos en la fuente de destino
    void escribirDatos(String datos);
    
    // Método abstracto que define la firma para leer todos los datos existentes y retornarlos en forma de cadena
    String leerDatos();
}
