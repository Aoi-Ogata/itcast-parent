package cn.itcast.usermanage.service;



import cn.itcast.usermanage.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {
    private UserService userService;

    @Before
    public void setUp(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml",
                "spring/applicationContext-mybatis.xml", "spring/applicationContext-transaction.xml");
        this.userService = context.getBean(UserService.class);
    }

    @Test
    public void test(){
        User user1 = new User();
        user1.setUserName("dengdeng3");
        user1.setPassword("123456");
        User user2 = new User();
        user2.setUserName("dengdeng4");
        user2.setPassword("123456");
        this.userService.addUsers(user1,user2);
    }

}

