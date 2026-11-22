package exceptionHandlings;
class InvalidMemberException  extends Exception {
    public InvalidMemberException(String message) {
        super(message);
    }
}
class BookUnavailableException  extends Exception {
    public BookUnavailableException(String message) {
        super(message);
    }
}

// Throw and Throws keyword
// Throw  -->> koi aisi condition reach kar jaye .. jaha par handling nhai karna chate hai to throw kar sakte hai exception
//Throws-- >> jo btata hai particlur  blocki of code(method )   ye exception throw kar rha hai
// /custom exception means ->> user defined exception
class Library {
    int availableBooks = 3;

    public void borrowBook(String  memberName, int bookRequestedCount) throws Exception {     // this is throws keyword
        if (bookRequestedCount > availableBooks)
            throw new BookUnavailableException("Not enough books available");
        if (bookRequestedCount < 0)
            throw new Exception("You must request at least one books");
        if (memberName == null ||  memberName.isEmpty())
            throw new InvalidMemberException("Invalid Membership");
    }
}
    public class LibraryDemo {
        public static void main(String[] args) throws Exception {
            Library library = new Library();
            try {
                library.borrowBook("Johan",1);
                library.borrowBook(null,1);
            } catch (BookUnavailableException e) {
                e.printStackTrace();         // this is user defined exception erroe
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Exception Occured: " + e.getMessage());
            }

        }
    }


    // using throws code
//int availableBooks = 3;
//
//public void borrowBook(int bookRequestedCount) throws Exception {     // this is throws keyword
//    if (bookRequestedCount > availableBooks)
//        throw new Exception("Not enough books available");
//    if (bookRequestedCount < 0)
//        throw new Exception("You must request at least one books");
//}



   // use in code throw

// try {
//         if (bookRequestedCount > availableBooks) {
//        throw new Exception("Not enough book availble");     // Exception ka object bna diya
//            }
//                    } catch (ArrayIndexOutOfBoundsException e ) {
//        System.out.println("Exception Occurred, you requested a book that you that does not exist");
//        } catch (Exception e) {       // Exception ki Information yha pass hogi kyunki yr parantes  class handle kar rhe hai
//        System.out.println("Exception");
//        } finally {
//                System.out.println("FINALLY BLOCK");
//        }
//                }





//  try {
////            int[] books = {101, 102, 103};
////            System.out.println("Book requested : " + books[bookRequested]);
//
//                    } catch (ArrayIndexOutOfBoundsException e ) {
//        System.out.println("Exception Occurred, you requested a book that you that does not exist");
//        } catch (NullPointerException e) {
//        System.out.println("NullPointerException");
//        } catch (Exception e) {       // Exception ki Information yha pass hogi kyunki yr parantes  class handle kar rhe hai
//        throw new RuntimeException(e);
//        } finally {
//                System.out.println("FINALLY BLOCK");
//        }
//                }