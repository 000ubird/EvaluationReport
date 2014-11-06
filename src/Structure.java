import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * �N���X�\������ێ�����N���X�ł��B
 * @author bp12084
 *
 */
public class Structure {
	private StructClass sClass;						//�N���X���
	private ArrayList<StructField> sField;			//�t�B�[���h���
	private ArrayList<StructConstructor> sConst;	//�R���X�g���N�^���
	private ArrayList<StructMethod> sMethod;		//���\�b�h���
	
	public Structure() {
	}
	
	/**
	 * �N���X�������Ɏ��N���X�\���𐶐�����R���X�g���N�^
	 * ���t���N�V����API���g�p
	 * @param c	�N���X
	 */
	public Structure(Class<?> c){
		//���X�g�̏�����
		sField  = new ArrayList<>();
		sConst  = new ArrayList<>();
		sMethod = new ArrayList<>();
		
		//�N���X���擾
		sClass = new StructClass(c);
		
		//�t�B�[���h���擾
	    Field[] fields = c.getDeclaredFields();
	    for(Field field : fields){
 	    	sField.add(new StructField(field.getName(),field.getType(),field.getModifiers()));
	    }
	    
	    //�R���X�g���N�^���擾
	    Constructor<?>[] constructors = c.getConstructors();
	    for(Constructor<?> constructor : constructors){
	    	Class<?>[] paramType = constructor.getParameterTypes();
	    	sConst.add(new StructConstructor(paramType));
	    }
	    
	    //���\�b�h���擾
		Method[] methods = c.getMethods();
		for(Method method : methods){
			String name = method.getName();							//���\�b�h���擾
			String returnType = method.getReturnType().getName();	//�Ԃ�l�̌^���擾
			Class<?>[]  paramTypes = method.getParameterTypes();	//�����̌^���擾
			sMethod.add(new StructMethod(name,returnType,paramTypes));
		}
	}
	
	@Override
	public String toString() {
		return sClass+"\n"+sField+"\n"+sConst+"\n"+sMethod;
	}	
}
