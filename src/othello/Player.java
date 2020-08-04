package othello;
/**
 * �v���C���[�̃N���X��\���B
 * @author kazut
 *
 */
public class Player {
	/**�@�v���C���[�̖��O */
	String name;
	
	/** �i�s�� */
	Master master;
	
	/** �Ֆʁ@*/
	Board board;
	
	/** �S������� */
	Stone stone;
	
	/**
	 * �v���C���[�̃R���X�g���N�^
	 * @param name ���O
	 * @param board �Ֆ�
	 */
	public Player(String name, Master master, Board board)
	{
		this.name = name;
		this.master = master;
		this.board = board;
	}
	
	/**
	 * �΂̐F��ݒ肷��B
	 */
	public void setStoneColor(int color)
	{
		stone = new Stone(color);
	}
	
	/**
	 * ���Ԃ��w������
	 * @param nextPlaye �v���C���[
	 * @param number �s�ԍ�
	 * @param alpha ��ԍ�
	 */
	public void play(Player nextPlayer, int number, int alpha, Stone stone)
	{
		//�Ֆʂɐ΂��u���邩�ǂ������ׂ�
		if(board.checkStone(number, alpha, stone) == true)
		{
			//�΂��u����Ȃ�΂�u��
			board.setStone(number, alpha, stone);
			
			//���܂ꂽ�΂��Ђ�����Ԃ�
			board.reverseStone(number, alpha);
			
			//�Q�[�����i�s�\���ǂ����`�F�b�N����
			if(board.finishCheck() == false)
			{
				//�Q�[���I����錾����B
				master.finishGame(board, this);
			}
		}
		
	}
	
	/**
	 * toString()���\�b�h���I�[�o�[���C�h�������\�b�h
	 */
	public String toString()
	{
		return name;
	}
	
	/*
	public static void main(String ...args)
	{
		Master master = new Master();
		Board board = new Board();
		
		Player player = new Player("�M��", master, board);
		
		player.setStoneColor(Stone.BLACK);
		
		System.out.println(player.stone);
		
	}
	*/
	
}
