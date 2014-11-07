
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
	    System.out.println(ansClass);
	    System.out.println(testClass);
	    
	    //クラス情報生成
	    Structure s1 = new Structure(ansClass);
	    System.out.println(s1);
	    Structure s2 = new Structure(testClass);
	    System.out.println(s2);
	    
	    //CSV文字列出力テスト
	    System.out.println("=== test for CSV output ===");
	    System.out.println(s1.getsClass().getCsv());
	    CSVFileWrite.out(s1.getsClass().getCsv(),"classInfo");
	    for(StructField sf : s1.getsField()) System.out.println(sf.getCSV());
	    for(StructMethod sm : s1.getsMethod()) System.out.println(sm.getCSV());
	}
}
