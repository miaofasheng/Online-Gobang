import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChangeName extends JFrame {
	public ChangeName() {

		// TODO Auto-generated constructor stub
		final JButton button1=new JButton("ȷ��");
		JFrame f=new JFrame("�޸�����");
		final JTextField message=new JTextField();
		JLabel label=new JLabel("��������Ҫ�޸ĵ�ID:");
		label.setFont(new Font("����",Font.BOLD,24));
		
		message.setFont(new Font("����",Font.BOLD,24));
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 String me= message.getText();
	                if(me.equals("")){
	                    JOptionPane.showMessageDialog(null, "����������ַ�Ŷ");
	                }else{
	                    if(JOptionPane.showConfirmDialog(null, "��ȷ��Ҫ������", "����", JOptionPane.YES_NO_OPTION)==0){
	                    	button1.setEnabled(false);
	                 Const.c.userChangeName(me);
	                 
	                    }
	                }
			}
		});	
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setLayout(new BorderLayout());
		message.setPreferredSize(new Dimension(300,40));
		f.add(label,BorderLayout.NORTH);
		f.add(message,BorderLayout.CENTER);

		f.add(button1,BorderLayout.SOUTH);
		f.setSize(250, 130);
		f.setVisible(true);
	
	}



}
