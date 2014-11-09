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
	private Score score;		//���_���
	private static int MAX_SCORE = 3;	//�t�B�[���h�X�R�A�̍ō����_
	
	public String getName(){
		return name;
	}

	/**
	 * �����L��̃R���X�g���N�^
	 * @param name	�t�B�[���h�ϐ���
	 * @param type	�t�B�[���h�ϐ��̌^
	 * @param mod	�t�B�[���h�ϐ��̏C���q�̒l
	 */
	public StructField(String name,Class<?> type,int mod){
		this.name = name;
		this.fieldType = type.getSimpleName();
		this.modifier = getModifierType(mod);
		score = new Score();
	}
	
	/**
	 * �t�B�[���h�ϐ��̏C���q�̎�ނ𕶎���ŕԂ�
	 * @param mod �C���q�̎�ނ�\�����l
	 * @return �C���q��\��������
	 */
	public static String getModifierType(int mod){
		String buf = "none";	//�A�N�Z�X�C���q��񖳂�
		
		if(Modifier.isPublic(mod))		buf = "public";
		if(Modifier.isPrivate(mod))		buf = "private";
		if(Modifier.isProtected(mod))	buf = "protected";
		if(Modifier.isFinal(mod))		buf = "final";
		if(Modifier.isStatic(mod))		buf = "static";
		
		return buf;
	}
	
	/**
	 * �w�肵���t�B�[���h���ƈ�v����t�B�[���h�ł��邩�𔻒肷��
	 * @param name ���ׂ����t�B�[���h��
	 * @return     ��v������true,��v���Ȃ�������false
	 */
	public boolean hasField(String name){
		if(this.name.equals(name)) return true;
		else return false;
	}
	
	/**
	 * �t�B�[���h�\�����������Ɏ���ăX�R�A���Z�o����
	 * �Z�o�����X�R�A�̓t�B�[���h�̃X�R�A���ɕێ������
	 * @param sf �t�B�[���h���
	 */
	public void calcScore(StructField sf){
		int currentScore = 0;
		if(this.name.equals(sf.name)) 			 currentScore++;
		if(this.fieldType.equals(sf.fieldType))  currentScore++;
		if(this.modifier.equals(sf.modifier))	 currentScore++;
		
		this.score = new Score(currentScore,MAX_SCORE);
	}
	
	/**
	 * �t�B�[���h�̏���CSV�`���̕�����ɂ���
	 * �t�H�[�}�b�g(�T���v��)-> Field | �C���q | �^ | �t�B�[���h��
	 * @return CSV�`���̕�����
	 */
	public String getCSV(){
		return "Field,"+modifier+","+fieldType+","+name;
	}
	
	/**
	 * �X�R�A���t����CSV��������擾����
	 * @return CSV�`���̕�����
	 */
	public String getScoreCSV(){
		return getCSV()+","+score.getCSV();
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
		return "Field  "+modifier+ " => " +name+ " : " +fieldType+" -> "+score;
	}

}
