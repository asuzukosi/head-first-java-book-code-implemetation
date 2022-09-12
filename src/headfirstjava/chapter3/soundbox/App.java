package headfirstjava.chapter3.soundbox;

public class App {

    public static void main(String[] args) {
        Shape square = selectShape("square");
        square.playSound();

        Shape amoeba = selectShape("amoeba");
        amoeba.playSound();

    }
    public static Shape selectShape(String name) {
        switch (name) {
            case "square":
                Shape square = new Square();
                return square;

            case "triangle":
                Shape triangle = new Triangle();
                return triangle;
        
            default:
                Shape amoeba = new Amoeba();
                return amoeba;
        }
    }
}
