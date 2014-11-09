/**
 * 正解構造オブジェクトとテストする構造オブジェクトを持つ
 * 評価クラスです
 * @author bp12084
 *
 */
public class Evaluate {
	private Structure answer;	//正解構造オブジェクト
	private Structure test;		//テスト構造オブジェクト
	private static String ANS_FILE_NAME = "AnsClassInfo";
	private static String TEST_FILE_NAME = "TestClassInfo";
	
	/**
	 * クラスを引数に取りそれぞれの構造オブジェクトを生成する
	 * デフォルトコンストラクタ
	 * @param answer 模範解答クラス
	 * @param test   テストクラス
	 */
	public Evaluate(Class<?> answer,Class<?> test){
		this.answer = new Structure(answer);
		this.test = new Structure(test);
	}
	
	/**
	 * 2つの構造オブジェクトからスコアを計算する
	 */
	public void calcScore(){
		answer.calcClassScore(test);
		answer.calcFieldScore(test);
		answer.calcConstructorScore(test);
		answer.calcMethodScore(test);
	}
	
	/**
	 * CSVファイルをそれぞれ出力する
	 */
	public void outCSV(){
	    CSVFileWrite.out(answer.getScoreCSV(),ANS_FILE_NAME);
	    CSVFileWrite.out(test.getCSV(),TEST_FILE_NAME);
	}
}
