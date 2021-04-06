package collectionApi.singletonDesignPattern;

public class Abc {


    //eager instantiation
    // Abc  obj= new Abc();

    static Abc  obj;
    private Abc(){
        System.out.println("Instance Created");
    }


    // but using synchronized key word will decrease the performance
    // and better to use Double checked Locking
    static synchronized Abc getStaticInstance(){

        //Lazy Instantiation
        if(obj==null) {
            obj = new Abc();
        }
        return obj;
    }

    //Singleton Design Pattern using Double Checked Locking
    static Abc getInstance(){
        if(obj==null){
            synchronized (Abc.class){
                if(obj==null){
                    obj= new Abc();
                }
            }
        }
        return obj;
    }
}
