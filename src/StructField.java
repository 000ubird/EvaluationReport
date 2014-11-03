import java.lang.reflect.Modifier;

/**
 * �t�B�[���h�ϐ��̏���ێ�����N���X�ł��B
 * �ϐ����A�^�A�C���q���t�B�[���h�Ɏ����܂��B
 * @author bp12084
 *
 */
public class StructField {
	private String name;		//�t�B�[���h�ϐ���
	private Class<?> fieldType;	//�t�B�[���h�ϐ��̌^
	private String modifier;	//�t�B�[���h�ϐ��̏C���q
	
	public StructField(){
	}
	
	public StructField(String name,Class type,int mod){
		this.name = name;
		this.fieldType = type;
		this.modifier = getModifierType(mod);
	}
	
	/**
	 * �t�B�[���h�ϐ��̏C���q�̎�ނ𕶎���ŕԂ�
	 * @param mod �C���q�̎�ނ�\��int�^�̐��l
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

}
