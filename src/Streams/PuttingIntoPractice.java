package Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PuttingIntoPractice {
	
	 public static void main(String ...args){    
	        Trader raoul = new Trader("Raoul", "Cambridge");
	        Trader mario = new Trader("Mario","Milan");
	        Trader alan = new Trader("Alan","Cambridge");
	        Trader brian = new Trader("Brian","Cambridge");
			List<Transaction> transactions = Arrays.asList(
	            new Transaction(brian, 2011, 300), 
	            new Transaction(raoul, 2012, 1000),
	            new Transaction(raoul, 2011, 400),
	            new Transaction(mario, 2012, 710),	
	            new Transaction(mario, 2012, 700),
	            new Transaction(alan, 2012, 950)
	        );	
			List<Trader> traders = Arrays.asList(raoul, mario, alan, brian);
	        
	        // Query 1: Find all transactions from year 2011 and sort them by value (small to high).
 Function<List<Transaction>,List<Transaction>> year2011transaction=(tra)->tra.stream()
		                                                                .filter(tt->tt.getYear()==2011)
		                                                              .sorted(Comparator.comparing(Transaction::getValue))
		                                                              .collect(Collectors.toList());
		                                                              
         List<Transaction> sorted=year2011transaction.apply(transactions);
          System.out.println( "transaction done on the year 2011 sorted based on value are :");
          sorted.forEach(System.out::println);
		
       	
       	//Query 2: What are all the unique cities where the traders work?
       	 
             String uniqueCities=traders.stream()
            		                    .map(ci->ci.getCity())
            		                    .distinct()
            		                    .collect(Collectors.joining(","));
             System.out.println("Unique Cities:"+uniqueCities);
       	//// Query 3: Find all traders from Cambridge and sort them by name.
             List<Trader> cambridegTrader=traders.stream()
            		                              .filter(palce->palce.getCity().equals("Cambridge"))
            		                               .sorted(Comparator.comparing(Trader::getName))
            		                               .collect(Collectors.toList());
             System.out.println( "Traders from cambridge are:");      
                    
               cambridegTrader.forEach(System.out::println);
        // Query 4: Return a string of all traders names sorted alphabetically.
                    String alltraders=traders.stream()
                    		                .map(trade->trade.getName())
                    		                .sorted()
                    		                .collect(Collectors.joining(","));
                    System.out.println(" All traders sorted alpahabetically ");
                    System.out.println(alltraders);
       	 
       	   //Query 5: Are there any trader based in Milan?
                     long numberofMilantrader= traders.stream()
                    		                          .filter(tr->tr.getCity().equals("Barcelona"))
                    		                          .count();
                    System.out.println(" the number of milan traders are:"+numberofMilantrader);
       	        //or using optional traders
                    
                    Optional<Trader> milanTrader=traders.stream()
                    		.filter(tr->tr.getCity().equals("Barcelona")).findFirst();
                       System.out.println("Are there milan traders:"+milanTrader);
                    		//or 3rd option
Predicate<List<Trader>> traderFromMilan= (trad)->trad.stream()
                                        .filter(trader->trader.getCity().equals("Barcelona"))
                                         .count()>0;
System.out.println("Any traders based in Milan? " + traderFromMilan.test(traders)); 
       	  // Query 6: Update all transactions so that the traders from Milan are set to Cambridge.
                                  transactions.stream()
                                              .forEach(x->{
                                            	        if(x.getTrader().getCity().equals("Milan")) {
                                            	        	x.getTrader().setCity("Cambridge");
                                            	              }
                                            	  
                                            	      System.out.println(x.toString());
                                                    }
                                              
                                            		  
                                            		  );
       	       
       	     
       	// Query 7: What's the highest value in all the transactions?
       	       
       	     
       	        		                   
       	      
        }

}