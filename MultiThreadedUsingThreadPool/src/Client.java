import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public Runnable getRunnable() {
        return new Runnable() {
            @Override
            public void run() {
                int port = 8080;
                try {
                    InetAddress address = InetAddress.getByName("localhost");
                    /*
                    InetAddress --> representation of an IP address
                    getByName --> Convert a name (hostname/domain) → into an IP address
                    storing my Ip address of my device in address
                    */
                    Socket socket = new Socket(address, port); // socket created by client
                    try(
                            PrintWriter toServer = new PrintWriter(socket.getOutputStream(), true);
                            BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            /*
                            This uses automatic resource management
                            Streams auto-close
                            Cleaner code
                            Safer (even if exception occurs)
                            */
                    )
                    {
                        toServer.println("Hello from client" + socket.getLocalAddress());
                        String line = fromServer.readLine();
                        System.out.println("Response from server: " + line);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                /*
                Here socket would close automatically when leaving try with resource block
                */
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }

            }
        };
    }
    public static void main(String[] args) {
        Client client = new Client(); // creates client
        for (int i = 0; i < 100 ; i++)
        {
            try
            {
                Thread thread = new Thread(client.getRunnable());
                thread.start();
            }
            catch (Exception ex)
            {
                System.out.println("Waiting for client...");
            }
            try {
                Thread.sleep(20); // Thread.sleep() is used to pause the execution of the current thread for a specific amount of time.
            } catch (Exception e) {}

        }

    }
}
