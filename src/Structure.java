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
	    Constructor<?>[] constructors = c.getDeclaredConstructors();
	    for(Constructor<?> constructor : constructors){
	    	Class<?>[] paramType = constructor.getParameterTypes();
	    	sConst.add(new StructConstructor(paramType));
	    }
	    
	    //���\�b�h���擾
		Method[] methods = c.getDeclaredMethods();
		for(Method method : methods){
			String name = method.getName();							//���\�b�h���擾
			String returnType = method.getReturnType().getName();	//�Ԃ�l�̌^���擾
			Class<?>[]  paramTypes = method.getParameterTypes();	//�����̌^���擾
			sMethod.add(new StructMethod(name,returnType,paramTypes));
		}
	}
	
	/**
	 * �N���X�\������1��CSV�`���̕�����ɂ܂Ƃ߂��f�[�^���擾����
	 * @return ���ꂼ��̏����܂Ƃ߂�CSV�`���̕�����
	 */
	public String getCSV(){
		String buf = "";
		
	    buf += sClass.getScoreCSV()+"\n";
	    for(StructField sf : sField) buf += sf.getScoreCSV()+"\n";
	    for(StructConstructor sc : sConst) buf+= sc.getCSV()+"\n";
	    for(StructMethod sm : sMethod) buf += sm.getCSV()+"\n";
	    
	    return buf;
	}
	
	public void calcClassScore(Structure testStructure){
		sClass.calcScore(testStructure.getsClass());
	}
	
	/**
	 * �w�肵���t�B�[���h�������݂��邩�𔻒肷��
	 * @param name	�T�������t�B�[���h�̖��O
	 * @return		���茋��
	 */
	public boolean isSameField(String name) {
		for (StructField sf : sField) {
			if(sf.hasField(name)) return true;
		}
		return false;
	}
	
	/**
	 * �t�B�[���h�̃X�R�A�����擾����
	 * �����N���X�\���I�u�W�F�N�g�ŌĂяo��
	 * @param testStructure	�e�X�g����N���X�\���I�u�W�F�N�g
	 */
	public void calcFieldScore(Structure testStructure){
		for(int i=0; i<sField.size();i++){
			if(testStructure.isSameField(sField.get(i).getName())){
				sField.get(i).calcScore(testStructure.getsField().get(i));
				System.out.println(sField.get(i));
			}
		}
	}
	
	public StructClass getsClass() {
		return sClass;
	}

	public ArrayList<StructField> getsField() {
		return sField;
	}

	public ArrayList<StructConstructor> getsConst() {
		return sConst;
	}

	public ArrayList<StructMethod> getsMethod() {
		return sMethod;
	}
	
	@Override
	public String toString() {
		return sClass+"\n"+sField+"\n"+sConst+"\n"+sMethod;
	}	
}
