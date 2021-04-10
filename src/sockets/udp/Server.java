package sockets.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server {
	public static void main(String[] args) {
		final int PORT = 8001;
		byte[] buffer = new byte[1024];
		
		try {
			System.out.println("start udp server");
			DatagramSocket socketUDP = new DatagramSocket(PORT);
			while (true) {
				
				DatagramPacket request = new DatagramPacket(buffer, buffer.length);
				socketUDP.receive(request);
				System.out.println("receive client info");

				String message = new String(request.getData());
				System.out.println(message);
				
				int portClient = request.getPort();
				InetAddress address = request.getAddress();
				
				message = "Hello from udp server";
				buffer = message.getBytes();
				
				DatagramPacket response = new DatagramPacket(
						buffer, buffer.length, address, portClient);
				System.out.println("send info to client");
				socketUDP.send(response);
				//socketUDP.close();
				
	
			}
						
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
