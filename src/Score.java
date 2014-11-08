/**
 * 得点オブジェクト
 * @author bp12084
 *
 */
public class Score {
	private int point;		//評価点
	private int maxPoint;	//最高点
	
	/**
	 * デフォルトコンストラクタ
	 */
	public Score (){
		point = 0;
		maxPoint = 0;
	}
	
	/**
	 * 評価点・最高点のそれぞれを引数に取る
	 * @param p		評価点
	 * @param max	最高点
	 */
	public Score(int p, int max) {
		point = p;
		maxPoint = max;
	}
	
	@Override
	public String toString() {
		return "Score [point=" + point + ", maxPoint=" + maxPoint + "]";
	}
}
