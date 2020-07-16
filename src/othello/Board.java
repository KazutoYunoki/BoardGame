package othello;

public class Board {
	
	/**盤面を表している2次元配列*/
	Stone[][] board = new Stone[9][9];
	
	/**
	 * 盤面の初期の石を置く関数
	 */
	public void firstSetStone()
	{
		
	}
	
	/**
	 * 黒の石の数を数える関数
	 * @return　黒石の数
	 */
	public int numberOfBlack() {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}
	
	/**
	 * 白の石を数える関数
	 * @return　白石の数
	 */
	public int numberOfWhite() {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	/**
	 * 石が置けるかどうかチェックする
	 * @param number 行番号
	 * @param alpha　列番号
	 * @param stoneColor　石の色
	 * @return 石が置けるならtrue
	 */
	public boolean checkStone(int number, int alpha, Stone stone) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}
	/**
	 * 石を置く
	 * @param number　行番号
	 * @param alpha　列番号
	 * @param stoneColor　石の色
	 */
	public void setStone(int number, int alpha, Stone stone) {
		// TODO 自動生成されたメソッド・スタブ
	}
	
	/**
	 * 盤面をチェックしてゲーム終了かどうか判定
	 * @return　ゲーム終了ならfalse
	 */
	public boolean finishCheck() {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}
	
	/**
	 * ひっくり返せる位置を探して実際にひっくり返す関数
	 * @param number
	 * @param alpha
	 */
	public void reverseStone(int number, int alpha) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	
	/**
	 * toStringメソッドをオーバーライドしたメソッド
	 */
	public String toString()
	{
		StringBuffer string = new StringBuffer();
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				//1行目はアルファベットを出力
				if(i == 0 && j != 0)
				{
					//アスキーコード97をアルファベットに変換
					char c = (char) ('a' + (j - 1));
					string.append('|');
					string.append(c);
					continue;
				}
				//一列目は数字を出力
				if(j == 0)
				{
					string.append("|");
					string.append(i);
					continue;
				}
				//ボードに置かれている石を出力
				string.append("|");
				string.append(board[i][j]);
			}
			//改行して次の行へ
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
