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
		final JButton button1=new JButton("确定");
		JFrame f=new JFrame("修改名字");
		final JTextField message=new JTextField();
		JLabel label=new JLabel("请输入你要修改的ID:");
		label.setFont(new Font("宋体",Font.BOLD,24));
		
		message.setFont(new Font("宋体",Font.BOLD,24));
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 String me= message.getText();
	                if(me.equals("")){
	                    JOptionPane.showMessageDialog(null, "不能输入空字符哦");
	                }else{
	                    if(JOptionPane.showConfirmDialog(null, "你确定要改名吗", "警告", JOptionPane.YES_NO_OPTION)==0){
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
