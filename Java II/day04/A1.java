import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class A1 extends JFrame { //Container
	class A1Handler implements ActionListener {		// ActionListener ��� ����� ���� ���!!! import�� �������!!
		public void actionPerformed(ActionEvent e){        // e�� �ٺ����� ��ü
			//System.out.println("�̺�Ʈ �߻� ����!");					  // �̰Ŵ� ����⿡ �ߴ� �ؽ�Ʈ��
			b.setText("��ư Ŭ����!!( by ������Ŭ���� )");				  // �̰Ŵ� ���� ������ �� ���̴� ui���� �ߴ� �ؽ�Ʈ��  <1�����>

			//JButton bb = (JButton)e.getSource(); // ��ü?? ���� �ʿ���											 <2�����>
			//bb.setText("��ư Ŭ����!!( by ������Ŭ���� )");
		}
	}
	JButton b;  //��ư ���� ��� �ʱ�ȭ  (UI Component)
	
	void init(){
		b = new JButton("�ڹ��� ��ư"); //��ư�� �ʱⰪ �ο�
		add(b); //�̰� �־�� ��� �߰��ε�?
		ActionListener listener = new A1Handler();  // ������ ��ӹ޾� �߰��� ����� ���⼭ ��� �� �� �ְ� ���⼭ ����
		b.addActionListener(listener);	//��ư�� ������ �� ��� �׼� ����    ui�� api���� �ؾ��� > ���⼱ (listener) ��� �־���

		setUI();
	}
	void setUI(){
		setTitle("GUI Test Ver 1.0");	//UI Ÿ��Ʋ��
		setSize(300, 200);				//UI ���� ���� ������   ***��� ������ ������ !!���� ��ܱ���!!
		setVisible(true);				//ȭ�鿡 ��� (false)�� ���x
		setLocation(200, 100);			//UI ���� ��ǥ *** !!���� ��ܱ��� !!
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String args[]){
		A1 a1 = new A1();
		a1.init();
	}
}