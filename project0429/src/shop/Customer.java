package shop;

//�Ʒ��� Ŭ������ ���� ������ private, �� �����鿡 ���� getter,setter
//=����ȭ, encapsulation �����ʹ� ��ȣ�ϰ� �� �����͸� ���������� �����Ϸ���
public class Customer{
	private String name;
    private int age;
    private boolean isMarry; //isMarry�� ���վ�
}

//name
public void setName(String name){
	this.name = name;
}
public String getName(){
	return name;
}
//age
public void setAge(int age){
	this.age = age;
}
public int getAge(){
	return age;
}
//is marry
public void setIsMarry(boolean isMarry){
	this.isMarry = isMarry;
}
public boolean getIsMarry(){
	return isMarry;
}