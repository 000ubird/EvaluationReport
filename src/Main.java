import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
	private static String CLASSPATH = "./bin/ans/";		//クラスファイルのディレクトリ
	private static String CLASSNAME = "LineSegment";	//読み込む.classファイル名
	
	public static void main(String[] args) throws Exception{
		//クラスファイル読み込み
	    ClassLoader loader = ReadClass.createClassLoader(CLASSPATH);
	    Class<?> c = Class.forName(CLASSNAME, true, loader);
	    System.out.println(c);
	    
	    //クラス情報取得
		StructClass sc = new StructClass(c);
		System.out.println(sc);
	    
		//メソッド情報取得 この処理はClassStructureクラスに記述予定
		Method[] methods = c.getMethods();
		for(Method method : methods){
			String name = method.getName();							//メソッド名取得
			String returnType = method.getReturnType().getName();	//返り値の型を取得
			Class<?>[]  paramTypes = method.getParameterTypes();	//引数の型を取得
			
			StructMethod sm = new StructMethod(name,returnType,paramTypes);
			System.out.println(sm);
		}
		
		//コンストラクタ情報取得 この処理はClassStructureクラスに記述予定
	    Constructor<?>[] constructors = c.getConstructors();
	    for(Constructor<?> constructor : constructors){
	    	Class<?>[] paramType = constructor.getParameterTypes();
	    	StructConstructor sCons = new StructConstructor(paramType);
	    	System.out.println(sCons);
	    }
	    
	    //フィールド取得 この処理はClassStructureクラスに記述予定
	    Field[] fields = c.getDeclaredFields();
	    for(Field field : fields){
 	    	StructField sf = new StructField(field.getName(),field.getType(),field.getModifiers());
	    	System.out.println(sf);
	    }
	}
}
