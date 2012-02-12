package br.com.yaw.jdk7;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Exemplo: utilizar a annotation @SafeVarargs em método que recebe vargars com tipo genérico.
 * 
 * @author <a href="mailto:eder@yaw.com.br">Eder Magalhães</a>
 */
public class VarargsTipoGenerico {
    
    public static void main(String[] args) {
        Set<Integer> aSet = new HashSet<>();
        aSet.add(Integer.valueOf(100));
        aSet.add(Integer.valueOf(200));
        aSet.add(Integer.valueOf(300));
        
        //método asList de java.util.Arrays usa @SafeVarargs
        List listOfSets = Arrays.asList(new Set[]{aSet});
        System.out.println(listOfSets);
        
        imprime("teste",123);
        imprime(new HashSet<String>());
    }
    
    /*
     * Era possivel utilizar SuppressWarnings no metodo e nos pontos que invocavam o metodo.
     * No Java7 a annotation SafeVarargs no metodo resolve isso. 
     */
    @SafeVarargs
    static <T> void imprime(T ... args) {
    	for (T t: args) {
    		System.out.println(t);
    	}
    }
}
