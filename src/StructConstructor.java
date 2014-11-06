
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
	
	/**
	 * �R���X�g���N�^�̏���CSV�`���̕�����ɂ���
	 * �t�H�[�}�b�g(�T���v��) -> Constructor | param -> �����̌^  | ... |
	 * @return
	 */
	public String getCSV(){
		String buf = "";
		for(Class<?> c : paramTypes) buf += "param -> "+c.getName()+",";
		
		return "Constructor,"+buf;
	}
	
	@Override
	public String toString(){
		String buf = "";
		for(Class<?> c : paramTypes) buf += c.getName() + ",";
		
		return "Constructor => "+buf;
	}
}
