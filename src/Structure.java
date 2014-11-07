import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * クラス構造情報を保持するクラスです。
 * @author bp12084
 *
 */
public class Structure {
	private StructClass sClass;						//クラス情報
	private ArrayList<StructField> sField;			//フィールド情報
	private ArrayList<StructConstructor> sConst;	//コンストラクタ情報
	private ArrayList<StructMethod> sMethod;		//メソッド情報
	
	/**
	 * クラスを引数に取りクラス構造を生成するコンストラクタ
	 * リフレクションAPIを使用
	 * @param c	クラス
	 */
	public Structure(Class<?> c){
		//リストの初期化
		sField  = new ArrayList<>();
		sConst  = new ArrayList<>();
		sMethod = new ArrayList<>();
		
		//クラス情報取得
		sClass = new StructClass(c);
		
		//フィールド情報取得
	    Field[] fields = c.getDeclaredFields();
	    for(Field field : fields){
 	    	sField.add(new StructField(field.getName(),field.getType(),field.getModifiers()));
	    }
	    
	    //コンストラクタ情報取得
	    Constructor<?>[] constructors = c.getConstructors();
	    for(Constructor<?> constructor : constructors){
	    	Class<?>[] paramType = constructor.getParameterTypes();
	    	sConst.add(new StructConstructor(paramType));
	    }
	    
	    //メソッド情報取得
		Method[] methods = c.getMethods();
		for(Method method : methods){
			String name = method.getName();							//メソッド名取得
			String returnType = method.getReturnType().getName();	//返り値の型を取得
			Class<?>[]  paramTypes = method.getParameterTypes();	//引数の型を取得
			sMethod.add(new StructMethod(name,returnType,paramTypes));
		}
	}
	
	/**
	 * クラス構造情報を1つのCSV形式の文字列にまとめたデータを取得する
	 * @return それぞれの情報をまとめたCSV形式の文字列
	 */
	public String getCSV(){
		String buf = "";
		
	    buf += sClass.getCSV()+"\n";
	    for(StructField sf : sField) buf += sf.getCSV()+"\n";
	    for(StructConstructor sc : sConst) buf+= sc.getCSV()+"\n";
	    for(StructMethod sm : sMethod) buf += sm.getCSV()+"\n";
	    
	    return buf;
	}
	
	public StructClass getsClass() {
		return sClass;
	}

	public ArrayList<StructField> getsField() {
		return sField;
	}

	public ArrayList<StructConstructor> getsConst() {
		return sConst;
	}

	public ArrayList<StructMethod> getsMethod() {
		return sMethod;
	}
	
	@Override
	public String toString() {
		return sClass+"\n"+sField+"\n"+sConst+"\n"+sMethod;
	}	
}
