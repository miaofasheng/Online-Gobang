import java.awt.Color;
import java.awt.Dimension;  //��װ��һ�������ĸ߶ȺͿ��
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton; 
public class Begin {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Begin login = new Begin();
		login.initUI();
	}
	//�����ж����ʼ������ķ���
	public void initUI() {
		JFrame frame = new JFrame();
		ImageIcon image=new ImageIcon("src\\Source\\login.jpeg");
		JLabel label=new JLabel(image);
		label.setSize(image.getIconWidth(), image.getIconHeight());
		frame.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
		JPanel pan=(JPanel)frame.getContentPane();
		pan.setOpaque(false);
		frame.setTitle("Begin");//���ô������
		frame.setSize(400, 250);//���ô����С��ֻ�Զ���������Ч
		frame.setDefaultCloseOperation(3);//���ô���رղ�����3��ʾ�رմ����˳�����
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);//��ֹ���������С
		frame.setFont(new Font("����",Font.PLAIN,14));//�������壬��ʾ��ʽ��������С
		frame.setIconImage(frame.getToolkit().getImage("src\\Source\\tubiao.jpeg"));
		FlowLayout fl = new FlowLayout(FlowLayout.CENTER,10,10);
		//ʵ������ʽ������Ķ���
		frame.setLayout(fl);
		JLabel labname = new JLabel("�˺ţ�");
		labname.setFont(new Font("����",Font.BOLD,24));
		
	
		frame.add(labname);
		
		//ʵ����JTextField��ǩ����
		JTextField text_name = new JTextField();
		text_name.setOpaque(false);
		text_name.setFont(new Font("����",Font.BOLD,24));
		Dimension dim1 = new Dimension(260,30);
		text_name.setPreferredSize(dim1);//���ó������������������������Ĵ�С
		//��textName��ǩ��ӵ�������
		frame.add(text_name);
		
		JLabel labpass = new JLabel("���룺");
		labpass.setOpaque(false);
		labpass.setFont(new Font("����",Font.BOLD,24));
		frame.add(labpass);
		
		//ʵ����JPasswordField
		JPasswordField text_password = new JPasswordField();
		//���ô�С
		text_password.setPreferredSize(dim1);
		text_password.setOpaque(false);
	    text_password.setFont(new Font("����",Font.BOLD,24));
		frame.add(text_password);
		JButton button1 = new JButton();
		Dimension dim2 = new Dimension(100,30);
		button1.setText("��¼");
		button1.setFont(new Font("����",Font.PLAIN,24));
		button1.setContentAreaFilled(false);
		//���ð�����С
		button1.setSize(dim2);
		frame.add(button1);
		frame.setVisible(true);//����ɼ���һ��Ҫ��������������봰���
		BeginListener ll = new BeginListener(frame,text_name,text_password);
		button1.addActionListener(ll);
	}
}
