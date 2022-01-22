package Repository;

import Model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserRepository {

    private static List<User> users;

    private static UserRepository userRepository=null;

    private UserRepository(){
        users=new ArrayList<>();
    }


    public static UserRepository getInstance()
    {
        if(userRepository==null)
            userRepository=new UserRepository();

        return userRepository;
    }


    public List<User> getUsers(){
        return users;
    }

    public User add(User user){
        users.add(user);
        return user;
    }


    public User getUser(String userName) {

        List<User> user=users.stream().filter(e->

                 e.getName().equals(userName)

        ).collect(Collectors.toList());

        return user.get(0);
    }

    public void remove(User user) {
        users.remove(user);
    }
}
