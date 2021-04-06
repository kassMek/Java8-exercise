package Myxercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import Streams.Employee;

public class MyProcessingEmployee {
	
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
	      
	        List<Employee> list=Arrays.asList(employees);
	        
	            //list.forEach(System.out::println);
	            System.out.println("printting the employee whose salary is between 4000 & 6000");
	            
/*//		/*
//		  Predicate<Employee> foutToSixthousand =emp->emp.getSalary()>4000 &&
//		 * emp.getSalary()<6000; list.stream() // .filter(emp->emp.getSalary()>4000 &&
//		 * emp.getSalary()<6000) .filter(foutToSixthousand)
//		 * .forEach(System.out::println);
//		 */
                    System.out.printf( "%nEmployees earning $4000-$6000 per month sorted by salary:%n");
	                    
	                         list.stream()
	                        .filter(emp->emp.getSalary()>4000 &&  emp.getSalary()<6000)
	                        //.sorted(Comparator.comparing(emp->emp.getSalary()))
	                         .sorted(Comparator.comparing(Employee::getSalary))
	                         .forEach(System.out::println);
	        
	                      // display unique employee last names sorted
	                         list.stream()
	                             .map(emp->emp.getLastName())
	                             .sorted()
	                             .distinct()
	                             .forEach(System.out::println);
	                         System.out.println("********");
	                         // display unique employee last names sorted
	     	    	        list.stream()
	     	    	             .map(emp->emp.getLastName())
	     	    	             .sorted(Comparator.reverseOrder())
	     	    	             .distinct()
	     	    	             .forEach(System.out::println);
	     	    System.out.println("sorting employees by first and last name");
	     	    	  list.stream()
	     	    	  .sorted(Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getLastName))
	     	    	  .forEach(System.out::println);
	     	    	  
	     	    	  
	     	    	// display only first and last names
	    	           System.out.printf("Displaying first and last name");
	    	           list.stream()
	    	                .map(emp->emp.getFirstName().toUpperCase() + " "+  emp.getLastName().toUpperCase())
	    	                .sorted()
	    	                .forEach(System.out::println);
	    	           
	    	           
	    	          //2.Print out all of the Employee objects whose last name begins with the letter  ‘B’  in sorted order.
	    	           System.out.println(" employee objects sorted whose las name beigins with B");
	    	             list.stream()
	    	                 .filter(emp->emp.getLastName().startsWith("B"))
	    	                 .sorted(Comparator.comparing(Employee::getLastName))
	    	                 .forEach(System.out::println);
	    	           //4.Print out All of the employee objects, but if the last name begins with the letter  ‘B’,  
		    	           // then capitalize all the letters in the last name.
	    	             
	    	             System.out.println(".................................");
		    	           System.out.println(" emeplyee objects with last name in uppercase ");
		    	           list.stream()
		    	                .forEach(x->{
		    	                	
		    	                	        if(x.getLastName().startsWith("B")) {
		    	                	        	 x.setLastName( x.getLastName().toUpperCase());
		    	                	         }
		    	                	          System.out.println(x);
		    	                            }
		    	                		);
	    	           
	                         
	    	              
		    	           //3.Print out all of the Employee objects whose last name begins with the letter  ‘B’ 
		    	         //and change their first name and last name to be All capital letters. 
		    	         System.out.println(" last name statrts with only B and Upper case");
		    	         
		    	         list.stream()
		    	              .filter(emp->emp.getLastName().startsWith("B"))
		    	              .forEach(x->{
		    	            	          x.setLastName( x.getLastName().toUpperCase());
		    	            	          x.setFirstName(x.getFirstName().toUpperCase());
	                                   
		    	                            System.out.println(x);
		    	                           }
		    	              );
		    	         
		    	         
		    	         
		    	         System.out.println(" printing all employee objects using Collector.joining:");
		    	    	 String allJoined=    list.stream()
		    	    			                   .map(Employee::toString)
		    	    			                  .collect(Collectors.joining("\n"));
		    	    	        
		    	    	    	           System.out.println(allJoined);
		    	    	    String lastAndFirst= list.stream()
		    	    	    		                  .map(emp->emp.getFirstName() +" "+  emp.getLastName())
		    	    	    		                  .collect(Collectors.joining("\n"));
		    	    	    System.out.println(lastAndFirst);
		    	    	    
		    	    	    
		    	    	  //5.Print out all of the Employee objects’ last names,
		    	    	    //whose last name begins with the letter  ‘I’  in sorted order, and get rid of all the duplicates. 
		    	    	   //Print out only the last names. 
		    	    	    list.stream()
		    	    	        .filter(emp->emp.getLastName().startsWith("I"))
		    	    	        .map(emp->emp.getLastName())
		    	    	        .sorted()
		    	    	        .distinct()
		    	    	        .forEach(System.out::println);
		    	    	  //6. Print out the average of all the salaries.  
		    	    	    
		    	    	Double avrg=    list.stream()
		    	    	        .mapToDouble(emp->emp.getSalary())
		    	    	        .average()
		    	    	        .getAsDouble();
		    	    	  System.out.printf("the average salary is %.2f",avrg);
		    	    	//7.Use the  ‘reduce’  method to print out the total salary of all employees.  
		    	    	         Double totalSalary=list.stream()
		    	    	    		                    .mapToDouble(Employee::getSalary)
		    	    	    		                     .reduce(0.0,Double::sum);
		    	    	    System.out.printf("the average Totalsalary is %.2f",totalSalary);
		    	    	    System.out.println("\n");
		    	    	    System.out.printf(" the total salary is %.2f\n",
		    
	    	    	    		      list.stream().mapToDouble(Employee::getSalary).reduce(0.0,Double::sum)
		    	    	    		
		    	    	    		);
		    	    	    
		    	    	    Double maxValue=    list.stream()
			    	    	        .mapToDouble(emp->emp.getSalary())
			    	    	        .max()
			    	    	        .getAsDouble();
			    	    	  System.out.printf("the maximum  salary is %.2f",maxValue);
		    	    	    
	} 
}
