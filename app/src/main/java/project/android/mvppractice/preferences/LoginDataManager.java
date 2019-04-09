package project.android.mvppractice.preferences;

import java.util.ArrayList;
import java.util.List;

import project.android.mvppractice.model.User;

/**
 * Created by Rahul khurana on 09/04/19.
 */

public class LoginDataManager {


    List<User> userlist = new ArrayList<>();


   public LoginDataManager(){

        populateData();

    }

    private void populateData() {

        userlist.add(new User("rahul","123"));
        userlist.add(new User("khurana","123"));

        userlist.add(new User("ushyaku","123"));

        userlist.add(new User("raj","123"));

        userlist.add(new User("raghav","123"));


    }


    public boolean checkCrendentials( String username, String password){




        for(User user :  userlist){

            if(user.getUsername().equalsIgnoreCase(username) && user.getPassword().equalsIgnoreCase(password)){

                return true;
            }
        }
        return false;
    }


}
