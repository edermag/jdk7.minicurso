package br.com.yaw.jdk7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Exemplo: como fazer o backup de um arquivo com a nova API de IO (NIO.2).
 * 
 * @author <a href="mailto:eder@yaw.com.br">Eder Magalhães</a>
 */
public class Backup {
    
    public static void main(String[] args) throws IOException {
        Path home = Paths.get("/home/user");  //Coloque o caminho para sua pasta
        Path foto = home.resolve("foto.jpg"); //Coloque o nome do arquivo
        Path backup = home.resolve("foto.jpg.backup"); //Coloque o nome do arquivo backup

        Files.copy(foto, backup);
        
        System.out.println("Arquivo foi copiado? "+backup.toFile().exists());
    }

}
