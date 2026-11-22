package fuctionalProgramming;

@FunctionalInterface        // this is annotation for,,,,,,
interface  BookAction{
    void perform();    //  FunctionalInterface  -->> sirf ak hi abstract method hi bas..    .......   this is functional interface
}

// lambda expression -->  jiski help  se implementation provide kar sakte hai  functional interface ko
// syntax of  lambda -->>
// parameter -> expression body
// ()  -> {}


// Functional /interface with Parameters
@FunctionalInterface
interface Operation {
    int add(int a, int b);
}


 public class functionalInterfaceDemo {
    public static void main(String[] args) {
        // step 1
//      BookAction action1 =  new BookAction() {
//          @Override
//          public void perform() {
//              System.out.println("Action Performed");
//          }
 //   };


        // step 2
        // ab ham lambda ka use karenge
        BookAction action2 =  () -> {
            System.out.println("Action Performed");
      };

        // STEP 3
        BookAction action3 =  () -> System.out.println("Action Performed");
//            System.out.println("Action Performed");
      action3.perform();

      Operation operation1  = (int a, int b ) ->  {
             return a + b;
        };
        System.out.println(operation1.add(10,20));

        // THREAD INTERFACE
          // ham start ka use karenge
    }
}
