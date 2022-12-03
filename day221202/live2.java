public class live2 {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape square = new Square();

        circle.Draw();
        square.Draw();
    }

}
class Shape{
    public void Draw() {
        System.out.println("그리기");
    }
}

class Square extends Shape{
    @Override
    public void Draw() {
        System.out.println("사각형 그리기");
    }
}

class Circle extends Shape{

    @Override
    public void Draw() {
        System.out.println("원 그리기");
    }
}
