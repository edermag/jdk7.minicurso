package br.com.yaw.jdk7;

/**
 * Exemplo: utilizar String no operador switch.
 * 
 * @author <a href="mailto:eder@yaw.com.br">Eder Magalhães</a>
 */
public class StringSwitch {
    
    //Curiosidade: verifique o codigo gerado pelo compilador!
    public static void main(String[] args) {
        String s= "oi";
        
        switch(s) {
            case "oi": 
                System.out.println("Oi amiguinho"); 
                break;
            case "tchau":
                System.out.println("Tchau amigucho"); 
                break;
            default:
                System.out.println("Mal educado"); 
        }
    }
    
}
