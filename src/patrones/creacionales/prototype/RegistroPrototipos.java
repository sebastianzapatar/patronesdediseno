package patrones.creacionales.prototype;

import java.util.HashMap;
import java.util.Map;

// --- REGISTRO DE PROTOTIPOS (PROTOTYPE REGISTRY) ---
// Esta clase actúa como un caché. Almacena las instancias originales "vírgenes"
// y se encarga de devolver clones listos para usar cada vez que el cliente los pida,
// evitando así que el cliente tenga que usar la palabra 'new' o ensamblar objetos.

public class RegistroPrototipos {
    // Un mapa para almacenar los moldes base catalogados por un ID o llave String
    private Map<String, Personaje> cachePrototipos = new HashMap<>();

    // Constructor que precarga la memoria con los modelos base
    public RegistroPrototipos() {
        // 1. Fabricamos el "Molde" base del Guerrero
        Guerrero moldeGuerrero = new Guerrero();
        moldeGuerrero.setNombre("Guerrero Genérico");
        moldeGuerrero.setFaccion("Alianza del Norte");
        moldeGuerrero.agregarHabilidad(new Habilidad("Golpe de Escudo", 50, "Aturde al enemigo"));
        moldeGuerrero.agregarHabilidad(new Habilidad("Corte Cruzado", 120, "Ataque con espada doble"));
        
        // Lo guardamos en el caché
        cachePrototipos.put("GUERRERO_BASE", moldeGuerrero);

        // 2. Fabricamos el "Molde" base del Mago
        Mago moldeMago = new Mago();
        moldeMago.setNombre("Mago Genérico");
        moldeMago.setFaccion("Gremio Arcano");
        moldeMago.agregarHabilidad(new Habilidad("Bola de Fuego", 250, "Quema en área"));
        moldeMago.agregarHabilidad(new Habilidad("Teletransporte", 0, "Movimiento instantáneo"));
        
        // Lo guardamos en el caché
        cachePrototipos.put("MAGO_BASE", moldeMago);
    }

    // Método principal del registro: Devuelve un CLON del prototipo solicitado
    public Personaje obtenerClon(String tipo) {
        // Buscamos el molde en el mapa
        Personaje molde = cachePrototipos.get(tipo);
        if (molde != null) {
            // ¡MAGIA! En lugar de devolver el molde, devolvemos una copia exacta de él
            return molde.clonar();
        }
        throw new IllegalArgumentException("No existe un prototipo para el tipo: " + tipo);
    }
}
