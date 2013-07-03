package br.com.yaw.jdk7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Exemplo: mover um arquivo de um diretório para outro, utilizando a nova API de IO (NIO.2).
 * 
 * @author <a href="mailto:eder@yaw.com.br">Eder Magalhães</a>
 */
public class MoverArquivo {
    
    public static void main(String[] args) throws IOException {
        Path home = Paths.get("/home/user"); //Coloque o diretório origem
        Path backup = home.resolve("foto.jpg.backup"); //Coloque o arquivo q deve mover
        Path dirDestino = Paths.get("/home/user/Desktop"); //Coloque o diretorio de destino
        
        //transfere o arquivo para outro lugar
        Files.move(backup, dirDestino.resolve(backup.getFileName()));
        System.out.println("Pronto, o arquivo foi movido!");
    }
    
}
