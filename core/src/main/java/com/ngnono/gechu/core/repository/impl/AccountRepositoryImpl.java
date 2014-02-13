package com.ngnono.gechu.core.repository.impl;

import com.ngnono.gechu.core.entity.UserEntity;
import com.ngnono.gechu.core.repository.IAccontRepository;
import com.ngnono.gechu.core.repository.persistence.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by ngnono on 14-1-16.
 */
@Repository
public class AccountRepositoryImpl extends BaseRepository implements IAccontRepository {

    @Autowired
    private UserMapper userMapper;

    /**
     * 获取用户
     *
     * @param id 用户ID
     * @return 用户实体
     */
    @Override
    public UserEntity getByUid(int id) {

        return userMapper.getById(id);
    }

    /**
     * 获取用户
     *
     * @param username 用户名
     * @return 用户实体
     */
    @Override
    public UserEntity getByUsername(String username) {

        return userMapper.getByUsername(username);
    }
}
