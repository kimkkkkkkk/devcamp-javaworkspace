package bank;

class Enemy{
	public static void main(String[] args){
		//������ �ǵ��� ������ �ܰ� ����...
		Account acc = new Account();
		
		acc.balance=-100000; // ���� ���� ���� account�� 
		System.out.println(acc.master+"�� �ܰ��"+acc.balance);
	}

}