/**
 * ���_�I�u�W�F�N�g
 * @author bp12084
 *
 */
public class Score {
	private int point;		//�]���_
	private int maxPoint;	//�ō��_
	
	/**
	 * �f�t�H���g�R���X�g���N�^
	 */
	public Score (){
		point = 0;
		maxPoint = 0;
	}
	
	/**
	 * �]���_�E�ō��_�̂��ꂼ��������Ɏ��
	 * @param p		�]���_
	 * @param max	�ō��_
	 */
	public Score(int p, int max) {
		point = p;
		maxPoint = max;
	}
	
	@Override
	public String toString() {
		return "Score [point=" + point + ", maxPoint=" + maxPoint + "]";
	}
}
