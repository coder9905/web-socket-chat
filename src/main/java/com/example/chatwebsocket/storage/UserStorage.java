package com.example.chatwebsocket.storage;

import java.util.HashSet;
import java.util.Set;

public class UserStorage {

    private static UserStorage instange;
    private Set<String> users;

    private UserStorage(){
        users=new HashSet<>();
    }

    public static synchronized UserStorage getInstance(){
        if (instange == null){
            instange=new UserStorage();
        }
        return instange;
    }

    public Set<String> getUsers(){
        return users;
    }

    public void setUsers(String userName) throws Exception {
        if (users.contains(userName)){
            throw new Exception("User aready exists with userName:"+userName);
        }
        users.add(userName);
    }

}
