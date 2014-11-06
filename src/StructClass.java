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
	
	/**
	 * クラスを引数に取ってコンストラクタを生成
	 * @param c	クラス
	 */
	public StructClass(Class<?> c) {
		name = c.getName();
		modifiers = getModifierType(c.getModifiers());
		inheritance = c.getSuperclass();
		interfaces = c.getInterfaces();
	}
	
	/**
	 * クラスの情報をCSV形式の文字列にする
	 * フォーマット(サンプル)-> Class | 修飾子 | クラス名 | 継承 | インターフェース |
	 * @return CSV形式の文字列
	 */
	public String getCsv(){
		String buf = "";
		for(Class<?> inter : interfaces) buf += inter+",";
		return "Class,"+modifiers+","+name+","+inheritance+","+buf;
	}
	
	/**
	 * クラスの修飾子の種類を文字列で返す
	 * @param mods 修飾子の種類を表すint型の数値
	 * @return 修飾子を表す文字列
	 */
	public static String getModifierType(int mods){
		String buf = "none";
		
		if(Modifier.isPublic(mods)) buf = "public";
		if(Modifier.isAbstract(mods)) buf = "abstruct";
		if(Modifier.isFinal(mods)) buf = "final";
		
		return buf;
	}
	
	@Override
	public boolean equals(Object o){
		StructClass sc = (StructClass)o;
		
		if(this.name.equals(sc.name) == false) return false;
		if(this.modifiers.equals(sc.modifiers) == false)return false;
		if(this.inheritance.equals(sc.inheritance) == false) return false;
		for(int i=0;i<this.interfaces.length;i++){
			if(this.interfaces[i].equals(sc.interfaces[i])==false)return false;
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
