package cn.itcast.usermanage.service;

import cn.itcast.usermanage.pojo.EasyUIResult;
import cn.itcast.usermanage.pojo.User;

import java.util.List;

public interface UserService {

    EasyUIResult queryEasyUIResult(Integer pageNum, Integer pageSize);

    /**
     * 测试事务
     *
     * @param user1
     * @param user2
     */
    public void addUsers(User user1, User user2);

    /**
     * 新增用户信息
     *
     * @param user
     * @return
     * @throws Exception
     */
    Boolean addUser(User user) throws Exception;


    Boolean deleteUser(List<Object> ids);

    Boolean editUser(User user);

    Boolean insert(User user) throws Exception;

    User queryUserById(Long id);

    Boolean updateUser(User user);

    Boolean deleteUserById(Long id);
}
