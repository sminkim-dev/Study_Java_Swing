package prof.finalterm;

import java.io.*;
import java.net.*;
import java.util.*;

public class ServerEx {
	
	static ArrayList<BufferedWriter> out = new ArrayList<>();
	static int nextClientId = 1;
	
	public static void broadcasting(String inputMessage) {
		System.out.println(inputMessage);
		// 여러 ClientConn이 같은 목록을 읽고 수정하므로 같은 잠금을 사용한다.
		synchronized(out) {
			for(int i = 0; i < out.size(); i++) {
				try {
					out.get(i).write(inputMessage + "\n");
					out.get(i).flush();
				}
				catch(IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
	
	public static void main(String[] args) {
		ServerSocket listener = null;
		
		try {
			listener = new ServerSocket(9999); // 서버 소켓 생성
			System.out.println("연결을 기다리고 있습니다...");
			while(true) {
				Socket socket = listener.accept();
				try {
					ClientConn client = new ClientConn(socket, nextClientId++);
					synchronized(out) {
						out.add(client.out);
					}
					client.start();
					System.out.println("연결되었습니다.");
				}
				catch(IOException e) {
					socket.close();
					System.out.println(e.getMessage());
				}
			}
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				if(listener != null) {
					listener.close();
				}
			}
			catch(IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}

class ClientConn extends Thread {
	int clientId;
	BufferedReader in = null;
	BufferedWriter out = null;
	Socket socket = null;
	
	public ClientConn(Socket socket, int clientId) throws IOException {
		this.clientId = clientId;
		this.socket = socket;
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
	}
	
	public void run() {
		try {
			while(true) {
				String inputMessage = in.readLine();
				if(inputMessage == null || inputMessage.equalsIgnoreCase("bye")) {
					System.out.println("클라이언트" + clientId + " 연결이 종료되었습니다.");
					break;
				}
				ServerEx.broadcasting("클라이언트" + clientId + ": " + inputMessage);
			}
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		finally {
			synchronized(ServerEx.out) {
				ServerEx.out.remove(out);
			}
			try {
				socket.close();
			}
			catch(IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
