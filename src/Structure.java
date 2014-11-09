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
	    Constructor<?>[] constructors = c.getDeclaredConstructors();
	    for(Constructor<?> constructor : constructors){
	    	Class<?>[] paramType = constructor.getParameterTypes();
	    	sConst.add(new StructConstructor(paramType));
	    }
	    
	    //メソッド情報取得
		Method[] methods = c.getDeclaredMethods();
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
		
	    buf += sClass.getScoreCSV()+"\n";
	    for(StructField sf : sField) buf += sf.getScoreCSV()+"\n";
	    for(StructConstructor sc : sConst) buf+= sc.getCSV()+"\n";
	    for(StructMethod sm : sMethod) buf += sm.getCSV()+"\n";
	    
	    return buf;
	}
	
	public void calcClassScore(Structure testStructure){
		sClass.calcScore(testStructure.getsClass());
	}
	
	/**
	 * 指定したフィールド名が存在するかを判定する
	 * @param name	探したいフィールドの名前
	 * @return		判定結果
	 */
	public boolean isSameField(String name) {
		for (StructField sf : sField) {
			if(sf.hasField(name)) return true;
		}
		return false;
	}
	
	/**
	 * フィールドのスコア情報を取得する
	 * 正解クラス構造オブジェクトで呼び出す
	 * @param testStructure	テストするクラス構造オブジェクト
	 */
	public void calcFieldScore(Structure testStructure){
		for(int i=0; i<sField.size();i++){
			if(testStructure.isSameField(sField.get(i).getName())){
				sField.get(i).calcScore(testStructure.getsField().get(i));
				System.out.println(sField.get(i));
			}
		}
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
