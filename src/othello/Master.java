package othello;

import java.util.ArrayList;

/**
 * 進行役を表すクラス
 * @author kazut
 *
 */
public class Master {
	
	/** プレイヤーを入れておくリスト */
	private ArrayList<Player> players = new ArrayList<Player>();
	
	/**
	 * プレイヤーを登録する。
	 * @param プレイヤー
	 */
	public void registerPlayer(Player player)
	{
		players.add(player);
	}
	
	/**
	 * プレイヤーを削除する。
	 * @param player
	 */
	private void deregisterPlayer(Player player)
	{
		players.remove(player);
	}
	
	/**
	 * ゲームを終了する。
	 */
	public void finishGame(Board board, Player winner)
	{
		//黒と白の枚数を表示する。
		System.out.println("黒: " + board.numberOfBlack() + "白: " + board.numberOfWhite());
		System.out.println(winner + "の勝ちです。");
		
		//プレイヤーを削除する。
		deregisterPlayer(winner);
		
		System.out.println("【ゲームを終了します】");
	}
}
