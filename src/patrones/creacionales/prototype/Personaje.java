package patrones.creacionales.prototype;

import java.util.ArrayList;
import java.util.List;

// --- INTERFAZ PROTOTIPO (CLASE BASE) ---
// Actúa como el molde general. Implementa Cloneable nativo de Java
// pero define su propio método clonar() para garantizar una clonación profunda.

public abstract class Personaje implements Cloneable {
    // Atributos base que todo personaje tendrá
    protected String nombre;
    protected int nivel;
    protected int puntosVida;
    protected String faccion;
    
    // Lista de objetos complejos. Aquí radica la importancia de la clonación profunda.
    // Si solo hacemos 'super.clone()', la lista sería compartida por todos los clones.
    protected List<Habilidad> habilidades;

    // Constructor vacío por defecto
    public Personaje() {
        // Inicializamos la lista para evitar NullPointerExceptions
        this.habilidades = new ArrayList<>();
    }

    // Constructor de copia (La magia del patrón Prototype)
    // Copia minuciosamente los estados de otro objeto 'Personaje'
    public Personaje(Personaje objetivo) {
        if (objetivo != null) {
            this.nombre = objetivo.nombre;
            this.nivel = objetivo.nivel;
            this.puntosVida = objetivo.puntosVida;
            this.faccion = objetivo.faccion;
            
            // Clonación Profunda (Deep Copy) de la lista de habilidades
            this.habilidades = new ArrayList<>();
            for (Habilidad h : objetivo.habilidades) {
                // Usamos el constructor copia de Habilidad para crear una instancia nueva en memoria
                this.habilidades.add(new Habilidad(h));
            }
        }
    }

    // Método abstracto que obliga a los hijos a implementar su propio clon
    public abstract Personaje clonar();

    // Método para añadir habilidades al personaje
    public void agregarHabilidad(Habilidad habilidad) {
        this.habilidades.add(habilidad);
    }

    // Setters básicos
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setFaccion(String faccion) { this.faccion = faccion; }

    // Método para mostrar el estado completo del personaje en memoria
    public void mostrarEstado() {
        System.out.println("-------------------------------------------------");
        System.out.println("Personaje: " + nombre + " | Facción: " + faccion);
        System.out.println("Nivel: " + nivel + " | HP: " + puntosVida);
        System.out.println("Habilidades en memoria: " + habilidades);
        System.out.println("Firma de memoria (Hash): " + this.hashCode());
        System.out.println("-------------------------------------------------");
    }
}
