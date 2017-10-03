package dao;

import entity.User;

/**
 * Created by User on 026 26.09.17.
 */
public class UserDAOService {
    private final UserDAO userDAO;

    public UserDAOService(UserDAO udao) {
        this.userDAO = udao;
    }

    public void add(User user){
        userDAO.add(user);
    }

    public User getByLogin(String name){
        User user = userDAO.getByLogin(name);
        return user;
    }

}
