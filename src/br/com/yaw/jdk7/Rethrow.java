package br.com.yaw.jdk7;

/**
 * Exemplo: novo rethrow.
 * 
 * @author <a href="mailto:eder@yaw.com.br">Eder Magalhães</a>
 */
public class Rethrow {
	
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        try {
            Object o = Object.class.newInstance();
            
            System.out.println("Objeto criado: "+o);
        } catch (Exception e) {
            System.err.println("Erro na criação do objeto");
            //possivel desde q no try nao lance exceções (checked) diferentes de throws
            throw e;
        }
    }
}
