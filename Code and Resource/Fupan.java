import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class Fupan extends JFrame{
	public Fupan() {
		// TODO Auto-generated constructor stub
		JFrame f=new JFrame("复盘");
		JLabel label=new JLabel("复盘如下");
		
		
		JTextArea chatArea=new JTextArea();
		
		chatArea.setFont(new Font("宋体",Font.BOLD,14));
	    chatArea.setBorder(new TitledBorder(new EtchedBorder(),"复盘如下:"));
	    for(int i=0;i<Const.fupanArray.size();i+=3)
	    {
	    	String str1=null;
	    	String str2=null;
	    	if(Const.fupanArray.get(i).equals("1"))
	    	{	
	    		str1="黑棋";
	    		str2="第"+Integer.toString(i/3+1)+"步"+str1+"下在了("+Const.fupanArray.get(i+1)+","+Const.fupanArray.get(i+2)+")"+'\n';
	    	    chatArea.append(str2);
	    	}
	    	if(Const.fupanArray.get(i).equals("-1"))
	    	{	
	    		str1="白棋";
	    		str2="第"+Integer.toString(i/3+1)+"步"+str1+"下在了("+Const.fupanArray.get(i+1)+","+Const.fupanArray.get(i+2)+")"+'\n';
	    	    chatArea.append(str2);
	    	}
	    }  
	    add(new JScrollPane(chatArea),BorderLayout.CENTER);
		label.setFont(new Font("宋体",Font.BOLD,24));
		f.setLayout(new BorderLayout());
		f.add(label,BorderLayout.NORTH);
		f.add(new JScrollPane(chatArea),BorderLayout.CENTER);
		f.setVisible(true);
		f.setResizable(false);
		f.setSize(300, 600);
	}
}
