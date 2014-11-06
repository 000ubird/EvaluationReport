
public class Main {
	private static String CLASSPATH = "./bin/ans/";		//クラスファイルのディレクトリ
	private static String CLASSNAME = "LineSegment";	//読み込む.classファイル名
	
	public static void main(String[] args) throws Exception{
		//クラスファイル読み込み
	    ClassLoader loader = ReadClass.createClassLoader(CLASSPATH);
	    Class<?> c = Class.forName(CLASSNAME, true, loader);
	    System.out.println(c);
	    
	    //クラス情報生成
	    Structure s = new Structure(c);
	    System.out.println(s);
	}
}
