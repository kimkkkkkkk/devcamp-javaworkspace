package animal.birds;

/*������ �ֻ��� ��ü�� �����Ѵ�.. �� �� �μ� ���� �� �ִ� ������ Ư¡��
�����غ���..*/

public class Bird{
	String name = "�׳� ��";
	boolean hasWing=true;
	String color;

	public Bird(String color){ // ������ ���� ��������!!!
		this.color=color; //�μ��� ����!!!
	}
	public void Fly(){
		System.out.println(name+"�� ���ƴٴմϴ�");
	}
}

