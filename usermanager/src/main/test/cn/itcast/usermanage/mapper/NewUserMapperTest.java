package cn.itcast.usermanage.mapper;

import cn.itcast.usermanage.pojo.User;
import com.github.abel533.entity.Example;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.fail;

public class NewUserMapperTest {

    private NewUserMapper userMapper;

    @Before
    public void setUp() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml", "spring/applicationContext-mybatis.xml");
        this.userMapper = context.getBean(NewUserMapper.class);
    }

    @Test
    public void testSelectOne() {
        User record = new User();
        record.setUserName("zhangsan");
        System.out.println(this.userMapper.selectOne(record));
    }

    @Test
    public void testSelect() {
        User record = new User();
        record.setAge(30);
        record.setPassword("123456");
        List<User> list = this.userMapper.select(record);
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void testSelectCount() {
        System.out.println(this.userMapper.selectCount(null));
    }

    @Test
    public void testSelectByPrimaryKey() {
        System.out.println(this.userMapper.selectByPrimaryKey(2L));
    }

    @Test
    public void testInsert() {
        User record = new User();
        record.setName("大幂幂");
        record.setAge(18);
        record.setPassword("123456");
        record.setUserName("bigmi");
        this.userMapper.insert(record);
        System.out.println(record.getId());
    }

    @Test
    public void testInsertSelective() {
        User record = new User();
        record.setName("张学友");
        record.setAge(18);
        record.setPassword("123456");
        record.setUserName("bigmi2");
        this.userMapper.insertSelective(record);
        System.out.println(record.getId());
    }

    @Test
    public void testDelete() {
        User record = new User();
        record.setId(12L);
        this.userMapper.delete(record);
    }

    @Test
    public void testDeleteByPrimaryKey() {
        this.userMapper.deleteByPrimaryKey(13L);
    }

    @Test
    public void testUpdateByPrimaryKey() {
        User record = new User();
        record.setName("范冰冰");
        record.setAge(19);
        record.setPassword("123456");
        record.setUserName("fanice");
        record.setId(9L);
        this.userMapper.updateByPrimaryKey(record);
    }

    @Test
    public void testUpdateByPrimaryKeySelective() {
        User record = new User();
        record.setName("范冰冰");
        record.setAge(18);
        record.setPassword("123456");
        record.setUserName("lllll");
        record.setId(11L);
        this.userMapper.updateByPrimaryKeySelective(record);
    }

    @Test
    public void testSelectByExample() {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andBetween("age", 20, 30);
        criteria.andLike("userName", "%zhang%");
        Example.Criteria criteria2 = example.createCriteria();
        criteria2.andEqualTo("password", "123456");
        example.or(criteria2);
        example.setOrderByClause("age desc, id desc");
        List<User> list = this.userMapper.selectByExample(example);
        for (User user : list) {
            System.out.println(user);
        }
    }
}
