import java.io.*;
import java.net.*;

public class echoserver {

  public static void main(String[] args) throws IOException {
    int port = 4444; // Set your desired port number

    ServerSocket serverSocket = new ServerSocket(port);
    System.out.println("Server is listening on port " + port);

    while (true) {
      Socket clientSocket = serverSocket.accept();

      // Get input and output streams
      BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

      String message;

      while ((message = in.readLine()) != null) {
        System.out.println("Client: " + message);
        out.println("Echo: " + message); // Echo the message back
      }

      clientSocket.close();
    }
  }
}
