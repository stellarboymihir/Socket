package simple_tcp_multithread;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
	public ServerMain() throws Exception{
		ServerSocket server_socket = new ServerSocket(2025);
		System.out.println("Port 2025 is now open");
		
		while(true) {
			Socket socket = server_socket.accept();
			ServerThread server_thread = new ServerThread(socket, this);
			Thread thread = new Thread(server_thread);
			thread.start();
		}
	}
	
	public int clientnumber = 1;
	
	public int getClientNumber() {
		return clientnumber++;
	}
	
	public static void main(String[] args) {
		try {
			new ServerMain();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
