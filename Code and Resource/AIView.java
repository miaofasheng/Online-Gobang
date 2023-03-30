

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;

public class AIView extends JPanel{
	ImageIcon image=new ImageIcon("src\\Source\\ma.jpeg");
	public static final int CHESSBOARD_SIZE = 19;//���̴�С15X15
	private ArrayList<Location> locationList = new ArrayList<>();//���������п������ӵ�λ���������Ϣ
	private Color backgroundColor = new Color(255, 245, 186);//���̱���ɫ
	private Color lineColor = new Color(66, 66, 66);   //����������ɫ
	private int margin = 20;//���̱�Ե����
	public void init(){
		locationList.clear();
		repaint();
	}
	//����paint����
	public void paint(Graphics g){
		super.paint(g);
		drawChessboard(g);
		drawChessman(g);
		
	}

	//������
	public void drawChessboard(Graphics g){
		//�Ȼ�����
		g.drawImage(image.getImage(),0,0, this.getWidth(), this.getHeight(),this);g.setColor(backgroundColor); 
		//����
		g.setColor(lineColor);
		int cellSize = (this.getWidth() - 2*margin)/(CHESSBOARD_SIZE - 1);//ÿ�����ӵı߳�
		for(int i = 0; i < CHESSBOARD_SIZE; i++){
			g.drawLine(margin, margin + i*cellSize, this.getWidth() - margin, margin + i*cellSize);//������
			g.drawLine(margin + i*cellSize, margin, margin + i*cellSize, this.getHeight() - margin);//������
		}
	}
	
	//������
	public void drawChessman(Graphics g){
		for(int i = 0; i < locationList.size(); i++){
			Location loc = locationList.get(i);
			//�����Ⱥ�����������Ϊ��ɫ�Ͱ�ɫ
			if(loc.getOwner() == 1){
				g.setColor(Color.BLACK);	
			}else{
				g.setColor(Color.WHITE);
			}
			
			int cellSize = (this.getWidth() - 2*margin)/(CHESSBOARD_SIZE - 1);//ÿ�����ӵı߳�
			//������
			g.fillOval(margin + cellSize*loc.getX() - cellSize/2, margin + cellSize*loc.getY() - cellSize/2, cellSize, cellSize);
			
		}
	}

	//����
	public void addChessman(int x, int y, int owner){
		locationList.add(new Location(x, y, owner));
		repaint();
	}

	//����
	public void addChessman(Location loc){
		locationList.add(loc);
		repaint();
	}

	//��������ÿ��С���ӵĴ�С
	public int getCellSize(){
		return (this.getWidth() - 2*margin)/(CHESSBOARD_SIZE - 1);
	}
	
	//�ж������Ƿ�û������
	public boolean isEmpty(){
		return locationList.size() == 0 ? true : false;
	}
}
