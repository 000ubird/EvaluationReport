import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class CSVFileWrite {
	private static String PATH = "./";				//�o�͂���CSV�t�@�C���̃p�X

	/**
	 * �������CSV�t�@�C���ɏo�͂���
	 * @param out �o�͂��镶����
	 * @param fileName �o�͂���CSV�t�@�C����
	 */
	public static void out(String out,String fileName){
		try {
			//�o�͐���쐬����
			FileWriter fw = new FileWriter(PATH+fileName+".csv", false);
			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));

			//��������t�@�C���ɏo��
			pw.print(out);
			pw.close();

			System.out.println("Output CSV file as "+PATH+fileName+".csv");
		} catch (IOException ex) {
			//��O������
			ex.printStackTrace();
		}
	}
}
