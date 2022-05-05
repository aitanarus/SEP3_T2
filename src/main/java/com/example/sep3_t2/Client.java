package com.example.sep3_t2;

import com.example.sep3_t2.networking.UserClient;
import java.io.IOException;

public class Client implements Runnable{
    UserClient userClient;

    public Client() throws IOException{
        userClient = new UserClient();
    }

    @Override
    public void run() {

        //ERROR HANDLING

        //saving works
        //userClient.saveUser(new User("Troels1", "Mortesen1", "troels2@email.com", "Troels1234", new ArrayList<>()));

        //deleting works - fix deleting any id?
        //userClient.deleteUser(2);

        //updating works
        //userClient.updateUser(new User(9, "Upd", "Upd", "upd@email.com", "Upd123", new ArrayList<>()));

        //authClient.getUserById(6);

        //get all users works
        //authClient.getAllUsers();

        //Find email works
       // authClient.findEmail("troels3@email.com");
       // authClient.saveUser(new User("Aitana", "Rus", "aitanarus@gmail.com", "AitanaRus1234", "Admin"));

    }
}
