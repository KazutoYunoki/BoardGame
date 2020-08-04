package othello;
/**
 * 石を表すクラス
 * @author kazut
 *
 */
public class Stone {
	
	/** 黒色を表す定数 */
	public static final int BLACK = 0;
	
	/** 白色を表す定数 */
	public static final int WHITE = 1;
	
	/** 何も置かれていないことを表す定数 */
	public static final int SPACE = 2;
	
	
	/** 石の色*/
	private  int color;
	
	/**
	 * コンストラクタ
	 * @param 色
	 */
	public Stone(int color)
	{
		this.color = color;
	}
	
	/**
	 * 石の色を返す関数
	 * @return 石の色
	 */
	public int getColor()
	{
		return this.color;
	}
	/**
	 * 石の反対の色を返す関数
	 * @return 石の反対の色
	 */
	public int getReverseColor()
	{
		//黒なら白を返す
		if(this.color == BLACK) {
			return WHITE;
		}
		//白なら黒を返す
		else {
			return BLACK;
		}
	}
	/**
	 * 石の色をひっくり返す
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
	 * toStringメソッドをオーバライドしたメソッド
	 * 文字列表現
	 */
	public String toString()
	{
		int stoneColor = this.color; 
		if(stoneColor == BLACK) {
			return "○";
		}
		else if(stoneColor == WHITE)
		{
			return "●";
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
		System.out.println("石をひっくり返します。");
		playerStone.reverseStone();
		System.out.println(playerStone);
	}
	*/

}
