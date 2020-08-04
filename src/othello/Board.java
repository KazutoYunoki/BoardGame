package othello;

public class Board {
	
	/**盤面を表している2次元配列*/
	Stone[][] board = new Stone[9][9];
	
	/**
	 * コンストラクタ
	 * 全盤面を空白で初期化する。
	 */
	public Board()
	{
		for(int i = 0 ; i < board[0].length; i++) {
			for(int j = 0; j < board[1].length; j++) {
				board[i][j] = new Stone(Stone.SPACE);
			}
		}
	}
	/**
	 * 盤面の初期の石を置く関数
	 */
	public void firstSetStone()
	{
		//盤面の中心4つに白と黒の石を置く
		board[4][4] = new Stone(Stone.WHITE);
		board[4][5] = new Stone(Stone.BLACK);
		board[5][4] = new Stone(Stone.BLACK);
		board[5][5] = new Stone(Stone.WHITE);				

	}
	
	/**
	 * 黒の石の数を数える関数
	 * @return　黒石の数
	 */
	public int numberOfBlack() {
		//石をカウントする変数
		int count = 0;
		
		for(int i = 1; i < board[0].length; i++) {
			for(int j = 1; j < board[1].length; j++) {
				
				//置かれている石を取得する。
				Stone placedStone = board[i][j];
				
				//置かれている石が黒だったらカウント
				if(placedStone.getColor() == Stone.BLACK) {
					count++;
				}
			}
		}
		
		return count;
	}
	
	/**
	 * 白の石を数える関数
	 * @return　白石の数
	 */
	public int numberOfWhite() {
		//石をカウントする変数
		int count = 0;
		
		for(int i = 1; i < board[0].length; i++) {
			for(int j = 1; j < board[1].length; j++) {
				
				//置かれている石を取得する。
				Stone placedStone = board[i][j];
				
				//置かれている石が白だったらカウント
			if(placedStone.getColor() == Stone.WHITE) {
					count++;
				}
			}
		}
		
		return count;		
	}

	/**
	 * 石が置けるかどうかチェックする
	 * @param number 行番号
	 * @param alpha　列番号
	 * @param stoneColor　石の色
	 * @return 石が置けるならtrue
	 */
	public boolean checkStone(int number, int alpha, Stone stone) {
		// 置く石の色を取得
		int stoneColor = stone.getColor();
		
		//　置く石の反対の色を取得
		int stoneReverseColor = stone.getReverseColor();
		
		boolean result = false;
		
		//　置いた場所の左走査
		boolean leftFlag = checkLeft(number, alpha, stoneColor, stoneReverseColor);
		boolean rightFlag = checkRight(number, alpha, stoneColor, stoneReverseColor);
		boolean upFlag = checkUp(number, alpha, stoneColor, stoneReverseColor);
		boolean downFlag = checkDown(number, alpha, stoneColor, stoneReverseColor);
		boolean upRightFlag = checkUpRight(number, alpha, stoneColor, stoneReverseColor);
		if(upRightFlag == true)
		{
			result = true;
		}
		boolean upLeftFlag = checkUpLeft(number, alpha, stoneColor, stoneReverseColor);
		boolean downRightFlag = checkDownRight(number, alpha, stoneColor, stoneReverseColor);
		boolean downLeftFlag = checkDownLeft(number, alpha, stoneColor, stoneReverseColor);
		
		return result;
		

	}
	/**
	 * 置いた場所から左側の走査(テスト動作確認済み）
	 * @param number　行番号
	 * @param alpha　列番号
	 * @param Color　石の色
	 * @param reverseColor 反対の色
	 * @return　ひっくり返せる場合true
	 */
	private boolean checkLeft(int number, int alpha, int color, int reverseColor) {
		
		//アルファベットを0~の数字に変換する。
		int alphaNum = alpha - 'a';
		
		//1から使いたいのでインクリメントする。
		alphaNum++;	
		
		for(int i = alphaNum - 1; i >= 1; i--){
			//隣に置いてある石を取得
			Stone placedStone = board[number][i];
				
			//一個となりが同じ色だった場合、ひっくり返せないためfalseを返す
			if(placedStone.getColor() == color && (i == alphaNum -1))
			{
				return false;
			}
			//1個目以降が反対の色だった場合ループを続ける
			else if(placedStone.getColor() == reverseColor)
			{
				continue;
			}
			//空白だったらfalseを返す
			else if(placedStone.getColor() == Stone.SPACE)
			{
				return false;
			}
			//2個目以降が同じ色だった場合、かつ空白でないなら挟んでいることになるためtrueを返す
			else
			{
				return true;
			}
		}
		//ループが終了する場合は挟めてないためfalseを返して終了
		return false;
	}
	/**
	 * 置いた場所から右の走査 (テスト動作確認済み）
	 * @param number　行番号
	 * @param alpha　列番号
	 * @param color　石の色
	 * @param reverseColor　反対の色
	 * @return　ひっくり返せる場合true
	 */
	private boolean checkRight(int number, int alpha, int color, int reverseColor)
	{
		//アルファベットを0~の数字に変換する。
		int alphaNum = alpha - 'a';
	
		//1から使いたいのでインクリメントする。
		alphaNum++;	
	
		for(int i = alphaNum + 1; i <= 8; i++){
			//そこに置いてある石を取得
			Stone placedStone = board[number][i];

			//一個となりが同じ色だった場合、ひっくり返せないためfalseを返す
			if(placedStone.getColor() == color && (i == alphaNum + 1))
			{
				return false;
			}
			//1個目以降が反対の色だった場合ループを続ける
			else if(placedStone.getColor() == reverseColor)
			{
				continue;
			}
			//空白だったらfalseを返す
			else if (placedStone.getColor() == Stone.SPACE)
			{
				return false;
			}
			//2個目以降が同じ色だった場合、挟んでいることになるためtrueを返す
			else
			{
				return true;
			}
				
		}
		//ループが終了する場合は挟めてないためfalseを返して終了
		return false;		
	}
	
