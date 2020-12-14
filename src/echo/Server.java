package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[]args) throws IOException {
		ServerSocket serverSocket = new ServerSocket();
		serverSocket.bind(new InetSocketAddress("192.168.35.52",1021));
		
		System.out.println("<서버 시작>");
		System.out.println("===================================");
		System.out.println("연결을 기다리고 있습니다.");
		
		while(true) {
			Socket socket = serverSocket.accept();
			System.out.println("클라이언트가 연결되었습니다.");
			
			Thread thread = new ServerThread(socket);
			thread.start();
			
		}
	}
}
