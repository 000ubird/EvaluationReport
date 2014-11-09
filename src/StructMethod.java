
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
	private Score score;			//���_���
	private static int MAX_SCORE = 3;	//�X�R�A�̍ō����_
	
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
		score = new Score();
	}
	
	public String getname() {
		return name;
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
	
	/**
	 * �X�R�A���t����CSV��������擾����
	 * @return CSV�`���̕�����
	 */
	public String getScoreCSV(){
		return getCSV()+","+score.getCSV();
	}
	
	/**
	 * �w�肵�����\�b�h���ƈ�v���郁�\�b�h�ł��邩�𔻒肷��
	 * @param name ���ׂ������\�b�h��
	 * @return     ��v������true,��v���Ȃ�������false
	 */
	public boolean hasMethod(String name){
		if(this.name.equals(name)) return true;
		else return false;
	}
	
	/**
	 * ���\�b�h�\�����������Ɏ���ăX�R�A���Z�o����
	 * �Z�o�����X�R�A�̓t�B�[���h�̃X�R�A���ɕێ������
	 * @param sm ���\�b�h�\���I�u�W�F�N�g
	 */
	public void calcScore(StructMethod sm){
		int currentScore = 0;
		if(this.name.equals(sm.name)) 				currentScore++;
		if(this.returnType.equals(sm.returnType)) 	currentScore++;
		if(this.paramType.equals(sm.paramType)) 	currentScore++;
		
		score = new Score(currentScore,MAX_SCORE);
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
		
		return "Method Name => "+name+" , return => "+returnType+" , paramType => "+buf+score;
	}
}
