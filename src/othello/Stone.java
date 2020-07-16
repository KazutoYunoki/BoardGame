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
		else
		{
			return "��";
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
