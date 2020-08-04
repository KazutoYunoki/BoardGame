package othello;

public class Board {
	
	/**�Ֆʂ�\���Ă���2�����z��*/
	Stone[][] board = new Stone[9][9];
	
	/**
	 * �R���X�g���N�^
	 * �S�Ֆʂ��󔒂ŏ���������B
	 */
	public Board()
	{
		for(int i = 0 ; i < board[0].length; i++) {
			for(int j = 0; j < board[1].length; j++) {
				board[i][j] = new Stone(Stone.SPACE);
			}
		}
	}
	/**
	 * �Ֆʂ̏����̐΂�u���֐�
	 */
	public void firstSetStone()
	{
		//�Ֆʂ̒��S4�ɔ��ƍ��̐΂�u��
		board[4][4] = new Stone(Stone.WHITE);
		board[4][5] = new Stone(Stone.BLACK);
		board[5][4] = new Stone(Stone.BLACK);
		board[5][5] = new Stone(Stone.WHITE);				

	}
	
	/**
	 * ���̐΂̐��𐔂���֐�
	 * @return�@���΂̐�
	 */
	public int numberOfBlack() {
		//�΂��J�E���g����ϐ�
		int count = 0;
		
		for(int i = 1; i < board[0].length; i++) {
			for(int j = 1; j < board[1].length; j++) {
				
				//�u����Ă���΂��擾����B
				Stone placedStone = board[i][j];
				
				//�u����Ă���΂�����������J�E���g
				if(placedStone.getColor() == Stone.BLACK) {
					count++;
				}
			}
		}
		
		return count;
	}
	
	/**
	 * ���̐΂𐔂���֐�
	 * @return�@���΂̐�
	 */
	public int numberOfWhite() {
		//�΂��J�E���g����ϐ�
		int count = 0;
		
		for(int i = 1; i < board[0].length; i++) {
			for(int j = 1; j < board[1].length; j++) {
				
				//�u����Ă���΂��擾����B
				Stone placedStone = board[i][j];
				
				//�u����Ă���΂�����������J�E���g
			if(placedStone.getColor() == Stone.WHITE) {
					count++;
				}
			}
		}
		
		return count;		
	}

	/**
	 * �΂��u���邩�ǂ����`�F�b�N����
	 * @param number �s�ԍ�
	 * @param alpha�@��ԍ�
	 * @param stoneColor�@�΂̐F
	 * @return �΂��u����Ȃ�true
	 */
	public boolean checkStone(int number, int alpha, Stone stone) {
		// �u���΂̐F���擾
		int stoneColor = stone.getColor();
		
		//�@�u���΂̔��΂̐F���擾
		int stoneReverseColor = stone.getReverseColor();
		
		boolean result = false;
		
		//�@�u�����ꏊ�̍�����
		boolean leftFlag = checkLeft(number, alpha, stoneColor, stoneReverseColor);
		boolean rightFlag = checkRight(number, alpha, stoneColor, stoneReverseColor);
		boolean upFlag = checkUp(number, alpha, stoneColor, stoneReverseColor);
		boolean downFlag = checkDown(number, alpha, stoneColor, stoneReverseColor);
		boolean upRightFlag = checkUpRight(number, alpha, stoneColor, stoneReverseColor);
		if(upRightFlag == true)
		{
			result = true;
		}
		boolean upLeftFlag = checkUpLeft(number, alpha, stoneColor, stoneReverseColor);
		boolean downRightFlag = checkDownRight(number, alpha, stoneColor, stoneReverseColor);
		boolean downLeftFlag = checkDownLeft(number, alpha, stoneColor, stoneReverseColor);
		
		return result;
		

	}
	/**
	 * �u�����ꏊ���獶���̑���(�e�X�g����m�F�ς݁j
	 * @param number�@�s�ԍ�
	 * @param alpha�@��ԍ�
	 * @param Color�@�΂̐F
	 * @param reverseColor ���΂̐F
	 * @return�@�Ђ�����Ԃ���ꍇtrue
	 */
	private boolean checkLeft(int number, int alpha, int color, int reverseColor) {
		
		//�A���t�@�x�b�g��0~�̐����ɕϊ�����B
		int alphaNum = alpha - 'a';
		
		//1����g�������̂ŃC���N�������g����B
		alphaNum++;	
		
		for(int i = alphaNum - 1; i >= 1; i--){
			//�ׂɒu���Ă���΂��擾
			Stone placedStone = board[number][i];
				
			//��ƂȂ肪�����F�������ꍇ�A�Ђ�����Ԃ��Ȃ�����false��Ԃ�
			if(placedStone.getColor() == color && (i == alphaNum -1))
			{
				return false;
			}
			//1�ڈȍ~�����΂̐F�������ꍇ���[�v�𑱂���
			else if(placedStone.getColor() == reverseColor)
			{
				continue;
			}
			//�󔒂�������false��Ԃ�
			else if(placedStone.getColor() == Stone.SPACE)
			{
				return false;
			}
			//2�ڈȍ~�������F�������ꍇ�A���󔒂łȂ��Ȃ狲��ł��邱�ƂɂȂ邽��true��Ԃ�
			else
			{
				return true;
			}
		}
		//���[�v���I������ꍇ�͋��߂ĂȂ�����false��Ԃ��ďI��
		return false;
	}
	/**
	 * �u�����ꏊ����E�̑��� (�e�X�g����m�F�ς݁j
	 * @param number�@�s�ԍ�
	 * @param alpha�@��ԍ�
	 * @param color�@�΂̐F
	 * @param reverseColor�@���΂̐F
	 * @return�@�Ђ�����Ԃ���ꍇtrue
	 */
	private boolean checkRight(int number, int alpha, int color, int reverseColor)
	{
		//�A���t�@�x�b�g��0~�̐����ɕϊ�����B
		int alphaNum = alpha - 'a';
	
		//1����g�������̂ŃC���N�������g����B
		alphaNum++;	
	
		for(int i = alphaNum + 1; i <= 8; i++){
			//�����ɒu���Ă���΂��擾
			Stone placedStone = board[number][i];

			//��ƂȂ肪�����F�������ꍇ�A�Ђ�����Ԃ��Ȃ�����false��Ԃ�
			if(placedStone.getColor() == color && (i == alphaNum + 1))
			{
				return false;
			}
			//1�ڈȍ~�����΂̐F�������ꍇ���[�v�𑱂���
			else if(placedStone.getColor() == reverseColor)
			{
				continue;
			}
			//�󔒂�������false��Ԃ�
			else if (placedStone.getColor() == Stone.SPACE)
			{
				return false;
			}
			//2�ڈȍ~�������F�������ꍇ�A����ł��邱�ƂɂȂ邽��true��Ԃ�
			else
			{
				return true;
			}
				
		}
		//���[�v���I������ꍇ�͋��߂ĂȂ�����false��Ԃ��ďI��
		return false;		
	}
	
