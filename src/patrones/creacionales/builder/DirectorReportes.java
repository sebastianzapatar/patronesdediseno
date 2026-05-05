package patrones.creacionales.builder;

// Clase Director que orquesta el proceso de construcción utilizando cualquier implementación de Builder
public class DirectorReportes {
    // Referencia a la interfaz genérica del builder, permitiendo inyectar cualquier variante (ej: PDF, HTML)
    private ReporteBuilder builder;

    // Método para establecer explícitamente qué builder concreto utilizará este director
    public void setBuilder(ReporteBuilder builder) {
        // Asigna el builder recibido por parámetro al estado interno de la clase
        this.builder = builder;
    }

    // Método de alto nivel para construir un "Reporte Mensual" ejecutando los pasos en orden
    public void construirReporteMensual(String mes) {
        // 1. Delega al builder la construcción del título con el mes específico
        this.builder.construirTitulo("Reporte Mensual Financiero de " + mes);
        // 2. Delega al builder la construcción del contenido principal con un texto predefinido
        this.builder.construirContenido("Detalle de las ventas, costos e ingresos brutos del mes de " + mes);
        // 3. Delega al builder la construcción de la firma y el pie de página
        this.builder.construirPiePagina("Generado automáticamente por el Sistema Contable (Director)");
    }
}
