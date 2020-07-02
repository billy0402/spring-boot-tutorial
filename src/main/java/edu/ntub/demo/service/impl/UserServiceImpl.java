package edu.ntub.demo.service.impl;

import edu.ntub.demo.bean.UserBean;
import edu.ntub.demo.dao.UserDAO;
import edu.ntub.demo.entity.User;
import edu.ntub.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserBean setUser(UserBean user) {
        User entity = new User();
        userDAO.saveAndFlush(entity);
        user.setId(entity.getId());
        return user;
    }
}
