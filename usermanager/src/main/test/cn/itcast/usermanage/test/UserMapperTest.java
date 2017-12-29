package cn.itcast.usermanage.test;

import cn.itcast.usermanage.mapper.UserMapper;
import cn.itcast.usermanage.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserMapperTest {

    public UserMapper userMapper;

    @Before
    public void setUp() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml","spring/applicationContext-mybatis.xml");
        this.userMapper = (UserMapper) context.getBean(UserMapper.class);
    }

    @Test
    public void queryUserById() {
        User user = this.userMapper.queryUserById(2L);
        System.out.println(user);
    }
}