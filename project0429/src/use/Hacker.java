//Account �ʹ� �ٸ� ��Ű������ ���� ������ �ǽ��غ���!!
package use;
import bank.Account;

class Hacker{
	public static void main(String[] args){
	//���� ���¸� �޸𸮿� �÷�����, ����� �峭�ĺ���
	//��ī��Ʈ�� ����  ��Ʈ�� ����.
	//��ī��Ʈ�� Ŭ���� �� ��ũ �ؿ��ִ�. �׷��� ���� import�� ���
	Account acc = new bank.Account();
	
	//�Ʒ��� �ڵ�� ��Ű�� ��ġ�� ������� balance ���� ��ü�� private�̱� ������
	//�� � ������ ������ �Ұ�..
	//System.out.println("���� "+acc.master+"�� ������ �ܰ��"+acc.balance);
	
	//�����, ������, ���¹�ȣ ���� ����? �������,, �Ұ��� �ٸ� ��Ű������
	System.out.println("����� : "+acc.bankName);
	System.out.println("������ : "+acc.master);
	System.out.println("���¹�ȣ : "+acc.num);

	}
}