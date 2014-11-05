
/**
 * 1�̃��\�b�h�̏���ێ�����N���X�ł��B
 * ���\�b�h���E�Ԃ�l�̌^�E�����̌^���t�B�[���h�Ɏ����܂��B
 * @author bp12084
 *
 */

public class StructMethod {
	private String name;			//�t�B�[���h��
	private String returnType;		//�Ԃ�l�̌^
	private Class<?>[] paramType;	//�����̌^
	
	public StructMethod() {
	}
	
	/**
	 * �����L��̃R���X�g���N�^
	 * @param name			�t�B�[���h��
	 * @param returnType	�Ԃ�l�̌^
	 * @param paramType		�����̌^
	 */
	public StructMethod(String name,String returnType,Class<?>[] paramType){
		this.name = name;
		this.returnType = returnType;
		this.paramType = paramType;
	}
	
	@Override
	public String toString(){
		String buf = "";
		for(Class<?> c : paramType) buf += c.getName() + ",";
		
		return "Method Name => "+name+" , return => "+returnType+" , paramType => "+buf;
	}
}
