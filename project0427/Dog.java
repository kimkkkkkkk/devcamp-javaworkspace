/*������ �������� �����غ���, Ŭ���� �ȿ��� ����/�Լ� ����*/

class Dog{
	/*�������� ���� �� �ִ� �Ӽ����� ������ ����
	�ϳ��� Ŭ������ ������ �������� ������ ��ü�� �ݿ��� ����, �Ӽ��� ǥ���ߴٰ� �Ͽ�
	property��(�Ӽ�) �Ѵ�..
	*/
	int age=5;
	String color="white"; // js�� ���� ���ڿ��� ��ü�� ó���Ѵ�!~
	String name="Happy";


	//�Լ� �� �޼��� ����.. js�� �ణ Ʋ��(��ü���� Ʋ�� ����)
	//public ����������, void�� �� �޼��尡 ��ȯ���� ����, �� ��ȯ���� ����
	//�Լ��� �ǹ�..
	public String getName(){ //String�� ��ȯ�ϴ� �޼���
		return name;
	}
	public int getAge(){ //int�� ��ȯ�ϴ� �޼���
		return age;
	}

	public void run(){ //���ϰ��� ���� void -> �ƹ��͵� ����
		System.out.println(name+"�� �پ��");
	}
}