import java.net.ServerSocket;
import java.net.Socket;

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("Instanciando servidor...");
        ServerSocket server = new ServerSocket(5555);

        // Esperar conexão...
        System.out.println("Esperando conexão...");
        Socket connection = server.accept();

        System.out.println("Conexão chegou!");

        // Ler quantos bytes chegaram
        int nBytes = connection.getInputStream().read();

        // Construir uma resposta (HTTP)
        String response = "HTTP/1.1 200 OK\n"
            + "Content-Type: text/html\n\n"
            + "[{\"scoreA\": 5, \"scoreB\": 3}]";
        byte[] bytesResponse = response.getBytes();

        // Enviar a resposta (em bytes)
        connection.getOutputStream().write(bytesResponse);

        System.out.println("Fechando servidor...");
        server.close();

    }
}
