import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class A2 extends JFrame{
	JButton b;
	void init(){
		b = new JButton("��ư");
		add(b);
		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				b.setText("��ư Ŭ����!");
			}
		});

		setUI();
	}

	void setUI(){
		setTitle("�ι�° ��� UI");
		setSize(200, 200);
		setVisible(true);
		setLocation(200, 200);

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args){
		A2 a2 = new A2();
		a2.init();
	
	}
}