
public class Main {
	private static String ANS_CLASSPATH  = "./bin/ans/";	//正解クラスファイルのディレクトリ
	private static String ANS_CLASSNAME  = "LineSegment";	//正解クラスファイルの名前
	private static String TEST_CLASSPATH = "./bin/1/";		//テストするクラスファイルのディレクトリ
	private static String TEST_CLASSNAME = "LineSegment";	//テストするクラスファイルの名前
	
	public static void main(String[] args) throws Exception{
		//クラスファイル読み込み
	    ClassLoader ansLoader  = ReadClass.createClassLoader(ANS_CLASSPATH);
	    ClassLoader testLoader = ReadClass.createClassLoader(TEST_CLASSPATH);
	    Class<?> ansClass  = Class.forName(ANS_CLASSNAME, true, ansLoader);
	    Class<?> testClass = Class.forName(TEST_CLASSNAME,true, testLoader);
	    
	    //評価オブジェクト生成
	    Evaluate e = new Evaluate(ansClass, testClass);
	    e.calcScore();
	    e.outCSV();
	}
}
