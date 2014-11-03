import java.lang.reflect.Field;

public class Main {
	private static String CLASSPATH = "./bin/ans/";		//クラスファイルのディレクトリ
	private static String CLASSNAME = "LineSegment";			//読み込む.classファイル名
	
	public static void main(String[] args) throws Exception{
		//クラスファイル読み込み
	    ClassLoader loader = ReadClass.createClassLoader(CLASSPATH);
	    Class<?> c = Class.forName(CLASSNAME, true, loader);
	    System.out.println(c);
	    
	    //クラス名取得
		StructClass sc = new StructClass(c);
		System.out.println(sc);
	    
	    //フィールド取得
	    Field[] fields = c.getDeclaredFields();
	    for(Field field : fields){
 	    	StructField sf = new StructField(field.getName(),field.getType(),field.getModifiers());
	    	System.out.println(sf);
	    }
	}
}
