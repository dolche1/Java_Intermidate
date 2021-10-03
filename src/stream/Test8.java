package stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test8 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList();

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

//        Map<Integer, List<Student>> map = students.stream().map(s -> {
//            s.setName(s.getName().toUpperCase(Locale.ROOT));
//            return s;
//        }).collect(Collectors.groupingBy(s -> s.getCourse()));
//
//        for (Map.Entry<Integer, List<Student>> m : map.entrySet()) {
//            System.out.println(m.getKey() + " " + m.getValue());
//        }
//
//        Map<Boolean, List<Student>> map1 = students.stream().map(s -> {
//            s.setName(s.getName().toUpperCase(Locale.ROOT));
//            return s;
//        }).collect(Collectors.partitioningBy(s -> s.avgGrade > 7));
//        for (Map.Entry<Boolean, List<Student>> m : map1.entrySet()) {
//            System.out.println(m.getKey() + " " + m.getValue());
////
//        }

        Student s8 = students.stream().map(s -> {
            s.setName(s.getName().toUpperCase(Locale.ROOT));
            return s;
        }).filter(element -> element.getSex() == 'f').sorted((s1, s2) -> s1.getAge() - s2.getAge()).findFirst().get();

        System.out.println(s8);
    }
}

