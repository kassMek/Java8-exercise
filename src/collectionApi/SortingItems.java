package collectionApi;

import java.time.LocalDate;

import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class SortingItems {

    public static void main (String []args){

        List<Integer> list= Arrays.asList(23,12,45,67,89,112,54,671);
        LocalDate local= LocalDate.now();

        LocalDate myBirthDay=LocalDate.of(1986, Month.JUNE,19);
        System.out.println(local);
        System.out.println("Birth Date ..->"+myBirthDay);


    }
}
