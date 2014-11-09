
/**
 * �R���X�g���N�^�̏���ێ�����N���X�ł��B
 * �R���X�g���N�^�̈����̌^���t�B�[���h�Ɏ����܂��B
 * @author bp12084
 *
 */
public class StructConstructor {
	private Class<?>[] paramTypes;	//�R���X�g���N�^�̈����̌^
	private Score score;			//���_���
	private static int MAX_SCORE = 1;	//�t�B�[���h�X�R�A�̍ō����_
	
	/**
	 * �u�R���X�g���N�^�̈����̌^�v�������Ɏ��R���X�g���N�^
	 * @param paramTypes �R���X�g���N�^�̈����̌^
	 */
	public StructConstructor(Class<?>[] paramTypes){
		this.paramTypes = paramTypes;
		score = new Score();
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
	
	/**
	 * �X�R�A���t����CSV��������擾����
	 * @return CSV�`���̕�����
	 */
	public String getScoreCSV(){
		return getCSV()+","+score.getCSV();
	}
	
	/**
	 * �R���X�g���N�^���������Ɏ���ăX�R�A���Z�o����
	 * @param sc �e�X�g����R���X�g���N�^�\���I�u�W�F�N�g
	 */
	public void calcScore(StructConstructor sc){
		int currentScore = 0;
		if(this.equals(sc)) currentScore++;
		
		 score = new Score(currentScore,MAX_SCORE);
	}
	
	@Override
	public boolean equals(Object o){
		StructConstructor sc = (StructConstructor)o;
		try{
			for(int i=0;i<this.paramTypes.length;i++){
				if(this.paramTypes[i].equals(sc.paramTypes[i])==false) return false;
			}
		}catch(ArrayIndexOutOfBoundsException e){
			return false;
		}
		
		return true;
	}
	
	@Override
	public String toString(){
		String buf = "";
		for(Class<?> c : paramTypes) buf += c.getName() + ",";
		
		return "Constructor => "+buf+score;
	}
}
