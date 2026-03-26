import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public void run() throws IOException {
        /*
         commonly used port for local server development and
        Port 8080 where this server application (running Java program) listens for incoming client requests
         */
        int port = 8080;
        ServerSocket socket = new ServerSocket(port); // Opening a server socket on port 8080 to listen for incoming client connections
        socket.setSoTimeout(10000);  // socket is open for 10seconds then it will close automatically
        while (true)  //this means that server should never stop
        {
            try{
                System.out.println("Server is listening on port " + port); //just to show that server is active
                Socket acceptedConnection = socket.accept();
                /* it is to accept the connection but if request from the
                client doesnt comes then it would throw an exception and if we havent use try catch here
                 then program will crash and out server would stop working */
                System.out.println("Accepted connection from " + acceptedConnection.getRemoteSocketAddress()); //printings clients's socket address
//                try {
//                    Thread.sleep(3000); // 3 seconds delay
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

                PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream(), true);
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(acceptedConnection.getInputStream()));
                toClient.println("Hello from the server");
                toClient.close();
                fromClient.close();
                acceptedConnection.close();
            }
            catch (Exception ex)
            {
                ex.printStackTrace();  //Server was running and listening, but no client connected within the timeout period.
            }
        }
    }
    public static void main(String [] args)
    {
        Server server = new Server(); //not a static method
        try {
            server.run();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
