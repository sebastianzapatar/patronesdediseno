package patrones.creacionales.builder;

// Interfaz que define los pasos estandarizados para construir un Reporte
public interface ReporteBuilder {
    // Método para reiniciar o instanciar un nuevo reporte limpio
    void reset();
    // Método para construir y dar formato a la parte del título del reporte
    void construirTitulo(String titulo);
    // Método para construir y dar formato a la parte del cuerpo/contenido
    void construirContenido(String contenido);
    // Método para construir y dar formato al pie de página
    void construirPiePagina(String pie);
    // Método para obtener el producto final ya completamente construido
    Reporte obtenerReporte();
}
