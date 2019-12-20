package com.hk.service;

import com.hk.pojo.User;

public interface UserService {
    User CheckUser(String username,String password);
}
