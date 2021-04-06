public interface YourInterface {

    default void newMethod(){
        System.out.println("Greeting from YourInterface...default");
    }
    void existingMethod(String str);


}
