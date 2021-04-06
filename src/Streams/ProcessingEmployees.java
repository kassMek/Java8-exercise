package Streams;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProcessingEmployees {
	public static void main(String [] args) {
		
	      Employee[] employees = {
	    	         new Employee("Jason", "Red", 5000, "IT"),
	    	         new Employee("Ashley", "Green", 7600, "IT"),
	    	         new Employee("Matthew", "Indigo", 3587.5, "Sales"),
	    	         new Employee("James", "Indigo", 4700.77, "Marketing"),
	    	         new Employee("Luke", "Indigo", 6200, "IT"),
	    	         new Employee("Jason", "Blue", 3200, "Sales"),
	    	         new Employee("Wendy", "Brown", 4236.4, "Marketing")};

	    	      // get List view of the Employees
	    	      List<Employee> list = Arrays.asList(employees);
	    	      System.out.println("printting the employee whose salary is between 4000 & 6000");
	    	      Predicate<Employee> FourToSixThousand=(emp)->emp.getSalary()>4000 && emp.getSalary()<6000;
	    	      list.stream()
	    	           .filter(FourToSixThousand)
	    	           .forEach(System.out::println);
	    	      System.out.printf( "%nEmployees earning $4000-$6000 per month sorted by salary:%n");
	    	        list.stream()
	    	            .filter(FourToSixThousand)
	    	            .sorted(Comparator.comparing(Employee::getSalary))
	    	            .forEach(System.out::println);
	    	        
	    	        // display unique employee last names sorted
	    	        list.stream()
	    	             .map(emp->emp.getLastName())
	    	             .sorted(Comparator.reverseOrder())
	    	             .distinct()
	    	             .forEach(System.out::println);
	    	           Function<Employee,String> byFirstName=(emp)->emp.getFirstName();
	    	           Function<Employee,String> byLastName=(emp)->emp.getLastName();
	    	           System.out.println("sorting employees by first and last name");
	    	           list.stream()
	    	                .sorted(Comparator.comparing(byFirstName).thenComparing(byLastName))
	    	                .forEach(System.out::println);
	    	           
	    	        // display only first and last names
	    	           System.out.printf("Displaying first and last name");
	    	           list.stream()
	    	               .map(emp->emp.getFirstName().toUpperCase()+"  "+emp.getLastName().toUpperCase())
	    	               .forEach(System.out::println);
	    	           
	    	         //2.Print out all of the Employee objects whose last name begins with the letter  ‘B’  in sorted order.
	    	           System.out.println(" employee objects sorted whose las name beigins with B");
	    	           list.stream()
	    	                 .filter(emp->emp.getLastName().startsWith("B"))
	    	                 .sorted(Comparator.comparing(byLastName))
	    	                 .forEach(System.out::println);
	    	           
	    	         //4.Print out All of the employee objects, but if the last name begins with the letter  ‘B’,  
	    	           // then capitalize all the letters in the last name.
	    	           System.out.println(" emeplyee objects with last name in uppercase ");
	    	           list.stream()
	    	                .forEach(x->{
	    	                	
	    	                	        if(x.getLastName().startsWith("B")) {
	    	                	        	 x.setLastName( x.getLastName().toUpperCase());
	    	                	         }
	    	                	          System.out.println(x.toString());
	    	                            }
	    	                		);
	    	                		
	    	                		
	    	                		
	    	           
//3.Print out all of the Employee objects whose last name begins with the letter  ‘B’ 
//and change their first name and last name to be All capital letters. 
	    	            System.out.println(" last name statrts with only B and Upper case");
	    	           list.stream()
	    	               .filter(x->x.getLastName().startsWith("B"))
	    	               .forEach(x-> {
	    	            	            x.getLastName().toUpperCase();
	    	            	             System.out.println( x.toString());
	    	                        }
	    	               
	    	            		   
	    	            		   );
	    	           
	    	           
	System.out.println(" printing all employee objects using Collector.joining:");
	 String allJoined=    list.stream()
			                   .map(Employee::toString)
			                  .collect(Collectors.joining("\n"));
	        
	    	           System.out.println(allJoined);
	    	           
 //5.Print out all of the Employee objects’ last names,
 //whose last name begins with the letter  ‘I’  in sorted order, and get rid of all the duplicates. 
//Print out only the last names.  
System.out.println(" employee with last name I :");    	

       list.stream()
            .filter(x->x.getLastName().startsWith("I"))
            .map(x->x.getLastName())
            //.sorted(Comparator.reverseOrder())
              .sorted()
            .distinct()
            .forEach(System.out::println);
       
//6. Print out the average of all the salaries.  
         Double totalSalary=list.stream()
        		                .mapToDouble(Employee::getSalary)
        		                .average()
        		                .getAsDouble();
         System.out.printf("the average salary is  %.2f :",totalSalary);
         
//7.Use the  ‘reduce’  method to print out the total salary of all employees.  
         
        System.out.println("the total salary is :");
          System.out.println( list.stream().mapToDouble(Employee::getSalary).reduce(0.0, Double::sum));
	    	           
      }

}
