import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.util.*;
import java.text.*;
import javax.swing.JPanel;

//import lll.Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.awt.color.*;



public class PeoplePeopleControl {

	int localColor = MainModel.BLACK;
	int otherColor = MainModel.WHITE;
	int winner=0;
	boolean single = false;
	boolean openDoor = true;
	int backTime=1;
	String nowUserName="我";
	String LastNetName="对手";
	public void closeSingle(){
		single=false;
	}
	public void setSingle(){
		single=true;
	}
	public void setLocalColor(int color){
		localColor = color;
		otherColor = -color;
	}
	public void netPressChess(int row, int col) {
		boolean success = Const.m.putChess(row, col, otherColor);
		if (success) {
			openDoor = true;
			Const.v.repaint();
			winner = Const.m.whoWin(row,col);
			if (winner == MainModel.BLACK) {
				JOptionPane.showMessageDialog(null, "黑棋赢了");
				openDoor=false;
			} else if (winner == MainModel.WHITE) {
				JOptionPane.showMessageDialog(null, "白棋赢了");
				openDoor=false;
			}
		}
	}
	public void netConnect(){
		JOptionPane.showMessageDialog(null, "你已连接成功");
		
	}
	public void connect(){
		JOptionPane.showMessageDialog(null, "连接成功");
		
	}
	public void netGoback(int row,int col){
		Const.m.reset(row, col);
		Const.v.repaint();
	}
	public void netRestart(){
		for(int i=0;i<19;i++){
			for(int j=0;j<19;j++){
				Const.m.reset(i, j);
			}
		}
		openDoor=true;
		backTime=1;
		Const.v.repaint();
	}
	public void netSendMessage(String message){
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
		Const.ep.getChatArea().append(df.format(new Date())+": "+LastNetName+": "+message+"\r\n");
	}
	public void netChangeName(String a){
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
		LastNetName=a;
		Const.ep.getChatArea().append(df.format(new Date())+": 你的对手已将名字更改为"+LastNetName+"\r\n");
	}
	public void userGoback(){
		if(!openDoor&&backTime==1){
		if(JOptionPane.showConfirmDialog(null, "每个人只有一次悔棋机会", "警告", JOptionPane.YES_NO_OPTION)==0){
		openDoor=true;
		backTime--;
		Const.m.goBack();
		Const.v.repaint();
		Const.n.sendGoback(Const.m.getLastRow(), Const.m.getLastCow());
	}
		}
	}

	public void userPressChess(int row, int col) {
		if (!openDoor) {
			return;
		}
		if (single) {
			boolean success = Const.m.putChess(row, col, localColor);
			if (success) {
				localColor = -localColor;

				Const.v.repaint();
				winner = Const.m.whoWin(row,col);
				if (winner == MainModel.BLACK) {
					JOptionPane.showMessageDialog(null, "黑棋赢了");
					openDoor=false;
				} else if (winner == MainModel.WHITE) {
					JOptionPane.showMessageDialog(null, "白棋赢了");
					openDoor=false;
				}
			}
		} else {
			boolean success = Const.m.putChess(row, col, localColor);
			if (success) {
				openDoor = false;
				Const.v.repaint();
				winner = Const.m.whoWin(row,col);
				if (winner == MainModel.BLACK) {
					JOptionPane.showMessageDialog(null, "黑棋赢了");
				} else if (winner == MainModel.WHITE) {
					JOptionPane.showMessageDialog(null, "白棋赢了");
				}

				Const.n.sendChess(row, col);
			}
		}
	}
	public void userRestart(){
		if(winner!=0){
			for(int i=0;i<19;i++){
				for(int j=0;j<19;j++){
					Const.m.reset(i, j);
				}
			}
			openDoor=true;
			backTime=1;
			Const.v.repaint();
			if(!single){
			//Const.n.sendRestart();
		}
		}
		else{
			JOptionPane.showMessageDialog(null, "请下完这一句再开始下一局");
			
		}
	}
	public void userSendMessage(String message){
		
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
		
		Const.ep.getChatArea().append(df.format(new Date())+": "+nowUserName+": "+message+"\r\n");
		Const.ep.cleanMessageField();
		Const.n.sendChat(message);
		
	}
	public void userChangeName(String newName){
		nowUserName=newName;
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
		Const.ep.cleanChangeNameField();
		Const.ep.getChatArea().append(df.format(new Date()) + ": 你已将名字更改为"+nowUserName+"\r\n");
		Const.n.changeName(nowUserName);
		
	}
	public int getBacktime(){
		return backTime;
	}
}
