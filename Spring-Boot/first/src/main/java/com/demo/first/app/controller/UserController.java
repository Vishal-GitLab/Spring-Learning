package com.demo.first.app.controller;

import com.demo.first.app.model.User;
import com.demo.first.app.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/user")    // sare ends points user par honge
public class UserController {
    private UserService userService =  new UserService();
//    private Map<Integer, User> userDb = new HashMap<>();



    public UserController(UserService userService) {
        this.userService =  userService;
    }

//    @PostMapping // kyunki yha ham recource create kar rhe hai...   postmapping ki help se ak method ko map kar diya hai
//    public String createUser(@RequestBody User user) {     // jisme user ki ak object aa jayegi     ,,,, RequestBody -->> Post request me hm RequestBody bhejte hai
//        System.out.println(user.getEmail());
////              userDb.put(user.getId(),user);
//        userDb.putIfAbsent(user.getId(), user);   // ye tabhi put karega jab uski  absent hai
//
//        return "User Created";
//    }


// hame status code change karke 200 ke bajay 201 karna hai
@PostMapping // kyunki yha ham recource create kar rhe hai...   postmapping ki help se ak method ko map kar diya hai
public ResponseEntity<User> createUser(@RequestBody User user) {     // jisme user ki ak object aa jayegi     ,,,, RequestBody -->> Post request me hm RequestBody bhejte hai
    // String ke bajay user bhi dal sakte h
//    System.out.println(user.getEmail());
////              userDb.put(user.getId(),user);
//    userDb.putIfAbsent(user.getId(), user);   // ye tabhi put karega jab uski  absent hai
////      return ResponseEntity.status(HttpStatus.CREATED).body(user);
//      // dusre tarike se responseEntity ko return kaena
    User createdUser = userService.createUser(user);
    return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
 }

    // 1 -> John, johan@gmail.com
    // 1 -> Alice, johan@gmail.com
//    @PutMapping    // ham data update karne ke liye @PutMapping ka use karte hai
//    public String updateUser(@RequestBody User user) {   //   yha jo change karna rhega vo pass karenge
//        if (userDb.containsKey(user.getId()))      // ye check karega ki key exixt karti hai ki nahi
//            userDb.put(user.getId(), user);       //  agar key exixt karti hai to  update kar dega
//        return "Update successful";
//    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
//        if (!userDb.containsKey(user.getId()))
//            return  ResponseEntity.notFound().build();
//
//            userDb.put(user.getId(), user);
////        return  ResponseEntity.status(HttpStatus.OK).body(user);
//        return  ResponseEntity.ok( user);

        User updated = userService.updateUser(user);
        if (updated == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(updated);

    }

    // /user/1    /user/2   /user/3        har dusri bar url change ho rha h to isko dynamic url kahte hai
//    @DeleteMapping("/{id}")
//    public String deleteUser(@PathVariable int id) {      // @PathVariable -->> ka use isliye kar rhe hai ki jo ham url pass kar rhe h usko delete kar sake     // int id -- isliye le rhe hai ki hmko pta hona chaiye ki kya delete karna hai mujhe
//
//       // delete tabhi karenge jab koi data present ho ,,,, and jab data  present na ho to error de denge
//        // ham koi bhi msg pass kare chahe jo status code jo pass ham pass karte hai us par hmara koi control nahi rhta hai ya  koi api control karna chahu to nhi kar sakta hu to iska solution hai Response Entity class
//        if(!userDb.containsKey(id))
//            return "User not found";
//        userDb.remove(id);
//        return "User deleted";
//    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
//         if(!userDb.containsKey(id))
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build() ;
//        userDb.remove(id);
////        return ResponseEntity.ok("User Deleted");
//
//        // 204 chahiye to use karte h
//        return ResponseEntity.noContent().build();
//
//    }


        boolean isDeleted  = userService.deleteUser(id);
         if (!isDeleted)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.noContent().build();
    }


        // jo user delete ho gya usko fir se pane ke liye ]
    @GetMapping
    public List<User> getUser() {
//        return new ArrayList<>(userDb.values());     // .Values ---  sare k sare jo values hai user ki list de dega collection format me
         return userService.getAllUsers();
    }

    // dono ends points ko ak sath likhna
//    @GetMapping({"/user", "/user/{id}"})        // ham iska use kar sakte hai

        //    /user/100, /user/400
        @GetMapping("{userId}")
//                public ResponseEntity<User> getUser(@PathVariable int id) {   // @PathVariable ---> ye btata hai ki jo id variable hai vo aapko URL se mil jayega
         // kabhi kabhi aise hota hai ki url ka parameter h  aur variable same nhi hote hai to us case me .....
//        public ResponseEntity<User> getUser(@PathVariable("userId") int id) {  // ka use krte h
        public ResponseEntity<User> getUser(@PathVariable(value = "userId",required = false) int id) {   // iska use karte h agr  orderId -- ye akbhi userId available na ho to
//            if (!userDb.containsKey(id))
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//            return ResponseEntity.ok(userDb.get(id));
            User user = userService.getUserById(id);       // user -- user ka object return karega jo User se milega
            if (user == null)           // agar ye condition true ho jati hai  to not found return kar dega
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            return ResponseEntity.ok(user);

        }
            // kya ak url me multiple path variable except kr skte h ? ---    yes kar skate hai

            @GetMapping("{userId}/orders/{orderId}")    // orderId -- ye akbhi available hoga kabhi nhi uske liye ... agar available nhi h to isko optional mark kar dete h
            public ResponseEntity<User> getUserOrder(
                    @PathVariable("userId") int id,
                   @PathVariable int orderId
            ){  // orderId bhi lagegi aur userId bhi lagegi ..  orderId  aur url ke parameter ka name same hai to isliye @PathVariable ka use krna padega
//                System.out.println("ORDER ID: " + orderId);
//                if(!userDb.containsKey(id))
//                    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//                return ResponseEntity.ok(userDb.get(id));

                User user = userService.getUserById(id);       // user -- user ka object return karega jo User se milega
                if (user == null)           // agar ye condition true ho jati hai  to not found return kar dega
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                return ResponseEntity.ok(user);
            }

            // hame search API bnani h
          // /search?name=john
           @GetMapping("/search")
     public ResponseEntity<List<User>> searchUsers(
             @RequestParam(required = false, defaultValue = "alice") String name,
             // ham multiple RequestParam bhi pass kar sakte hai ,,, ye tabhi kam aate hai jab hame search  aur multiple level ke functioality bna rhe hai
             @RequestParam(required = false, defaultValue = "email") String email
             ) {     // agar jo ham value pass kar rhe h vo consider hogi nhi to default value consider ho jayegi

//               System.out.println(name);
//               // filter karne ke liye
//               List<User> users = userDb.values().stream()
//                       .filter(u -> u.getName().equalsIgnoreCase(name))
//                       .filter(u -> u.getEmail().equalsIgnoreCase(email))
//                       .toList();
//               return ResponseEntity.ok(new ArrayList<>(userDb.values()));

               return ResponseEntity.ok(userService.searchUsers(name,email));
           }


           // hm sare api ko ak sath likh sakte hai

           @GetMapping("/info/{id}")
    public String getInfo(
            @PathVariable int id,
            @RequestParam String name,
            @RequestHeader("User-Agent") String userAgent) {
    return "User Agent: " + userAgent
            + " : " + id
            + " : " + name;
           }

}






