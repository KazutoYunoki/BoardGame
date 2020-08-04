package othello;
/**
 * プレイヤーのクラスを表す。
 * @author kazut
 *
 */
public class Player {
	/**　プレイヤーの名前 */
	String name;
	
	/** 進行役 */
	Master master;
	
	/** 盤面　*/
	Board board;
	
	/** 担当する石 */
	Stone stone;
	
	/**
	 * プレイヤーのコンストラクタ
	 * @param name 名前
	 * @param board 盤面
	 */
	public Player(String name, Master master, Board board)
	{
		this.name = name;
		this.master = master;
		this.board = board;
	}
	
	/**
	 * 石の色を設定する。
	 */
	public void setStoneColor(int color)
	{
		stone = new Stone(color);
	}
	
	/**
	 * 順番を指名する
	 * @param nextPlaye プレイヤー
	 * @param number 行番号
	 * @param alpha 列番号
	 */
	public void play(Player nextPlayer, int number, int alpha, Stone stone)
	{
		//盤面に石が置けるかどうか調べる
		if(board.checkStone(number, alpha, stone) == true)
		{
			//石が置けるなら石を置く
			board.setStone(number, alpha, stone);
			
			//挟まれた石をひっくり返す
			board.reverseStone(number, alpha);
			
			//ゲームが進行可能かどうかチェックする
			if(board.finishCheck() == false)
			{
				//ゲーム終了を宣言する。
				master.finishGame(board, this);
			}
		}
		
	}
	
	/**
	 * toString()メソッドをオーバーライドしたメソッド
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
		
		Player player = new Player("柚木", master, board);
		
		player.setStoneColor(Stone.BLACK);
		
		System.out.println(player.stone);
		
	}
	*/
	
}
