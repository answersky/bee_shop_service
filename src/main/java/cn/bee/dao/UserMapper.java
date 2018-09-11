package cn.bee.dao;

import cn.bee.User;

import java.util.Map;

/**
 * created by liufeng
 * 2018/9/11
 */
public interface UserMapper {
    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    int save(User user);

    /**
     * 根据用户名查询用户
     *
     * @param name
     * @return
     */
    Map findUserByName(String name);
}
