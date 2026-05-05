package patrones.resiliencia.circuitbreaker;

// Enumeración estandarizada que define los tres estados universales de un Circuit Breaker
public enum EstadoCircuito {
    // Estado CERRADO: El sistema funciona normal. Las peticiones fluyen sin problema al servicio remoto.
    CERRADO,
    
    // Estado ABIERTO: El servicio remoto falló demasiadas veces. Se rechazan/bloquean todas las peticiones al instante.
    ABIERTO,
    
    // Estado SEMI_ABIERTO: Ha pasado un tiempo de castigo/espera. Se dejan pasar peticiones de prueba para ver si el servicio sanó.
    SEMI_ABIERTO
}
