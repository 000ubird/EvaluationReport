/**
 * クラス構造を保持するクラスです。
 * クラス名、修飾子、継承の有無、インターフェースをフィールドに持ちます。
 * @author bp12084
 *
 */
public class StructClass {
	private String name;			//クラス名
	private String modifiers;		//修飾子
	private Class<?> inheritance;	//継承
	private Class<?>[] interfaces;	//インターフェース
	
	public StructClass(){
	}
}
