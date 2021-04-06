package Streams;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamOfCharacters {

	public static void main(String[] args) {
		//Stream<Character> combined =Stream.concat(characterStream("Hello"),characterStream("World"));
		//converitng  a stream in to an array;
		String[] stringArr = { "a", "b", "c", "d" };
		System.out.println(" the original string array is:"+Arrays.toString(stringArr));
		Stream<String> myStream=Stream.of(stringArr);
		String[] arr = myStream.toArray(String[]::new);
		System.out.println(" the new string is :"+Arrays.toString(arr));
				
		/*Stream <Integer>powerOfTen = Stream.of(1, 10, 100, 1000, 10000); 
		 Integer [] array = powerOfTen.toArray(Integer[]::new);
		System.out.println(Arrays.toString(array));
*/
		 //flatmap
		
		/*List<String> list =Arrays.asList("joe","Tom","Abe");
		Stream<Stream<Character>> result = list.stream().
				map(s ->characterStream(s));
       */
		
		LocalDate loc= LocalDate.now();
     System.out.println(loc);
     LocalTime loct= LocalTime.now();
     System.out.println(loct);
     Instant it=Instant.now();
     System.out.println(it);
	}

}
