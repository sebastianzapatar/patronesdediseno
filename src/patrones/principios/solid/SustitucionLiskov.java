package patrones.principios.solid;

// --- PRINCIPIO DE SUSTITUCIÓN DE LISKOV (LSP) ---
// Regla: "Las clases derivadas deben poder sustituir a sus clases base sin alterar el funcionamiento del programa."

// Clase base abstracta que representa a un ave genérica en el sistema.
// NOTA CLAVE: No incluimos el método 'volar()' aquí, porque biológicamente no TODAS las aves vuelan.
// Si lo incluyéramos, forzaríamos a las aves no voladoras a lanzar errores, rompiendo el principio de Liskov.
abstract class Ave {
    // Todas las aves (sin excepción) pueden alimentarse, así que este comportamiento es 100% seguro aquí.
    public abstract void comer();
}

// Sub-jerarquía intermedia exclusiva para agrupar a las aves que SÍ tienen la capacidad motriz de volar.
abstract class AveVoladora extends Ave {
    // Método exclusivo y seguro solo para aquellas aves que se desplazan por el aire.
    public abstract void volar();
}

// Clase concreta Loro, la cual lógicamente es un AveVoladora.
class Loro extends AveVoladora {
    // Implementa el acto genérico de comer heredado desde arriba.
    @Override
    public void comer() {
        System.out.println("El loro come ricas semillas y frutas.");
    }

    // Implementa el acto específico de volar.
    @Override
    public void volar() {
        System.out.println("El loro vuela libremente por la selva tropical.");
    }
}

// Clase concreta Pingüino, la cual hereda DIRECTAMENTE de Ave (y NO de AveVoladora).
// De esta forma respetamos tajantemente a Liskov: el sistema nunca le pedirá a un pingüino que intente volar.
class Pinguino extends Ave {
    // Implementa su propia forma de alimentarse.
    @Override
    public void comer() {
        System.out.println("El pingüino se sumerge y come peces frescos.");
    }
}

// Clase pública para testear e ilustrar el cumplimiento del principio LSP.
public class SustitucionLiskov {
    
    // Este método acepta CUALQUIER tipo de Ave y la hace comer. 
    // Gracias a Liskov, tenemos la garantía absoluta de que ninguna ave lanzará un error aquí.
    public void alimentarAveGenerica(Ave ave) {
        // Comportamiento seguro polimórfico
        ave.comer();
    }

    // Este método acepta estrictamente solo aves con capacidad de vuelo comprobada.
    // Previene errores en tiempo de ejecución protegiendo la integridad del ecosistema.
    public void realizarExhibicionAerea(AveVoladora ave) {
        // Acción de vuelo segura garantizada
        ave.volar();
    }
}
