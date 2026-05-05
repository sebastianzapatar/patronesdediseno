package patrones.comportamiento.observer;

// Interfaz que define la estructura común de los "Suscriptores" o entidades que observan
public interface Observador {
    // Método de devolución de llamada (callback) que el Sujeto invocará automáticamente cuando hayan novedades
    // En este caso especializado, el sujeto enviará la clave de la acción y su nuevo precio valorado
    void actualizar(String nombreAccion, double nuevoPrecio);
}
