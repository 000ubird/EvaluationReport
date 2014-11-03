import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {
	private static String CLASSPATH = "./bin/ans/";		//�N���X�t�@�C���̃f�B���N�g��
	private static String CLASSNAME = "Point";			//�ǂݍ���.class�t�@�C����
	
	public static void main(String[] args) throws Exception{
		//�N���X�t�@�C���ǂݍ���
	    ClassLoader loader = ReadClass.createClassLoader(CLASSPATH);
	    Class<?> c = Class.forName(CLASSNAME, true, loader);
	    System.out.println(c);
	    
	    //�N���X���擾
	    System.out.println(c.getName());
	    System.out.println(Modifier.isInterface(c.getModifiers()));
	    System.out.println(c.getSuperclass());
	    
	    //�t�B�[���h�擾
	    Field[] fields = c.getDeclaredFields();
	    for(Field field : fields){
	    	System.out.println(field.getModifiers()+ " => "+ field.getName() +" : "+ field.getType());
	    }
	    
	    //���\�b�h�擾
	    Method[] methods = c.getMethods();
	    for(Method method : methods){
	    	String name = method.getName();
	    	String returnType = method.getReturnType().getName();
			Class<?>[] paramType = method.getParameterTypes();
	    	
	    	System.out.print("Name => "+name+" , return => "+returnType);
	    	for(Class<?> type : paramType){
	    		System.out.print(" , paramType => "+type);
	    	}
	    	System.out.println();
	    }
	}
}
