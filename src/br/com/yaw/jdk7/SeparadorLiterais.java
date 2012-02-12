package br.com.yaw.jdk7;

/**
 * Exemplo: Separador ( _ ) de literais numéricas.
 *
 * @author <a href="mailto:eder@yaw.com.br">Eder Magalhães</a>
 */
public class SeparadorLiterais {

    public static void main(String[] args) {
        //decimal com _
    	int x = 1_2_34_5;
        System.out.println(x);
        
        //hexadecimal com _
        double d = 0x1.ffff_ffff_ffff_fP1_023;
        System.out.println(d);
        
        //decimal ponto flutuante com _
        d = 1_0.2_5;
        System.out.println(d);
        
        //binario com _ 
        char b = 0b10_00_00_0;
        System.out.println(b);
    }
    
}
