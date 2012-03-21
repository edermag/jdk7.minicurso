package br.com.yaw.jdk7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Exemplo: utilizar operador diamond para reduzir declaracao de tipos Genericos
 * 
 * @author <a href="mailto:eder@yaw.com.br">Eder Magalhães</a>
 */
public class OperadorDiamond {

	public static void main(String[] args) {
		Map<Integer, Set<Integer>> mapOfIntegers = new HashMap<>();

		Integer aKey = 10;
		Set<Integer> aSet = new HashSet<>();    

		mapOfIntegers.put(aKey, aSet);
		mapOfIntegers.put(20, aSet = new TreeSet<>());
	}
	
}
