
public class Main {
	private static String CLASSPATH = "./bin/ans/";		//�N���X�t�@�C���̃f�B���N�g��
	private static String CLASSNAME = "LineSegment";	//�ǂݍ���.class�t�@�C����
	
	public static void main(String[] args) throws Exception{
		//�N���X�t�@�C���ǂݍ���
	    ClassLoader loader = ReadClass.createClassLoader(CLASSPATH);
	    Class<?> c = Class.forName(CLASSNAME, true, loader);
	    System.out.println(c);
	    
	    //�N���X��񐶐�
	    Structure s = new Structure(c);
	    System.out.println(s);
	}
}
