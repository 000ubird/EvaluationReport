
public class Main {
	private static String ANS_CLASSPATH  = "./bin/ans/";	//�����N���X�t�@�C���̃f�B���N�g��
	private static String ANS_CLASSNAME  = "LineSegment";	//�����N���X�t�@�C���̖��O
	private static String TEST_CLASSPATH = "./bin/1/";		//�e�X�g����N���X�t�@�C���̃f�B���N�g��
	private static String TEST_CLASSNAME = "LineSegment";	//�e�X�g����N���X�t�@�C���̖��O
	
	public static void main(String[] args) throws Exception{
		//�N���X�t�@�C���ǂݍ���
	    Class<?> ansClass = ReadClass.createClass(ANS_CLASSNAME, ANS_CLASSPATH);
	    Class<?> testClass= ReadClass.createClass(TEST_CLASSNAME, TEST_CLASSPATH);
	    
	    //�]�����s
	    Evaluate e = new Evaluate(ansClass, testClass);
	    e.calcScore();
	    e.outCSV();
	}
}
