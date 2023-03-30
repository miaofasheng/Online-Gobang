import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicComboBoxUI.ItemHandler;
public class PeoplePeopleNorthPanel extends JPanel{
	private JTextField ipTF = new JTextField(25);
	private JButton listenBtn = new JButton("创建服务器");
	private JButton connectBtn = new JButton("连接");
	private JButton backBtn=new JButton("悔棋");
	private JButton restartBtn=new JButton("再来一局！");
	private JComboBox chooseBackground=new JComboBox<>(new String[]{"1","2","3","4","默认"});
	private JButton explain=new JButton("人人对战游戏说明");
	public PeoplePeopleNorthPanel() {		
		ipTF.setText("localhost");
		setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		listenBtn.setForeground(Color.RED);
		listenBtn.setContentAreaFilled(false);
		connectBtn.setForeground(Color.RED);
		connectBtn.setContentAreaFilled(false);
		backBtn.setContentAreaFilled(false);
		restartBtn.setContentAreaFilled(false);
		explain.setContentAreaFilled(false);
		add(listenBtn);
		add(ipTF);
		add(connectBtn);
		add(backBtn);
		add(restartBtn);
		add(chooseBackground);
	    add(explain);
	    Const.v.changeBackgroundImage("默认");
	    Const.c.closeSingle();
		initBtn();
	}
	private void initBtn() {
		 explain.addActionListener(new ActionListener() {			
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
			            Explain ex=new Explain();		
				}
			});
		 listenBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					Const.n.startListen();
					Const.c.closeSingle();
					listenBtn.setEnabled(false);
				}
			});
			connectBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					String port = null;
					try {
						BufferedReader br = new BufferedReader(new FileReader(Const.tableNumber + "Table.txt"));
						port = br.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
					Const.n.connect(ipTF.getText(), Integer.parseInt(port));
					connectBtn.setEnabled(false);
				}
			});
		backBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			Const.c.userGoback();
			}
		});
		restartBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Const.c.userRestart();
			}
		});
		backBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				backBtn.setEnabled(false);
			}
		});
		chooseBackground.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e) {
				JComboBox cb=(JComboBox)e.getSource();
				String str=cb.getSelectedItem().toString();
				Const.v.changeBackgroundImage(str);
			}
		});
	}
}