/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.yaw.jdk7;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Exemplo: verificar o mimetype do arquivo com a API NIO.2.
 *
 * @author <a href="mailto:eder@yaw.com.br">Eder Magalhães</a>
 */
public class MimeType {
    
    public static void main(String[] args) throws Exception {
        String filename = "/home/user/file"; //Coloque o arquivo para testar.
        Path file = Paths.get(filename);
        String type = Files.probeContentType(file);
        
        System.out.format("%s tem MimeType: %s %n", file, type);
    }
    
}
