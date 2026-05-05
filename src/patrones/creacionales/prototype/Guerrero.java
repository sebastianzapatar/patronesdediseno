package patrones.creacionales.prototype;

// --- PROTOTIPO CONCRETO 1 ---
// Esta clase representa un tipo específico de personaje que puede ser clonado.

public class Guerrero extends Personaje {
    // Atributo específico de los guerreros
    private int armaduraPesada;
    private int fuerzaFisica;

    // Constructor original: Simula un proceso pesado de creación (ej. carga desde Base de Datos)
    public Guerrero() {
        super();
        System.out.println("=> Creando GUERRERO desde cero... (Proceso costoso)");
        this.nivel = 1;
        this.puntosVida = 1500; // Alta vida
        this.armaduraPesada = 300;
        this.fuerzaFisica = 50;
    }

    // Constructor copia específico para el Guerrero
    public Guerrero(Guerrero objetivo) {
        // Llama al constructor copia del padre para clonar nombre, nivel y habilidades (Deep Copy)
        super(objetivo);
        
        // Clona los atributos específicos de esta clase
        if (objetivo != null) {
            this.armaduraPesada = objetivo.armaduraPesada;
            this.fuerzaFisica = objetivo.fuerzaFisica;
        }
    }

    // Implementación obligatoria del método clonar
    @Override
    public Personaje clonar() {
        // Utiliza el constructor copia para devolver una instancia completamente nueva e independiente
        return new Guerrero(this);
    }
}
