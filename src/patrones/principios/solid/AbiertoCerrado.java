package patrones.principios.solid;

// --- PRINCIPIO ABIERTO/CERRADO (OCP) ---
// Regla: "El software debe estar abierto para extensión, pero cerrado para modificación."

// Creamos una interfaz general para calcular descuentos. 
// Esta es la "abstracción" clave que usaremos para no atarnos a un solo tipo de cliente.
interface Descuento {
    // Método que cada tipo de cliente implementará aplicando su propia regla matemática
    double aplicarDescuento(double precioBase);
}

// Clase concreta de negocio para clientes regulares (sin beneficios)
class DescuentoRegular implements Descuento {
    // Implementa la regla para clientes normales
    @Override
    public double aplicarDescuento(double precioBase) {
        // Retorna exactamente el mismo precio sin alteraciones
        return precioBase;
    }
}

// Clase concreta extendida para clientes nivel VIP (Tienen 20% de descuento)
class DescuentoVIP implements Descuento {
    // Implementa la regla exclusiva para clientes preferenciales
    @Override
    public double aplicarDescuento(double precioBase) {
        // Multiplica por 0.8 para restarle directamente el 20% al precio
        return precioBase * 0.80;
    }
}

// Clase pública y principal que procesa las compras finales.
// Esta clase está CERRADA a modificación: Si mañana añadimos un nuevo tipo de cliente 
// (por ejemplo "DescuentoEstudiante"), NO tenemos que tocar ni alterar este archivo.
// Simplemente creamos la nueva clase "DescuentoEstudiante" que implemente la interfaz 
// (Abierto a extensión).
public class AbiertoCerrado {
    
    // Método central que calcula el pago final recibiendo cualquier tipo de descuento mediante polimorfismo
    public double procesarPagoFinal(double precioArticulo, Descuento politicaDescuento) {
        // Imprime una traza en consola simulando el inicio del cálculo en la caja registradora
        System.out.println("Calculando el precio final en el carrito de compras...");
        // Delega de manera abstracta la responsabilidad matemática a la interfaz, 
        // sin importar (ni saber) qué implementación concreta de cliente se está usando.
        return politicaDescuento.aplicarDescuento(precioArticulo);
    }
}
