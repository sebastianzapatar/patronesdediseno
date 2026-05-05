package patrones.creacionales.prototype;

// --- CLIENTE PRINCIPAL DEL PATRÓN PROTOTYPE ---
// Esta clase demuestra cómo podemos spawnear (generar) múltiples personajes
// copiando moldes prefabricados, en lugar de instanciarlos línea por línea.

public class MainPrototype {
    
    public static void main(String[] args) {
        System.out.println("=== INICIANDO SISTEMA DE CLONACIÓN DE PERSONAJES ===");
        System.out.println("1. Cargando moldes base en memoria (Registro)...");
        
        // Al inicializar el registro, se "fabrican" los moldes originales.
        // Verás en consola los mensajes de "Creando... (Proceso costoso)" SOLO UNA VEZ.
        RegistroPrototipos fabricaClones = new RegistroPrototipos();
        
        System.out.println("\n2. Spawneando un ejército de clones instantáneamente sin el operador 'new'...");
        
        // Obtenemos un clon exacto del Guerrero base
        Personaje guerreroClon1 = fabricaClones.obtenerClon("GUERRERO_BASE");
        // Lo personalizamos sin afectar al molde original
        guerreroClon1.setNombre("Arthur (Jugador 1)");
        
        // Obtenemos otro clon exacto del Guerrero base
        Personaje guerreroClon2 = fabricaClones.obtenerClon("GUERRERO_BASE");
        guerreroClon2.setNombre("Lancelot (NPC Enemigo)");
        guerreroClon2.setFaccion("Horda Invasora"); // Le cambiamos la facción
        
        // Obtenemos un clon del Mago base
        Personaje magoClon = fabricaClones.obtenerClon("MAGO_BASE");
        magoClon.setNombre("Merlín");

        System.out.println("\n--- VERIFICACIÓN DE CLONES ---");
        // Mostramos el estado en memoria de cada uno. 
        // Observa que los Hash (Firmas de memoria) son TOTALMENTE DIFERENTES.
        guerreroClon1.mostrarEstado();
        guerreroClon2.mostrarEstado();
        magoClon.mostrarEstado();
        
        // --- PRUEBA DE CLONACIÓN PROFUNDA (DEEP COPY) ---
        System.out.println("\n3. Alterando una habilidad del Jugador 1 para verificar que NO afecta a los demás...");
        
        // Como implementamos Clonación Profunda, al modificar la lista de Arthur, Lancelot no se entera.
        // Si fuera 'super.clone()' básico, ambos compartirían la misma lista en memoria y Lancelot también ganaría esta habilidad.
        guerreroClon1.agregarHabilidad(new Habilidad("Furia Divina", 500, "Ataque definitivo"));
        
        System.out.println("Estado final de Arthur:");
        guerreroClon1.mostrarEstado();
        
        System.out.println("Estado final de Lancelot (Sus habilidades deben seguir intactas):");
        guerreroClon2.mostrarEstado();
        
        System.out.println("=== CLONACIÓN PROFUNDA EJECUTADA CON ÉXITO ===");
    }
}
