package com.telran.rest.springrestdemo.b_service_business;

import com.telran.rest.springrestdemo.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private static List<User> users = new ArrayList<>();

    public void save(User user) {
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public void deleteUser(String lastName) {
        users = users
                .stream()
                .filter(x -> !x
                .getLastName()
                .equalsIgnoreCase(lastName))
                .collect(Collectors.toList());
    }
}
