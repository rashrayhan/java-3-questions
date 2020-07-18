
public class ShapeFactory {
	public void drawShape(String type) {
		if(type.equals("Square")) {
			new Square().drawShape();
		}else if(type.equals("Circle")) {
			new Circle().drawShape();
		}else if(type.equals("Triangle")) {
			new Triangle().drawShape();
		}else {
			System.out.println("Drawing " + type + " is not supported");
		}
		
	}
}
