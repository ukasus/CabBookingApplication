package Service;

import Model.User;

public interface UserService {

  void add_user(User user);

  User upate_user(String userName,User updatedUser);

  User upate_userLocation(String userName,int[] location);






}
