package com.telran.rest.springrestdemo.a_controller_api;

import com.telran.rest.springrestdemo.b_service_business.UserService;
import com.telran.rest.springrestdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/users")
public class UserController {
    //POSTMAN -> Tomcat -> Spring (MVC) -> Out controller -> out method

//    public String getHtmlPage() {
//        return "index.html";
//    }

    //GET - дай всех юзеров
    //POST - сохрани
    //DELETE - удали

    @Autowired
    private UserService userService;

    //users/all
    @GetMapping("/all")
    public List<User> getUsers() {
        return userService.getUsers();
    }

//    @PostMapping("/all")
//    public void aasada

    //users/save
    @PostMapping("/save")
    public void save(@RequestBody User user) {
        userService.save(user);

    }

    //REQUEST PARAMETER - users/delete?lastName={lastName}
    //PATH VARIABLE - users/delete/{lastName}
    @DeleteMapping("/delete/{lastName}")
    public void deleteUser(@PathVariable("lastName") String lastName) {
        userService.deleteUser(lastName);
    }



}


