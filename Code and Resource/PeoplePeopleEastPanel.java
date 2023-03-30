import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
public class PeoplePeopleEastPanel extends JPanel{
	SimpleDateFormat myfmt = new SimpleDateFormat("时间:HH时mm分ss秒");
	private JTextField time;
	private JTextArea chatArea=new JTextArea(50,20);
    private JTextField messageField=new JTextField(22);
    private JButton sendButton=new JButton("发送内容");
    private JPanel secondPanel=new JPanel();
    private JPanel sendPanel=new JPanel();
    private JPanel functionPanel=new JPanel();
    private JTextField changeNameField=new JTextField(22);
    private JButton changeNameBtn=new JButton("更改名字");
    private JButton begin=new JButton("开始");
    private JLabel label_timeCount;//计时
	private JPanel timecount=new JPanel();
	private JButton fupan;

    public PeoplePeopleEastPanel(){
   
        setLayout(new BorderLayout());
     
        
        time=new JTextField();
        time.addActionListener(new TimeActionListener());
        time.setBorder(new TitledBorder(new EtchedBorder(),"时间"));
       
        time.setOpaque(false);
        time.setFont(new Font("宋体",Font.BOLD,30));
        time.setForeground(Color.BLUE);
        add(time,BorderLayout.NORTH);

        chatArea.setFont(new Font("宋体",Font.BOLD,14));
        chatArea.setBorder(new TitledBorder(new EtchedBorder(),"聊天室"));
        add(new JScrollPane(chatArea),BorderLayout.CENTER);
        secondPanel.setLayout(new GridLayout(2,1));
        sendButton.setPreferredSize(new Dimension(100,30));
        sendButton.setFont(new Font("宋体",Font.BOLD,14));
        changeNameBtn.setPreferredSize(new Dimension(100,30));
        changeNameBtn.setFont(new Font("宋体",Font.BOLD,14));
        changeNameField.setFont(new Font("宋体",Font.BOLD,14));
      
        messageField.setPreferredSize(new Dimension(0,30));
        messageField.setFont(new Font("宋体",Font.BOLD,14));
        sendButton.setContentAreaFilled(false);
        changeNameBtn.setContentAreaFilled(false);



        sendPanel.add(messageField);
        sendPanel.add(sendButton);
        secondPanel.add(sendPanel);

        functionPanel.setLayout(new FlowLayout());
        
        begin.setPreferredSize(new Dimension(100,30));
        begin.setFont(new Font("宋体",Font.BOLD,20));
        begin.setContentAreaFilled(false);
        fupan=new JButton("复盘");
        fupan.setContentAreaFilled(false);
        fupan.setPreferredSize(new Dimension(100,30));
        functionPanel.add(fupan);
        functionPanel.add(changeNameBtn);
        functionPanel.add(begin);
        secondPanel.add(functionPanel);
        add(secondPanel,BorderLayout.SOUTH);
        initial();
    }
    public JTextArea getChatArea(){
        return chatArea;
    }
    public void cleanMessageField(){
        messageField.setText("");
    }
    public void cleanChangeNameField(){
        changeNameField.setText("");
    }
    public void initial(){
        sendButton.addActionListener(new ActionListener(){
            @Override
			public void actionPerformed(ActionEvent e){
               String me= messageField.getText();
               if(me.equals("")){
                   JOptionPane.showMessageDialog(null, "不能输入空字符哦");
               }else{
                Const.c.userSendMessage(me);
               }
            }
        });
        fupan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Fupan a=new Fupan();
			}
		});
        changeNameBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               ChangeName a=new ChangeName();
                
            }
        });
        begin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				begin.setEnabled(false);
				Const.c.userSendMessage("游戏开始了，接受我的对决吧");
			}
		});
    } 
    class TimeActionListener implements ActionListener{
        public TimeActionListener(){
            javax.swing.Timer t=new javax.swing.Timer(1000,this);
            t.start();
        }

        @Override
        public void actionPerformed(ActionEvent ae){
            time.setText(myfmt.format(new java.util.Date()).toString());
        }
    }
    
    
}