/**
 * �����\���I�u�W�F�N�g�ƃe�X�g����\���I�u�W�F�N�g������
 * �]���N���X�ł�
 * @author bp12084
 *
 */
public class Evaluate {
	private Structure answer;	//�����\���I�u�W�F�N�g
	private Structure test;		//�e�X�g�\���I�u�W�F�N�g
	private static String ANS_FILE_NAME = "AnsClassInfo";
	private static String TEST_FILE_NAME = "TestClassInfo";
	
	/**
	 * �N���X�������Ɏ�肻�ꂼ��̍\���I�u�W�F�N�g�𐶐�����
	 * �f�t�H���g�R���X�g���N�^
	 * @param answer �͔͉𓚃N���X
	 * @param test   �e�X�g�N���X
	 */
	public Evaluate(Class<?> answer,Class<?> test){
		this.answer = new Structure(answer);
		this.test = new Structure(test);
	}
	
	/**
	 * 2�̍\���I�u�W�F�N�g����X�R�A���v�Z����
	 */
	public void calcScore(){
		answer.calcClassScore(test);
		answer.calcFieldScore(test);
		answer.calcConstructorScore(test);
		answer.calcMethodScore(test);
	}
	
	/**
	 * CSV�t�@�C�������ꂼ��o�͂���
	 */
	public void outCSV(){
	    CSVFileWrite.out(answer.getScoreCSV(),ANS_FILE_NAME);
	    CSVFileWrite.out(test.getCSV(),TEST_FILE_NAME);
	}
}
