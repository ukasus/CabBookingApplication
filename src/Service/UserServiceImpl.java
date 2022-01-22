package Service;

import Model.User;
import Repository.UserRepository;

public class UserServiceImpl implements UserService{

    private UserRepository userRepository=UserRepository.getInstance();


    @Override
    public void add_user(User user) {

        if(userRepository.getUsers().contains(user))
            System.out.println("Can't add duplicate User");
        else
            userRepository.getUsers().add(user);
    }

    @Override
    public User upate_user(String userName, User updatedUser) {
        User user=userRepository.getUser(userName);
        if(user!=null) {
            userRepository.remove(user);
            userRepository.add(updatedUser);
            return updatedUser;
        }
        return user;
    }

    @Override
    public User upate_userLocation(String userName, int[] location) {
        User user=userRepository.getUser(userName);
        if(user!=null)
            user.setLocation(location);

        return user;
    }
}
