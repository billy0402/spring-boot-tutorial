package edu.ntub.demo.service.impl;

import edu.ntub.demo.bean.UserBean;
import edu.ntub.demo.dao.UserDAO;
import edu.ntub.demo.entity.User;
import edu.ntub.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserDAO userDAO, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserBean setUser(UserBean user) {
        User entity = new User();
        entity.setId(user.getId());
        entity.setAccount(user.getAccount());
        entity.setBirthday(user.getBirthday());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
        entity.setPassword(passwordEncoder.encode(user.getPassword()));
        userDAO.saveAndFlush(entity);
        user.setId(entity.getId());
        return user;
    }
}
