package othello;

import java.util.ArrayList;

/**
 * �i�s����\���N���X
 * @author kazut
 *
 */
public class Master {
	
	/** �v���C���[�����Ă������X�g */
	private ArrayList<Player> players = new ArrayList<Player>();
	
	/**
	 * �v���C���[��o�^����B
	 * @param �v���C���[
	 */
	public void registerPlayer(Player player)
	{
		players.add(player);
	}
	
	/**
	 * �v���C���[���폜����B
	 * @param player
	 */
	private void deregisterPlayer(Player player)
	{
		players.remove(player);
	}
	
	/**
	 * �Q�[�����I������B
	 */
	public void finishGame(Board board, Player winner)
	{
		//���Ɣ��̖�����\������B
		System.out.println("��: " + board.numberOfBlack() + "��: " + board.numberOfWhite());
		System.out.println(winner + "�̏����ł��B");
		
		//�v���C���[���폜����B
		deregisterPlayer(winner);
		
		System.out.println("�y�Q�[�����I�����܂��z");
	}
}
