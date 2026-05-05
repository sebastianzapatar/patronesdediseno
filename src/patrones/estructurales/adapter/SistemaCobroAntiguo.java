package patrones.estructurales.adapter;

// Clase legada o antigua (Adaptee). Este es un código de terceros o antiguo que NO PODEMOS MODIFICAR
// Funciona diferente: espera centavos como un 'int' y el orden de los parámetros es distinto
public class SistemaCobroAntiguo {
    
    // Método heredado de hace 15 años que procesa transacciones
    public void procesarCobroLegacy(String tokenCuenta, int importeCentavos) {
        // Imprime un aviso simulando un sistema mainframe o antiguo
        System.out.println("[SISTEMA LEGACY] Iniciando cobro en servidor central...");
        // Calcula e imprime el valor real solo para verificación
        System.out.println("[SISTEMA LEGACY] Cobro exitoso de " + importeCentavos + " centavos de la cuenta [" + tokenCuenta + "]");
    }
}
