package bank;

//���¸� �����غ���!!
//�ڹٴ�, Ŭ������ ���� ����� �����ϹǷ� ���Ȼ� ������ �ʾҴ� ������ �߻�
//�Ҽ� �ֱ� ������ �̸� �����ϱ� ���� ���������ڴ� ����ó���� �����Ѵ�..
//�ڹ��� ���� ó���� ������ ���� �� 4�ܰ�� �����ȴ�. (��������)
/*
(����)		��Ӱ��� or ������Ű��		������Ű����			���� ����� ���ٰ���
public			< protected			< default			< private

default�� ������ ���� ��Ű���� �־�� ��������, �����ڰ� �ƹ��͵� ��� ���� ������ default �츮�� ���� �ִ°� �� default�� 
private : �״��� �����Ѱ� ������ ���� �� �� ����
*/
public class Account{ // �ϳ��� �ν��Ͻ� �ȿ� ����ִ� �͵��� ������ �Ҹ�
	private String bankName="�������";
	private String master="��Ʈ��"; //�ƹ��͵� ��õǾ� ���� �ʾƼ� default�� �����ִ� �Ű� 
	private int balance=5000; // ��� �޼��常 �� ������ ���� �� �� �ִ�..
	private String num="084-45678-01"; //�������, ������ : 0�� �����ޱ� ���ؼ��� int �� �ƴ� String���� ������
/*public void test(){
		balance =6000; // �ϳ��� ��ü �� ��� �޼��尡 �� ���� ��Ʈ�� �޼��� ���� ���� ������ �ܺδ� ���� �Ұ���

	}
*/

	// �����Ϳ� ���� ���� ������ ��������, ������ ����ڵ� ������� ���ϰ� �Ǿ����Ƿ�,
	// ������ ����ڰ� ������ �� �ִ� � ��ġ�� ����������!!
	public void setBalance(int balance){  // �޼��� (�����, ���� �����ϱ� ���� ���ۿ�)
		//��ȯ���� ���� ������ �տ� void �׸��� �����ؾ��ϱ� ������ public
		//���� �����Ҷ��� setter���� ����
		this.balance=balance; // ����:���� �ִ� ����޼��� �׷��� this�� ����Ŵ
	}
	//���� ��ȯ�޾� �� �� �ִ� �޼��� ���� (return�� �ִ� �޼���)
	public int getBalance(){ // ���� ������ ���ϹǷ� �޼��带 ���ؼ� ����, (�������� ���� �뵵)
		//���� �����ö��� getter�� ��
		return balance;
	}


	//�����ʹ� ��ȣ�ϰ�, �� �����͸� ����� �� �ִ� �޼��带 ��������� ������ �����ϹǷ�
	//�̷��� ����ȭ, ����ȭ�� �޼��� ���� ����� ������  setter,getter�� �Ѵ�..
	//setter, getter�� �޼��� ���� ��Ģ�� �ִ�..get����, set����
	//������ ù ö�ڴ� �빮�ڷ� �Ѵ�..

	//master
	public void setMaster(String master){
		this.master = master;
	}
	public String getMaster(){
		return master;
	}
	//bankname
	public void setBankName(String bankName){
		this.bankName = bankName;
	}
	public String getBankName(){
		return bankName;
	}
	//num
	public void setNum(String num){
		this.num = num;
	}
	public String getNum(){
		return num;
	}
}