
public class Main {
	private static String ANS_CLASSPATH  = "./bin/ans/";	//�����N���X�t�@�C���̃f�B���N�g��
	private static String ANS_CLASSNAME  = "LineSegment";	//�����N���X�t�@�C���̖��O
	private static String TEST_CLASSPATH = "./bin/1/";		//�e�X�g����N���X�t�@�C���̃f�B���N�g��
	private static String TEST_CLASSNAME = "LineSegment";	//�e�X�g����N���X�t�@�C���̖��O
	
	public static void main(String[] args) throws Exception{
		//�N���X�t�@�C���ǂݍ���
	    ClassLoader ansLoader  = ReadClass.createClassLoader(ANS_CLASSPATH);
	    ClassLoader testLoader = ReadClass.createClassLoader(TEST_CLASSPATH);
	    Class<?> ansClass  = Class.forName(ANS_CLASSNAME, true, ansLoader);
	    Class<?> testClass = Class.forName(TEST_CLASSNAME,true, testLoader);
	    
	    //�N���X��񐶐�
	    Structure s1 = new Structure(ansClass);
	    Structure s2 = new Structure(testClass);
	    
	    //CSV������o�̓e�X�g
	    CSVFileWrite.out(s1.getCSV(),"AnsClassInfo");
	    CSVFileWrite.out(s2.getCSV(),"TestClassInfo");
	}
}
