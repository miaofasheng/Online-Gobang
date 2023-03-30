public class AIChess{
	public static final int CHESSBOARD_SIZE = 19;
	public static int FIRST = 1;
	private int[][] chessboard = new int[CHESSBOARD_SIZE][CHESSBOARD_SIZE];//��������̶�Ӧ��0����գ�-1���������1��������
	private int[][] score = new int[CHESSBOARD_SIZE][CHESSBOARD_SIZE];//ÿ��λ�õ÷�
	public AIChess(){}	
	public void init(){
		FIRST = 1;//Ĭ����������
		for(int i = 0; i  < CHESSBOARD_SIZE; i++){
			for(int j = 0; j < CHESSBOARD_SIZE; j++){
				chessboard[i][j] = 0;
				score[i][j] = 0;
			}
		}
	}	
	//����
	public void addChessman(int x, int y, int owner){
		chessboard[x][y] = owner;
	}

	//�ж�����λ���Ƿ�Ϸ�
	public boolean isLegal(int x, int y){
		if(x >=0 && x < CHESSBOARD_SIZE && y >= 0 && y < CHESSBOARD_SIZE && chessboard[x][y] == 0){
			return true;
		}
		return false;
	}

	
	public boolean isWin(int x, int y, int owner){
		int sum = 0;
		//�жϺ������
		for(int i = x - 1; i >= 0; i--){
			if(chessboard[i][y] == owner){sum++;}
			else{break;}
		}	
		//�жϺ����ұ�
		for(int i = x + 1; i < CHESSBOARD_SIZE; i++){
			if(chessboard[i][y] == owner){sum++;}
			else{break;}
		}
		if(sum >= 4) {return true;}
		
		sum = 0;
		//�ж������ϱ�
		for(int i = y - 1; i >= 0; i--){
			if(chessboard[x][i] == owner){sum++;}
			else{break;}
		}
		//�ж������±�
		for(int i = y + 1; i < CHESSBOARD_SIZE; i++){
			if(chessboard[x][i] == owner){sum++;}
			else{break;}
		}
		if(sum >= 4) {return true;}
	
		sum = 0;
		//�ж����Ͻǵ����½Ƿ����ϲ�
		for(int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j-- ){
			if(chessboard[i][j] == owner){sum++;}
			else{break;}
		}
		//�ж����Ͻǵ����½Ƿ����²�
		for(int i = x + 1, j = y + 1; i < CHESSBOARD_SIZE && j < CHESSBOARD_SIZE; i++, j++ ){
			if(chessboard[i][j] == owner){sum++;}
			else{break;}
		}
		if(sum >= 4) {return true;}
		
		sum = 0;
		//�ж����Ͻǵ����½Ƿ����ϲ�
		for(int i = x + 1, j = y - 1; i < CHESSBOARD_SIZE && j >= 0; i++, j-- ){
			if(chessboard[i][j] == owner){sum++;}
			else{break;}
		}
		//�ж����Ͻǵ����½Ƿ����²�
		for(int i = x - 1, j = y + 1; i >= 0 && j < CHESSBOARD_SIZE; i--, j++ ){
			if(chessboard[i][j] == owner){sum++;}
			else{break;}
		}
		if(sum >= 4) {return true;}

		return false;
		
	}

	//______ȷ����������λ��

	public Location searchLocation(){
		//ÿ�ζ���ʼ����score��������
		for(int i = 0; i  < CHESSBOARD_SIZE; i++){
			for(int j = 0; j < CHESSBOARD_SIZE; j++){
				score[i][j] = 0;
			}
		}
		
		//�ȶ���һЩ����
		int humanChessmanNum = 0;//��Ԫ���еĺ�������
		int machineChessmanNum = 0;//��Ԫ���еİ�������
		int tupleScoreTmp = 0;//��Ԫ��÷���ʱ����
		
		int goalX = -1;//Ŀ��λ��x����
		int goalY = -1;//Ŀ��λ��y����
		int maxScore = -1;//������

		//1.ɨ������19����
		for(int i = 0; i < 19; i++){
			for(int j = 0; j < 15; j++){
				int k = j;
				while(k < j + 5){
					
					if(chessboard[i][k] == -1) machineChessmanNum++;
					else if(chessboard[i][k] == 1)humanChessmanNum++;
				
					k++;
				}
				tupleScoreTmp = tupleScore(humanChessmanNum, machineChessmanNum);
				//Ϊ����Ԫ���ÿ��λ����ӷ���
				for(k = j; k < j + 5; k++){
					score[i][k] += tupleScoreTmp;
				}
				//����
				humanChessmanNum = 0;//��Ԫ���еĺ�������
				machineChessmanNum = 0;//��Ԫ���еİ�������
				tupleScoreTmp = 0;//��Ԫ��÷���ʱ����
			}
		}
		
		//2.ɨ������19��
		for(int i = 0; i < 19; i++){
			for(int j = 0; j < 15; j++){
				int k = j;
				while(k < j + 5){
					if(chessboard[k][i] == -1) machineChessmanNum++;
					else if(chessboard[k][i] == 1)humanChessmanNum++;
				
					k++;
				}
				tupleScoreTmp = tupleScore(humanChessmanNum, machineChessmanNum);
				//Ϊ����Ԫ���ÿ��λ����ӷ���
				for(k = j; k < j + 5; k++){
					score[k][i] += tupleScoreTmp;
				}
				//����
				humanChessmanNum = 0;//��Ԫ���еĺ�������
				machineChessmanNum = 0;//��Ԫ���еİ�������
				tupleScoreTmp = 0;//��Ԫ��÷���ʱ����
			}
		}

		//3.ɨ�����Ͻǵ����½��ϲಿ��
		for(int i = 18; i >= 4; i--){
			for(int k = i, j = 0; j < 19 && k >= 0; j++, k--){
				int m = k;
				int n = j;
				while(m > k - 5 && k - 5 >= -1){
					if(chessboard[m][n] == -1) machineChessmanNum++;
					else if(chessboard[m][n] == 1)humanChessmanNum++;
					m--;
					n++;
				}
				//ע��б���жϵ�ʱ�򣬿��ܹ�������Ԫ�飨�����ĸ����䣩�������������Ҫ���Ե�
				if(m == k-5){
					tupleScoreTmp = tupleScore(humanChessmanNum, machineChessmanNum);
					//Ϊ����Ԫ���ÿ��λ����ӷ���
					for(m = k, n = j; m > k - 5 ; m--, n++){
						score[m][n] += tupleScoreTmp;
					}
				}

				//����
				humanChessmanNum = 0;//��Ԫ���еĺ�������
				machineChessmanNum = 0;//��Ԫ���еİ�������
				tupleScoreTmp = 0;//��Ԫ��÷���ʱ����

			}
		}
		
		//4.ɨ�����Ͻǵ����½��²ಿ��
		for(int i = 1; i < 19; i++){
			for(int k = i, j = 18; j >= 0 && k < 19; j--, k++){
				int m = k;
				int n = j;
				while(m < k + 5 && k + 5 <= 19){
					if(chessboard[n][m] == -1) machineChessmanNum++;
					else if(chessboard[n][m] == 1)humanChessmanNum++;
					m++;
					n--;
				}
				//ע��б���жϵ�ʱ�򣬿��ܹ�������Ԫ�飨�����ĸ����䣩�������������Ҫ���Ե�
				if(m == k+5){
					tupleScoreTmp = tupleScore(humanChessmanNum, machineChessmanNum);
					//Ϊ����Ԫ���ÿ��λ����ӷ���
					for(m = k, n = j; m < k + 5; m++, n--){
						score[n][m] += tupleScoreTmp;
					}
				}
				//����
				humanChessmanNum = 0;//��Ԫ���еĺ�������
				machineChessmanNum = 0;//��Ԫ���еİ�������
				tupleScoreTmp = 0;//��Ԫ��÷���ʱ����

			}
		}

		//5.ɨ�����Ͻǵ����½��ϲಿ��
		for(int i = 0; i < 19; i++){
			for(int k = i, j = 0; j < 19 && k < 19; j++, k++){
				int m = k;
				int n = j;
				while(m < k + 5 && k + 5 <= 19){
					if(chessboard[m][n] == -1) machineChessmanNum++;
					else if(chessboard[m][n] == 1)humanChessmanNum++;
					
					m++;
					n++;
				}
				//ע��б���жϵ�ʱ�򣬿��ܹ�������Ԫ�飨�����ĸ����䣩�������������Ҫ���Ե�
				if(m == k + 5){
					tupleScoreTmp = tupleScore(humanChessmanNum, machineChessmanNum);
					//Ϊ����Ԫ���ÿ��λ����ӷ���
					for(m = k, n = j; m < k + 5; m++, n++){
						score[m][n] += tupleScoreTmp;
					}
				}

				//����
				humanChessmanNum = 0;//��Ԫ���еĺ�������
				machineChessmanNum = 0;//��Ԫ���еİ�������
				tupleScoreTmp = 0;//��Ԫ��÷���ʱ����

			}
		}	
	
		//6.ɨ�����Ͻǵ����½��²ಿ��
		for(int i = 1; i < 19; i++){
			for(int k = i, j = 0; j < 19 && k < 19; j++, k++){
				int m = k;
				int n = j;
				while(m < k + 5 && k + 5 <= 15){
					if(chessboard[n][m] == -1) machineChessmanNum++;
					else if(chessboard[n][m] == 1)humanChessmanNum++;
					
					m++;
					n++;
				}
				//ע��б���жϵ�ʱ�򣬿��ܹ�������Ԫ�飨�����ĸ����䣩�������������Ҫ���Ե�
				if(m == k + 5){
					tupleScoreTmp = tupleScore(humanChessmanNum, machineChessmanNum);
					//Ϊ����Ԫ���ÿ��λ����ӷ���
					for(m = k, n = j; m < k + 5; m++, n++){
						score[n][m] += tupleScoreTmp;
					}
				}

				//����
				humanChessmanNum = 0;//��Ԫ���еĺ�������
				machineChessmanNum = 0;//��Ԫ���еİ�������
				tupleScoreTmp = 0;//��Ԫ��÷���ʱ����

			}
		}	
	
		//�ӿ�λ�����ҵ��÷�����λ��
		for(int i = 0; i < 19; i++){
			for(int j = 0; j < 19; j++){
				if(chessboard[i][j] == 0 && score[i][j] > maxScore){
					goalX = i;
					goalY = j;
					maxScore = score[i][j];
				}
			}
		}		

		if(goalX != -1 && goalY != -1){
			return new Location(goalX, goalY, -1);
		}
		
		return new Location(-1, -1, -1);
	}
	
	//������Ԫ��������ֱ�
	public int tupleScore(int humanChessmanNum, int machineChessmanNum){
		//1.�����������ӣ����л������ӣ��з�Ϊ0
		if(humanChessmanNum > 0 && machineChessmanNum > 0){
			return 0;
		}
		//2.ȫ��Ϊ�գ�û�����ӣ��з�Ϊ7
		if(humanChessmanNum == 0 && machineChessmanNum == 0){
			return 7;
		}
		//3.������1�ӣ��з�Ϊ35
		if(machineChessmanNum == 1){
			return 35;
		}
		//4.������2�ӣ��з�Ϊ800
		if(machineChessmanNum == 2){
			return 800;
		}
		//5.������3�ӣ��з�Ϊ15000
		if(machineChessmanNum == 3){
			return 15000;
		}
		//6.������4�ӣ��з�Ϊ800000
		if(machineChessmanNum == 4){
			return 800000;
		}
		//7.������1�ӣ��з�Ϊ15
		if(humanChessmanNum == 1){
			return 15;
		}
		//8.������2�ӣ��з�Ϊ400
		if(humanChessmanNum == 2){
			return 400;
		}
		//9.������3�ӣ��з�Ϊ1800
		if(humanChessmanNum == 3){
			return 1800;
		}
		//10.������4�ӣ��з�Ϊ100000
		if(humanChessmanNum == 4){
			return 100000;
		}
		return -1;//������������϶������ˡ����д������������ִ��
	}
	
}
