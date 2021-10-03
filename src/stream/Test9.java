package stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test9 {
    public static void main(String[] args) {

        Student st1 = new Student("Ivan", 'm', 22, 3, 8.3);
        Student st2 = new Student("Nikolay", 'm', 28, 2, 6.4);
        Student st3 = new Student("Elena", 'f', 19, 1, 8.9);
        Student st4 = new Student("Petr", 'm', 35, 4, 7);
        Student st5 = new Student("Mariya", 'f', 23, 3, 7.5);

        List<Student> students = new ArrayList<>();

        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);

//        Student studentMin = students.stream().min(Comparator.comparingInt(Student::getAge)).get();
//        Student studentMax = students.stream().max(Comparator.comparingInt(Student::getAge)).get();
//        System.out.println(studentMin);
//        System.out.println(studentMax);

//        students.stream().filter(s -> s.getAge() > 20).forEach(System.out::println);
//        System.out.println("------------------------------------");
//        students.stream().filter(s -> s.getAge() > 20).limit(2).forEach(System.out::println);
//        System.out.println("------------------------------------");
//        students.stream().filter(s -> s.getAge() > 20).skip(2).forEach(System.out::println);

//        List<Integer> courseList = students.stream().mapToInt(s -> s.getCourse()).boxed().collect(Collectors.toList());
        int sum = students.stream().mapToInt(s -> s.getCourse()).sum();
        double average = students.stream().mapToInt(s -> s.getCourse()).average().getAsDouble();
        int max = students.stream().mapToInt(s -> s.getCourse()).max().getAsInt();

        System.out.println(sum);
        System.out.println(average);
        System.out.println(max);

    }
}