	/**
	 * 置いた場所から上の走査(テスト動作確認済み）
	 * @param number　行番号
	 * @param alpha　列番号
	 * @param color　石の色
	 * @param reverseColor　反対の色
	 * @return　ひっくり返せる場合true
	 */
	private boolean checkUp(int number, int alpha, int color, int reverseColor)
	{
		//アルファベットを0~の数字に変換する。
		int alphaNum = alpha - 'a';
	
		//1から使いたいのでインクリメントする。
		alphaNum++;	

		for(int i = number - 1; i >= 1; i--){
			//隣に置いてある石を取得
			Stone placedStone = board[i][alphaNum];
				
			//一個となりが同じ色だった場合、ひっくり返せないためfalseを返す
			if(placedStone.getColor() == color && (i == number - 1))
			{
				return false;
			}
			//1個目以降が反対の色だった場合ループを続ける
			else if(placedStone.getColor() == reverseColor)
			{
				continue;
			}
			//空白だったらfalse
			else if(placedStone.getColor() == Stone.SPACE)
			{
				return false;
			}
			//2個目以降が同じ色だった場合、挟んでいることになるためtrueを返す
			else
			{
				return true;
			}
				
		}
		//ループが終了する場合は挟めてないためfalseを返して終了
		return false;				
	}
	/**
	 * 置いた場所から下の走査(動作確認済み）
	 * @param number　行番号
	 * @param alpha　列番号
	 * @param color　石の色
	 * @param reverseColor　反対の色
	 * @return　ひっくり返せる場合true
	 */
	private boolean checkDown(int number, int alpha, int color, int reverseColor)
	{
		//アルファベットを0~の数字に変換する。
		int alphaNum = alpha - 'a';
			
		//1から使いたいのでインクリメントする。
		alphaNum++;	
				
		for(int i = number + 1; i <= 8; i++){
			//隣に置いてある石を取得
			Stone placedStone = board[i][alphaNum];

			//一個となりが同じ色だった場合、ひっくり返せないためfalseを返す
			if(placedStone.getColor() == color && (i == number + 1))
			{
				return false;
			}
			//1個目以降が反対の色だった場合ループを続ける
			else if(placedStone.getColor() == reverseColor)
			{
				continue;
			}
			//空白だったらfalseを返す。
			else if(placedStone.getColor() == Stone.SPACE)
			{
				return false;
			}
			//2個目以降が同じ色だった場合、挟んでいることになるためtrueを返す
			else 
			{
				return true;
			}
				
		}
		//ループが終了する場合は挟めてないためfalseを返して終了
		return false;				
	}
	/**
	 * 置いた場所からの右上の走査（動作確認済み）
	 * @param number　行番号
	 * @param alpha　列番号
	 * @param color　石の色
	 * @param reverseColor　反対の色
	 * @return　ひっくり返せる場合true
	 */
	private boolean checkUpRight(int number, int alpha, int color, int reverseColor) {
		
		//アルファベットを0~の数字に変換する。
		int alphaNum = alpha - 'a';
		//1から使いたいのでインクリメントする。
		alphaNum++;
		
		for(int i = number - 1, j = alphaNum + 1; i >= 1; i--, j++){
			// 8を超えたら終わり
			if(j > 8)
			{
				return false;
			}
			//置いた場所から右上に置いてある石を取得
			Stone placedStone = board[i][j];
			System.out.print(i);
			System.out.print(" ");
			System.out.print(j);
			System.out.println(placedStone);	
			
			//一個となりが同じ色だった場合、ひっくり返せないためfalseを返す
			if(placedStone.getColor() == color && (i == number - 1 && j == alphaNum + 1))
			{
				return false;
			}
			//1個目以降が反対の色だった場合ループを続ける
			else if(placedStone.getColor() == reverseColor)
			{
				continue;
			}
			//2個目以降が空白だったらfalse
			else if(placedStone.getColor() == Stone.SPACE)
			{
				return false;
			}
			//2個目以降が同じ色だった場合、挟んでいることになるためtrueを返す
			else {
				return true;
			}
		}
		//ループが終了する場合は挟めてないためfalseを返して終了
		return false;		
	}
	/**
	 * 左上の走査
	 * @param number 行番号
	 * @param alpha　列番号
	 * @param color　色
	 * @param reverseColor　反対の色
	 * @return　ひっくり返せる場合ture
	 */
	private boolean checkUpLeft(int number, int alpha, int color, int reverseColor)
	{	
		//アルファベットを0~の数字に変換する。
		int alphaNum = alpha - 'a';
		//1から使いたいのでインクリメントする。
		alphaNum++;
		
		for(int i = number - 1; i >= 0; i--){
			for(int j = alphaNum - 1; j >= 0; j--) {
				
			
				//置いた場所から右上に置いてある石を取得
				Stone placedStone = board[i][j];
				
				//一個となりが同じ色だった場合、ひっくり返せないためfalseを返す
				if(placedStone.getColor() == color && (i == number - 1 && j == alphaNum - 1))
				{
					return false;
				}
				//1個目以降が反対の色だった場合ループを続ける
				else if(placedStone.getColor() == reverseColor)
				{
					continue;
				}
				//2個目以降が同じ色だった場合、挟んでいることになるためtrueを返す
				else
				{
					return true;
				}
			}
				
		}
		//ループが終了する場合は挟めてないためfalseを返して終了
		return false;			
	}
	
