package patrones.principios.solid;

// --- PRINCIPIO DE SEGREGACIÓN DE INTERFACES (ISP) ---
// Regla: "Los clientes no deben verse obligados a depender de interfaces que no utilizan."
// Filosofía: Es mucho más limpio tener muchas interfaces pequeñas, modulares y específicas, 
// que una sola interfaz "gorda" y monolítica que obligue a implementar métodos inútiles.

// Interfaz segregada y altamente específica, exclusiva para la acción de imprimir texto/imágenes.
interface Impresora {
    // Firma del contrato para materializar documentos físicos en papel.
    void imprimirDocumento();
}

// Interfaz segregada y específica, exclusiva para la acción de escanear y digitalizar.
interface Escaner {
    // Firma del contrato para convertir papeles a formato digital (PDF, JPG).
    void escanearDocumento();
}

// Clase que representa a una impresora de alta gama o multifuncional de oficina.
// Como es un equipo avanzado, tiene la capacidad de implementar ambas interfaces de forma natural.
class MaquinaMultifuncional implements Impresora, Escaner {
    // Cumple con el contrato del escáner aportando lógica real.
    @Override
    public void escanearDocumento() {
        System.out.println("[MULTIFUNCIONAL] Escaneando el documento a color en alta resolución...");
    }

    // Cumple con el contrato de la impresora aportando lógica real.
    @Override
    public void imprimirDocumento() {
        System.out.println("[MULTIFUNCIONAL] Imprimiendo el documento físico en papel brillante...");
    }
}

// Clase que representa una máquina de fax antigua o una impresora básica de tickets.
// Gracias a la segregación de interfaces, esta clase NO está obligada a implementar 
// un método 'escanearDocumento()' que no sabría cómo resolver.
class ImpresoraBasica implements Impresora {
    // Solo implementa lo que realmente sus capacidades le permiten hacer.
    @Override
    public void imprimirDocumento() {
        System.out.println("[IMPRESORA BÁSICA] Imprimiendo texto en formato blanco y negro económico...");
    }
}

// Clase pública y principal para ilustrar conceptualmente el diseño ISP.
public class SegregacionInterfaces {
    // Método principal de ejecución.
    public static void main(String[] args) {
        // Si tuviéramos una "MaquinaMultifuncional", podemos pasarla a métodos que pidan "Escaner" o "Impresora".
        // Si tuviéramos una "ImpresoraBasica", el compilador bloquearía intentar pasarla como "Escaner", evitando bugs.
        System.out.println("Diseño de hardware moderno basado en interfaces correctamente segregadas y modulares.");
    }
}
