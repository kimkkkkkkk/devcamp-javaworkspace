package music;
//�ҿ����� �߻�޼��尡 �� �ϳ��󵵼��������� , �� Ŭ������ �������� ���� Ŭ������ �����Ѵ�.
//�̷��� �ҿ����� Ŭ������ ������ �߻� Ŭ������ �Ѵ�..
public abstract class MusicPlayer{
	
	//���� �� Ŭ������ ��ӹ޴� ��ü���� ���� ��� ������� ��������, �� ��������
	//�� ���� ���ŴϿ�, ���س��Ƽ��� �ȵȴ�.
	//���� �θ� Ŭ������ �������� ����� �� ������ ��������, �ڽĵ��� ������ �޼���
	//�� �θ� �����ϸ� �ȵǰ�, �ڽĿ��� ������ �����ؾ� �Ѵ�..
	//�׷��� ���ؼ��� �Ʒ��� �޼��带 ��ü�� ���� �ҿ����� �޼���� �����ؾ� �Ѵ�
	//�ڹٿ����� �̷��� �ҿ����� �޼��带 ������ ��ü�� ���ٰ� �߻� �޼���� �Ѵ�.
	/**
	������ �����ϴ� �޼��� ����
	*/
	public abstract void setVolume();//�߻� �޼��� ����!!
	
	/**
	mp3������ �����ϴ� �޼��� ����
	*/
	public abstract void openMP3();//�߻� �޼��� ����!!
}
//�ڹٴ� �޼���� �տ� ��ȯ�� �ڸ��� �ݵ�� �;��� void ~~~~���ñ� �� ����
// �� �տ��� ������ �ٲ㵵 �ǰ� ��� ���� 