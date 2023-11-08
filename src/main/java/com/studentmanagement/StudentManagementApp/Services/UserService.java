package com.studentmanagement.StudentManagementApp.Services;

import com.studentmanagement.StudentManagementApp.Entity.User;
import com.studentmanagement.StudentManagementApp.Repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@Transactional
public class UserService implements IUserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void registerNewUserAccount(User userDto){
        if(usernameExists(userDto.getUsername())){
            return;
        }
        userDto.setEnabled(true);
        userRepository.createUser(userDto);
    }

    private boolean usernameExists(String username){
        return userRepository.findByUsername(username);
    }

}
