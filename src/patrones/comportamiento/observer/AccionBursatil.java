package patrones.comportamiento.observer;

// Importaciones necesarias para manejar listas y colecciones dinámicas en Java
import java.util.ArrayList;
import java.util.List;

// Clase concreta que representa un Publicador específico: Una Acción en el mercado bursátil
public class AccionBursatil implements Sujeto {
    // Colección de tipo Lista para almacenar y rastrear dinámicamente a todos los observadores registrados
    private List<Observador> observadores;
    // Variable para almacenar el símbolo de mercado representativo de la acción (por ejemplo, MSFT, AAPL, GOOG)
    private String simbolo;
    // Variable que representa el estado interno crítico del Sujeto: el precio fluctuante del mercado
    private double precio;

    // Constructor principal para inicializar la Acción Bursátil con sus valores por defecto
    public AccionBursatil(String simbolo, double precioInicial) {
        // Inicializa la lista de observadores vacía, previniendo errores de NullPointerException al registrar
        this.observadores = new ArrayList<>();
        // Establece el identificador bursátil a partir del parámetro recibido
        this.simbolo = simbolo;
        // Establece el valor inicial de la cotización a partir del parámetro recibido
        this.precio = precioInicial;
    }

    // Cumple el contrato de la interfaz Sujeto permitiendo a otros objetos agregarse a la lista de notificaciones
    @Override
    public void registrarObservador(Observador o) {
        // Utiliza el método add() de ArrayList para incorporar una nueva referencia de un observador
        this.observadores.add(o);
    }

    // Cumple el contrato de la interfaz Sujeto permitiendo a otros objetos eliminarse de la lista
    @Override
    public void removerObservador(Observador o) {
        // Utiliza el método remove() de ArrayList para eliminar la referencia, deteniendo futuras notificaciones
        this.observadores.remove(o);
    }

    // Método nuclear del patrón que recorre todos los suscritos emitiendo un mensaje general o 'broadcast'
    @Override
    public void notificarObservadores() {
        // Bucle for mejorado (for-each) que itera de manera limpia sobre cada observador en la colección actual
        for (Observador observador : observadores) {
            // Dispara sincrónicamente el método actualizar() en cada observador, pasándole el estado actualizado (push)
            observador.actualizar(this.simbolo, this.precio);
        }
    }

    // Método setter estándar para el precio, el cual a su vez actúa como el gatillo (trigger) de los eventos
    public void setPrecio(double nuevoPrecio) {
        // El estado interno de la clase ha cambiado con la asignación del nuevo valor numérico
        this.precio = nuevoPrecio;
        // Imprime un log central en consola reflejando que la bolsa acaba de sufrir una fluctuación real
        System.out.println("\n[SISTEMA DE MERCADO] La accion " + simbolo + " acaba de actualizar su cotización a: USD $" + nuevoPrecio);
        // Al darse un cambio de estado crítico, es imperativo alertar al instante llamando a la notificación
        this.notificarObservadores();
    }
}
