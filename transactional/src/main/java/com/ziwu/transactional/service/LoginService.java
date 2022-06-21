package com.ziwu.transactional.service;

import com.ziwu.transactional.mapper.user.UserMapper;
import com.ziwu.transactional.mapper.userslave.UserSlaveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserSlaveMapper userSlaveMapper;

    @Transactional(transactionManager = "jtaTransactionManager")
    public void insert() {
        userMapper.add("ziwu");
        userSlaveMapper.add("ziwu");
    }
}
