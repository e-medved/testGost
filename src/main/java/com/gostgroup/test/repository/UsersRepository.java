package com.gostgroup.test.repository;

import com.gostgroup.test.model.UsersEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by root on 1/26/17.
 */
public interface UsersRepository extends CrudRepository<UsersEntity, Integer> {

}
