package collectionApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyStreams {

    public static void main(String[] args) {
        List<String> names = new ArrayList<String>();
        names.add("Ajeet");
        names.add("Negan");
        names.add("Aditya");
        names.add("Steve");
        int count = 0;
        for (String str : names) {
            if (str.length() < 6)
                count++;
        }
        System.out.println("There are "+count+" strings with length less than 6");

        //using streams

        long  myCount=names.stream()
                       .filter(x->x.length()<6)
                        .count();

        System.out.println("using sreams..the number of names..."+myCount);

        List<Integer> list= Arrays.asList(24,212,45,67,89,72,54,671);

        list.stream()
                .filter(x->x%6==0)
                .limit(3)
                .forEach(x-> System.out.println(x));

        //concatenating two streams

        //list 1
        List<String> alphabets = Arrays.asList("Ashly","Bob","Catherine");
        //list 2
        List<String> schoolBoy = Arrays.asList("Samantha","Jon","Aron","Jonathan","Kassahun","Seine");
        Stream<String> joinedStream = Stream.concat(alphabets.stream(), schoolBoy.stream());
        //joinedStream.forEach(x-> System.out.println(x));

          //collector method
          //map method
        List<String> longName=schoolBoy.stream()
                                .filter(x->x.length()>5)
                                 .map(data->data.toUpperCase())
                                 .sorted()
                                .collect(Collectors.toList());
        longName.forEach(x-> System.out.println(x));
        List<Integer> num = Arrays.asList(1,2,3,4,5,6);
          num.stream().filter(n->n%2==0)
                       .map(n->n*n)
                        .forEach(x-> System.out.println(x));

    }
    }


