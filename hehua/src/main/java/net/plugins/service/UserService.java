package net.plugins.service;

import net.plugins.model.User;
import net.pagination.Pagination;

import java.util.List;

/**
 * Created by Administrator on 2017/7/22.
 * IntelliJ IDEA 2017 of gzcss
 */
public  interface UserService {
    void save(User user);
    boolean update(User user);
    boolean delete(int id);
    User findById(int id);
    List<User> findAll();

    User findByAccount(String account);

    User findUserWithRoles(String account);

    Pagination<User> getList(int page, int size);

    void updateUser(User user);

    void insertUser(User user);
}