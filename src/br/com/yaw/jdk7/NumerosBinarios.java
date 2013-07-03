package br.com.yaw.jdk7;

/**
 * Exemplo: literais binarias.
 *  
 * @author <a href="mailto:eder@yaw.com.br">Eder Magalhães</a>
 */
public class NumerosBinarios {

	private static final int ALARME  = 0b001; // o valor é 1 
	private static final int FECHADA = 0b010; // o valor é 2 
	private static final int ABERTA  = 0b100; // o valor é 4 

	public static void main(String[] args) {
		int ultimaLeitura = ABERTA;
		
		final int[] mascaras = { ALARME, FECHADA, ABERTA };
		final String[] mensagens = {"alarme", "fechada", "aberta"};
		
		for (int i = 0; i < mascaras.length; i++) {
			if ((ultimaLeitura & mascaras[i]) == mascaras[i])
				System.out.println(mensagens[i]);
		}
		
		System.out.println("");
		
        //complemento...
        System.out.printf("6 == 0b0110 = %s%n", 6 == 0b0110);
        System.out.printf("0b0110 + 0b0110 = %s%n", 0b0110 + 0b0110);
	}
	
}
