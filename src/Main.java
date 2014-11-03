import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {
	private static String CLASSPATH = "./bin/ans/";		//クラスファイルのディレクトリ
	private static String CLASSNAME = "Point";			//読み込む.classファイル名
	
	public static void main(String[] args) throws Exception{
		//クラスファイル読み込み
	    ClassLoader loader = ReadClass.createClassLoader(CLASSPATH);
	    Class<?> c = Class.forName(CLASSNAME, true, loader);
	    System.out.println(c);
	    
	    //クラス名取得
	    System.out.println(c.getName());
	    System.out.println(Modifier.isInterface(c.getModifiers()));
	    System.out.println(c.getSuperclass());
	    
	    //フィールド取得
	    Field[] fields = c.getDeclaredFields();
	    for(Field field : fields){
	    	System.out.println(field.getModifiers()+ " => "+ field.getName() +" : "+ field.getType());
	    }
	    
	    //メソッド取得
	    Method[] methods = c.getMethods();
	    for(Method method : methods){
	    	String name = method.getName();
	    	String returnType = method.getReturnType().getName();
			Class<?>[] paramType = method.getParameterTypes();
	    	
	    	System.out.print("Name => "+name+" , return => "+returnType);
	    	for(Class<?> type : paramType){
	    		System.out.print(" , paramType => "+type);
	    	}
	    	System.out.println();
	    }
	}
}