	/**
	 * �u�����ꏊ�����̑���(�e�X�g����m�F�ς݁j
	 * @param number�@�s�ԍ�
	 * @param alpha�@��ԍ�
	 * @param color�@�΂̐F
	 * @param reverseColor�@���΂̐F
	 * @return�@�Ђ�����Ԃ���ꍇtrue
	 */
	private boolean checkUp(int number, int alpha, int color, int reverseColor)
	{
		//�A���t�@�x�b�g��0~�̐����ɕϊ�����B
		int alphaNum = alpha - 'a';
	
		//1����g�������̂ŃC���N�������g����B
		alphaNum++;	

		for(int i = number - 1; i >= 1; i--){
			//�ׂɒu���Ă���΂��擾
			Stone placedStone = board[i][alphaNum];
				
			//��ƂȂ肪�����F�������ꍇ�A�Ђ�����Ԃ��Ȃ�����false��Ԃ�
			if(placedStone.getColor() == color && (i == number - 1))
			{
				return false;
			}
			//1�ڈȍ~�����΂̐F�������ꍇ���[�v�𑱂���
			else if(placedStone.getColor() == reverseColor)
			{
				continue;
			}
			//�󔒂�������false
			else if(placedStone.getColor() == Stone.SPACE)
			{
				return false;
			}
			//2�ڈȍ~�������F�������ꍇ�A����ł��邱�ƂɂȂ邽��true��Ԃ�
			else
			{
				return true;
			}
				
		}
		//���[�v���I������ꍇ�͋��߂ĂȂ�����false��Ԃ��ďI��
		return false;				
	}
	/**
	 * �u�����ꏊ���牺�̑���(����m�F�ς݁j
	 * @param number�@�s�ԍ�
	 * @param alpha�@��ԍ�
	 * @param color�@�΂̐F
	 * @param reverseColor�@���΂̐F
	 * @return�@�Ђ�����Ԃ���ꍇtrue
	 */
	private boolean checkDown(int number, int alpha, int color, int reverseColor)
	{
		//�A���t�@�x�b�g��0~�̐����ɕϊ�����B
		int alphaNum = alpha - 'a';
			
		//1����g�������̂ŃC���N�������g����B
		alphaNum++;	
				
		for(int i = number + 1; i <= 8; i++){
			//�ׂɒu���Ă���΂��擾
			Stone placedStone = board[i][alphaNum];

			//��ƂȂ肪�����F�������ꍇ�A�Ђ�����Ԃ��Ȃ�����false��Ԃ�
			if(placedStone.getColor() == color && (i == number + 1))
			{
				return false;
			}
			//1�ڈȍ~�����΂̐F�������ꍇ���[�v�𑱂���
			else if(placedStone.getColor() == reverseColor)
			{
				continue;
			}
			//�󔒂�������false��Ԃ��B
			else if(placedStone.getColor() == Stone.SPACE)
			{
				return false;
			}
			//2�ڈȍ~�������F�������ꍇ�A����ł��邱�ƂɂȂ邽��true��Ԃ�
			else 
			{
				return true;
			}
				
		}
		//���[�v���I������ꍇ�͋��߂ĂȂ�����false��Ԃ��ďI��
		return false;				
	}
	/**
	 * �u�����ꏊ����̉E��̑����i����m�F�ς݁j
	 * @param number�@�s�ԍ�
	 * @param alpha�@��ԍ�
	 * @param color�@�΂̐F
	 * @param reverseColor�@���΂̐F
	 * @return�@�Ђ�����Ԃ���ꍇtrue
	 */
	private boolean checkUpRight(int number, int alpha, int color, int reverseColor) {
		
		//�A���t�@�x�b�g��0~�̐����ɕϊ�����B
		int alphaNum = alpha - 'a';
		//1����g�������̂ŃC���N�������g����B
		alphaNum++;
		
		for(int i = number - 1, j = alphaNum + 1; i >= 1; i--, j++){
			// 8�𒴂�����I���
			if(j > 8)
			{
				return false;
			}
			//�u�����ꏊ����E��ɒu���Ă���΂��擾
			Stone placedStone = board[i][j];
			System.out.print(i);
			System.out.print(" ");
			System.out.print(j);
			System.out.println(placedStone);	
			
			//��ƂȂ肪�����F�������ꍇ�A�Ђ�����Ԃ��Ȃ�����false��Ԃ�
			if(placedStone.getColor() == color && (i == number - 1 && j == alphaNum + 1))
			{
				return false;
			}
			//1�ڈȍ~�����΂̐F�������ꍇ���[�v�𑱂���
			else if(placedStone.getColor() == reverseColor)
			{
				continue;
			}
			//2�ڈȍ~���󔒂�������false
			else if(placedStone.getColor() == Stone.SPACE)
			{
				return false;
			}
			//2�ڈȍ~�������F�������ꍇ�A����ł��邱�ƂɂȂ邽��true��Ԃ�
			else {
				return true;
			}
		}
		//���[�v���I������ꍇ�͋��߂ĂȂ�����false��Ԃ��ďI��
		return false;		
	}
	/**
	 * ����̑���
	 * @param number �s�ԍ�
	 * @param alpha�@��ԍ�
	 * @param color�@�F
	 * @param reverseColor�@���΂̐F
	 * @return�@�Ђ�����Ԃ���ꍇture
	 */
	private boolean checkUpLeft(int number, int alpha, int color, int reverseColor)
	{	
		//�A���t�@�x�b�g��0~�̐����ɕϊ�����B
		int alphaNum = alpha - 'a';
		//1����g�������̂ŃC���N�������g����B
		alphaNum++;
		
		for(int i = number - 1; i >= 0; i--){
			for(int j = alphaNum - 1; j >= 0; j--) {
				
			
				//�u�����ꏊ����E��ɒu���Ă���΂��擾
				Stone placedStone = board[i][j];
				
				//��ƂȂ肪�����F�������ꍇ�A�Ђ�����Ԃ��Ȃ�����false��Ԃ�
				if(placedStone.getColor() == color && (i == number - 1 && j == alphaNum - 1))
				{
					return false;
				}
				//1�ڈȍ~�����΂̐F�������ꍇ���[�v�𑱂���
				else if(placedStone.getColor() == reverseColor)
				{
					continue;
				}
				//2�ڈȍ~�������F�������ꍇ�A����ł��邱�ƂɂȂ邽��true��Ԃ�
				else
				{
					return true;
				}
			}
				
		}
		//���[�v���I������ꍇ�͋��߂ĂȂ�����false��Ԃ��ďI��
		return false;			
	}
	
