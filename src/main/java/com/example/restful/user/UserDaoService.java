package com.example.restful.user;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int usersCount = 4;

    static {
        users.add(new User(1,"abcd",new Date(),"pass1","901010-1234567"));
        users.add(new User(2,"efgh",new Date(),"pass2","801010-1234567"));
        users.add(new User(3,"ijkl",new Date(),"pass3","701010-2234567"));
        users.add(new User(4,"mnop",new Date(),"pass4","001010-3456789"));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user){
        if (user.getId() == null) {
            user.setId(++usersCount);
            user.setJoinDate(new Date());
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
    public User update(User user) {
        for (User u: users) {
            if(u.getId() == user.getId()){
                u.setName(user.getName());
                return u;
            }
        }
        return null;
    }

    public User deleteById(int id) {
        Iterator<User> iterator = users.iterator();

        while (iterator.hasNext()) {
            User user = iterator.next();
            if(user.getId() == id) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }
}
