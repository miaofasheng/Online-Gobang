import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class GameLobby extends JFrame{
    private JButton button1=new JButton("��1");
    private JButton button2=new JButton("��2");
    private JButton button3=new JButton("��3");
    private	JButton button4=new JButton("��4");
    private	JButton button5=new JButton("��5");
    private	JButton button6=new JButton("��6");
    private	JButton button7=new JButton("��7");
    private	JButton button8=new JButton("��8");
    private JButton button9=new JButton("��9");
    private JButton button10=new JButton("��10");
	private JButton button11=new JButton("��11");
	private JButton button12=new JButton("��12");
	private JButton button13=new JButton("��13");
	private JButton button14=new JButton("��14");
	private JButton button15=new JButton("��15");
	private JButton button16=new JButton("��16");
	private JButton button17=new JButton("��17");
	private JButton button18=new JButton("��18");
	private JButton button19=new JButton("��19");
	private JButton button20=new JButton("��20");
	private JButton button21=new JButton("��21");
	private JButton button22=new JButton("��22");
	private JButton button23=new JButton("��23");
	private JButton button24=new JButton("��24");
public GameLobby() {
	button1.setFont(new Font("����",Font.BOLD,25));
	button2.setFont(new Font("����",Font.BOLD,25));
	button3.setFont(new Font("����",Font.BOLD,25));
	button4.setFont(new Font("����",Font.BOLD,25));
	button5.setFont(new Font("����",Font.BOLD,25));
	button6.setFont(new Font("����",Font.BOLD,25));
	button7.setFont(new Font("����",Font.BOLD,25));
	button8.setFont(new Font("����",Font.BOLD,25));
	button9.setFont(new Font("����",Font.BOLD,25));
	button10.setFont(new Font("����",Font.BOLD,25));
	button11.setFont(new Font("����",Font.BOLD,25));
	button12.setFont(new Font("����",Font.BOLD,25));
	button13.setFont(new Font("����",Font.BOLD,25));
	button14.setFont(new Font("����",Font.BOLD,25));
	button15.setFont(new Font("����",Font.BOLD,25));
	button16.setFont(new Font("����",Font.BOLD,25));
	button17.setFont(new Font("����",Font.BOLD,25));
	button18.setFont(new Font("����",Font.BOLD,25));
	button19.setFont(new Font("����",Font.BOLD,25));
	button20.setFont(new Font("����",Font.BOLD,25));
	button21.setFont(new Font("����",Font.BOLD,25));
	button22.setFont(new Font("����",Font.BOLD,25));
	button23.setFont(new Font("����",Font.BOLD,25));
	button24.setFont(new Font("����",Font.BOLD,25));
	button1.setContentAreaFilled(false);
	button2.setContentAreaFilled(false);
	button3.setContentAreaFilled(false);
	button4.setContentAreaFilled(false);
	button5.setContentAreaFilled(false);
	button6.setContentAreaFilled(false);
	button7.setContentAreaFilled(false);
	button8.setContentAreaFilled(false);
	button9.setContentAreaFilled(false);
	button10.setContentAreaFilled(false);
	button11.setContentAreaFilled(false);
	button12.setContentAreaFilled(false);
	button13.setContentAreaFilled(false);
	button14.setContentAreaFilled(false);
	button15.setContentAreaFilled(false);
	button16.setContentAreaFilled(false);
	button17.setContentAreaFilled(false);
	button18.setContentAreaFilled(false);
	button19.setContentAreaFilled(false);
	button20.setContentAreaFilled(false);
	button21.setContentAreaFilled(false);
	button22.setContentAreaFilled(false);
	button23.setContentAreaFilled(false);
	button24.setContentAreaFilled(false);	
	final JFrame f = new JFrame("�˻���ս������");
	ImageIcon image=new ImageIcon("src\\Source\\GameLogger.jpeg");
	JLabel label=new JLabel(image);
	label.setSize(image.getIconWidth(), image.getIconHeight());
	f.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
	JPanel pan=(JPanel)f.getContentPane();
	pan.setOpaque(false);
	pan.setLayout(new GridLayout(6,8));
	pan.add(button1);
	pan.add(button2);
	pan.add(button3);
	pan.add(button4);
	pan.add(button5);
	pan.add(button6);
	pan.add(button7);
	pan.add(button8);
	pan.add(button9);
	pan.add(button10);
	pan.add(button11);
	pan.add(button12);
	pan.add(button13);
	pan.add(button14);
	pan.add(button15);
	pan.add(button16);
	pan.add(button17);
	pan.add(button18);
	pan.add(button19);
	pan.add(button20);
	pan.add(button21);
	pan.add(button22);
	pan.add(button23);
	pan.add(button24);
	init();
	f.setSize(800, 600);
	f.setLocationRelativeTo(null);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setResizable(false);
	f.setVisible(true);
}

    public void init()
    {
    	 button1.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(java.awt.event.ActionEvent e) {
                 dispose(); 
    			 Const.tableNumber = 1;

        JFrame f = new JFrame("��1��");
 		f.getContentPane().setBackground(Color.gray);
 		f.getContentPane().add(Const.np,BorderLayout.NORTH);
 		f.getContentPane().add(Const.v, BorderLayout.CENTER);
 		f.getContentPane().add(Const.ep,BorderLayout.EAST);
 		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		f.setIconImage(f.getToolkit().getImage("src\\Source\\tubiao.jpeg"));
 		f.setResizable(false);
 		new BackgroundMusic("src\\Source\\whatmakesyou.mp3").start();
 		f.setSize(800, 600);
 		f.setVisible(true);
         }
         });
    	 button2.addActionListener(new ActionListener(){
    		 @Override
    		 public void actionPerformed(java.awt.event.ActionEvent e) {
    			 dispose();  
    			 Const.tableNumber = 2;
    			 JFrame f = new JFrame("��2��");
    			 f.getContentPane().setBackground(Color.gray);
    			 f.getContentPane().add(Const.np,BorderLayout.NORTH);
    			 f.getContentPane().add(Const.v, BorderLayout.CENTER);
    			 f.getContentPane().add(Const.ep,BorderLayout.EAST);
    			 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    			 f.setIconImage(f.getToolkit().getImage("src\\Source\\tubiao.jpeg"));
    			 f.setResizable(false);
    			 new BackgroundMusic("src\\Source\\whatmakesyou.mp3").start();
    			 f.setSize(800, 600);
    			 f.setVisible(true);
    		 }
    	 });
    	 button3.addActionListener(new ActionListener(){
    		 @Override
    		 public void actionPerformed(java.awt.event.ActionEvent e) {
    			 dispose();  
    			 Const.tableNumber = 3;
    			 JFrame f = new JFrame("��3��");
    			 f.getContentPane().setBackground(Color.gray);
    			 f.getContentPane().add(Const.np,BorderLayout.NORTH);
    			 f.getContentPane().add(Const.v, BorderLayout.CENTER);
    			 f.getContentPane().add(Const.ep,BorderLayout.EAST);
    			 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    			 f.setIconImage(f.getToolkit().getImage("src\\Source\\tubiao.jpeg"));
    			 f.setResizable(false);
    			 new BackgroundMusic("src\\Source\\whatmakesyou.mp3").start();
    			 f.setSize(800, 600);
    			 f.setVisible(true);
    		 }
    	 });
    	 button4.addActionListener(new ActionListener(){
    		 @Override
    		 public void actionPerformed(java.awt.event.ActionEvent e) {
    			 dispose();  
    			 Const.tableNumber = 4;
    			 JFrame f = new JFrame("��4��");
    			 f.getContentPane().setBackground(Color.gray);
    			 f.getContentPane().add(Const.np,BorderLayout.NORTH);
    			 f.getContentPane().add(Const.v, BorderLayout.CENTER);
    			 f.getContentPane().add(Const.ep,BorderLayout.EAST);
    			 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    			 f.setIconImage(f.getToolkit().getImage("src\\Source\\tubiao.jpeg"));
    			 f.setResizable(false);
    			 new BackgroundMusic("src\\Source\\whatmakesyou.mp3").start();
    			 f.setSize(800, 600);
    			 f.setVisible(true);
    		 }
    	 });
    	 button5.addActionListener(new ActionListener(){
    		 @Override
    		 public void actionPerformed(java.awt.event.ActionEvent e) {
    			 dispose();  
    			 Const.tableNumber = 5;
    			 JFrame f = new JFrame("��5��");
    			 f.getContentPane().setBackground(Color.gray);
    			 f.getContentPane().add(Const.np,BorderLayout.NORTH);
    			 f.getContentPane().add(Const.v, BorderLayout.CENTER);
    			 f.getContentPane().add(Const.ep,BorderLayout.EAST);
    			 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    			 f.setIconImage(f.getToolkit().getImage("src\\Source\\tubiao.jpeg"));
    			 f.setResizable(false);
    			 new BackgroundMusic("src\\Source\\whatmakesyou.mp3").start();
    			 f.setSize(800, 600);
    			 f.setVisible(true);
    		 }
    	 });
    	 button6.addActionListener(new ActionListener(){
    		 @Override
    		 public void actionPerformed(java.awt.event.ActionEvent e) {
    			 dispose();  
    			 Const.tableNumber = 6;
    			 JFrame f = new JFrame("��6��");
    			 f.getContentPane().setBackground(Color.gray);
    			 f.getContentPane().add(Const.np,BorderLayout.NORTH);
    			 f.getContentPane().add(Const.v, BorderLayout.CENTER);
    			 f.getContentPane().add(Const.ep,BorderLayout.EAST);
    			 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    			 f.setIconImage(f.getToolkit().getImage("src\\Source\\tubiao.jpeg"));
    			 f.setResizable(false);
    			 new BackgroundMusic("src\\Source\\whatmakesyou.mp3").start();
    			 f.setSize(800, 600);
    			 f.setVisible(true);
    		 }
    	 });
    	 button7.addActionListener(new ActionListener(){
    		 @Override
    		 public void actionPerformed(java.awt.event.ActionEvent e) {
    			 dispose();  
    			 Const.tableNumber = 7;
    			 JFrame f = new JFrame("��7��");
    			 f.getContentPane().setBackground(Color.gray);
    			 f.getContentPane().add(Const.np,BorderLayout.NORTH);
    			 f.getContentPane().add(Const.v, BorderLayout.CENTER);
    			 f.getContentPane().add(Const.ep,BorderLayout.EAST);
    			 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    			 f.setIconImage(f.getToolkit().getImage("src\\Source\\tubiao.jpeg"));
    			 f.setResizable(false);
    			 new BackgroundMusic("src\\Source\\whatmakesyou.mp3").start();
    			 f.setSize(800, 600);
    			 f.setVisible(true);
    		 }
    	 });
    	 button8.addActionListener(new ActionListener(){
    		 @Override
    		 public void actionPerformed(java.awt.event.ActionEvent e) {
    			 dispose();  
    			 Const.tableNumber = 8;
    			 JFrame f = new JFrame("��8��");
    			 f.getContentPane().setBackground(Color.gray);
    			 f.getContentPane().add(Const.np,BorderLayout.NORTH);
    			 f.getContentPane().add(Const.v, BorderLayout.CENTER);
    			 f.getContentPane().add(Const.ep,BorderLayout.EAST);
    			 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    			 f.setIconImage(f.getToolkit().getImage("src\\Source\\tubiao.jpeg"));
    			 f.setResizable(false);
    			 new BackgroundMusic("src\\\\Source\\\\whatmakesyou.mp3").start();
    			 f.setSize(800, 600);
    			 f.setVisible(true);
    		 }
    	 });
    	 button9.addActionListener(new ActionListener(){
    		 @Override
    		 public void actionPerformed(java.awt.event.ActionEvent e) {
    			 dispose();  
    			 Const.tableNumber = 9;
    			 JFrame f = new JFrame("��9��");
    			 f.getContentPane().setBackground(Color.gray);
    			 f.getContentPane().add(Const.np,BorderLayout.NORTH);
    			 f.getContentPane().add(Const.v, BorderLayout.CENTER);
    			 f.getContentPane().add(Const.ep,BorderLayout.EAST);
    			 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    			 f.setIconImage(f.getToolkit().getImage("src\\\\Source\\\\tubiao.jpeg"));
    			 f.setResizable(false);
    			 new BackgroundMusic("src\\\\Source\\\\whatmakesyou.mp3").start();
    			 f.setSize(800, 600);
    			 f.setVisible(true);
    		 }
    	 });
    	 button10.addActionListener(new ActionListener(){
    		 @Override
    		 public void actionPerformed(java.awt.event.ActionEvent e) {
    			 dispose();  
    			 Const.tableNumber = 10;
    			 JFrame f = new JFrame("��10��");
    			 f.getContentPane().setBackground(Color.gray);
    			 f.getContentPane().add(Const.np,BorderLayout.NORTH);
    			 f.getContentPane().add(Const.v, BorderLayout.CENTER);
    			 f.getContentPane().add(Const.ep,BorderLayout.EAST);
    			 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    			 f.setIconImage(f.getToolkit().getImage("src\\\\Source\\\\tubiao.jpeg"));
    			 f.setResizable(false);
    			 new BackgroundMusic("src\\\\Source\\\\whatmakesyou.mp3").start();
    			 f.setSize(800, 600);
    			 f.setVisible(true);
    		 }
    	 });
    	 button11.addActionListener(new ActionListener(){
    		 @Override
    		 public void actionPerformed(java.awt.event.ActionEvent e) {
    			 dispose();  
    			 Const.tableNumber = 11;
    			 JFrame f = new JFrame("��11��");
    			 f.getContentPane().setBackground(Color.gray);
    			 f.getContentPane().add(Const.np,BorderLayout.NORTH);
    			 f.getContentPane().add(Const.v, BorderLayout.CENTER);
    			 f.getContentPane().add(Const.ep,BorderLayout.EAST);
    			 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    			 f.setIconImage(f.getToolkit().getImage("src\\\\Source\\\\tubiao.jpeg"));
    			 f.setResizable(false);
    			 new BackgroundMusic("src\\\\Source\\\\whatmakesyou.mp3").start();
    			 f.setSize(800, 600);
    			 f.setVisible(true);
    		 }
    	 });
    	 button12.addActionListener(new ActionListener(){
    		 @Override
    		 public void actionPerformed(java.awt.event.ActionEvent e) {
    			 dispose();  
    			 Const.tableNumber = 12;
    			 JFrame f = new JFrame("��12��");
    			 f.getContentPane().setBackground(Color.gray);
    			 f.getContentPane().add(Const.np,BorderLayout.NORTH);
    			 f.getContentPane().add(Const.v, BorderLayout.CENTER);
    			 f.getContentPane().add(Const.ep,BorderLayout.EAST);
    			 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    			 f.setIconImage(f.getToolkit().getImage("src\\\\Source\\\\tubiao.jpeg"));
    			 f.setResizable(false);
    			 new BackgroundMusic("src\\\\Source\\\\whatmakesyou.mp3").start();
    			 f.setSize(800, 600);
    			 f.setVisible(true);
    		 }
    	 });
    	 button13.addActionListener(new ActionListener(){
    		 @Override
    		 public void actionPerformed(java.awt.event.ActionEvent e) {
    			 dispose();  
    			 Const.tableNumber = 13;
    			 JFrame f = new JFrame("��13��");
    			 f.getContentPane().setBackground(Color.gray);
    			 f.getContentPane().add(Const.np,BorderLayout.NORTH);
    			 f.getContentPane().add(Const.v, BorderLayout.CENTER);
    			 f.getContentPane().add(Const.ep,BorderLayout.EAST);
    			 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    			 f.setIconImage(f.getToolkit().getImage("src\\\\Source\\\\tubiao.jpeg"));
    			 f.setResizable(false);
    			 new BackgroundMusic("src\\\\Source\\\\whatmakesyou.mp3").start();
    			 f.setSize(800, 600);
    			 f.setVisible(true);
    		 }
    	 });
    	 button14.addActionListener(new ActionListener(){
    		 @Override
    		 public void actionPerformed(java.awt.event.ActionEvent e) {
    			 dispose(); 
    			 Const.tableNumber = 14;
    			 JFrame f = new JFrame("��14��");
    			 f.getContentPane().setBackground(Color.gray);
    			 f.getContentPane().add(Const.np,BorderLayout.NORTH);
    			 f.getContentPane().add(Const.v, BorderLayout.CENTER);
    			 f.getContentPane().add(Const.ep,BorderLayout.EAST);
    			 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    			 f.setIconImage(f.getToolkit().getImage("src\\\\Source\\\\tubiao.jpeg"));
    			 f.setResizable(false);
    			 new BackgroundMusic("src\\\\Source\\\\whatmakesyou.mp3").start();
    			 f.setSize(800, 600);
    			 f.setVisible(true);
    		 }
    	 });
    	 button15.addActionListener(new ActionListener(){
    		 @Override
    		 public void actionPerformed(java.awt.event.ActionEvent e) {
    			 dispose();  
    			 Const.tableNumber = 15;
    			 JFrame f = new JFrame("��15��");
    			 f.getContentPane().setBackground(Color.gray);
    			 f.getContentPane().add(Const.np,BorderLayout.NORTH);
    			 f.getContentPane().add(Const.v, BorderLayout.CENTER);
    			 f.getContentPane().add(Const.ep,BorderLayout.EAST);
    			 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    			 f.setIconImage(f.getToolkit().getImage("src\\\\Source\\\\tubiao.jpeg"));
    			 f.setResizable(false);
    			 new BackgroundMusic("src\\\\Source\\\\whatmakesyou.mp3").start();
    			 f.setSize(800, 600);
    			 f.setVisible(true);
    		 }
    	 });
    	 button16.addActionListener(new ActionListener(){
    		 @Override
    		 public void actionPerformed(java.awt.event.ActionEvent e) {
    			 dispose(); 
    			 Const.tableNumber = 16;
    			 JFrame f = new JFrame("��16��");
    			 f.getContentPane().setBackground(Color.gray);
    			 f.getContentPane().add(Const.np,BorderLayout.NORTH);
    			 f.getContentPane().add(Const.v, BorderLayout.CENTER);
    			 f.getContentPane().add(Const.ep,BorderLayout.EAST);
    			 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    			 f.setIconImage(f.getToolkit().getImage("src\\\\Source\\\\tubiao.jpeg"));
    			 f.setResizable(false);
    			 new BackgroundMusic("src\\\\Source\\\\whatmakesyou.mp3").start();
    			 f.setSize(800, 600);
    			 f.setVisible(true);
    		 }
    	 });
    	 button17.addActionListener(new ActionListener(){
    		 @Override
    		 public void actionPerformed(java.awt.event.ActionEvent e) {
    			 dispose(); 
    			 Const.tableNumber = 17;
    			 JFrame f = new JFrame("��17��");
    			 f.getContentPane().setBackground(Color.gray);
    			 f.getContentPane().add(Const.np,BorderLayout.NORTH);
    			 f.getContentPane().add(Const.v, BorderLayout.CENTER);
    			 f.getContentPane().add(Const.ep,BorderLayout.EAST);
    			 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    			 f.setIconImage(f.getToolkit().getImage("src\\\\Source\\\\tubiao.jpeg"));
    			 f.setResizable(false);
    			 new BackgroundMusic("src\\\\Source\\\\whatmakesyou.mp3").start();
    			 f.setSize(800, 600);
    			 f.setVisible(true);
    		 }
    	 });
    	 button18.addActionListener(new ActionListener(){
    		 @Override
    		 public void actionPerformed(java.awt.event.ActionEvent e) {
    			 dispose();  
    			 Const.tableNumber = 18;
    			 JFrame f = new JFrame("��18��");
    			 f.getContentPane().setBackground(Color.gray);
    			 f.getContentPane().add(Const.np,BorderLayout.NORTH);
    			 f.getContentPane().add(Const.v, BorderLayout.CENTER);
    			 f.getContentPane().add(Const.ep,BorderLayout.EAST);
    			 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    			 f.setIconImage(f.getToolkit().getImage("src\\\\Source\\\\tubiao.jpeg"));
    			 f.setResizable(false);
    			 new BackgroundMusic("src\\\\Source\\\\whatmakesyou.mp3").start();
    			 f.setSize(800, 600);
    			 f.setVisible(true);
    		 }
    	 });
    	 button19.addActionListener(new ActionListener(){
    		 @Override
    		 public void actionPerformed(java.awt.event.ActionEvent e) {
    			 dispose();  
    			 Const.tableNumber = 19;
    			 JFrame f = new JFrame("��19��");
    			 f.getContentPane().setBackground(Color.gray);
    			 f.getContentPane().add(Const.np,BorderLayout.NORTH);
    			 f.getContentPane().add(Const.v, BorderLayout.CENTER);
    			 f.getContentPane().add(Const.ep,BorderLayout.EAST);
    			 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    			 f.setIconImage(f.getToolkit().getImage("src\\\\Source\\\\tubiao.jpeg"));
    			 f.setResizable(false);
    			 new BackgroundMusic("src\\\\Source\\\\whatmakesyou.mp3").start();
    			 f.setSize(800, 600);
    			 f.setVisible(true);
    		 }
    	 });
    	 button20.addActionListener(new ActionListener(){
    		 @Override
    		 public void actionPerformed(java.awt.event.ActionEvent e) {
    			 dispose();  
    			 Const.tableNumber = 20;
    			 JFrame f = new JFrame("��20��");
    			 f.getContentPane().setBackground(Color.gray);
    			 f.getContentPane().add(Const.np,BorderLayout.NORTH);
    			 f.getContentPane().add(Const.v, BorderLayout.CENTER);
    			 f.getContentPane().add(Const.ep,BorderLayout.EAST);
    			 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    			 f.setIconImage(f.getToolkit().getImage("src\\\\Source\\\\tubiao.jpeg"));
    			 f.setResizable(false);
    			 new BackgroundMusic("src\\\\Source\\\\whatmakesyou.mp3").start();
    			 f.setSize(800, 600);
    			 f.setVisible(true);
    		 }
    	 });
    	 button21.addActionListener(new ActionListener(){
    		 @Override
    		 public void actionPerformed(java.awt.event.ActionEvent e) {
    			 dispose(); 
    			 Const.tableNumber = 21;
    			 JFrame f = new JFrame("��21��");
    			 f.getContentPane().setBackground(Color.gray);
    			 f.getContentPane().add(Const.np,BorderLayout.NORTH);
    			 f.getContentPane().add(Const.v, BorderLayout.CENTER);
    			 f.getContentPane().add(Const.ep,BorderLayout.EAST);
    			 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    			 f.setIconImage(f.getToolkit().getImage("src\\\\Source\\\\tubiao.jpeg"));
    			 f.setResizable(false);
    			 new BackgroundMusic("src\\\\Source\\\\whatmakesyou.mp3").start();
    			 f.setSize(800, 600);
    			 f.setVisible(true);
    		 }
    	 });
    	 button22.addActionListener(new ActionListener(){
    		 @Override
    		 public void actionPerformed(java.awt.event.ActionEvent e) {
    			 dispose();  
    			 Const.tableNumber = 22;
    			 JFrame f = new JFrame("��22��");
    			 f.getContentPane().setBackground(Color.gray);
    			 f.getContentPane().add(Const.np,BorderLayout.NORTH);
    			 f.getContentPane().add(Const.v, BorderLayout.CENTER);
    			 f.getContentPane().add(Const.ep,BorderLayout.EAST);
    			 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    			 f.setIconImage(f.getToolkit().getImage("src\\\\Source\\\\tubiao.jpeg"));
    			 f.setResizable(false);
    			 new BackgroundMusic("src\\\\Source\\\\whatmakesyou.mp3").start();
    			 f.setSize(800, 600);
    			 f.setVisible(true);
    		 }
    	 });
    	 button23.addActionListener(new ActionListener(){
    		 @Override
    		 public void actionPerformed(java.awt.event.ActionEvent e) {
    			 dispose();  
    			 Const.tableNumber = 23;
    			 JFrame f = new JFrame("��23��");
    			 f.getContentPane().setBackground(Color.gray);
    			 f.getContentPane().add(Const.np,BorderLayout.NORTH);
    			 f.getContentPane().add(Const.v, BorderLayout.CENTER);
    			 f.getContentPane().add(Const.ep,BorderLayout.EAST);
    			 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    			 f.setIconImage(f.getToolkit().getImage("src\\\\Source\\\\tubiao.jpeg"));
    			 f.setResizable(false);
    			 new BackgroundMusic("src\\\\Source\\\\whatmakesyou.mp3").start();
    			 f.setSize(800, 600);
    			 f.setVisible(true);
    		 }
    	 });
    	 button24.addActionListener(new ActionListener(){
    		 @Override
    		 public void actionPerformed(java.awt.event.ActionEvent e) {
    			 dispose();  
    			 Const.tableNumber = 24;
    			 JFrame f = new JFrame("��24��");
    			 f.getContentPane().setBackground(Color.gray);
    			 f.getContentPane().add(Const.np,BorderLayout.NORTH);
    			 f.getContentPane().add(Const.v, BorderLayout.CENTER);
    			 f.getContentPane().add(Const.ep,BorderLayout.EAST);
    			 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    			 f.setIconImage(f.getToolkit().getImage("src\\\\Source\\\\tubiao.jpeg"));
    			 f.setResizable(false);
    			 new BackgroundMusic("src\\\\Source\\\\whatmakesyou.mp3").start();
    			 f.setSize(800, 600);
    			 f.setVisible(true);
    		 }
    	 });
    }
}
