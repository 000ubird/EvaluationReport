
/**
 * �R���X�g���N�^�̏���ێ�����N���X�ł��B
 * �R���X�g���N�^�̈����̌^���t�B�[���h�Ɏ����܂��B
 * @author bp12084
 *
 */
public class StructConstructor {
	private Class<?>[] paramTypes;	//�R���X�g���N�^�̈����̌^
	
	/**
	 * �u�R���X�g���N�^�̈����̌^�v�������Ɏ��R���X�g���N�^
	 * @param paramTypes �R���X�g���N�^�̈����̌^
	 */
	public StructConstructor(Class<?>[] paramTypes){
		this.paramTypes = paramTypes;
	}
	
	@Override
	public String toString(){
		String buf = "";
		for(Class<?> c : paramTypes) buf += c.getName() + ",";
		
		return "Constructor => "+buf;
	}
}
