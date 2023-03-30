
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

//�����࣬������Ϸ������
public class AIMainControl{
	
	private JFrame frame;//��������Ϸ����
	private AIView chessboard = new AIView();//��������
	private AIChess chess = new AIChess();	
	private JMenuBar menu;
	private JMenu option;
	private Action replayOption;
	private Action AIFirstOption;
	private Action HumanFirstOption;
	public AIMainControl() {
		frame = new JFrame("�˻���ս������");
		frame.setLayout(new BorderLayout());
		menu = new JMenuBar();
		option = new JMenu("����");
		menu.add(option);
		replayOptionInit();
		option.add(replayOption);
		AIFirstOptionInit();
		option.add(AIFirstOption);
		HumanFirstOptionInit();
		option.add(HumanFirstOption);		
		frame.setJMenuBar(menu);
		frame.add(chessboard,BorderLayout.CENTER);
		frame.setResizable(false);
		frame.setBounds(300, 10, 800, 800);
		chessboard.init();
		chess.init();	
		chessboard.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				//��������������¼������������¼��ȽϷ�����Ϊ�˿�һ������
				play(e);
			}
		});	
		frame.setIconImage(frame.getToolkit().getImage("src\\Source\\tubiao.jpeg"));		
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public void replayOptionInit(){
		replayOption = new AbstractAction("����һ��", new ImageIcon("src\\Source\\caidan.png")){
			public void actionPerformed(ActionEvent e){
				chessboard.init();
				chess.init();
			}
		};
	}
	public void AIFirstOptionInit(){
		AIFirstOption = new AbstractAction("��������", new ImageIcon("src\\Source\\caidan.png")){
			public void actionPerformed(ActionEvent e){
				if(chessboard.isEmpty()){
					AIChess.FIRST = -1;
					chessboard.addChessman(7, 7, -1);
					chess.addChessman(7, 7, -1);
				}
			}
		};
	}
	public void HumanFirstOptionInit(){
		HumanFirstOption = new AbstractAction("��������", new ImageIcon("src\\Source\\caidan.png")){
			public void actionPerformed(ActionEvent e){
				if(chessboard.isEmpty()){	
					AIChess.FIRST = 1;
				}
			}
		};
	}
	public void play(MouseEvent e){
		int cellSize = chessboard.getCellSize();//ÿ�����ӵı߳�
		int x = (e.getX() - 5) / cellSize;//����ֵת������������
		int y = (e.getY() - 5) / cellSize;//����ֵת������������
		boolean isLegal = chess.isLegal(x, y);
		if(isLegal){
			chessboard.addChessman(x, y, 1);//���淽���һ������
			chess.addChessman(x, y, 1);//�߼�ҵ�����һ������
			new BackgroundMusic("src\\Source\\yinxiao.mp3").start();
			
			//�ж������Ƿ�ʤ��
			if(chess.isWin(x, y, 1)){
				JOptionPane.showMessageDialog(frame, "�����ʤ", "Congratulations����Ӯ�ˣ�", JOptionPane.PLAIN_MESSAGE);
				chessboard.init();
				chess.init();
				return;
			}
			Location loc = chess.searchLocation();
			chessboard.addChessman(loc);
			chess.addChessman(loc.getX(), loc.getY(), loc.getOwner());
			if(chess.isWin(loc.getX(), loc.getY(), -1)){
				JOptionPane.showMessageDialog(frame, "������ʤ", "Congratulations�������ˣ�", JOptionPane.PLAIN_MESSAGE);
				chessboard.init();
				chess.init();
				return;
			}
		}
	}
}
