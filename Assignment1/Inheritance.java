package Assignment1;
class Shape{
    Float pi = 3.14f;
    Float area;
    Float length,breadth;
    Shape(Float length,Float breadth){
        this.length = length;
        this.breadth = breadth;
    }

    Float getArea(){
        return this.area;
    }
}
class Circle extends Shape{
    Float radius;
    Circle(Float radius){
        super(radius,radius);
        this.radius = radius;
        area = pi * radius * radius;  
    }
}
class Rectangle extends Shape{
    Rectangle(Float length,Float breadth){
        super(length,breadth);
        area = length * breadth;
    }
}
public class Inheritance {
    public static void main(String[] args) {
        Circle c = new Circle(5.6f);
        Rectangle r = new Rectangle(5f,4f);

        System.out.println(c.getArea()+" is the area of the circle of radius 5.6");
        System.out.println(r.getArea()+" is the area of the rectangle of length 5 and breadth 4");
    }
}
