import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadClass {
	/**
	 * �N���X�ǂݍ���
	 * @param dirname �f�B���N�g����
	 * @return �N���X���[�_
	 * @throws java.io.IOException
	 */
	public static ClassLoader createClassLoader(String dirname) throws java.io.IOException {
	    java.net.URL[] url = new java.net.URL[1];
	    java.io.File file;
	    if (dirname.endsWith("/")) {
	        file = new java.io.File(dirname);
	    }
	    else {
	        // �f�B���N�g���͍Ō�ɃX���b�V�����K�v
	        file = new java.io.File(dirname + "/");
	    }
	    url[0]= file.toURI().toURL();

	    ClassLoader parent = ClassLoader.getSystemClassLoader();
	    java.net.URLClassLoader loader = new java.net.URLClassLoader(url, parent);

	    return loader;
	}
	
	/**
	 * �t�@�C�����ƃf�B���N�g������N���X���擾����
	 * ������Ȃ������ꍇ�̓f�B���N�g���ƃt�@�C�����̍ē��͂�v������
	 * @param fileName	�t�@�C����
	 * @param dirName	�f�B���N�g����
	 * @return			�N���X
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
				System.out.println("�w�肳�ꂽ�N���X: " + fileName + " �͑��݂��܂���.");
				System.out.println("Input Class Directory");
				dirName = br.readLine();
				System.out.println("Input ClassName");
				fileName = br.readLine();
			}
		}

		return cls;
	}
}
