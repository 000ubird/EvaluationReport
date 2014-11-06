
/**
 * コンストラクタの情報を保持するクラスです。
 * コンストラクタの引数の型をフィールドに持ちます。
 * @author bp12084
 *
 */
public class StructConstructor {
	private Class<?>[] paramTypes;	//コンストラクタの引数の型
	
	/**
	 * 「コンストラクタの引数の型」を引数に取るコンストラクタ
	 * @param paramTypes コンストラクタの引数の型
	 */
	public StructConstructor(Class<?>[] paramTypes){
		this.paramTypes = paramTypes;
	}
	
	@Override
	public String toString(){
		String buf = "";
		for(Class<?> c : paramTypes) buf += c.getName() + ",";
		
		return "Constructor => "+buf;
	}
}
