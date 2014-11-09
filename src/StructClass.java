import java.lang.reflect.Modifier;

/**
 * クラス情報を保持するクラスです。
 * クラス名、修飾子、継承の有無、インターフェースをフィールドに持ちます。
 * @author bp12084
 *
 */
public class StructClass {
	private String name;			//クラス名
	private String modifiers;		//修飾子
	private Class<?> inheritance;	//継承
	private Class<?>[] interfaces;	//インターフェース
	private Score score;			//得点情報
	private static int MAX_SCORE = 4;	//スコアの最高得点
	
	/**
	 * クラスを引数に取ってコンストラクタを生成
	 * @param c	クラス
	 */
	public StructClass(Class<?> c) {
		name = c.getSimpleName();
		modifiers = getModifierType(c.getModifiers());
		inheritance = c.getSuperclass();
		interfaces = c.getInterfaces();
		score = new Score();
	}
	
	/**
	 * クラスの情報をCSV形式の文字列にする
	 * フォーマット(サンプル)-> class | 修飾子 | クラス名 | 継承 | インターフェース |
	 * @return CSV形式の文字列
	 */
	public String getCSV(){
		String buf = "";
		for(Class<?> inter : interfaces) buf += inter+",";
		return "Class,"+modifiers+","+name+",Extends "+inheritance+","+buf;
	}
	
	/**
	 * スコア情報付きのCSV文字列を取得する
	 * @return CSV形式の文字列
	 */
	public String getScoreCSV(){
		return getCSV()+","+score.getCSV();
	}
	
	/**
	 * クラスの修飾子の種類を文字列で返す
	 * @param mods 修飾子の種類を表すint型の数値
	 * @return 修飾子を表す文字列
	 */
	private static String getModifierType(int mods){
		String buf = "none";
		
		if(Modifier.isPublic(mods)) buf = "public";
		if(Modifier.isAbstract(mods)) buf = "abstruct";
		if(Modifier.isFinal(mods)) buf = "final";
		
		return buf;
	}
	
	/**
	 * クラス構造情報を引数に取ってスコアを算出する
	 * 算出したスコアはフィールドのスコア情報に保持される
	 * @param sc クラス構造オブジェクト
	 */
	public void calcScore(StructClass sc){
		int currentScore = 0;
		
		if(this.name.equals(sc.name)) currentScore++;
		if(this.modifiers.equals(sc.modifiers)) currentScore++;
		if(this.inheritance.equals(sc.inheritance)) currentScore++;
		if(this.interfaces.equals(sc.interfaces)) currentScore++;
		
		score = new Score(currentScore,MAX_SCORE);
	}
	
	@Override
	public boolean equals(Object o){
		StructClass sc = (StructClass)o;
		
		if(this.name.equals(sc.name) == false) return false;
		if(this.modifiers.equals(sc.modifiers) == false)return false;
		if(this.inheritance.equals(sc.inheritance) == false) return false;
		try{
			for(int i=0;i<this.interfaces.length;i++){
				if(this.interfaces[i].equals(sc.interfaces[i])==false)return false;
			}
		}catch(ArrayIndexOutOfBoundsException e){
			return false;
		}
		
		return true;
	}
	
	@Override
	public String toString(){
		String buf = "";
		for(Class<?> inter : interfaces) buf += inter+" , ";
		return "Class Name => "+name+" , Modifier => "+modifiers+
				" , SuperClass => "+inheritance+" , Interfaces => "+ buf;
	}
}
