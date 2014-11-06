
/**
 * 1つのメソッドの情報を保持するクラスです。
 * メソッド名・返り値の型・引数の型をフィールドに持ちます。
 * @author bp12084
 *
 */

public class StructMethod {
	private String name;			//フィールド名
	private String returnType;		//返り値の型
	private Class<?>[] paramType;	//引数の型
	
	/**
	 * 引数有りのコンストラクタ
	 * @param name			フィールド名
	 * @param returnType	返り値の型
	 * @param paramType		引数の型
	 */
	public StructMethod(String name,String returnType,Class<?>[] paramType){
		this.name = name;
		this.returnType = returnType;
		this.paramType = paramType;
	}
	
	/**
	 * メソッド情報をCSV形式の文字列にする
	 * フォーマット(サンプル)-> Method | メソッド名 | param -> 引数の型 | ...| 返り値の型
	 * @return CSV形式の文字列
	 */
	public String getCSV(){
		String buf = "";
		for(Class<?> c :paramType) buf += "param -> "+c.getName()+",";
		return "Method,"+name+","+buf+returnType;
	}
	
	@Override
	public String toString(){
		String buf = "";
		for(Class<?> c : paramType) buf += c.getName() + ",";
		
		return "Method Name => "+name+" , return => "+returnType+" , paramType => "+buf+"\n";
	}
}
