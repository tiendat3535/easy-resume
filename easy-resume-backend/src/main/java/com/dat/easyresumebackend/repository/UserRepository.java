package com.dat.easyresumebackend.repository;

import com.dat.easyresumebackend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Pham Tien Dat on 01/11/2017.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    long countByUsername(String username);
}
