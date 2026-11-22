package com.demo.first;


import com.demo.first.app.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

    //spring boot automatically java object ko JSON form me convert karta hai
@RestController           // jo api ki body hoti h use trah data ko represent kar deta hai  ... ye class level  par use hota hai
@RequestMapping("/api")    // ak bar hm likh denge to hamko bar bar api likhna nhi padega
public class HelloController {   // Controller --> ak aisa component hai  hmari application ka jo  ki jo request aati h hmare application ki ooor unko interccept karta hai
   @GetMapping("/hello")                //  ak get request   ..  aur ye method level par use hota hai
//   @RequestMapping(value = "/user", method = {RequestMethod.GET, RequestMethod.POST})   // multiple request ko support karta hai
//   @RequestMapping(value = "/user", method = RequestMethod.GET)
   public String sayHello() {
        return "Hello World!";                 // print krane ke liye hame http://localhost:8080/hello ka use karna padega
    }


    // fir request jati hai controller ke pass fir java object ko JSON me convert karta hai
        //JACTION jab ham akk web framework bnate hai to java object ko JSON me convert karna aur JSON se java me convert karna
    @GetMapping("/user")
        public User getUser() {
//        User user = new User(1,"John","johan@gmail.com");
//        User user = new User(1,"John","johan@gmail.com");   // ab return kar dega ab mujhe getter setter bnane ki jarurat hai
         return   new User(1,"John","johan@gmail.com");

    }
}
