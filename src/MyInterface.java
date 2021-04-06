

interface MyInterface{

    default void newMethod(){
        System.out.println("Greeting from MyInterface...default");
    }


    static void staticNewMethod(){
        System.out.println("Newly added static method from interface");
    }
    void existingMethod(String str);

}  