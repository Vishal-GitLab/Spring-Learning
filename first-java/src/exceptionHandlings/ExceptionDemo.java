package exceptionHandlings;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionDemo {
    public static void main(String[] args) {
//        int a = 10;
//        int  b  = 0;
//        int result  = 10/0;   // this is eception

        try{
            // EXCEPTION GENERATING STATEMENTS
            // agar  try block me exceotion generate hogi tabhi catch block me aaygi
            int result  = 10/0;
        }  catch (Exception e) {       //    ()-->> iske andar exception  parameter pass karna hota hai
            System.out.println(" In catch block ");
            // EXCEPTION HANDLING STATEMENTS   --  EXCEPTION AANE PAR KYA KARNA HOGA YE DECIDE KETI HAI
        }
        System.out.println("DONE");

        int[] a  = {1,2,3};
        try{
            System.out.println(a[6]);
        } catch (IndexOutOfBoundsException  e) {
            System.out.println("EXCEPTION");

            // jab ham multiple tyoes of exception handle karna ho to ham  multiple catch block ka use krenge
        } catch (ArithmeticException e) {

        } finally {     // ye block recourece management ke liye use hota hai
            // chahe exception aaye ya na aaye tab bhi ye execute hoga
            // ye block har baar execute hota hai
            System.out.println("FINNALY");
        }




        try{
            FileReader fileReader =  new FileReader("abc.txt");
        }  catch (FileNotFoundException e) {
            // agar compiler hamko force karta hai ki jo exception hai isko ham handle kare to is prakar ka exception checked exception hoga  aur jo baki condition hai uskp unchekced kahte hai
//            throw  new RuntimeException(e);
        }
    }
}














