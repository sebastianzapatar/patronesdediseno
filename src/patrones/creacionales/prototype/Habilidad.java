package patrones.creacionales.prototype;

// --- PATRÓN PROTOTYPE ---
// Esta clase representa un objeto complejo anidado.
// Para que el patrón Prototype funcione correctamente, las referencias a objetos
// internos también deben clonarse (Clonación Profunda o Deep Copy), de lo contrario
// ambos clones apuntarían al mismo objeto en memoria.

public class Habilidad {
    // Nombre de la habilidad (ej. "Ataque Fuerte", "Bola de Fuego")
    private String nombre;
    // Nivel de daño o poder de la habilidad
    private int poder;
    // Descripción extensa de la habilidad
    private String descripcion;

    // Constructor que inicializa los valores de la habilidad
    public Habilidad(String nombre, int poder, String descripcion) {
        this.nombre = nombre;
        this.poder = poder;
        this.descripcion = descripcion;
    }

    // Constructor copia (usado para la clonación profunda)
    // Recibe un objeto del mismo tipo y copia sus valores a una nueva instancia
    public Habilidad(Habilidad otraHabilidad) {
        this.nombre = otraHabilidad.nombre;
        this.poder = otraHabilidad.poder;
        this.descripcion = otraHabilidad.descripcion;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public int getPoder() { return poder; }
    public void setPoder(int poder) { this.poder = poder; }

    // Representación en texto para depuración
    @Override
    public String toString() {
        return "Habilidad{" +
                "nombre='" + nombre + '\'' +
                ", poder=" + poder +
                '}';
    }
}
