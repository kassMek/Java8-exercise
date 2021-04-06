public class LambdaClass {


    public static void main (String []args){
//        YourInterface test= new YourInterface(){
//
//
//            @Override
//            public void existingMethod(String str) {
//                System.out.println(" Hello from anonymous inner class..."+str);
//            }
//        };


        YourInterface test=(data)-> System.out.println("Kass ..."+data);
        test.existingMethod("Lambda");
    }
}
