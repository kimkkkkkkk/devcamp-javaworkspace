package bank;

class Friend{
	
	public static void main(String[] args){
			Account acc = new Account(); // �տ� �ƹ��͵� ������� ������ ���� ���丮���� ���簡 ��
			System.out.println("ģ���� ���� �� �ܰ�� "+acc.getBalance()); // private�̾ ���� ����, 
			//account���� �޼��带 ���� �����ϰ� acc.balance -> acc.getbalnce()�� ����
			//acc.balance = acc.balance+8000; // ���������� friend�� �����ؾ��ϱ� ������
			//������ ���� ���������� ��������, �޼��� ȣ��� �����͸� �����غ���.
			acc.setBalance(1500000); //���� ���� �� ���̱� �ƴϱ⶧���� �����ϸ� ���׵� �ݾ��� �� �� ����.

			System.out.println("ģ���� ���� �� �ܰ�� "+acc.getBalance());
			//���� �Ҷ� ���� ���丮�� ��� ������ (bank�� ����) 
			


			//���� Friend Ŭ������ Account�� ���� ��Ű���� �����Ƿ�, Account�� ������
			//defaul ���������� �ɷ� �ִ� ��� ������ ����� ������ �����ϴ�!!
			System.out.println("����� : "+acc.bankName);
			System.out.println("������ : "+acc.master);
			System.out.println("���¹�ȣ : "+acc.num);

	}
}