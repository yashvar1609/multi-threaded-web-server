import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.function.Consumer;

public class Server
{
    public Consumer<Socket> getConsumer() //returning a function (consumer) that will handle a client socket
    {
        return (clientSocket)->{
            try
            {
                Thread.sleep(1000); // 1 second delay
                PrintWriter toClient = new PrintWriter(clientSocket.getOutputStream());
                toClient.println("Hello from the server");
                toClient.flush();
                toClient.close();
                clientSocket.close();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        };
    }
    public static void main(String[] args)
    {
        int port = 8080;
        Server server = new Server();
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(10000);
            System.out.println("Server is listening on port " + port);
            while(true)
            {
                Socket acceptedSocket = serverSocket.accept();
                Thread thread = new Thread(()->server.getConsumer().accept(acceptedSocket));  // creating thread to assign socket to threads
                thread.start();
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }



}


