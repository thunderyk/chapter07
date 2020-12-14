package echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ServerThread extends Thread{
	
	private Socket socket;
	
	public ServerThread(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		try {
			
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is,"UTF-8");
			BufferedReader br = new BufferedReader(isr);
			
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os,"UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			
			while(true) {
				String msg = br.readLine();
				
				if(msg==null) {
					break;
				}

				System.out.println("받은메세지:" + msg);
				
				//메세지 보내기
				bw.write(msg);
				bw.newLine();
				bw.flush();
			}

		}catch(Exception e) {
			e.toString();
		}
	}
}
