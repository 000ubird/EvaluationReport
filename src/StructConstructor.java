
/**
 * コンストラクタの情報を保持するクラスです。
 * コンストラクタの引数の型をフィールドに持ちます。
 * @author bp12084
 *
 */
public class StructConstructor {
	private Class<?>[] paramTypes;	//コンストラクタの引数の型
	private Score score;			//得点情報
	private static int MAX_SCORE = 1;	//フィールドスコアの最高得点
	
	/**
	 * 「コンストラクタの引数の型」を引数に取るコンストラクタ
	 * @param paramTypes コンストラクタの引数の型
	 */
	public StructConstructor(Class<?>[] paramTypes){
		this.paramTypes = paramTypes;
		score = new Score();
	}
	
	/**
	 * コンストラクタの情報をCSV形式の文字列にする
	 * フォーマット(サンプル) -> Constructor | param -> 引数の型  | ... |
	 * @return
	 */
	public String getCSV(){
		String buf = "";
		for(Class<?> c : paramTypes) buf += "param -> "+c.getName()+",";
		
		return "Constructor,"+buf;
	}
	
	/**
	 * スコア情報付きのCSV文字列を取得する
	 * @return CSV形式の文字列
	 */
	public String getScoreCSV(){
		return getCSV()+","+score.getCSV();
	}
	
	/**
	 * コンストラクタ情報を引数に取ってスコアを算出する
	 * @param sc テストするコンストラクタ構造オブジェクト
	 */
	public void calcScore(StructConstructor sc){
		int currentScore = 0;
		if(this.equals(sc)) currentScore++;
		
		 score = new Score(currentScore,MAX_SCORE);
	}
	
	@Override
	public boolean equals(Object o){
		StructConstructor sc = (StructConstructor)o;
		try{
			for(int i=0;i<this.paramTypes.length;i++){
				if(this.paramTypes[i].equals(sc.paramTypes[i])==false) return false;
			}
		}catch(ArrayIndexOutOfBoundsException e){
			return false;
		}
		
		return true;
	}
	
	@Override
	public String toString(){
		String buf = "";
		for(Class<?> c : paramTypes) buf += c.getName() + ",";
		
		return "Constructor => "+buf+score;
	}
}
