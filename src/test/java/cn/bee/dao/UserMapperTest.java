package cn.bee.dao;

import cn.bee.BaseTest;
import cn.bee.User;
import cn.bee.utils.Md5Encrypt;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.UUID;

/**
 * created by liufeng
 * 2018/9/11
 */
public class UserMapperTest extends BaseTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void save() {
        User user = new User();
        user.setName("admin");
        user.setRealName("answer");
        String uuid = UUID.randomUUID().toString();
        user.setUuid(uuid);
        String password = "123456";
        try {
            String str = Md5Encrypt.EncoderByMd5(uuid, password);
            user.setPassword(str);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        userMapper.save(user);

    }

    @Test
    public void findUserByName() {
        Map user = userMapper.findUserByName("admin");
        System.out.println(user);
    }
}