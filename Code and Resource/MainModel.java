

public class MainModel {
	public static final int WIDTH = 19;
	public static final int BLACK = 1;
	public static final int WHITE = -1;
	public static final int SPACE  = 0;
	public static int num=0;
	private int[][] data = new int[WIDTH][WIDTH];
	private int lastRow;
	private int lastCol;
	public int getChess(int row,int col){
		if(row>=0&&row<WIDTH&&col>=0&&col<WIDTH){
			return data[row][col];
		}
		return SPACE;
	}
	public int whoWin(int i,int j){
		for(int row=i,count=0;row<18;row++){
			if(data[row][j] == 0) {
				break;
			}
			if (row+1<=17&&data[row][j] == data[row + 1][j]) {
				count++;
			}
			if (count == 4) {
				if(data[row][j]==1){
					return BLACK;
				}
				return WHITE;
			}
		}
		for (int row = i, count = 0; row >= 0; row--) {
			if (data[row][j] == 0) {
				break;
			}
			if (row-1>=0&&data[row][j] == data[row - 1][j]) {
				count++;
			}
			if (count == 4) {
				if(data[row][j]==1){
					return BLACK;
				}
				return WHITE;
			}
		}
		for (int col = j, count = 0; col < 18; col++) {
			if (data[i][col] == 0) {
				break;
			}
			if (col+1<=17&&data[i][col] == data[i][col + 1]) {
				count++;
			}
			if (count == 4) {
				if(data[i][col]==1){
					return BLACK;
				}
				return WHITE;
			}

		}
		for (int col = j, count = 0; col >= 0; col--) {
			if (data[i][col] == 0) {
				break;
			}
			if (col-1>=0&&data[i][col] == data[i][col - 1]) {
				count++;
			}
			if (count == 4) {
				if(data[i][col]==1){
					return BLACK;
				}
				return WHITE;
			}

		}
		for (int row = i, col = j, count = 0; row >= 0 && col >= 0; row--, col--) {
			if (data[row][col] == 0) {
				break;
			}
			if (col-1>=0&&row-1>=0&&data[row][col] == data[row - 1][col - 1]) {
				count++;
			}
			if (count == 4) {
				if(data[row][col]==1){
					return BLACK;
				}
				return WHITE;
			}
		}
		for (int row = i, col = j, count = 0; row >= 0 && col < 18; row--, col++) {
			if (data[row][col] == 0) {
				break;
			}
			if (row-1>=0&&col+1<=17&&data[row][col] == data[row - 1][col + 1]) {
				count++;
			}
			if (count == 4) {
				if(data[row][col]==1){
					return BLACK;
				}
				return WHITE;
			}
		}
		for (int row = i, col = j, count = 0; row < 18 && col >= 0; row++, col--) {
			if (data[row][col] == 0) {
				break;
			}
			if (row+1<=17&&col-1>=0&&data[row][col] == data[row + 1][col - 1]) {
				count++;
			}
			if (count == 4) {
				if(data[row][col]==1){
					return BLACK;
				}
				return WHITE;
			}
		}
		for (int row = i, col = j, count = 0; row < 18 && col < 18; row++, col++) {
			if (data[row][col] == 0) {
				break;
			}
			if (row+1<=17&&col+1<=17&&data[row][col] == data[row + 1][col + 1]) {
				count++;
			}
			if(count==4){
				if(data[row][col]==1){
				return BLACK;
			}
			return WHITE;}
		}
		return SPACE;
	}
	public boolean putChess(int row,int col,int color){
		if(row>=0&&row<WIDTH&&col>=0&&col<WIDTH){
			
			if(data[row][col]==SPACE){
				new BackgroundMusic("src\\\\Source\\\\yinxiao.mp3").start();
				num++;
				data[row][col] = color;
				lastRow = row;
				lastCol = col;
				Const.fupanArray.add(Integer.toString(color));
				Const.fupanArray.add(Integer.toString(row));
				Const.fupanArray.add(Integer.toString(col));
				return true;
			}
		}
		return false;
	}
	public void goBack(){
		data[lastRow][lastCol]=0;
	}
	public void reset(int row,int col){
		data[row][col]=0;
	}
	public int getLastRow(){
		return lastRow;
	}
	public int getLastCow(){
		return lastCol;
	}
}
