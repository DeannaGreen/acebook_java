package com.makersacademy.acebook.service;

import com.makersacademy.acebook.model.User;

public interface UserService {

    public void saveUser(User user);

    public boolean isUserAlreadyPresent(User user);
}
