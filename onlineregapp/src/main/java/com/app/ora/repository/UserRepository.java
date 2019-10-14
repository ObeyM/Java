package com.app.ora.repository;

import com.app.ora.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query("SELECT rec FROM User rec WHERE rec.userIdNumber = ?")
    public User checkDuplication(String idNumber);
}