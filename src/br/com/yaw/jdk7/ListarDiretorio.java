package br.com.yaw.jdk7;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Exemplo: listar o conteúdo de um diretório utilizando a nova API de IO (NIO.2).
 * 
 * @author <a href="mailto:eder@yaw.com.br">Eder Magalhães</a>
 */
public class ListarDiretorio {
    
    public static void main(String[] args) throws IOException {
        Path dir = Paths.get("/home/user"); //Coloque o caminho do diretório

        //lista o conteudo do diretorio sem filtro
        DirectoryStream<Path> stream = Files.newDirectoryStream(dir);
        System.out.println("Listando conteudo do diretorio (sem filtro)");
        for (Path p: stream) {
            System.out.println("\t"+p + (Files.isSymbolicLink(p) ? " (link)":""));
        }
        
        //lista o conteudo do diretorio com filtro
        String filter = "*.jpg"; //Coloque o filtro desejado
        stream = Files.newDirectoryStream(dir, filter);
        System.out.println("\n\nListando conteudo do diretorio (com filtro)");
        for (Path p: stream) {
            System.out.println("\t"+p + (Files.isSymbolicLink(p) ? " (link)":""));
        }
    }
}
