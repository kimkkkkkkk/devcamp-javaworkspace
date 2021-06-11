package vehicle;

class UseCar {
	public static void main(String[] args){
	/*과제: 자동차의 인스턴스를 생성하고, 그 자동차가 보유한 엔진의 이름 및 바퀴의 가격을
		출력하시오!!*/
	Car car = new Car();
	// 엔진을 존재시켜라!!
	//car.e = new Engine(); 

	System.out.println(car.e.name);
	// 객체를 메모리에 올리지 않고 객체가 보유한 것을 쓰려고 할떄 null로
	}
}