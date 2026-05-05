package patrones.estructurales.decorator;

// Clase abstracta central del patrón Decorator; actúa como envoltorio (wrapper) genérico e implementa el tipo base
public abstract class DecoradorFuenteDatos implements FuenteDatos {
    // Atributo protegido que mantiene la referencia al objeto original que está siendo envuelto/decorado
    protected FuenteDatos envoltorio;

    // Constructor que exige recibir un componente concreto u otro decorador para poder "envolverlo"
    public DecoradorFuenteDatos(FuenteDatos envoltorio) {
        // Almacena el componente recibido dentro de nuestra variable de clase protegida
        this.envoltorio = envoltorio;
    }

    // Sobrescritura de la operación de escritura por defecto para el decorador
    @Override
    public void escribirDatos(String datos) {
        // La implementación base del decorador simplemente delega (reenvía) la ejecución al objeto envuelto
        envoltorio.escribirDatos(datos);
    }

    // Sobrescritura de la operación de lectura por defecto para el decorador
    @Override
    public String leerDatos() {
        // Al igual que la escritura, delega la acción de leer al objeto que ha sido envuelto y retorna su resultado
        return envoltorio.leerDatos();
    }
}
