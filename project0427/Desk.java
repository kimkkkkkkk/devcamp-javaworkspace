/*�� ������� ������..*/
public class Desk {
	int x;
	static int y;

	//����, �Լ� ���⼭ ���� �Լ��� ���� �� �� ����
	// ���� �ݺ��� �����Ͽ� �ڵ帣�����ϰ� �ʹٸ�? ���� ���� �� �ִ�..
/*
	public void test(){
		for(int i=1;i<=10;i++){
			x+=i;
		}
	}
	*/

	{ //A
		for(int i=0;i<10;i++){
			x++;
		}
	}
	
	//�ν��Ͻ� �ʱ�ȭ ��
	//�� Ŭ������ Desk�κ��� �ν��Ͻ��� ������ ������, �Ʒ��� �ڵ尡 ����
	//static ���̸�: static �ʱ�ȭ ��
	/*
	1) �ν��Ͻ� �ʱ�ȭ �� : �ش� �ν��Ͻ��� �����ɶ� �����ϴ� �ڵ� ����
								�������� ���Ұ� ���
	2) static �ʱ�ȭ �� : ���������� 
	*/

	static { //B ,  Ŭ������ �ε�ɶ� �����Ѵ�!!����� �����Ѵ�!!
			//main �޼��� ȣ��� ������!!
		for(int i=0;i<20;i++){
			y++;
		}
	}
	                              
	public static void main(String[] args){
		//System.out.println(x); //C �޸� �ö������ ����, static �������� ���۷�������
		// ���� x �� ������ ���� ����..
		int a=new Desk().x; //D  10
		System.out.println(a); //E 10
		System.out.println(y); //F 20
		
	}
}