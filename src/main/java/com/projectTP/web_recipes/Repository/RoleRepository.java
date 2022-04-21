package com.projectTP.web_recipes.Repository;


import com.projectTP.web_recipes.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository <Role,Long> {
}
