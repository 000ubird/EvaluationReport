
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
	    System.out.println(ansClass);
	    System.out.println(testClass);
	    
	    //�N���X��񐶐�
	    Structure s1 = new Structure(ansClass);
	    System.out.println(s1);
	    Structure s2 = new Structure(testClass);
	    System.out.println(s2);
	    
	    //CSV������o�̓e�X�g
	    System.out.println("=== test for CSV output ===");
	    System.out.println(s1.getsClass().getCsv());
	    CSVFileWrite.out(s1.getsClass().getCsv(),"classInfo");
	    for(StructField sf : s1.getsField()) System.out.println(sf.getCSV());
	    for(StructMethod sm : s1.getsMethod()) System.out.println(sm.getCSV());
	}
}
