package nested_classes.static_nestes_class;
public class Car {
    String color;
    int doorCount;
    Engine engine;
    static int a;

    public Car(String color, int doorCount, Engine engine) {
        this.color = color;
        this.doorCount = doorCount;
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "My car{" +
                "color='" + color + '\'' +
                ", doorCount=" + doorCount +
                ", engine=" + engine +
                '}';
    }

    public final static class Engine {
        int horsePower;
        static int countOfObjects = 0;

        public Engine(int horsePower) {
            this.horsePower = horsePower;
            countOfObjects++;
        }

        @Override
        public String toString() {
            return "Engine{" +
                    "horsePower=" + horsePower +
                    '}';
        }
    }
}

class Test{
    public static void main(String[] args) {

        Car.Engine e = new Car.Engine(256);
        System.out.println(e);
        Car car = new Car("red", 2, e);
        System.out.println(car);
    }
}
