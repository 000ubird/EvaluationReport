import java.lang.reflect.Modifier;

/**
 * フィールド変数の情報を保持するクラスです。
 * 変数名、型、修飾子をフィールドに持ちます。
 * @author bp12084
 *
 */
public class StructField {
	private String name;		//フィールド変数名
	private String fieldType;	//フィールド変数の型
	private String modifier;	//フィールド変数の修飾子
	private Score score;		//得点情報
	private static int MAX_SCORE = 3;	//フィールドスコアの最高得点
	
	public String getName(){
		return name;
	}

	/**
	 * 引数有りのコンストラクタ
	 * @param name	フィールド変数名
	 * @param type	フィールド変数の型
	 * @param mod	フィールド変数の修飾子の値
	 */
	public StructField(String name,Class<?> type,int mod){
		this.name = name;
		this.fieldType = type.getSimpleName();
		this.modifier = getModifierType(mod);
		score = new Score();
	}
	
	/**
	 * フィールド変数の修飾子の種類を文字列で返す
	 * @param mod 修飾子の種類を表す数値
	 * @return 修飾子を表す文字列
	 */
	public static String getModifierType(int mod){
		String buf = "none";	//アクセス修飾子情報無し
		
		if(Modifier.isPublic(mod))		buf = "public";
		if(Modifier.isPrivate(mod))		buf = "private";
		if(Modifier.isProtected(mod))	buf = "protected";
		if(Modifier.isFinal(mod))		buf = "final";
		if(Modifier.isStatic(mod))		buf = "static";
		
		return buf;
	}
	
	/**
	 * 指定したフィールド名と一致するフィールドであるかを判定する
	 * @param name 調べたいフィールド名
	 * @return     一致したらtrue,一致しなかったらfalse
	 */
	public boolean hasField(String name){
		if(this.name.equals(name)) return true;
		else return false;
	}
	
	/**
	 * フィールド構造情報を引数に取ってスコアを算出する
	 * 算出したスコアはフィールドのスコア情報に保持される
	 * @param sf フィールド情報
	 */
	public void calcScore(StructField sf){
		int currentScore = 0;
		if(this.name.equals(sf.name)) 			 currentScore++;
		if(this.fieldType.equals(sf.fieldType))  currentScore++;
		if(this.modifier.equals(sf.modifier))	 currentScore++;
		
		this.score = new Score(currentScore,MAX_SCORE);
	}
	
	/**
	 * フィールドの情報をCSV形式の文字列にする
	 * フォーマット(サンプル)-> Field | 修飾子 | 型 | フィールド名
	 * @return CSV形式の文字列
	 */
	public String getCSV(){
		return "Field,"+modifier+","+fieldType+","+name;
	}
	
	/**
	 * スコア情報付きのCSV文字列を取得する
	 * @return CSV形式の文字列
	 */
	public String getScoreCSV(){
		return getCSV()+","+score.getCSV();
	}
	
	@Override
	public boolean equals(Object o){
		StructField sf = (StructField)o;
		if(this.name.equals(sf.name) == false) 			 return false;
		if(this.fieldType.equals(sf.fieldType) == false) return false;
		if(this.modifier.equals(sf.modifier) == false)   return false;
			
		return true;
	}
	
	@Override
	public String toString(){
		return "Field  "+modifier+ " => " +name+ " : " +fieldType+" -> "+score;
	}

}
