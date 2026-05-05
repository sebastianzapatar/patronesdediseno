package patrones.creacionales.builder;

// Clase concreta que implementa el constructor definiendo la creación de un reporte tipo PDF
public class PdfReporteBuilder implements ReporteBuilder {
    // Referencia interna al reporte que se está construyendo paso a paso
    private Reporte reporte;

    // Constructor de la clase que inicializa un nuevo proceso de construcción
    public PdfReporteBuilder() {
        // Llama al método reset para asegurar que se empiece desde un reporte nuevo y vacío
        this.reset();
    }

    // Implementación del método para reiniciar el estado del builder
    @Override
    public void reset() {
        // Crea una nueva instancia de la clase Reporte lista para ser armada
        this.reporte = new Reporte();
    }

    // Implementación del método para construir el título aplicando un formato específico de PDF
    @Override
    public void construirTitulo(String titulo) {
        // Aplica un formato simulado de título de PDF y lo inyecta en el objeto reporte
        this.reporte.setTitulo("[PDF FORMAT - TITLE] " + titulo);
    }

    // Implementación del método para construir el contenido con un formato específico de PDF
    @Override
    public void construirContenido(String contenido) {
        // Aplica un formato simulado de cuerpo de texto de PDF y lo inyecta en el reporte
        this.reporte.setContenido("<< PDF Body: " + contenido + " >>");
    }

    // Implementación del método para construir el pie de página con un formato específico de PDF
    @Override
    public void construirPiePagina(String pie) {
        // Aplica un formato simulado de footer de PDF y lo inyecta en el reporte
        this.reporte.setPiePagina("[PDF Footer] " + pie);
    }

    // Implementación del método que finaliza el proceso y devuelve el producto terminado
    @Override
    public Reporte obtenerReporte() {
        // Guarda la referencia del reporte actual completamente construido en una variable temporal
        Reporte reporteFinal = this.reporte;
        // Reinicia el builder creando un nuevo reporte en blanco para estar listo para la próxima construcción
        this.reset();
        // Retorna el reporte ya construido al cliente que lo solicitó
        return reporteFinal;
    }
}
