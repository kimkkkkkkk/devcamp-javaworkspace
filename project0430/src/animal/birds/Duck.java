package animal.birds;
/*�Ʒ� �ڵ��� ��Ӱ��谡 ���� ������ �� �� �ִٴ� �ٰ�!!
1) �ڹٿ����� �⺻ �ڷ������� ������ ũ�� 3������ �з�
	����, ����, ������
	Ư�� ���� (byte, short, int, long, float, double)�� char(0���� ���) �� ������
	���� ���� ������ �ڷ������� ���� ����ȯ�� �����ϴ�!!
2) �ڹ��� �ڷ����� �� 4�����μ�, ��ü�ڷ����� �ڷ����̴�!!

3) ��� : 2���� ���� ��ü�ڷ����� �ڷ����̶��, �⺻ �ڷ����鰣�� ����Ǿ��� ��ü�� ����ȯ��
			��ü�ڷ������� ����Ǿ�� �Ѵ�!!
			��? ��ü �ڷ����� �ڷ����̴ϱ�!!!!!!!!!!!!!!!!!!!!!!!!!1
4) ����?
	����ڰ� ���� �ڷ����� Ŭ���������� ���� ������ �ڷ����� ���� �� �ִ°�?
	�ִ�!! �ٷ� ����� �̿��ϸ� �θ�, �ڽİ��� ���谡 �����ǰ�, �θ�, �ڽ� ���� ���踦 �츮��
	���� ������ �ڷ������� �� �� �ִ�...
*/




// Duck�� �������� 
public class Duck extends Bird{ 
	//						is a  ������ ��ӿ����� is a�� �������� ������ ���� ������ ����̴�. (���� �ڷ����̴�)
	// extends Bird (��Ӱ��� �����)
	//����� �ȵ����? �ȵ���� ���ο� �����ڰ� ����
	String name="�� ����";
	String color;

	public Duck(String color){ // ������ ����!!
		super(color); // �����Ǿ� �ִ��� ����������!!!!! ���¨��!!!!!!
	}

	//������ ������
	public void canSwim(){
		System.out.println("������ ���մϴ�");
	}
}