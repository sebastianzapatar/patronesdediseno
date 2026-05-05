package patrones.creacionales.factory;

// Subclase creadora concreta encargada exclusivamente de instanciar notificaciones por Email
public class CreadorEmail extends CreadorNotificaciones {

    // Sobrescribe el Factory Method de la clase padre abstracta
    @Override
    public Notificacion crearNotificacion() {
        // Inicializa y devuelve una instancia concreta del producto NotificacionEmail
        // De esta forma encapsulamos la complejidad de crear el objeto Email aquí
        return new NotificacionEmail();
    }
}
