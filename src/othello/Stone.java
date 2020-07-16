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
		else
		{
			return "●";
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
