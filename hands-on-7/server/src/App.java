import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

// HTTP Server
public class App {

    public static List<Match> matches = new ArrayList<Match>();
    public static void main(String[] args) throws Exception {

        System.out.println("Instanciando servidor...");
        ServerSocket server = new ServerSocket(5555);
 
        while(true) {
            System.out.println("Esperando conexão..");
            Socket connection = server.accept();
    
            System.out.println("Nova conexão!");
    
            // Bytes chegando
            InputStream bytesChegando = connection.getInputStream();
    
            // Leitor de bytes
            InputStreamReader leitorBytes = new InputStreamReader(bytesChegando);
    
            // Transformar os bytes em String
            BufferedReader leitorString = new BufferedReader(leitorBytes);
    
            String primeiraLinha = leitorString.readLine();
            String request = "";
            ByteArrayOutputStream dados = new ByteArrayOutputStream();
    
            if (primeiraLinha.startsWith("GET")) {
                // Eu sei que é uma GET HTTP
    
                // Ler os headers
                String line = "";
                while(true) {
    
                    line = leitorString.readLine();
    
                    if(line.isEmpty()) {
                        break;
                    }
                }

                // Enviar os dados
                ObjectMapper mapper = new ObjectMapper();
                String response = mapper.writeValueAsString(matches);
                dados.write(response.getBytes());

            } else if(primeiraLinha.startsWith("POST")) {
                // POST HTTP

                // Ler os headers
                String line = "";
                int totalBytes = 0;
                while(true) {
                    line = leitorString.readLine();
                    request += line + "\n";

                    if (line.startsWith("Content-Length")) {
                        String[] partes = line.split(" ");
                        totalBytes = Integer.parseInt(partes[1]);
                    }

                    if (line.isEmpty()) {
                        // headers lidos!
                        break;
                    }
                }

                System.out.println(request);
    
                // Ler os dados
                int nBytes = 0;
                
                while(true) {
                    int byteLido = leitorString.read();
                    nBytes++;

                    dados.write(byteLido);

                    if(nBytes >= totalBytes) {
                        break;
                    }
                }

                ObjectMapper mapper = new ObjectMapper();

                // ArrayList<Match>
                String dadosString = dados.toString();
                Match[] matchesAux = mapper.readValue(dadosString, Match[].class);
                matches = Arrays.asList(matchesAux);

                for(Match m : matches) {

                    System.out.println(
                        "Status da Partida: " + m.getStatus() + "\n"
                        + m.getTeamA() + " " + m.getScoreA() + " - " + m.getScoreB() + " " + m.getTeamB()
                        + "\n\n"
                    );
                }


            } else if(primeiraLinha.startsWith("END")) {
                break;
            }
    
            // Construir a resposta
            String response = "HTTP/1.1 200 OK\n"
            + "Access-Control-Allow-Origin: *\n"
            + "Access-Control-Allow-Headers: *\n"
            + "Content-Type: application/json\n\n"
            + dados;
    
            // transformar pra bytes
            OutputStream bytesSaindo = connection.getOutputStream();
    
            byte[] bytesResponse = response.getBytes();
    
            // Enviar a resposta
            bytesSaindo.write(bytesResponse);
        
            connection.close();
        }
        
        System.out.println("Fechando servidor...");
        server.close();

    }
}
