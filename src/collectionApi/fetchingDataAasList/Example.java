package collectionApi.fetchingDataAasList;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Example {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<Student>();

        //Adding Students
        studentList.add(new Student(11,"John",22));
        studentList.add(new Student(22,"Steve",18));
        studentList.add(new Student(33,"Lucy",22));
        studentList.add(new Student(44,"Samantha",23));
        studentList.add(new Student(55,"Maggie",18));
        studentList.add(new Student(19,"John",22));
        studentList.add(new Student(24,"Lucy",22));


        //Fetching student names as List
        List<String> names = studentList.stream()
                .filter(data->data.name.length()<=4)
                .map(n->n.name)
                .collect(Collectors.toList());
                 //System.out.println(names);

                 //calculating the average age of students

        Double age=studentList.stream()
                        .collect(Collectors.averagingInt(data->data.age));
        System.out.println(" the average student age is..."+age);


        //summary statistics

        IntSummaryStatistics stats = Arrays.asList(1,2,3,4,6,8)
                .stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics();

                   stats.getSum();
                   stats.getCount();
                   stats.getAverage();
        System.out.println(" the sum is... " +stats.getSum());
        System.out.println(" the count is .."+stats.getCount());
        System.out.println(" the average is..."+stats.getAverage());
        System.out.println(" the min value is ..."+stats.getMin());
        System.out.println(" the max value is ..."+stats.getMax());
        System.out.println(stats );

        List<Integer> ll = Arrays.asList(22,33,44);
            Integer sum= ll.stream()
                    .mapToInt(Integer::intValue)
                    .sum();
        System.out.println("The integer stream sum is " + sum);

        //sorting

        Stream.of("Ava","Anne"," Alberto")
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);

        // 5. Stream from Array, sort, filter and print
        String[] friends = {"Ale", "Ankit", "Kushal", "Brent", "Sarika", "Amanda", "Hans", "Shivika", "Sarah"};

        Arrays.stream(friends)
                .sorted()
                .forEach(System.out::println);

        // 6. average of squares of an int array
        Arrays.stream(new int[] {2, 4, 6, 8, 10})
                .map(x -> x * x)
                .average()
                .ifPresent(System.out::println);

        // 7. Stream from List, filter and print
        List<String> people = Arrays.asList("Al", "Ankit", "Brent", "Sarika", "Amanda", "Hans", "Shivika", "Sarah");
        people
                .stream()
                .map(String::toUpperCase)
                .filter(x -> x.startsWith("A"))
                .forEach(System.out::println);



        //printing student details

//        studentList.forEach(student->{
//                            System.out.println(" student id :"+student.getId() +" student name..."+ student.getName()+" student age..."+ student.getAge());
//                            System.out.println();
//                        }
//
//        );

        //sorting objects by using their properties, example student by using student name
        //descending order
        List<Student> sortedStudents=studentList.stream()
                                                 .sorted(Comparator.comparing(Student::getName).reversed())
                                                  .collect(Collectors.toList());
        sortedStudents.forEach(stud-> System.out.println(stud));

      //calculating the average age od students

        Double averageAge=studentList.stream()
                                      .mapToDouble(Student::getAge)
                                       .average().getAsDouble();
        System.out.println(" the average age of the student is :"+averageAge);

        //Count the number of student from the list with similar name and age less than 25
        Map<String, Long> counting = studentList.stream()
                  .collect(Collectors.groupingBy(Student::getName, Collectors.counting()));
        System.out.println(" the number count for each student is:"+counting);

    }

}