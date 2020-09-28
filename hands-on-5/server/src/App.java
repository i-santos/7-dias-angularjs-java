import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class App {
    public static void main(String[] args) throws Exception {

        // Criar servidor
        System.out.println("Instanciando servidor...");
        ServerSocket server = new ServerSocket(5555);

        while (true) {
            // Esperar conexão...
            System.out.println("Esperando conexão...");
            Socket connection = server.accept();

            System.out.println("Conexão chegou!");

            // Pegar os dados que estão chegando
            InputStream bytesChegando = connection.getInputStream();

            // Colocar os dados em bytes que tão chegando em um objeto que entenda bytes
            InputStreamReader leitorBytes = new InputStreamReader(bytesChegando);

            // Colocar os bytes lidos em um objeto que consiga tranformar os bytes pra
            BufferedReader leitorString = new BufferedReader(leitorBytes);

            String request = "";

            String line = leitorString.readLine();

            if (line == null) {
                line = "";
            }

            if (line.startsWith("GET")) {
                // GET request

                // Construir a requisição (linha por linha)
                while (true) {
                    line = leitorString.readLine();

                    if (line.isEmpty()) {
                        break;
                    }

                    request += line + "\n";
                }

            } else if (line.startsWith("POST")) {
                // POST request

                // Ler os headers
                while (true) {
                    line = leitorString.readLine();

                    if (line.isEmpty()) {
                        break;
                    }
                }

                // Ler os dados
                while (true) {
                    line = leitorString.readLine();
                    request += line + "\n";
                }

            } else if (line.startsWith("OPTIONS")) {
                // OPTIONS request
                request = "";
            }

            if (request.equals("END")) {
                break;
            }

            System.out.println(request);

            String responseHttp = "HTTP/1.1 200 OK\n" + "Access-Control-Allow-Origin: *\n"
                    + "Access-Control-Allow-Method: OPTIONS,POST\n" + "Accept: application/json\n"
                    + "Content-Type: text/html\n\n" + request;

            byte[] bytesResponse = responseHttp.getBytes();

            connection.getOutputStream().write(bytesResponse);
            connection.close();
        }

        System.out.println("Fechando servidor...");
        server.close();

    }
}
