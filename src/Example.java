public class Example implements MyInterface,YourInterface {

     public void newMethod(){
        System.out.println("default method from the implementing  class");
    }

    @Override
    public void existingMethod(String str) {
        System.out.println("String is: " + str);
    }
    public static void main(String[] args) {
        Example obj = new Example();

        //calling the default method of interface
        obj.newMethod();

        //calling the abstract method of interface
        obj.existingMethod("Java 8 is easy to learn");

        MyInterface.staticNewMethod();


    }


}