	/**
	 * �E���̑���
	 * @param number
	 * @param alpha
	 * @param color
	 * @param reverseColor
	 * @return
	 */
	private boolean checkDownRight(int number, int alpha, int color, int reverseColor)
	{
		//�A���t�@�x�b�g��0~�̐����ɕϊ�����B
		int alphaNum = alpha - 'a';
		//1����g�������̂ŃC���N�������g����B
		alphaNum++;
		
		for(int i = number + 1; i <= 8; i++){
			for(int j = alphaNum + 1; j <= 8; j++) {
				
			
				//�u�����ꏊ����E��ɒu���Ă���΂��擾
				Stone placedStone = board[i][j];
				
				//��ƂȂ肪�����F�������ꍇ�A�Ђ�����Ԃ��Ȃ�����false��Ԃ�
				if(placedStone.getColor() == color && (i == number + 1 && j == alphaNum + 1))
				{
					return false;
				}
				//1�ڈȍ~�����΂̐F�������ꍇ���[�v�𑱂���
				else if(placedStone.getColor() == reverseColor)
				{
					continue;
				}
				//2�ڈȍ~�������F�������ꍇ�A����ł��邱�ƂɂȂ邽��true��Ԃ�
				else
				{
					return true;
				}
			}
				
		}
		//���[�v���I������ꍇ�͋��߂ĂȂ�����false��Ԃ��ďI��
		return false;			
		
	}
	/**
	 * �����̑���
	 * @param number
	 * @param alpha
	 * @param color
	 * @param reverseColor
	 * @return
	 */
	private boolean checkDownLeft(int number, int alpha, int color, int reverseColor)
	{
		//�A���t�@�x�b�g��0~�̐����ɕϊ�����B
		int alphaNum = alpha - 'a';
		//1����g�������̂ŃC���N�������g����B
		alphaNum++;
		
		for(int i = number + 1; i <= 8; i++){
			for(int j = alphaNum - 1; j >= 0; j--) {
				
			
				//�u�����ꏊ����E��ɒu���Ă���΂��擾
				Stone placedStone = board[i][j];
				
				//��ƂȂ肪�����F�������ꍇ�A�Ђ�����Ԃ��Ȃ�����false��Ԃ�
				if(placedStone.getColor() == color && (i == number + 1 && j == alphaNum - 1))
				{
					return false;
				}
				//1�ڈȍ~�����΂̐F�������ꍇ���[�v�𑱂���
				else if(placedStone.getColor() == reverseColor)
				{
					continue;
				}
				//2�ڈȍ~�������F�������ꍇ�A����ł��邱�ƂɂȂ邽��true��Ԃ�
				else
				{
					return true;
				}
			}
				
		}
		//���[�v���I������ꍇ�͋��߂ĂȂ�����false��Ԃ��ďI��
		return false;			
		
	}
	/**
	 * �΂�u��
	 * @param number�@�s�ԍ�
	 * @param alpha�@��ԍ�
	 * @param stoneColor�@�΂̐F
	 */
	public void setStone(int number, int alpha, Stone stone) {
		//�A���t�@�x�b�g��0~�̐����ɕϊ�����B
		int alphaNum = alpha - 'a';
		//1����g�������̂ŃC���N�������g����B
		alphaNum++;
		
		//�w�肵���ꏊ�ɐ΂�u���B
		board[number][alphaNum] = stone;
	}
	
