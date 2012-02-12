package br.com.yaw.jdk7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Exemplo: como criar um link (symbolic link) de um arquivo, utilizando a nova API de IO (NIO.2).
 * 
 * @author <a href="mailto:eder@yaw.com.br">Eder Magalhães</a>
 */
public class LinkSimbolico {

	public static void main(String[] args) throws IOException {
		Path target = Paths.get("/home/user/Pictures/figura.jpg"); //Coloque o caminho e arquivo alvo
		Path newLink = Paths.get("/home/user/figura.jpg"); //Coloque o caminho do link

		Files.createSymbolicLink(newLink, target);
		System.out.println("Link criado!");

		Path link = Paths.get("/home/user/figura.jpg");
		if (Files.isSymbolicLink(link)) {
			System.out.format("'%s' eh link de '%s'%n", link,
					Files.readSymbolicLink(link));
		} else { 
			System.out.format("'%s' nao eh link %n", link);
		}
	}

}
