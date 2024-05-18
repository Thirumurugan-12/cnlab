import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class udpchatserver {

  public static void main(String[] args) throws IOException {
    int port = 4345; // Set your desired port number

    System.out.println("Server is listening on port " + port);

    try (DatagramSocket serverSocket = new DatagramSocket(port)) {
      while (true) {
        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        serverSocket.receive(receivePacket);

        String message = new String(receivePacket.getData()).trim();

        System.out.println("Client: " + message);
      }
    }
  }
}
