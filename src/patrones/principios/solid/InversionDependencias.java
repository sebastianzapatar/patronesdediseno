package patrones.principios.solid;

// --- PRINCIPIO DE INVERSIÓN DE DEPENDENCIAS (DIP) ---
// Regla: "Los módulos de alto nivel (negocio) no deben depender de los módulos de bajo nivel (herramientas). 
// Ambos deben depender estrictamente de abstracciones (interfaces)."

// Abstracción (Interfaz) que servirá de puente neutral entre el negocio y la tecnología.
// Define el contrato de "qué" se debe hacer, pero sin importar el "cómo".
interface ConexionPersistencia {
    // Firma del método abstracto que obliga a definir cómo se persistirán/guardarán los datos.
    void guardarDatos(String datosSensibles);
}

// Módulo tecnológico de BAJO nivel (Clase concreta de implementación 1).
// Entiende y maneja la lógica nativa del motor de base de datos MySQL.
class BaseDatosMySQL implements ConexionPersistencia {
    // Ejecuta la lógica real, abriendo sockets y enviando comandos SQL.
    @Override
    public void guardarDatos(String datosSensibles) {
        System.out.println("-> Ejecutando sentencia [INSERT INTO tabla] en servidor MySQL con los datos: " + datosSensibles);
    }
}

// Módulo tecnológico de BAJO nivel (Clase concreta de implementación 2).
// Entiende y maneja la lógica nativa del motor NoSQL MongoDB.
class BaseDatosMongo implements ConexionPersistencia {
    // Ejecuta la lógica real, armando y guardando documentos tipo BSON.
    @Override
    public void guardarDatos(String datosSensibles) {
        System.out.println("-> Insertando documento [BSON/JSON] en clúster MongoDB con los datos: " + datosSensibles);
    }
}

// Módulo de ALTO nivel (Core / Lógica y reglas de negocio puras de la empresa).
// Gracias a la Inversión de Dependencias, esta clase IGNORA por completo si la empresa usa MySQL, Mongo u Oracle.
public class InversionDependencias {
    // Inyección de dependencia de manera abstracta y genérica mediante la interfaz.
    private ConexionPersistencia motorBaseDeDatos;

    // Constructor que inyecta la dependencia: Exige que le envíen CUALQUIER objeto instanciado 
    // que cumpla rigurosamente con el contrato de "ConexionPersistencia".
    public InversionDependencias(ConexionPersistencia bd) {
        // Almacena en memoria la herramienta que utilizará luego, pero tratándola solo como abstracción.
        this.motorBaseDeDatos = bd;
    }

    // Método que ejecuta la operación primordial del sistema.
    public void registrarNuevoUsuario(String nombreUsuario) {
        // 1. Procesa reglas estrictas de negocio del dominio interno.
        System.out.println("[SISTEMA CENTRAL] Validando credenciales y permisos corporativos del usuario: " + nombreUsuario + "...");
        
        // 2. Delega sin preocupaciones el trabajo físico o almacenamiento a la abstracción.
        // El polimorfismo se encargará de ejecutar el método de MySQL o MongoDB según el que se inyectó.
        this.motorBaseDeDatos.guardarDatos(nombreUsuario);
    }
}
