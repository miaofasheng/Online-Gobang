import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileInputStream;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicComboBoxUI.ItemHandler;



public class DanjiNorthPanel extends JPanel{
	private JButton backBtn=new JButton("悔棋");
	private JButton restartBtn=new JButton("再来一局！");
	private JButton fupan=new JButton("复盘");
	private JComboBox chooseBackground=new JComboBox<>(new String[]{"1","2","3","4","默认"});
	public DanjiNorthPanel() {		
		setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		add(backBtn);
		add(restartBtn);
		add(chooseBackground);
		add(fupan);

		initBtn();
	}
	private void initBtn() {
		backBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			backBtn.setEnabled(false);
			Const.c.userGoback();
			}
		});
		restartBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Const.c.userRestart();
			}
		});
		fupan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Fupan a=new Fupan();
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