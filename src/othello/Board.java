package othello;

public class Board {
	
	/**�Ֆʂ�\���Ă���2�����z��*/
	Stone[][] board = new Stone[9][9];
	
	/**
	 * �Ֆʂ̏����̐΂�u���֐�
	 */
	public void firstSetStone()
	{
		
	}
	
	/**
	 * ���̐΂̐��𐔂���֐�
	 * @return�@���΂̐�
	 */
	public int numberOfBlack() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return 0;
	}
	
	/**
	 * ���̐΂𐔂���֐�
	 * @return�@���΂̐�
	 */
	public int numberOfWhite() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return 0;
	}

	/**
	 * �΂��u���邩�ǂ����`�F�b�N����
	 * @param number �s�ԍ�
	 * @param alpha�@��ԍ�
	 * @param stoneColor�@�΂̐F
	 * @return �΂��u����Ȃ�true
	 */
	public boolean checkStone(int number, int alpha, Stone stone) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return false;
	}
	/**
	 * �΂�u��
	 * @param number�@�s�ԍ�
	 * @param alpha�@��ԍ�
	 * @param stoneColor�@�΂̐F
	 */
	public void setStone(int number, int alpha, Stone stone) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
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
		System.out.println(board);
	}

}
