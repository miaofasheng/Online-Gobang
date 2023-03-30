import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
public class Net {
	public static int PORT = 0;
	private BufferedReader in;
	private PrintWriter out;
	private Socket s;
	public void startListen() {
		new Thread() {
			public void run() {
				try {
					ServerSocket ss = new ServerSocket(0, 1, InetAddress.getByName("127.0.0.1"));
					PORT = ss.getLocalPort();
					File f = new File(Const.tableNumber + "Table.txt");
					OutputStream os = new FileOutputStream(f);
					PrintWriter pw = new PrintWriter(os);
					pw.println(Integer.toString(PORT));
					pw.close();
					os.close();
					
					s = ss.accept();
					Const.c.connect();
					in = new BufferedReader(new InputStreamReader(
							s.getInputStream()));
					out = new PrintWriter(s.getOutputStream(), true);
					startReadThread();
				} catch (Exception e) {
					e.printStackTrace();
				}
			};
		}.start();
		Const.c.setLocalColor(MainModel.BLACK);
	}
	private void startReadThread() {
		new Thread() {
			public void run() {
				while (true) {
					try {
						String line = in.readLine();
						parseLine(line);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
	protected void parseLine(String line) {
		if (line.startsWith("PutChess:")) {
			parsePutChess(line);
		}else if(line.startsWith("Chat:")){
			parseChat(line);
		}else if(line.startsWith("Goback")){
			parseGoback(line);
		}else if(line.startsWith("Restart")){
			parseRestart();
		}else if(line.startsWith("ChangeName")){
			parseChangeName(line);
		}
	}
	private void parseChat(String line) {
		line=line.substring(5);
		Const.c.netSendMessage(line);		
	}
	private void parseGoback(String line){
		line = line.substring(6);
		String[] param = line.split(",");
		int row = Integer.parseInt(param[0]);
		int col = Integer.parseInt(param[1]);
		Const.c.netGoback(row, col);
	}
	private void parsePutChess(String line) {
		line = line.substring(9);
		String[] param = line.split(",");
		int row = Integer.parseInt(param[0]);
		int col = Integer.parseInt(param[1]);
		Const.c.netPressChess(row, col);
	}
	private void parseRestart(){
		Const.c.netRestart();
	}
	private void parseChangeName(String line){
		line=line.substring(10);
		Const.c.netChangeName(line);
	}
	public boolean connect(String ip, int port) {
		try {
			Const.c.setLocalColor(MainModel.WHITE);
			s = new Socket(ip, port);
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			out = new PrintWriter(s.getOutputStream(), true);
			Const.c.netConnect();
			startReadThread();
			return true;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public void sendChat(String msg){
		out.println("Chat:"+msg);
	}
	public void sendChess(int row, int col) {
		out.println("PutChess:" + row + "," + col);
	}
	public void sendGoback(int row,int col){
		out.println("Goback"+row+","+col);
	}
	public void sendRestart(){
		out.println("Restart");
	}
	public void changeName(String a){
		out.println("ChangeName"+a);
	}
	public void sendconnect(){
		out.println("connected");
	}
}