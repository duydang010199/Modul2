package services;

import models.User;

import java.util.ArrayList;
import java.util.List;

public interface ExtendUserServices {
    ArrayList<User> getUser();
    User loginUser(String userName, String passWord);
    void update();
    void addUser(User newUser);
    void removeUser(Long idUser);
    User findUserById(Long id);
    boolean exitUserId(Long id);
    List<User> findAllUsers();
    void editUser(User newUser);





}
