package com.example.lesson8.Repositories;

import com.example.lesson8.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    @Query("SELECT u FROM User u WHERE u.email = :email ORDER BY u.name")
    User findByEmail(@Param("email") String email);

    @Query("SELECT u FROM User u WHERE u.name LIKE %:name%")
    List<User> findByNameContaining(@Param("name") String name);

    @Query("SELECT u FROM User u WHERE u.gender LIKE %:gender%")
    List<User> findByGender(@Param("gender") String gender);


    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.gender = :gender WHERE u.gender IS NULL")
    int updateGenderWhereNull(@Param("gender") String gender);

}
