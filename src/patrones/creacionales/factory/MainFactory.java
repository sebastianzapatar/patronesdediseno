package patrones.creacionales.factory;

// Clase principal para ejecutar y testear el patrón Factory Method
public class MainFactory {
    // Método de entrada de la aplicación
    public static void main(String[] args) {
        // Imaginemos que la configuración del usuario indica que prefiere Emails
        // Instanciamos el creador específico para Emails de forma polimórfica
        CreadorNotificaciones creadorPrimario = new CreadorEmail();
        
        System.out.println("--- Proceso de Notificación por Email ---");
        // El cliente solo llama a la lógica de negocio; internamente se crea el objeto Email
        creadorPrimario.procesarYEnviar("Su pedido ha sido despachado", "cliente@empresa.com");

        // Si el usuario cambia sus preferencias y ahora quiere SMS para alertas críticas
        // Instanciamos el creador para SMS
        CreadorNotificaciones creadorSecundario = new CreadorSMS();
        
        System.out.println("\n--- Proceso de Notificación por SMS ---");
        // Llamamos al mismo método genérico, pero ahora se comportará como un SMS automáticamente
        creadorSecundario.procesarYEnviar("ALERTA: Código de seguridad 4492", "+573001234567");
    }
}
