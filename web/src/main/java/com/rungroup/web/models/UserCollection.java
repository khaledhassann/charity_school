package com.rungroup.web.models;

import com.rungroup.web.models.User;
import java.util.ArrayList;
import java.util.List;

public class UserCollection {
    private List<User> users;

    public UserCollection() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public UserIterator iterator() {
        return new UserIterator(users);
    }
}