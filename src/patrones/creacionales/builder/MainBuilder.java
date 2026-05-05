package patrones.creacionales.builder;

// Clase principal ejecutable para demostrar el funcionamiento del patrón de diseño Builder
public class MainBuilder {
    // Método principal de ejecución (entry point del programa Java)
    public static void main(String[] args) {
        // Instancia el Director que conoce "cómo" (el orden lógico) ensamblar un buen reporte
        DirectorReportes director = new DirectorReportes();
        
        // Instancia un constructor concreto, en este caso el encargado de dar formato PDF a los reportes
        ReporteBuilder builderPdf = new PdfReporteBuilder();
        
        // Configuramos al director inyectándole la dependencia del builder PDF específico
        director.setBuilder(builderPdf);
        
        // Ordenamos al director que ejecute su receta de pasos para crear un reporte mensual de "Octubre"
        director.construirReporteMensual("Octubre");
        
        // Solicitamos al builder el producto final que acaba de ser ensamblado bajo las directrices del director
        Reporte miReportePdf = builderPdf.obtenerReporte();
        
        // Imprimimos un mensaje cabecera en consola para indicar que mostraremos el resultado
        System.out.println("--- Reporte Generado Exitosamente ---");
        // Imprimimos el objeto reporte (esto invocará automáticamente su método sobreescrito toString())
        System.out.println(miReportePdf);
    }
}
