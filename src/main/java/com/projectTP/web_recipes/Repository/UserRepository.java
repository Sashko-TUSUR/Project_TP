package com.projectTP.web_recipes.Repository;


import com.projectTP.web_recipes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long >{
}
