import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;


public class MainLoadPanel extends JFrame {
    JLabel as;
    JButton PPBtn;
    JButton PCBtn;
    JButton danjiBtn;
    private JTextField time;
    SimpleDateFormat myfmt = new SimpleDateFormat("yyyy年M月d日H时m分s秒");
    ImageIcon image=new ImageIcon("src\\\\Source\\\\zhubeijing.jpeg");
    public JLabel label_timeCount;

	public JLabel getLabel() {return label_timeCount;}
public MainLoadPanel(){
    PPBtn=new JButton("进入联网模式");
    PCBtn=new JButton("进入AI模式");
    danjiBtn=new JButton("进入单机模式");
    as=new JLabel(image);
    initial();
}
    public void initial(){
        PPBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
            	dispose();  
   			GameLobby a=new GameLobby();
        }
        });
        PCBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                dispose();
            	new BackgroundMusic("src\\\\Source\\\\Remember.mp3").start();
                AIMainControl a=new AIMainControl(); 
            }
        });
        danjiBtn.addActionListener(new ActionListener() {
			@Override
				 public void actionPerformed(java.awt.event.ActionEvent e) {
		              dispose();
		        JFrame f = new JFrame("单机模式五子棋");
				f.getContentPane().setBackground(Color.gray);
				f.getContentPane().add(Const.danji,BorderLayout.NORTH);
				f.getContentPane().add(Const.v, BorderLayout.CENTER);
				new BackgroundMusic("src\\\\Source\\\\polang.mp3").start();
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setResizable(false);
				Const.c.setSingle();
				f.setSize(600, 600);
				f.setIconImage(f.getToolkit().getImage("src\\\\Source\\\\tubiao.jpeg"));
				f.setVisible(true);
		            }
		        });
        time=new JTextField();
        time.addActionListener(new TimeActionListener());
        time.setBounds(360, 500, 500, 50);
        time.setOpaque(false);
        time.setFont(new Font("宋体",Font.BOLD,30));
        add(time);
        setPreferredSize(new Dimension(800,600));
        setLayout(null);
        
        
        danjiBtn.setBounds(200, 150, 400, 80);
        danjiBtn.setContentAreaFilled(false);
        danjiBtn.setFont(new Font("宋体",Font.BOLD,40));
        add(danjiBtn);
        
        PPBtn.setBounds(200, 250, 400, 80);
        PPBtn.setContentAreaFilled(false);
        PPBtn.setFont(new Font("宋体",Font.BOLD,40));
        add(PPBtn);
        
        
        PCBtn.setBounds(200, 350, 400, 80);
        PCBtn.setContentAreaFilled(false);
        PCBtn.setFont(new Font("宋体",Font.BOLD,40));
        add(PCBtn);
        as.setBounds(0, 0, 800, 600);
        add(as);
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