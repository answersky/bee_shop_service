package cn.bee.service.impl;

import cn.bee.User;
import cn.bee.dao.UserMapper;
import cn.bee.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author answer
 * 2018/2/5
 */
@Service(value = "userService")
public class UserServeceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User findUserInfo() {
        User user = new User();
        user.setName("answer");
        return user;
    }

    @Override
    public User findUserByName(String s) {
        return userMapper.findUserByName(s);
    }
}
