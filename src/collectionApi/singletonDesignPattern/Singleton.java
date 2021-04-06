package collectionApi.singletonDesignPattern;

public class Singleton {

    public static void main(String[] args) {

        //Abc obj1= Abc.getStaticInstance();
        //Abc obj2= Abc.getStaticInstance();


        //creating 2 threads that access the getStaticInstance method

        Thread t1= new Thread( new Runnable(){
                   public void run(){
                       Abc obj1= Abc.getInstance();
                   }

        });


        Thread t2= new Thread( new Runnable(){
            public void run(){
                Abc obj2= Abc.getInstance();
            }

        });
   t1.start();
   t2.start();

    }
}
