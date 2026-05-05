package patrones.comportamiento.observer;

// Interfaz genérica que define el contrato estándar que deben seguir los "Publicadores" o Sujetos
public interface Sujeto {
    // Método obligatorio para que los clientes puedan suscribirse y empezar a observar este sujeto
    void registrarObservador(Observador o);
    
    // Método obligatorio para que los clientes puedan anular su suscripción y dejar de ser notificados
    void removerObservador(Observador o);
    
    // Método interno/externo que se dispara para avisar activamente a todos los suscriptores sobre un cambio de estado
    void notificarObservadores();
}
