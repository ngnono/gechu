package org.ngnono.gechu.core.repository.persistence;

import org.ngnono.gechu.core.entity.UserEntity;

import java.util.List;

/**
 * Created by ngnono on 14-1-27.
 * 用户Mapper
 */

public interface UserMapper extends BaseMapper {

    //@Select("select * from user")
    public List<UserEntity> getAll();

    //@Select("select * from user where username=#{username}")
    public UserEntity getByUsername(String username);

    //@Select("select * from user where id=#{id}")
    public UserEntity getById(int id);

    //@Insert("insert into user(name,password) values(#{username},#{password})")
    public void insertUser(UserEntity entity);

    //@Update("update user set username=#{username},password=#{password} where id=#{id}")
    public void updateUser(UserEntity entity);

    /**
     * 摧毁当前ID的用户
     */
    //@Delete("delete from user where id=#{id}")
    public void destroyUser(UserEntity entity);
}
