/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.yaw.jdk7;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Paths;
import java.util.concurrent.Future;

/**
 * Exemplo: leitura assíncrona de arquivo utilizando outra thread via 
 * <a href="http://docs.oracle.com/javase/7/docs/api/java/nio/channels/AsynchronousFileChannel.html">
 * AsynchronousFileChannel</a> da API NIO.2.
 *
 * @author <a href="mailto:eder@yaw.com.br">Eder Magalhães</a>
 */
public class LerArquivoAsync {

    public static void main(String[] args) throws Exception {
        String file = "/home/user/file"; //Coloque o caminho para o arquivo

        try (AsynchronousFileChannel channel = AsynchronousFileChannel.open(Paths.get(file))) {
            int bufferSize = 83000000; //tamanho do buffer (+ ou - 83mb, modifique conforme o tamanho do arquivo)
            
            ByteBuffer bf = ByteBuffer.allocate(bufferSize);
            Future<Integer> result = channel.read(bf, 0);
            while (!result.isDone()) {
                System.out.println("Aguardando...");
                Thread.sleep(500);
            }
            
            System.out.printf("Encerro %s sucesso %n", result.isDone() ? "com" : "sem");
            System.out.printf("Total de %d bytes lidos%n", result.get());
        }
    }
}
