package org.ngnono.gechu.core.repository.contract;

import org.ngnono.gechu.core.entity.UserEntity;

/**
 * Created by ngnono on 14-1-27.
 */
public interface IAccontRepository {
    /**
     * 获取用户
     * @param id 用户ID
     * @return 用户实体
     */
    UserEntity getByUid(int id);

    /**
     * 获取用户
     * @param username 用户名
     * @return 用户实体
     */
    UserEntity getByUsername(String username);
}
