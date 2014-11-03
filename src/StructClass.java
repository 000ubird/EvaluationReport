import java.lang.reflect.Modifier;

/**
 * �N���X�\����ێ�����N���X�ł��B
 * �N���X���A�C���q�A�p���̗L���A�C���^�[�t�F�[�X���t�B�[���h�Ɏ����܂��B
 * @author bp12084
 *
 */
public class StructClass {
	private String name;			//�N���X��
	private String modifiers;		//�C���q
	private Class<?> inheritance;	//�p��
	private Class<?>[] interfaces;	//�C���^�[�t�F�[�X
	
	public StructClass(){
	}
	
	/**
	 * �N���X�������Ɏ���ăR���X�g���N�^�𐶐�
	 * @param c	�N���X
	 */
	public StructClass(Class<?> c) {
		name = c.getName();
		modifiers = getModifierType(c.getModifiers());
		inheritance = c.getSuperclass();
		interfaces = c.getInterfaces();
	}
	
	/**
	 * �N���X�̏C���q�̎�ނ𕶎���ŕԂ�
	 * @param mods �C���q�̎�ނ�\��int�^�̐��l
	 * @return �C���q��\��������
	 */
	public static String getModifierType(int mods){
		String buf = "none";
		
		if(Modifier.isPublic(mods)) buf = "public";
		if(Modifier.isAbstract(mods)) buf = "abstruct";
		if(Modifier.isFinal(mods)) buf = "final";
		
		return buf;
	}
	
	@Override
	public String toString(){
		String buf = "";
		for(Class<?> inter : interfaces) buf += inter+" , ";
		return "Name => "+name+" , Modifier => "+modifiers+
				" , SuperClass => "+inheritance+" , Interfaces => "+ buf;
	}
}
