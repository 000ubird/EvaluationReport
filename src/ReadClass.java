import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadClass {
	/**
	 * クラス読み込む
	 * @param dirname ディレクトリ名
	 * @return クラスローダ
	 * @throws java.io.IOException
	 */
	public static ClassLoader createClassLoader(String dirname) throws java.io.IOException {
	    java.net.URL[] url = new java.net.URL[1];
	    java.io.File file;
	    if (dirname.endsWith("/")) {
	        file = new java.io.File(dirname);
	    }
	    else {
	        // ディレクトリは最後にスラッシュが必要
	        file = new java.io.File(dirname + "/");
	    }
	    url[0]= file.toURI().toURL();

	    ClassLoader parent = ClassLoader.getSystemClassLoader();
	    java.net.URLClassLoader loader = new java.net.URLClassLoader(url, parent);

	    return loader;
	}
	
	/**
	 * ファイル名とディレクトリからクラスを取得する
	 * 見つからなかった場合はディレクトリとファイル名の再入力を要求する
	 * @param fileName	ファイル名
	 * @param dirName	ディレクトリ名
	 * @return			クラス
	 * @throws IOException
	 */
	public static Class<?> createClass(String fileName,String dirName) throws IOException{
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		Class<?> cls = null;
		
		while(cls == null){
			try {
				ClassLoader loader = ReadClass.createClassLoader(dirName);
				cls = Class.forName(fileName, true, loader);
				break;
			} catch (ClassNotFoundException e) {
				System.out.println("指定されたクラス: " + fileName + " は存在しません.");
				System.out.println("Input Class Directory");
				dirName = br.readLine();
				System.out.println("Input ClassName");
				fileName = br.readLine();
			}
		}

		return cls;
	}
}
