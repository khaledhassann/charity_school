package com.rungroup.models;
import com.rungroup.models.User;
import java.util.Iterator;
import java.util.List;

public class UserIterator implements Iterator<User> {
    private List<User> users;
    private int position = 0;

    public UserIterator(List<User> users) {
        this.users = users;
    }

    @Override
    public boolean hasNext() {
        return position < users.size();
    }

    @Override
    public User next() {
        return users.get(position++);
    }
}
