
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
	
	/**
	 * ���\�b�h����CSV�`���̕�����ɂ���
	 * �t�H�[�}�b�g(�T���v��)-> Method | �Ԃ�l�̌^ | param -> �����̌^ | ...| ���\�b�h��
	 * @return CSV�`���̕�����
	 */
	public String getCSV(){
		String buf = "";
		for(Class<?> c :paramType) buf += "param -> "+c.getName()+",";
		return "Method,"+returnType+","+buf+name;
	}
	
	@Override
	public boolean equals(Object o){
		StructMethod sm = (StructMethod)o;
		if(this.name.equals(sm.name) == false) return false;
		if(this.returnType.equals(sm.returnType) == false) return false;
		try{
			for(int i=0;i<this.paramType.length;i++){
				if(this.paramType[i].equals(sm.paramType[i])==false) return false;
			}	
		}catch(ArrayIndexOutOfBoundsException e){
			return false;
		}

		return true;
	}

	@Override
	public String toString(){
		String buf = "";
		for(Class<?> c : paramType) buf += c.getName() + ",";
		
		return "Method Name => "+name+" , return => "+returnType+" , paramType => "+buf+"\n";
	}
}
