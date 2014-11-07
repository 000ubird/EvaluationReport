import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class CSVFileWrite {
	private static String PATH = "./";				//出力するCSVファイルのパス

	/**
	 * 文字列をCSVファイルに出力する
	 * @param out 出力する文字列
	 * @param fileName 出力するCSVファイル名
	 */
	public static void out(String out,String fileName){
		try {
			//出力先を作成する
			FileWriter fw = new FileWriter(PATH+fileName+".csv", false);
			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));

			//文字列をファイルに出力
			pw.print(out);
			pw.close();

			System.out.println("Output CSV file as "+PATH+fileName+".csv");
		} catch (IOException ex) {
			//例外時処理
			ex.printStackTrace();
		}
	}
}
