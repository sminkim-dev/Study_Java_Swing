package prof.finalterm;

import java.io.*;
import java.net.*;
import java.util.*;

public class exam_13_Client {
	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket("localhost", 9999);
			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);
			sender.start();
			receiver.start();
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
			try {
				if(socket != null) {
					socket.close();
				}
			}
			catch(IOException closeError) {
				System.out.println(closeError.getMessage());
			}
		}
	}
}

class Sender extends Thread {
	BufferedWriter out = null;
	Socket socket = null;
	
	public Sender(Socket socket) throws IOException {
		this.socket = socket;
		out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		// 서버가 연결을 끊어도 콘솔 입력 대기 때문에 프로그램이 남지 않게 한다.
		setDaemon(true);
	}
	
	public void run() {
		Scanner scanner = new Scanner(System.in);
		try {
			while(scanner.hasNextLine()) {
				String outputMessage = scanner.nextLine();
				out.write(outputMessage + "\n");
				out.flush();
				if(outputMessage.equalsIgnoreCase("bye")) {
					break;
				}
			}
		}
		catch(IOException e) {
			if(!socket.isClosed()) {
				System.out.println(e.getMessage());
			}
		}
		finally {
			try {
				socket.close();
			}
			catch(IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}

class Receiver extends Thread {
	BufferedReader in = null;
	Socket socket = null;
	
	public Receiver(Socket socket) throws IOException {
		this.socket = socket;
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}
	
	public void run() {
		try {
			while(true) {
				String inputMessage = in.readLine();
				if(inputMessage == null || inputMessage.equalsIgnoreCase("bye")) {
					break;
				}
				System.out.println(inputMessage);
			}
		}
		catch(IOException e) {
			if(!socket.isClosed()) {
				System.out.println(e.getMessage());
			}
		}
		finally {
			try {
				socket.close();
			}
			catch(IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
