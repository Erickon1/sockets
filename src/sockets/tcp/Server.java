package sockets.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		ServerSocket server  = null;
		Socket sc = null;
		DataInputStream in;
		DataOutputStream out;
		final int PORT = 8000;
		
		try {
			server = new ServerSocket(PORT);
			System.out.println("start server");
			
			while(true) {
				sc = server.accept();
				
				System.out.println("client connection");
				in = new DataInputStream(sc.getInputStream());
				out = new DataOutputStream(sc.getOutputStream());
				String message = in.readUTF();
				System.out.println(message);
				out.writeUTF("Hello world from server");
				
				sc.close();
				System.out.println("client disconnect");
				
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
