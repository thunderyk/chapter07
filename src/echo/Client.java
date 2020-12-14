package echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Client {

	public static void main(String[]args) throws IOException {
		Socket socket = new Socket();
		
		System.out.println("클라이언트 시작");
		System.out.println("===============================");
		System.out.println("서버에 연결을 요청합니다.");
		
		socket.connect(new InetSocketAddress("192.168.35.52",1021));
		
		System.out.println("서버에 연결되었습니다.");
		
		OutputStream os = socket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os,"UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);
		
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is,"UTF-8");
		BufferedReader br = new BufferedReader(isr);
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String s = sc.nextLine();
			if(s.equals("/q")) {
				break;
			}else {
				bw.write(s);
				bw.newLine();
				bw.flush();
				String msg = br.readLine();
				System.out.println("받은메세지: "+msg);
			}
		}
		
		bw.close();
		br.close();
		socket.close();
	}
}
