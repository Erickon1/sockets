package sockets.observable;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;

@SuppressWarnings("deprecation") //now is Listener
public class Server extends Observable implements Runnable {

	private int port;
	public Server(int port) {
		this.port = port;
	}

	@Override
	public void run() {
		
		ServerSocket server  = null;
		Socket sc = null;
		DataInputStream in;
		
		try {
			server = new ServerSocket(port);
			System.out.println("start server");
			
			while(true) {
				sc = server.accept();
				
				System.out.println("client connection");
				in = new DataInputStream(sc.getInputStream());
				String message = in.readUTF();
				System.out.println(message);
				
				
				//observable
				this.setChanged();
				this.notifyObservers(message);
				this.clearChanged();
				
				sc.close();
				System.out.println("client disconnect");
				
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}

}
