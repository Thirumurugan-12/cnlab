import java.io.BufferedReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.io.InputStreamReader;

public class udpchatclient {

  public static void main(String[] args) throws IOException {
    int port = 4345; // Same port number as the server
    String serverAddress = "localhost"; // Replace with server IP if running on different machines

    try (DatagramSocket clientSocket = new DatagramSocket()) {
      InetAddress serverIP = InetAddress.getByName(serverAddress);
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

      while (true) {
        String message = reader.readLine();

        byte[]sendData = message.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverIP, port);
        clientSocket.send(sendPacket);
      }
    }
  }
}
