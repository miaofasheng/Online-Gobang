
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
 
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
 
public class BeginListener implements ActionListener{
	private javax.swing.JTextField text_name;
	private javax.swing.JPasswordField text_password;
	private javax.swing.JFrame login;
	
	public BeginListener(javax.swing.JFrame login,javax.swing.JTextField text_name,javax.swing.JPasswordField text_password)
	{//��ȡ��¼���桢�˺�������������
		this.login=login;
		this.text_name=text_name;
		this.text_password=text_password;
	}
	
	int i=3;//3�ε�¼����
	public javax.swing.JFrame login2 = new javax.swing.JFrame();
	public void actionPerformed(ActionEvent e)
	{
		Dimension dim2 = new Dimension(100,30);
		Dimension dim3 = new Dimension(300,30);
		//�����½���
		
		login2.setSize(400,200);
		login2.setDefaultCloseOperation(3);
		login2.setLocationRelativeTo(null);
		login2.setFont(new Font("����",Font.PLAIN,14));  
		//�������
		javax.swing.JPanel jp1 = new JPanel();
		javax.swing.JPanel jp2 = new JPanel();
			if(text_name.getText().equals("2010224") && text_password.getText().equals("2010224"))
			{	
				try {
		            Thread.sleep(500); 
		            } catch(InterruptedException ex) {
		            Thread.currentThread().interrupt();
		            }
				MainLoadPanel a=new MainLoadPanel();
				a.setIconImage(a.getToolkit().getImage("src\\Source\\tubiao.jpeg"));
				a.setSize(800, 600);
				a.setTitle("����JAVA������");
			    a.setResizable(false);//�������ò�������
				a.setVisible(true);	
				//ͨ�����ǻ�ȡ�ĵ�¼���������dispose�����ر���
				login.dispose();
			}
			else if(i>=2)
			{
				JLabel message = new JLabel("�˺Ż��������,�����컹��"+(i-1)+"�λ���");
				message.setFont(new Font("����",Font.PLAIN,14));  //���壬�������14������
				message.setPreferredSize(dim3);
				//��textName��ǩ��ӵ�������
				jp1.add(message);
				login2.add(jp1,BorderLayout.CENTER);
				
				JButton close = new JButton("ȷ��");
				close.setFont(new Font("����",Font.PLAIN,14));
				//���ð�����С
				close.setSize(dim3);
				jp2.add(close);
				login2.add(jp2,BorderLayout.SOUTH);
				
				i--;//��������
				close.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						login.dispose();
					}
				});
				
				login2.setResizable(false);
				login2.setVisible(true);
			}
			
			else if(i == 1)
			{
				JLabel message = new JLabel("�˺�������������������");
				message.setFont(new Font("����",Font.PLAIN,14));  //���壬�������14������
				message.setPreferredSize(dim3);
				//��textName��ǩ��ӵ�������
				jp1.add(message);
				login2.add(jp1,BorderLayout.CENTER);
				
				JButton close = new JButton("ȷ��");
				close.setFont(new Font("����",Font.PLAIN,14));
				//���ð�����С
				close.setSize(dim3);
				jp2.add(close);
				login2.add(jp2,BorderLayout.SOUTH);
				
				close.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						login2.dispose();
					}
				});
				
				login2.setResizable(false);
				login2.setVisible(true);
				
				//ͨ�����ǻ�ȡ�ĵ�¼���������dispose�����ر���
				login2.dispose();
			}
	}
}