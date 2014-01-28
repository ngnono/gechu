package org.ngnono.gechu.core.repository.impl;

import org.ngnono.gechu.core.entity.UserEntity;
import org.ngnono.gechu.core.repository.contract.IAccontRepository;
import org.ngnono.gechu.core.repository.mapper.UserMapper;

/**
 * Created by ngnono on 14-1-16.
 */
public class AccountRepository extends BaseRepository implements IAccontRepository {

    private UserMapper dataContext;

    public AccountRepository(UserMapper dataContext) {
        this.dataContext = dataContext;
    }


    /**
     * 获取用户
     *
     * @param id 用户ID
     * @return 用户实体
     */
    @Override
    public UserEntity getByUid(int id) {
        return dataContext.getById(id);
    }

    /**
     * 获取用户
     *
     * @param username 用户名
     * @return 用户实体
     */
    @Override
    public UserEntity getByUsername(String username) {
        return dataContext.getByUsername(username);
    }
}
