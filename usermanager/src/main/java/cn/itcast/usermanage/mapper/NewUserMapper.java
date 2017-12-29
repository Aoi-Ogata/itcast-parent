package cn.itcast.usermanage.mapper;

import cn.itcast.usermanage.pojo.User;
import com.github.abel533.mapper.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewUserMapper extends Mapper<User> {
    /**
     * 根据id获取User信息
     *
     * @return
     */
    public User queryUserById(Long id);

    public List<User> queryUsersByPage(@Param("start") Integer pageNum, @Param("pageSize") Integer pageSize);

    /**
     * 查询所有用户
     *
     * @return
     */
    public List<User> queryUserAll();

    /**
     * 新增用户
     *
     * @param user
     * @return
     * @throws Exception
     */
    public int addUser(User user);

    /**
     * 删除用户
     *
     * @param ids
     * @return
     */
    public int deleteUser(@Param("ids") String[] ids);


}
