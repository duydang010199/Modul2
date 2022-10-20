package services;

import models.User;
import until.CSVUntil;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class UserServices implements ExtendUserServices{
    private static ArrayList<User> listUser = new ArrayList<>();
    private final String fileName = "C:\\Users\\ADMIN\\OneDrive\\Máy tính\\Modul2\\CaseStudyMD2\\data\\users.csv";

    @Override
    public ArrayList<User> getUser() {
        if (listUser.size() == 0){
            List<String> documents = CSVUntil.readFile(fileName);
            for (String document : documents){
                listUser.add(User.parseUser(document));
            }
            return listUser;
        }
        return null;
    }

    @Override
    public User loginUser(String userName, String passWord) {
        for (User user : listUser){
            if (user.getNameUser().equals(userName) && user.getPassWord().equals(passWord)){
                return user;
            }
        }
        return null;
    }
    @Override
    public List<User> findAllUsers() {
        List<User> users = new ArrayList<>();
        List<String> records = CSVUntil.readFile(fileName);
        for (String record : records) {
            users.add(User.parseUser(record));
        }
        return users;
    }

    @Override
    public void update() {
        CSVUntil.writeFile(fileName,listUser);
    }

    @Override
    public void addUser(User newUser) {
        List<User> users = getUser();
        users.add(newUser);
        CSVUntil.writeFile(fileName,users);
    }
    @Override
    public void removeUser(Long idUser) {
        List<User> users = findAllUsers();
        users.removeIf(id -> id.getId().equals(idUser));
        CSVUntil.writeFile(fileName, users);
    }
    @Override
    public User findUserById(Long id) {
        List<User> users = findAllUsers();
        for (User user : users){
            if (user.getId().equals(id)){
                return user;
            }
        }
        return null;
    }
    @Override
    public boolean exitUserId(Long id){
        return findUserById(id) != null;
    }

    public User getUserByUserName(String userName) {
        for (User user : listUser){
            if (user.getNameUser().equals(userName)){
                return user;
            }
        }
        return null;
    }
    @Override
    public void editUser(User newUser){
        List<User> users = findAllUsers();
        for (User user : users){
            if (user.getId().equals(newUser.getId())){
                String fullName = newUser.getName();
                if (fullName != null && !fullName.isEmpty()){
                    user.setNameUser(fullName);
                }
                String numberPhone = newUser.getPhone();
                if (numberPhone != null && !numberPhone.isEmpty()){
                    user.setPhone(numberPhone);
                }
                String email = newUser.getEmail();
                if (email != null && !email.isEmpty()){
                    user.setEmail(email);
                }
                String address = newUser.getAddress();
                if (address != null && !address.isEmpty()){
                    user.setAddress(address);
                }
                String role = newUser.getRole();
                if (role != null && !role.isEmpty()){
                    user.setRole(role);
                }
                user.setTimeCreatUser(Instant.now());
                CSVUntil.writeFile(fileName,users);
                break;
            }
        }
    }
}
