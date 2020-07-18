import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//@FunctionalInterface
interface Parent{
	void parentName(String name);
}

class Child{
	public static void printChildName(String name) {
		//System.out.println("child name: " + name);
	}
}

public class FP {
	
	public static void main(String[] args) {
		
		//Method referencing
		//This prints child name: Abdul
		Parent p = Child::printChildName;
		p.parentName("Abdul");
		
		
		
		//stream
		List<String> names = new ArrayList<>();
		
	      names.add("Abdul");
	      names.add("Raf");
	      names.add("Adamu");
	      names.add("Jaan");
	      names.add("Sewa");

	      
	      names.stream().filter(st -> (st.length() > 4)).limit(3)
	      .sorted().forEach(System.out::println);
		
	}
	
	
	//functional interface
	static void printName() {
		
		//lambda expression for Parent interface
		Parent parent = (name) ->{
			System.out.println("hello parent " + name);
		};
		//end of lambda
		
		
		parent.parentName("abdul");
	}

}
