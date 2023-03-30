
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

//界面类，这是游戏主体框架
public class AIMainControl{
	
	private JFrame frame;//五子棋游戏窗口
	private AIView chessboard = new AIView();//五子棋盘
	private AIChess chess = new AIChess();	
	private JMenuBar menu;
	private JMenu option;
	private Action replayOption;
	private Action AIFirstOption;
	private Action HumanFirstOption;
	public AIMainControl() {
		frame = new JFrame("人机对战五子棋");
		frame.setLayout(new BorderLayout());
		menu = new JMenuBar();
		option = new JMenu("功能");
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
				//鼠标点击引发下棋事件，处理下棋事件比较繁琐，为此开一个方法
				play(e);
			}
		});	
		frame.setIconImage(frame.getToolkit().getImage("src\\Source\\tubiao.jpeg"));		
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public void replayOptionInit(){
		replayOption = new AbstractAction("重玩一盘", new ImageIcon("src\\Source\\caidan.png")){
			public void actionPerformed(ActionEvent e){
				chessboard.init();
				chess.init();
			}
		};
	}
	public void AIFirstOptionInit(){
		AIFirstOption = new AbstractAction("机器先手", new ImageIcon("src\\Source\\caidan.png")){
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
		HumanFirstOption = new AbstractAction("人类先手", new ImageIcon("src\\Source\\caidan.png")){
			public void actionPerformed(ActionEvent e){
				if(chessboard.isEmpty()){	
					AIChess.FIRST = 1;
				}
			}
		};
	}
	public void play(MouseEvent e){
		int cellSize = chessboard.getCellSize();//每个格子的边长
		int x = (e.getX() - 5) / cellSize;//像素值转换成棋盘坐标
		int y = (e.getY() - 5) / cellSize;//像素值转换成棋盘坐标
		boolean isLegal = chess.isLegal(x, y);
		if(isLegal){
			chessboard.addChessman(x, y, 1);//界面方面加一个棋子
			chess.addChessman(x, y, 1);//逻辑业务方面加一个棋子
			new BackgroundMusic("src\\Source\\yinxiao.mp3").start();
			
			//判断人类是否胜利
			if(chess.isWin(x, y, 1)){
				JOptionPane.showMessageDialog(frame, "人类获胜", "Congratulations，您赢了！", JOptionPane.PLAIN_MESSAGE);
				chessboard.init();
				chess.init();
				return;
			}
			Location loc = chess.searchLocation();
			chessboard.addChessman(loc);
			chess.addChessman(loc.getX(), loc.getY(), loc.getOwner());
			if(chess.isWin(loc.getX(), loc.getY(), -1)){
				JOptionPane.showMessageDialog(frame, "机器获胜", "Congratulations，您输了！", JOptionPane.PLAIN_MESSAGE);
				chessboard.init();
				chess.init();
				return;
			}
		}
	}
}
