/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.yaw.jdk7;

import static java.nio.file.StandardWatchEventKinds.*;
import java.nio.file.*;

/**
 * Exemplo: monitorar a criação e remoção de conteúdo (arquivos e/ou subpastas) 
 * em um determinado diretório. Utiliza componentes da API NIO.2.
 *
 * @author <a href="mailto:eder@yaw.com.br">Eder Magalhães</a> 
 */
public class MonitoraDir {

    public static void main(String[] args) throws Exception {
        WatchService monitorador = FileSystems.getDefault().newWatchService();
        String dir = "/home/user/directory"; //Coloque o diretório.
        Path home = Paths.get(dir);
        home.register(monitorador, ENTRY_CREATE, ENTRY_DELETE); //eventos
       
        System.out.println("Ligando monitor...");
        while(true) {
            WatchKey skey = monitorador.take();//ativa monitor
           
            for (WatchEvent<?> event: skey.pollEvents()){
                WatchEvent.Kind<?> kind = event.kind();
               
                //evento foi perdido...
                if (kind == OVERFLOW) { continue; }
               
                WatchEvent<Path> ev = (WatchEvent<Path>)event;
                Path filename = ev.context();
                String acao = kind == ENTRY_CREATE ?"criado":"excluido";
                
                System.out.printf("\tArquivo %s foi %s", filename, acao);
            }
           
            //habilita o estado para proxima leitura
            boolean valid = skey.reset();
           
            //se o diretorio nao estiver mais disponivel
            if(!valid){
                System.out.println("Desligando monitor...");
                monitorador.close();
                break;
            }
        }
    }
}
