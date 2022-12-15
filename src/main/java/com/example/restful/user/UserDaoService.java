package com.example.restful.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int usersCount = 4;

    static {
        users.add(new User(1,"abcd",new Date()));
        users.add(new User(2,"efgh",new Date()));
        users.add(new User(3,"ijkl",new Date()));
        users.add(new User(4,"mnop",new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user){
        if (user.getId() == null) {
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        for (User u: users) {
            if(u.getId() == id){
                return u;
            }
        }
        return null;
    }
}
