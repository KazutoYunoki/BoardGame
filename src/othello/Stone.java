package othello;
/**
 * �΂�\���N���X
 * @author kazut
 *
 */
public class Stone {
	
	/** ���F��\���萔 */
	public static final int BLACK = 0;
	
	/** ���F��\���萔 */
	public static final int WHITE = 1;
	
	/** �����u����Ă��Ȃ����Ƃ�\���萔 */
	public static final int SPACE = 2;
	
	
	/** �΂̐F*/
	private  int color;
	
	/**
	 * �R���X�g���N�^
	 * @param �F
	 */
	public Stone(int color)
	{
		this.color = color;
	}
	
	/**
	 * �΂̐F��Ԃ��֐�
	 * @return �΂̐F
	 */
	public int getColor()
	{
		return this.color;
	}
	/**
	 * �΂̔��΂̐F��Ԃ��֐�
	 * @return �΂̔��΂̐F
	 */
	public int getReverseColor()
	{
		//���Ȃ甒��Ԃ�
		if(this.color == BLACK) {
			return WHITE;
		}
		//���Ȃ獕��Ԃ�
		else {
			return BLACK;
		}
	}
	/**
	 * �΂̐F���Ђ�����Ԃ�
	 */
	public void reverseStone()
	{
		if(this.color == BLACK) {
			this.color = WHITE;
		}
		else {
			this.color = BLACK;
		}
	}
	
	/**
	 * toString���\�b�h���I�[�o���C�h�������\�b�h
	 * ������\��
	 */
	public String toString()
	{
		int stoneColor = this.color; 
		if(stoneColor == BLACK) {
			return "��";
		}
		else if(stoneColor == WHITE)
		{
			return "��";
		}
		else
		{
			return " ";
		}
		
	}
	
	/*
	public static void main(String... args) {
		Stone playerStone = new Stone(Stone.BLACK);
		
		System.out.println(playerStone);
		System.out.println("�΂��Ђ�����Ԃ��܂��B");
		playerStone.reverseStone();
		System.out.println(playerStone);
	}
	*/

}
