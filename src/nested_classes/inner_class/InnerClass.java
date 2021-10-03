package nested_classes.inner_class;

import nested_classes.static_nestes_class.Car;

import java.util.ArrayList;

public class InnerClass {
    String color;
    int doorCount;
    Engine engine;
    static int a;

    public InnerClass(String color, int doorCount) {
        this.color = color;
        this.doorCount = doorCount;
//        this.engine = this.new Engine(horsepower);
    }

    public void setEngine(Engine engine) {
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

    public class Engine {
        int horsePower;
        int countOfObjects = 0;

        public Engine(int horsePower) {
            this.horsePower = horsePower;
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

        InnerClass innerClass = new InnerClass("Black", 4);
        InnerClass.Engine engine = innerClass.new Engine(150);

        innerClass.setEngine(engine);

        InnerClass.Engine engine1 = innerClass.new Engine(23);


    }
}