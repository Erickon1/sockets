package sockets.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) {
		
		final int PORT = 8001;
		byte[] buffer = new byte[1024];
		
		try {
			DatagramSocket socketUDP = new DatagramSocket();
			InetAddress address = InetAddress.getByName("localhost");
			String message = "Hello world from client udp";
			buffer = message.getBytes();
			DatagramPacket answer = new DatagramPacket(
					buffer, buffer.length, address, PORT);
			System.out.println("Send datagram");
			socketUDP.send(answer);
			

			DatagramPacket request = new DatagramPacket(buffer, buffer.length);
			socketUDP.receive(request);
			System.out.println("receive request");

			
			message = new String(request.getData());
			System.out.println(message);
			socketUDP.close();
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
