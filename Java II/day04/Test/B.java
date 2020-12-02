import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class B extends JFrame implements ActionListener{
	JButton bN, bS, bW, bE, bC;
	JButton bPC, bPN, bPS;
	Container cp;
	JPanel p;

	void init(){
		
		p = new JPanel();
		p.setLayout(new BorderLayout());

		bPC = new JButton("���� ����");
		bPN = new JButton("���� ����");
		bPS = new JButton("���� ����");
		p.add(bPC, BorderLayout.CENTER);
		p.add(bPN, BorderLayout.NORTH);
		p.add(bPS, BorderLayout.SOUTH);
		bPC.addActionListener(this);
		bPN.addActionListener(this);
		bPS.addActionListener(this);
		

		bN = new JButton("��");
		bS = new JButton("��");
		bW = new JButton("��");
		bE = new JButton("��");
		bC = new JButton("����");
		bN.addActionListener(this);
		bS.addActionListener(this);
		bW.addActionListener(this);
		bE.addActionListener(this);
		bC.addActionListener(this);

		cp = getContentPane();
		cp.add(bN, BorderLayout.NORTH);
		cp.add(bS, BorderLayout.SOUTH);
		cp.add(bW, BorderLayout.WEST);
		cp.add(bE, BorderLayout.EAST);
		//cp.add(bC, BorderLayout.CENTER);
		cp.add(p);


		setUI();
	}

	void setUI(){
		setTitle("ui b");
		setSize(500, 500);
		setVisible(true);
		setLocation(300, 300);

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();
		if(obj == bN){
			pln("�� Ŭ��");
		}else if(obj == bPC){
			pln("�г� ���� Ŭ��");
		}else{
			pln("������ Ŭ��");
		}	
		
	}

	void pln(String str){
		System.out.println(str);
	}	


	public static void main(String[] args){
		B b = new B();
		b.init();
	
	}
}