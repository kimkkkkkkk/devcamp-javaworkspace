package traffic;

class Bus{

}
//생성자로 버스를 초기화 해보자
public Bus(){
	color="blue";
	seat="가죽시트";
	camera=true;
}
//생성자는 new 할때 호출할 수 있음 재호출하면
//재 new 하면 이미 기존에 다른 버스가 아닌 다른 버스가 생김
//굳이 재호출 하려면 init , 일반 메서드를 만들어야함
//일반 메서드로 버스를 초기화 해보자
public void init(){
	color="red";
	seat="인조가죽시트";
	camera=false;
}

public static void main(String[] args){
	Bus b = new Bus();
	b.init();
}