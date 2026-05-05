package patrones.comportamiento.observer;

// Clase que representa un Observador concreto (Suscriptor), en este caso una entidad de inversión reaccionando al mercado
public class InversorInstitucional implements Observador {
    // Cadena de texto que sirve para identificar unívocamente el nombre del fondo de inversión o agencia
    private String nombreAgencia;

    // Constructor que exige proveer el nombre de la agencia en el momento de crear su instancia
    public InversorInstitucional(String nombreAgencia) {
        // Asignación simple del valor por parámetro a nuestra variable de clase privada
        this.nombreAgencia = nombreAgencia;
    }

    // Implementación del método obligatorio de la interfaz Observador, que es el punto de entrada de la notificación
    @Override
    public void actualizar(String nombreAccion, double nuevoPrecio) {
        // Primero confirmamos recibo de la notificación, identificando qué agencia está procesando el aviso
        System.out.print(" -> Agencia Inversora [" + nombreAgencia + "] recibió el reporte de " + nombreAccion + ". ");
        
        // Bloque de lógica de negocio o sistema de trading automático reaccionando inteligentemente al nuevo estado
        if (nuevoPrecio < 100) {
            // Si el precio cae por debajo del umbral psicológico de 100, el algoritmo lo ve barato
            System.out.println("Análisis: El precio de " + nombreAccion + " esta subvaluado. Decisión automática: COMPRAR ACCIONES.");
        } else if (nuevoPrecio > 150) {
            // Si el precio sube por encima de la resistencia de 150, el algoritmo lo considera riesgoso y asegura profit
            System.out.println("Análisis: El precio de " + nombreAccion + " esta sobrecomprado. Decisión automática: VENDER ACCIONES.");
        } else {
            // Si el precio se mantiene en el rango medio (entre 100 y 150), no se toma una posición agresiva
            System.out.println("Análisis: El precio es estable dentro del margen normal. Decisión automática: MANTENER POSICIÓN.");
        }
    }
}
