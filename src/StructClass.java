import java.lang.reflect.Modifier;

/**
 * クラス構造を保持するクラスです。
 * クラス名、修飾子、継承の有無、インターフェースをフィールドに持ちます。
 * @author bp12084
 *
 */
public class StructClass {
	private String name;			//クラス名
	private String modifiers;		//修飾子
	private Class<?> inheritance;	//継承
	private Class<?>[] interfaces;	//インターフェース
	
	public StructClass(){
	}
	
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
	public String toString(){
		String buf = "";
		for(Class<?> inter : interfaces) buf += inter+" , ";
		return "Name => "+name+" , Modifier => "+modifiers+
				" , SuperClass => "+inheritance+" , Interfaces => "+ buf;
	}
}
