package patrones.creacionales.builder;

// Clase que representa el producto final complejo a construir
public class Reporte {
    // Atributo para el título del reporte
    private String titulo;
    // Atributo para el contenido o cuerpo del reporte
    private String contenido;
    // Atributo para el pie de página del reporte
    private String piePagina;

    // Método setter para asignar el título
    public void setTitulo(String titulo) {
        // Asigna el valor del parámetro al atributo de la clase
        this.titulo = titulo;
    }

    // Método setter para asignar el contenido
    public void setContenido(String contenido) {
        // Asigna el valor del parámetro al atributo de la clase
        this.contenido = contenido;
    }

    // Método setter para asignar el pie de página
    public void setPiePagina(String piePagina) {
        // Asigna el valor del parámetro al atributo de la clase
        this.piePagina = piePagina;
    }

    // Sobrescritura del método toString para imprimir el reporte en consola
    @Override
    public String toString() {
        // Retorna una representación en cadena del objeto Reporte de forma legible
        return "Reporte [\n  Titulo=" + titulo + ",\n  Contenido=" + contenido + ",\n  Pie=" + piePagina + "\n]";
    }
}
