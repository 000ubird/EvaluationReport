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
}
