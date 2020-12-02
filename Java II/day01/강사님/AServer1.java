import java.io.*;
import java.net.*;

class AServer1{
	ServerSocket ss;
	Socket s;
	String ip = "192.168.0.131";
	int port = 1994;

	DataInputStream dis;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	InputStream is;
	OutputStream os;
	DataOutputStream dos;
	PrintStream ps = System.out;

	AServer1(){
		try{
			ss = new ServerSocket(port);
			s = new Socket(ip, port);
			pln("������"+port+"�� ��Ʈ���� ����� ...");

			s = ss.accept();
			pln("Client("+s.getInetAddress().getHostAddress()+") ���� ����");

			readyIO();
			listen();
			speak();
		}catch(IOException ie){
		}
	}

	void readyIO(){
		try{
			os = s.getOutputStream();
			dos = new DataOutputStream(os);

			is = s.getInputStream();
			dis = new DataInputStream(is);
		}catch(IOException ie){}
	}

	void speak(){
		try{
			String line = null;
			while((line=br.readLine()) != null){
				dos.writeUTF(line);
				dos.flush();
			}
			pln("������ �޼��� ���� �Ϸ�");
		}catch(IOException ie){
		}
	}

	void listen(){
		try{
			String line = null;
			while((line=dis.readUTF()) != null){
				ps.println("Ŭ���̾�Ʈ>> " + line);
			}
		}catch(IOException ie){}
	}

	void pln(String str){
		System.out.println(str);
	}

	public static void main(String[] args){
		new AServer1();
	}
}
