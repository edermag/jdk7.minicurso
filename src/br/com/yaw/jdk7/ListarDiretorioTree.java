package br.com.yaw.jdk7;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Exemplo: listar o conteúdo do diretório de forma recursiva (navegando em sub-diretórios).
 *
 * @author <a href="mailto:eder@yaw.com.br">Eder Magalhães</a>
 */
public class ListarDiretorioTree {

	public static void main(String[] args) throws IOException {
        Path dir = Paths.get("/home/user"); //Coloque o caminho do diretório
        String filter = "*.jpg"; //Coloque o filtro desejado
        
        Finder finder = new Finder(filter);
        Files.walkFileTree(dir, finder);
        finder.end();
        
        System.out.printf("%nEncerrando a consulta a arquivos %s no diretório %s%n", filter, dir);
    }
	
	//implemento um filtro mais inteligente
    public static class Finder extends SimpleFileVisitor<Path> {

        private final PathMatcher matcher;
        private int numMatches = 0;
        
        Finder(String pattern) {
            matcher = FileSystems.getDefault().getPathMatcher("glob:" + pattern);
        }
        
        private void find(Path file) {
            Path name = file.getFileName();
            
            //aplica a logica do filtro
            if (name != null && matcher.matches(name)) {
                numMatches++;
                System.out.println(file);
            }
        }
        
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            find(file);
            return FileVisitResult.CONTINUE;
        }
        
        void end() {
            System.out.println("Encontrou: " + numMatches);
        }
    }
    
}
