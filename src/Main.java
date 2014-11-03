import java.lang.reflect.Field;

public class Main {
	private static String CLASSPATH = "./bin/ans/";		//�N���X�t�@�C���̃f�B���N�g��
	private static String CLASSNAME = "LineSegment";			//�ǂݍ���.class�t�@�C����
	
	public static void main(String[] args) throws Exception{
		//�N���X�t�@�C���ǂݍ���
	    ClassLoader loader = ReadClass.createClassLoader(CLASSPATH);
	    Class<?> c = Class.forName(CLASSNAME, true, loader);
	    System.out.println(c);
	    
	    //�N���X���擾
		StructClass sc = new StructClass(c);
		System.out.println(sc);
	    
	    //�t�B�[���h�擾
	    Field[] fields = c.getDeclaredFields();
	    for(Field field : fields){
 	    	StructField sf = new StructField(field.getName(),field.getType(),field.getModifiers());
	    	System.out.println(sf);
	    }
	}
}
