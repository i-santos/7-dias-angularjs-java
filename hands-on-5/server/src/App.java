import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
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
            // String
            BufferedReader leitorString = new BufferedReader(leitorBytes);

            // Iniciar o request
            String request = "";

            // Ler a primeira linha
            String line = leitorString.readLine();

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
                int totalBytes = 0;
                while (true) {
                    line = leitorString.readLine();

                    if (line.startsWith("Content-Length")) {
                        String[] slices = line.split(" ");
                        totalBytes = Integer.parseInt(slices[1]);
                    }

                    if (line.isEmpty()) {
                        break;
                    }
                }

                // Ler os dados
                int nBytes = 0; // contador de bytes
                ByteArrayOutputStream out = new ByteArrayOutputStream(); // final de bytes
                int buffer; // buffer

                while (true) {
                    buffer = leitorString.read();
                    nBytes++;
                    out.write(buffer);

                    if (nBytes >= totalBytes) {
                        break;
                    }
                }

                // Usar o out para construir a request
                request = out.toString();

            } else if (line.startsWith("OPTIONS")) {
                // OPTIONS request
                request = "";
            }

            if (request.equals("END")) {
                break;
            }

            System.out.println(request);

            String responseHttp = "HTTP/1.1 200 OK\n" 
                + "Access-Control-Allow-Origin: *\n"
                + "Access-Control-Allow-Headers: *\n" 
                + "Content-Type: application/json\n\n"
                + request;

            byte[] bytesResponse = responseHttp.getBytes();

            connection.getOutputStream().write(bytesResponse);

            // fechar tudo
            leitorString.close();
            leitorBytes.close();
            bytesChegando.close();
            connection.close();
        }

        System.out.println("Fechando servidor...");
        server.close();

    }
}
