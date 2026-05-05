package patrones.creacionales.singleton;

// Clase Singleton clásica que representa un acceso centralizado a una base de datos
public class ConexionBaseDatos {

    // Variable estática privada que contendrá la única instancia de la clase
    private static ConexionBaseDatos instanciaUnica;

    // Simulación de un dato de estado interno, como la URL principal de la base de datos
    private String urlConexion;

    // Constructor PRIVADO: Evita estrictamente que otras clases usen la palabra clave 'new'
    private ConexionBaseDatos() {
        // Asignamos una URL simulada de producción al momento de inicializar el objeto
        this.urlConexion = "jdbc:postgresql://localhost:5432/produccion";
        
        // Registramos en consola el momento exacto en que se crea físicamente en memoria
        System.out.println(">> [SISTEMA] Se ha creado la INSTANCIA ÚNICA de la Base de Datos.");
    }

    // Método estático público que actúa como el punto de acceso global a la instancia
    public static ConexionBaseDatos getInstancia() {
        // Chequeo simple (Lazy Initialization): Verificamos si la instancia aún no existe
        if (instanciaUnica == null) {
            // Si es nula, significa que es la primera vez que la piden, así que la creamos
            instanciaUnica = new ConexionBaseDatos();
        }
        // Retornamos la única instancia existente (ya sea recién creada o la que ya guardamos)
        return instanciaUnica;
    }

    // Método de negocio funcional de prueba para ejecutar consultas sobre la instancia
    public void ejecutarQuery(String query) {
        // Imprime en pantalla la query ejecutada y expone la URL interna para comprobar que funciona
        System.out.println("Ejecutando [" + query + "] en la base de datos: " + urlConexion);
    }
}
