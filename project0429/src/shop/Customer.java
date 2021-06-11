package shop;

//아래의 클래스에 대해 변수는 private, 이 변수들에 대한 getter,setter
//=은닉화, encapsulation 데이터는 보호하고 그 데이터를 간접적으로 접근하려고
public class Customer{
	private String name;
    private int age;
    private boolean isMarry; //isMarry는 복합어
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