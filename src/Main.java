
public class Main {
	private static String ANS_CLASSPATH  = "./bin/ans/";	//正解クラスファイルのディレクトリ
	private static String ANS_CLASSNAME  = "LineSegment";	//正解クラスファイルの名前
	private static String TEST_CLASSPATH = "./bin/1/";		//テストするクラスファイルのディレクトリ
	private static String TEST_CLASSNAME = "LineSegment";	//テストするクラスファイルの名前
	
	public static void main(String[] args) throws Exception{
		//クラスファイル読み込み
	    Class<?> ansClass = ReadClass.createClass(ANS_CLASSNAME, ANS_CLASSPATH);
	    Class<?> testClass= ReadClass.createClass(TEST_CLASSNAME, TEST_CLASSPATH);
	    
	    //評価実行
	    Evaluate e = new Evaluate(ansClass, testClass);
	    e.calcScore();
	    e.outCSV();
	}
}
