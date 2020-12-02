import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import javax.swing.border.*;

class B extends JFrame {
	Container cp;
	ImageIcon ii;
	JLabel laImg;
	JLabel laFont;
	B(){
		laImg = new JLabel();
		laFont = new JLabel();
	}
	void init(){
		loadImg();
		setLaImg();
		cp = getContentPane();
		cp.add(laImg);

		laFont.setText("���ں� �԰�ʹ�");
		cp.add(laFont, BorderLayout.NORTH);

	    setUI();
	}

	void setLaImg(){
		//(1) Icon ����
		laImg.setIcon(ii);
		//(2) Font ����
		laFont.setFont(new Font("����ü", Font.BOLD, 40));
		laFont.setHorizontalAlignment(JLabel.CENTER); 
		//(3) Border ����
		Border oBorder = laFont.getBorder();
		Border eBorder = new EmptyBorder(20, 10, 10, 10); //12���� �ݽð���� �� �� �� ��
		CompoundBorder cBorder = new CompoundBorder(oBorder, eBorder);
		laFont.setBorder(cBorder);
	}

	void loadImg(){
		//���1
		/*try{
			File f = new File("imgs/dance.gif");
			BufferedImage bi = ImageIO.read(f);
			ii = new ImageIcon(bi);
		}catch(IOException ie){
		}*/

        //���2
		ii = new ImageIcon(getClass().getResource("cocoball.gif")); 
	}
	void setUI(){
		setTitle("Cocoball");
		pack();
		setVisible(true);
		//setLocation(300, 100);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) {
		new B().init();
	}
}
