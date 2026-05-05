package patrones.principios.solid;

// --- PRINCIPIO DE RESPONSABILIDAD ÚNICA (SRP) ---
// Regla: "Una clase debe tener una, y solo una, razón para cambiar."

// Esta clase tiene una única responsabilidad: Representar los datos de un Empleado.
// No se encarga de guardar en base de datos, ni de imprimir reportes.
class EmpleadoSRP {
    // Atributo privado para el nombre del empleado
    private String nombre;
    // Atributo privado para el salario base del empleado
    private double salario;

    // Constructor que inicializa el estado del objeto Empleado
    public EmpleadoSRP(String nombre, double salario) {
        // Asignación interna de las variables
        this.nombre = nombre;
        this.salario = salario;
    }
    
    // Método getter para obtener de forma segura el nombre
    public String getNombre() { 
        return nombre; 
    }
    
    // Método getter para obtener de forma segura el salario
    public double getSalario() { 
        return salario; 
    }
}

// Esta es la clase pública principal del archivo.
// Su ÚNICA responsabilidad es encargarse del diseño y generación de reportes financieros.
// Si mañana el reporte cambia a formato PDF o Web, modificamos ESTA clase, 
// pero la clase EmpleadoSRP queda totalmente intacta.
public class ResponsabilidadUnica {
    
    // Método que genera e imprime físicamente el recibo de nómina de un empleado
    public void imprimirReciboSueldo(EmpleadoSRP empleado) {
        // Imprime la cabecera del recibo financiero
        System.out.println("--- Recibo de Nómina Empresarial ---");
        // Imprime el nombre consultando al objeto empleado
        System.out.println("Nombre del Colaborador: " + empleado.getNombre());
        // Imprime el valor a transferir consultando al objeto empleado
        System.out.println("Total a transferir hoy: $" + empleado.getSalario());
    }
}
