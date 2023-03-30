import java.awt.Color;
import java.awt.Dimension;  //封装了一个构件的高度和宽度
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
	//在类中定义初始化界面的方法
	public void initUI() {
		JFrame frame = new JFrame();
		ImageIcon image=new ImageIcon("src\\Source\\login.jpeg");
		JLabel label=new JLabel(image);
		label.setSize(image.getIconWidth(), image.getIconHeight());
		frame.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
		JPanel pan=(JPanel)frame.getContentPane();
		pan.setOpaque(false);
		frame.setTitle("Begin");//设置窗体标题
		frame.setSize(400, 250);//设置窗体大小，只对顶层容器生效
		frame.setDefaultCloseOperation(3);//设置窗体关闭操作，3表示关闭窗体退出程序
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);//禁止调整窗体大小
		frame.setFont(new Font("宋体",Font.PLAIN,14));//设置字体，显示格式正常，大小
		frame.setIconImage(frame.getToolkit().getImage("src\\Source\\tubiao.jpeg"));
		FlowLayout fl = new FlowLayout(FlowLayout.CENTER,10,10);
		//实例化流式布局类的对象
		frame.setLayout(fl);
		JLabel labname = new JLabel("账号：");
		labname.setFont(new Font("宋体",Font.BOLD,24));
		
	
		frame.add(labname);
		
		//实例化JTextField标签对象化
		JTextField text_name = new JTextField();
		text_name.setOpaque(false);
		text_name.setFont(new Font("宋体",Font.BOLD,24));
		Dimension dim1 = new Dimension(260,30);
		text_name.setPreferredSize(dim1);//设置除顶级容器组件以外其他组件的大小
		//将textName标签添加到窗体上
		frame.add(text_name);
		
		JLabel labpass = new JLabel("密码：");
		labpass.setOpaque(false);
		labpass.setFont(new Font("宋体",Font.BOLD,24));
		frame.add(labpass);
		
		//实例化JPasswordField
		JPasswordField text_password = new JPasswordField();
		//设置大小
		text_password.setPreferredSize(dim1);
		text_password.setOpaque(false);
	    text_password.setFont(new Font("宋体",Font.BOLD,24));
		frame.add(text_password);
		JButton button1 = new JButton();
		Dimension dim2 = new Dimension(100,30);
		button1.setText("登录");
		button1.setFont(new Font("宋体",Font.PLAIN,24));
		button1.setContentAreaFilled(false);
		//设置按键大小
		button1.setSize(dim2);
		frame.add(button1);
		frame.setVisible(true);//窗体可见，一定要放在所有组件加入窗体后
		BeginListener ll = new BeginListener(frame,text_name,text_password);
		button1.addActionListener(ll);
	}
}
