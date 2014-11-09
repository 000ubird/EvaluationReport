import java.lang.reflect.Modifier;

/**
 * �N���X����ێ�����N���X�ł��B
 * �N���X���A�C���q�A�p���̗L���A�C���^�[�t�F�[�X���t�B�[���h�Ɏ����܂��B
 * @author bp12084
 *
 */
public class StructClass {
	private String name;			//�N���X��
	private String modifiers;		//�C���q
	private Class<?> inheritance;	//�p��
	private Class<?>[] interfaces;	//�C���^�[�t�F�[�X
	private Score score;			//���_���
	private static int MAX_SCORE = 4;	//�X�R�A�̍ō����_
	
	/**
	 * �N���X�������Ɏ���ăR���X�g���N�^�𐶐�
	 * @param c	�N���X
	 */
	public StructClass(Class<?> c) {
		name = c.getSimpleName();
		modifiers = getModifierType(c.getModifiers());
		inheritance = c.getSuperclass();
		interfaces = c.getInterfaces();
		score = new Score();
	}
	
	/**
	 * �N���X�̏���CSV�`���̕�����ɂ���
	 * �t�H�[�}�b�g(�T���v��)-> class | �C���q | �N���X�� | �p�� | �C���^�[�t�F�[�X |
	 * @return CSV�`���̕�����
	 */
	public String getCSV(){
		String buf = "";
		for(Class<?> inter : interfaces) buf += inter+",";
		return "Class,"+modifiers+","+name+",Extends "+inheritance+","+buf;
	}
	
	/**
	 * �X�R�A���t����CSV��������擾����
	 * @return CSV�`���̕�����
	 */
	public String getScoreCSV(){
		return getCSV()+","+score.getCSV();
	}
	
	/**
	 * �N���X�̏C���q�̎�ނ𕶎���ŕԂ�
	 * @param mods �C���q�̎�ނ�\��int�^�̐��l
	 * @return �C���q��\��������
	 */
	private static String getModifierType(int mods){
		String buf = "none";
		
		if(Modifier.isPublic(mods)) buf = "public";
		if(Modifier.isAbstract(mods)) buf = "abstruct";
		if(Modifier.isFinal(mods)) buf = "final";
		
		return buf;
	}
	
	/**
	 * �N���X�\�����������Ɏ���ăX�R�A���Z�o����
	 * �Z�o�����X�R�A�̓t�B�[���h�̃X�R�A���ɕێ������
	 * @param sc �N���X�\���I�u�W�F�N�g
	 */
	public void calcScore(StructClass sc){
		int currentScore = 0;
		
		if(this.name.equals(sc.name)) currentScore++;
		if(this.modifiers.equals(sc.modifiers)) currentScore++;
		if(this.inheritance.equals(sc.inheritance)) currentScore++;
		if(this.interfaces.equals(sc.interfaces)) currentScore++;
		
		score = new Score(currentScore,MAX_SCORE);
	}
	
	@Override
	public boolean equals(Object o){
		StructClass sc = (StructClass)o;
		
		if(this.name.equals(sc.name) == false) return false;
		if(this.modifiers.equals(sc.modifiers) == false)return false;
		if(this.inheritance.equals(sc.inheritance) == false) return false;
		try{
			for(int i=0;i<this.interfaces.length;i++){
				if(this.interfaces[i].equals(sc.interfaces[i])==false)return false;
			}
		}catch(ArrayIndexOutOfBoundsException e){
			return false;
		}
		
		return true;
	}
	
	@Override
	public String toString(){
		String buf = "";
		for(Class<?> inter : interfaces) buf += inter+" , ";
		return "Class Name => "+name+" , Modifier => "+modifiers+
				" , SuperClass => "+inheritance+" , Interfaces => "+ buf;
	}
}
