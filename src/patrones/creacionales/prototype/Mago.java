package patrones.creacionales.prototype;

// --- PROTOTIPO CONCRETO 2 ---
// Esta clase representa otro tipo de personaje que puede ser clonado masivamente.

public class Mago extends Personaje {
    // Atributos específicos exclusivos de los magos
    private int manaMagico;
    private int inteligencia;

    // Constructor original: Representa el ensamblaje pesado del objeto original
    public Mago() {
        super();
        System.out.println("=> Creando MAGO desde cero... (Proceso costoso)");
        this.nivel = 1;
        this.puntosVida = 800; // Baja vida
        this.manaMagico = 2000; // Mucho maná
        this.inteligencia = 100;
    }

    // Constructor copia específico para el Mago
    public Mago(Mago objetivo) {
        // Pasa el objeto al constructor padre para clonar la parte genérica y la lista de habilidades
        super(objetivo);
        
        // Copia exacta de las estadísticas exclusivas del mago
        if (objetivo != null) {
            this.manaMagico = objetivo.manaMagico;
            this.inteligencia = objetivo.inteligencia;
        }
    }

    // Implementación del contrato de clonación
    @Override
    public Personaje clonar() {
        // Devuelve una réplica exacta alojada en un nuevo espacio de memoria
        return new Mago(this);
    }
}
