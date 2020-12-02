import java.io.*;
import java.net.*;
import java.lang.Thread;

class AServer extends Thread {
	ServerSocket ss;
	Socket s;
	int port = 2020; //0 ~ 65535 // Well-Known Port : 0~1023
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	InputStream is; //Node 
	DataInputStream dis;//Filter 
	OutputStream os;
	PrintStream ps = System.out; //Node : Monitor 
	DataOutputStream dos;

    AServer(){
		try{
			ss = new ServerSocket(port);
			pln("������ "+port+"�� ��Ʈ���� �����...");
	
			s = ss.accept();
			pln("Client("+s.getInetAddress().getHostAddress()+") ���� ����");

            readyIO();
			start();
			listen();
			
        }catch(IOException ie){
			pln("ie: " + ie);
		}
	}
	public void run(){
		speak();
	}
	void readyIO(){
		try{
			os = s.getOutputStream();
			dos = new DataOutputStream(os);
			is = s.getInputStream();
			dis = new DataInputStream(is);
		}catch(IOException ie){}
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
		new AServer();
		
	}
}
