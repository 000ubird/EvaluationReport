import java.lang.reflect.Modifier;

/**
 * フィールド変数の情報を保持するクラスです。
 * 変数名、型、修飾子をフィールドに持ちます。
 * @author bp12084
 *
 */
public class StructField {
	private String name;		//フィールド変数名
	private Class<?> fieldType;	//フィールド変数の型
	private String modifier;	//フィールド変数の修飾子
	
	public StructField(){
	}
	
	public StructField(String name,Class type,int mod){
		this.name = name;
		this.fieldType = type;
		this.modifier = getModifierType(mod);
	}
	
	/**
	 * フィールド変数の修飾子の種類を文字列で返す
	 * @param mod 修飾子の種類を表すint型の数値
	 * @return 修飾子を表す文字列
	 */
	public static String getModifierType(int mod){
		String buf = "none";
		
		if(Modifier.isPublic(mod)) buf = "public";
		if(Modifier.isPrivate(mod)) buf = "private";
		if(Modifier.isProtected(mod)) buf = "protected";
		if(Modifier.isFinal(mod)) buf = "final";
		
		return buf;
	}

}
