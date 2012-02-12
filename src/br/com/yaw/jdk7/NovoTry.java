package br.com.yaw.jdk7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Exemplo: leitura de um arquivo com o novo try, sem utilizar o finally.
 *
 * @author <a href="mailto:eder@yaw.com.br">Eder Magalhães</a>
 */
public class NovoTry {
    
	//Curiosidade: verifique o codigo gerado pelo compilador!
    public static void main(String[] args) {
    	
        try (FileReader reader = new FileReader("/home/user/file.txt"); //Coloque o caminho e arquivo correto
             BufferedReader buf = new BufferedReader(reader)) {

            String s = null;
            while ((s = buf.readLine()) != null ) {
                System.out.println(s);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo");
        }
    }

}
