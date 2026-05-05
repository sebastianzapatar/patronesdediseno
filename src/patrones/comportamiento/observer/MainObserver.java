package patrones.comportamiento.observer;

// Clase principal autoejecutable para comprobar y simular el ecosistema del patrón Observer
public class MainObserver {
    // Método 'main' estandar de ejecución de Java
    public static void main(String[] args) {
        // 1. Fase de inicialización: Creamos al sujeto que será vigilado por todos (Ej. Las acciones de Tesla)
        AccionBursatil accionTesla = new AccionBursatil("TSLA", 130.0);

        // 2. Fase de instanciación de dependencias: Creamos nuestros agentes de bolsa u observadores autónomos
        InversorInstitucional jpMorgan = new InversorInstitucional("Fondo JPMorgan");
        InversorInstitucional blackRock = new InversorInstitucional("Grupo BlackRock");

        // 3. Fase de suscripción: Los fondos de inversión se registran oficialmente para observar la acción de Tesla
        accionTesla.registrarObservador(jpMorgan);
        accionTesla.registrarObservador(blackRock);

        // 4. Inicia la simulación de bolsa: El mercado abre y Tesla sufre una dura caída (De 130 baja a 95.5)
        // Este solo método ('setPrecio') disparará de forma mágica las notificaciones hacia todos los observadores
        accionTesla.setPrecio(95.5);

        // El mercado es volátil y ahora sufre una subida explosiva cruzando la barrera de los 150 USD
        accionTesla.setPrecio(160.0);
        
        // 5. Fase de alteración del ecosistema: El grupo BlackRock decide que ya no quiere invertir más en Tesla
        // Por lo tanto, solicitan cancelar su suscripción activa removiéndose de la lista de notificaciones
        accionTesla.removerObservador(blackRock);
        // Dejamos un registro en consola para dejar en claro el cambio de estado en la membresía
        System.out.println("\n[Información] El Grupo BlackRock ha cancelado su suscripción y dejado de observar a TSLA.");

        // 6. Nueva simulación del mercado: Tesla sufre otra corrección a la baja estabilizándose en 110 USD
        // IMPORTANTE: En este punto, SÓLO el fondo JPMorgan debería ser notificado de este suceso, BlackRock no.
        accionTesla.setPrecio(110.0);
    }
}
