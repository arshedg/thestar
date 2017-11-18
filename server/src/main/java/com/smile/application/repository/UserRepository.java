package com.smile.application.repository;

import com.smile.application.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by agulshan on 16/11/17.
 */
@Repository
public interface UserRepository extends JpaRepository<User,String> {

}
