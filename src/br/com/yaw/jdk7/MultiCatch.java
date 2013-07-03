package br.com.yaw.jdk7;


/**
 * Exemplo: multicatch, mesmo tratamento para 2 tipos de exceções.
 * 
 * @author <a href="mailto:eder@yaw.com.br">Eder Magalhães</a>
 */
public class MultiCatch {
    
    public static void main(String[] args) 
            throws InstantiationException, IllegalAccessException {
        Object o = null;
        try {
            o = Object.class.newInstance();
            
            System.out.println("Objeto criado: "+o);
        } catch (InstantiationException | IllegalAccessException e) {
            System.err.println("Erro na criação do objeto");
            throw e;
        }
    }
    
}
