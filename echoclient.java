import java.io.*;
import java.net.*;

public class echoclient {

  public static void main(String[] args) throws IOException {
    String hostname = "localhost"; // Replace with server IP if running on different machines
    int port = 4444; // Same port number as the server

    Socket clientSocket = new Socket(hostname, port);
    System.out.println("Connected to server: " + hostname + ":" + port);

    // Get input and output streams
    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

    BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

    String message;

    while ((message = userInput.readLine()) != null) {
      out.println(message);
      String response = in.readLine();
      System.out.println(response);
    }

    clientSocket.close();
  }
}
