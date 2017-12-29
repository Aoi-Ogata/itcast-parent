package cn.itcast.usermanage.service.impl;

import cn.itcast.usermanage.mapper.NewUserMapper;
import cn.itcast.usermanage.service.UserService;
import cn.itcast.usermanage.pojo.EasyUIResult;
import cn.itcast.usermanage.pojo.User;
import com.github.abel533.entity.Example;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private NewUserMapper userMapper;

    @Override
    public EasyUIResult queryEasyUIResult(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        User record = new User();
        List<User> userList = this.userMapper.select(record);
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        EasyUIResult easyUIResult = new EasyUIResult();
        easyUIResult.setTotal(pageInfo.getTotal());
        easyUIResult.setRows(pageInfo.getList());
        return easyUIResult;
    }

    @Override
    public void addUsers(User user1, User user2) {
        this.userMapper.addUser(user1);
        // 制造异常
        //int i=1/0;
        this.userMapper.addUser(user2);
    }

    @Override
    public Boolean addUser(User user) throws Exception {
        int index = this.userMapper.insertSelective(user);
        if (index > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteUser(List<Object> ids) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id", ids);
        int index = this.userMapper.deleteByExample(example);
        if (index > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean editUser(User user) {
        int index = this.userMapper.updateByPrimaryKeySelective(user);
        if (index > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean insert(User user) throws Exception {
        return this.userMapper.insertSelective(user)>0;
    }

    @Override
    public User queryUserById(Long id) {
        return this.userMapper.selectByPrimaryKey(id);
    }

    @Override
    public Boolean updateUser(User user) {
        return this.userMapper.updateByPrimaryKeySelective(user) > 0;
    }

    @Override
    public Boolean deleteUserById(Long id) {
        return this.userMapper.deleteByPrimaryKey(id) > 0;
    }
}
