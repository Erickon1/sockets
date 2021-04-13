package sockets.observable;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client implements Runnable{
	
	private int port;
	private String message;

	public Client(int port, String message) {
		super();
		this.port = port;
		this.message = message;
	}

	@Override
	public void run() {
		
		final String HOST ="127.0.0.1";
		
		DataOutputStream out;
		
		try {
			Socket sc = new Socket(HOST,port);

			out = new DataOutputStream(sc.getOutputStream());
			
			out.writeUTF(message);
			
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
