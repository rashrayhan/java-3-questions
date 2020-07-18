
public class SerialMultiplier {

	int first, second, third, fourth, fifth, result;

	public SerialMultiplier(int first, int second, int third, int fourth, int fifth) {
		this.first = first;
		this.second = second;
		this.third = third;
		this.fourth = fourth;
		this.fifth = fifth;
		
		this.result = first * second * third * fourth * fifth;
		if(this.result < 1) {
			System.out.println(1);
		}
		
	}

	
	public SerialMultiplier() {	}
	@Override
	public String toString() {
		return ""+result;
	}
	
}