	/**
	 * �Ֆʂ��`�F�b�N���ăQ�[���I�����ǂ�������
	 * @return�@�Q�[���I���Ȃ�false
	 */
	public boolean finishCheck() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return false;
	}
	
	/**
	 * �Ђ�����Ԃ���ʒu��T���Ď��ۂɂЂ�����Ԃ��֐�
	 * @param number
	 * @param alpha
	 */
	public void reverseStone(int number, int alpha) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		
	}
	
	/**
	 * toString���\�b�h���I�[�o�[���C�h�������\�b�h
	 */
	public String toString()
	{
		StringBuffer string = new StringBuffer();
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				//1�s�ڂ̓A���t�@�x�b�g���o��
				if(i == 0 && j != 0)
				{
					//�A�X�L�[�R�[�h97���A���t�@�x�b�g�ɕϊ�
					char c = (char) ('a' + (j - 1));
					string.append('|');
					string.append(c);
					continue;
				}
				//���ڂ͐������o��
				if(j == 0)
				{
					string.append("|");
					string.append(i);
					continue;
				}
				//�{�[�h�ɒu����Ă���΂��o��
				string.append("|");
				string.append(board[i][j]);
			}
			//���s���Ď��̍s��
			string.append("|");
			string.append("\n");
		}
		return string.toString();		
	}
	
	public static void main(String ...args)
	{
		Board board = new Board();
		board.firstSetStone();
		System.out.println(board);
		
		System.out.println("���̐�:" + board.numberOfBlack());
		System.out.println("���̐�:" + board.numberOfWhite());
		
		board.setStone(3, 'e', new Stone(Stone.BLACK));
		board.setStone(3, 'f', new Stone(Stone.WHITE));
		
		System.out.println(board);
		
		
		System.out.println(board.checkStone(5, 'c', new Stone(Stone.WHITE)));
		

	}

}
