import java.lang.reflect.Modifier;

/**
 * �t�B�[���h�ϐ��̏���ێ�����N���X�ł��B
 * �ϐ����A�^�A�C���q���t�B�[���h�Ɏ����܂��B
 * @author bp12084
 *
 */
public class StructField {
	private String name;		//�t�B�[���h�ϐ���
	private String fieldType;	//�t�B�[���h�ϐ��̌^
	private String modifier;	//�t�B�[���h�ϐ��̏C���q
	
	/**
	 * �����L��̃R���X�g���N�^
	 * @param name	�t�B�[���h�ϐ���
	 * @param type	�t�B�[���h�ϐ��̌^
	 * @param mod	�t�B�[���h�ϐ��̏C���q�̒l
	 */
	public StructField(String name,Class<?> type,int mod){
		this.name = name;
		this.fieldType = type.getName();
		this.modifier = getModifierType(mod);
	}
	
	/**
	 * �t�B�[���h�ϐ��̏C���q�̎�ނ𕶎���ŕԂ�
	 * @param mod �C���q�̎�ނ�\�����l
	 * @return �C���q��\��������
	 */
	public static String getModifierType(int mod){
		String buf = "none";
		
		if(Modifier.isPublic(mod)) buf = "public";
		if(Modifier.isPrivate(mod)) buf = "private";
		if(Modifier.isProtected(mod)) buf = "protected";
		if(Modifier.isFinal(mod)) buf = "final";
		
		return buf;
	}
	
	/**
	 * �t�B�[���h�̏���CSV�`���̕�����ɂ���
	 * �t�H�[�}�b�g(�T���v��)-> Field | �C���q | �^ | �t�B�[���h��
	 * @return CSV�`���̕�����
	 */
	public String getCSV(){
		return "Field,"+modifier+","+fieldType+","+name;
	}
	
	@Override
	public boolean equals(Object o){
		StructField sf = (StructField)o;
		if(this.name.equals(sf.name) == false) 			 return false;
		if(this.fieldType.equals(sf.fieldType) == false) return false;
		if(this.modifier.equals(sf.modifier) == false)   return false;
			
		return true;
	}
	
	@Override
	public String toString(){
		return "Field  "+modifier+ " => " +name+ " : " +fieldType;
	}

}
