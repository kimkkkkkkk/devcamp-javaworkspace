package traffic;

class Bus{

}
//�����ڷ� ������ �ʱ�ȭ �غ���
public Bus(){
	color="blue";
	seat="���׽�Ʈ";
	camera=true;
}
//�����ڴ� new �Ҷ� ȣ���� �� ���� ��ȣ���ϸ�
//�� new �ϸ� �̹� ������ �ٸ� ������ �ƴ� �ٸ� ������ ����
//���� ��ȣ�� �Ϸ��� init , �Ϲ� �޼��带 ��������
//�Ϲ� �޼���� ������ �ʱ�ȭ �غ���
public void init(){
	color="red";
	seat="�������׽�Ʈ";
	camera=false;
}

public static void main(String[] args){
	Bus b = new Bus();
	b.init();
}