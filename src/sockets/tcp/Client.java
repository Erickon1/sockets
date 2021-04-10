package sockets.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) {
		
		final String HOST ="127.0.0.1";
		final int PORT = 8000;
		DataInputStream in;
		DataOutputStream out;
		
		try {
			Socket sc = new Socket(HOST,PORT);

			in = new DataInputStream(sc.getInputStream());
			out = new DataOutputStream(sc.getOutputStream());
			
			out.writeUTF("Hello from client");
			String response = in.readUTF();
			System.out.println(response);
			sc.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
