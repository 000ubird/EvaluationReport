import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
	private static String CLASSPATH = "./bin/ans/";		//�N���X�t�@�C���̃f�B���N�g��
	private static String CLASSNAME = "LineSegment";	//�ǂݍ���.class�t�@�C����
	
	public static void main(String[] args) throws Exception{
		//�N���X�t�@�C���ǂݍ���
	    ClassLoader loader = ReadClass.createClassLoader(CLASSPATH);
	    Class<?> c = Class.forName(CLASSNAME, true, loader);
	    System.out.println(c);
	    
	    //�N���X���擾
		StructClass sc = new StructClass(c);
		System.out.println(sc);
	    
		//���\�b�h���擾 ���̏�����ClassStructure�N���X�ɋL�q�\��
		Method[] methods = c.getMethods();
		for(Method method : methods){
			String name = method.getName();							//���\�b�h���擾
			String returnType = method.getReturnType().getName();	//�Ԃ�l�̌^���擾
			Class<?>[]  paramTypes = method.getParameterTypes();	//�����̌^���擾
			
			StructMethod sm = new StructMethod(name,returnType,paramTypes);
			System.out.println(sm);
		}
		
		//�R���X�g���N�^���擾 ���̏�����ClassStructure�N���X�ɋL�q�\��
	    Constructor<?>[] constructors = c.getConstructors();
	    for(Constructor<?> constructor : constructors){
	    	Class<?>[] paramType = constructor.getParameterTypes();
	    	StructConstructor sCons = new StructConstructor(paramType);
	    	System.out.println(sCons);
	    }
	    
	    //�t�B�[���h�擾 ���̏�����ClassStructure�N���X�ɋL�q�\��
	    Field[] fields = c.getDeclaredFields();
	    for(Field field : fields){
 	    	StructField sf = new StructField(field.getName(),field.getType(),field.getModifiers());
	    	System.out.println(sf);
	    }
	}
}
