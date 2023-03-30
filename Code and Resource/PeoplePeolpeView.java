import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class PeoplePeolpeView extends JPanel {
	BufferedImage ima = null;
	ImageIcon image=new ImageIcon("src\\\\Source\\\\3.jpg");
	int sx = 20, sy = 20, unit = 20;
	int gap = 30;
	public PeoplePeolpeView()  {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent arg0) {
				int w = getWidth();
				int h = getHeight();
				int min = Math.min(w, h);
				unit = (min-gap*2)/(MainModel.WIDTH-1);
				sx = (w - unit*(MainModel.WIDTH-1))/2;
				sy = (h - unit*(MainModel.WIDTH-1))/2;	
				repaint();
			}
		});
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				int row = (y-sy)/unit;
				if((y-sy)%unit>unit/2){
					row++;
				}
				int col = (x-sx)/unit;
				if((x-sx)%unit > unit/2){
					col++;
				}
				Const.c.userPressChess(row,col);
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image.getImage(),0,0, this.getWidth(), this.getHeight(),this);
		drawPanel(g);
		drawChess(g);
	}

	public void changeBackgroundImage(String a){
		switch(a){
			case "1":
			image=new ImageIcon("src\\\\Source\\\\1.jpeg");
			Const.v.repaint();
			break;
			case "2":
			image=new ImageIcon("src\\\\Source\\\\2.jpg");
			Const.v.repaint();
			break;
			case "3":
			image=new ImageIcon("src\\\\Source\\\\3.jpeg");
			Const.v.repaint();
			break;
			case "4":
			image=new ImageIcon("src\\\\Source\\\\4.jpeg");
			Const.v.repaint();
			break;
			case "д╛хо":
			image=new ImageIcon("src\\\\Source\\\\moren.jpeg ");
			Const.v.repaint();
			break;
		}
	}
	private void drawChess(Graphics g) {
		
		Color oldColor = g.getColor();
		for(int row=0;row<MainModel.WIDTH;row++){
			for(int col=0;col<MainModel.WIDTH;col++){
				int chess = Const.m.getChess(row, col);
				if(chess==MainModel.BLACK){
					g.setColor(Color.black);
					g.fillOval(sx+col*unit-unit/2, sy+row*unit-unit/2, unit, unit);
				}else if(chess==MainModel.WHITE){
					g.setColor(Color.white);
					g.fillOval(sx+col*unit-unit/2, sy+row*unit-unit/2, unit, unit);
				}
			}
		}
		g.setColor(oldColor);
	}
	private void drawPanel(Graphics g) {
		for(int i = 0 ; i< MainModel.WIDTH;i++){
			g.drawLine(sx, sy+unit*i, sx+(MainModel.WIDTH-1)*unit, sy+unit*i);
			g.drawLine(sx+unit*i, sy, sx+unit*i, sy+(MainModel.WIDTH-1)*unit);
		}
	}
}