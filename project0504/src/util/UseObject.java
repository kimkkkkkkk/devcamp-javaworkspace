package util;

class UseObject{
	public static void main(String[] args){
		ObjectTest ot = new ObjectTest();
		String str = "monkey";
		
		//ot.test(); // �������� �ʴ� �޼��� ȣ��
		boolean result = ot.equals(str);
		System.out.println(result);

		//���� �ڵ忡�� equals() �޼���� ObjectTest
		//Ŭ�������� ���� ������ ���� ����!! �׷����� �ұ��ϰ�
		//�ϰ� ������ �߻����� �ʴ� ������
		//�̹� �����ϰ� �ִٴ� ����..
		//���� : �����ڰ� �������� �ʴ��� �ڹپ���� �ֻ��� ����� Ŭ������ Object Ŭ�����κ���
		//��� ���� �����̱⿡..
	}
}