	/**
	 * 右下の走査
	 * @param number
	 * @param alpha
	 * @param color
	 * @param reverseColor
	 * @return
	 */
	private boolean checkDownRight(int number, int alpha, int color, int reverseColor)
	{
		//アルファベットを0~の数字に変換する。
		int alphaNum = alpha - 'a';
		//1から使いたいのでインクリメントする。
		alphaNum++;
		
		for(int i = number + 1; i <= 8; i++){
			for(int j = alphaNum + 1; j <= 8; j++) {
				
			
				//置いた場所から右上に置いてある石を取得
				Stone placedStone = board[i][j];
				
				//一個となりが同じ色だった場合、ひっくり返せないためfalseを返す
				if(placedStone.getColor() == color && (i == number + 1 && j == alphaNum + 1))
				{
					return false;
				}
				//1個目以降が反対の色だった場合ループを続ける
				else if(placedStone.getColor() == reverseColor)
				{
					continue;
				}
				//2個目以降が同じ色だった場合、挟んでいることになるためtrueを返す
				else
				{
					return true;
				}
			}
				
		}
		//ループが終了する場合は挟めてないためfalseを返して終了
		return false;			
		
	}
	/**
	 * 左下の走査
	 * @param number
	 * @param alpha
	 * @param color
	 * @param reverseColor
	 * @return
	 */
	private boolean checkDownLeft(int number, int alpha, int color, int reverseColor)
	{
		//アルファベットを0~の数字に変換する。
		int alphaNum = alpha - 'a';
		//1から使いたいのでインクリメントする。
		alphaNum++;
		
		for(int i = number + 1; i <= 8; i++){
			for(int j = alphaNum - 1; j >= 0; j--) {
				
			
				//置いた場所から右上に置いてある石を取得
				Stone placedStone = board[i][j];
				
				//一個となりが同じ色だった場合、ひっくり返せないためfalseを返す
				if(placedStone.getColor() == color && (i == number + 1 && j == alphaNum - 1))
				{
					return false;
				}
				//1個目以降が反対の色だった場合ループを続ける
				else if(placedStone.getColor() == reverseColor)
				{
					continue;
				}
				//2個目以降が同じ色だった場合、挟んでいることになるためtrueを返す
				else
				{
					return true;
				}
			}
				
		}
		//ループが終了する場合は挟めてないためfalseを返して終了
		return false;			
		
	}
	/**
	 * 石を置く
	 * @param number　行番号
	 * @param alpha　列番号
	 * @param stoneColor　石の色
	 */
	public void setStone(int number, int alpha, Stone stone) {
		//アルファベットを0~の数字に変換する。
		int alphaNum = alpha - 'a';
		//1から使いたいのでインクリメントする。
		alphaNum++;
		
		//指定した場所に石を置く。
		board[number][alphaNum] = stone;
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
		board.firstSetStone();
		System.out.println(board);
		
		System.out.println("黒の数:" + board.numberOfBlack());
		System.out.println("白の数:" + board.numberOfWhite());
		
		board.setStone(3, 'e', new Stone(Stone.BLACK));
		board.setStone(3, 'f', new Stone(Stone.WHITE));
		
		System.out.println(board);
		
		
		System.out.println(board.checkStone(5, 'c', new Stone(Stone.WHITE)));
		

	}

}
