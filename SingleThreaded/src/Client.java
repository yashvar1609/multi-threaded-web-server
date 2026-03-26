import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public void run() throws UnknownHostException, IOException
    {
        int port = 8080;
        InetAddress address = InetAddress.getByName("localhost");
        /*
        InetAddress --> representation of an IP address
        getByName --> Convert a name (hostname/domain) → into an IP address
        storing my Ip address of my device in address
         */
        Socket socket = new Socket(address, port); // socket created by client
        PrintWriter toServer = new PrintWriter(socket.getOutputStream() ,  true);
        BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        toServer.println("Hello from the client");
        String response = fromServer.readLine();
        System.out.println("Response from the server is " + response);
        toServer.close();
        fromServer.close();
        socket.close();
    }
    public static void main(String[] args)
    {
        try
        {
            Client client = new Client();
            client.run();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
