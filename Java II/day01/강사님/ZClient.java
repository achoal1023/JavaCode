import java.io.*;
import java.net.*;
import java.lang.Thread;

class ZClient extends Thread  {
	Socket s;
	String ip = "192.168.0.131";
	int port = 1994;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Keyboard
	InputStream is;
	DataInputStream dis;
	OutputStream os; //Node 
	PrintStream ps = System.out; 
	DataOutputStream dos; //Filter 

	ZClient(){
		try{
			s = new Socket(ip, port);
			pln("������ ���� ����");

			readyIO();
			start();
			speak();
			
		}catch(UnknownHostException ne){
		}catch(IOException ie){
			pln("����("+ip+")�� ��Ʈ��ũ���� ã�� �� ����");
		}
	}

	public void run(){
		listen();
	}
	void readyIO(){
		try{
			os = s.getOutputStream();
			dos = new DataOutputStream(os);
			is = s.getInputStream();
			dis = new DataInputStream(is);
		}catch(IOException ie){
		}
	}
	void listen(){ //Socket -> Moniter
		try{
			String line = null;
			while((line=dis.readUTF()) != null){
				ps.println("Ŭ���̾�Ʈ>> " + line);
			}
		}catch(IOException ie){
		}
	}
	void speak(){ //Keyboard -> Socket 
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
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) {
		new ZClient();
		
	}
}
