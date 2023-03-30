import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Explain extends JFrame{
	public Explain() {
		// TODO Auto-generated constructor stub
		final JFrame f = new JFrame("人机对战五子棋");
		ImageIcon image=new ImageIcon("src\\Source\\shuoming.jpg");
		JLabel label=new JLabel(image);
		label.setSize(image.getIconWidth(), image.getIconHeight());
		f.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
		JPanel pan=(JPanel)f.getContentPane();
		pan.setOpaque(false);
		pan.setLayout(new FlowLayout());
		f.setSize(800, 600);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setVisible(true);
	}
}
