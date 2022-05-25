package com.projectTP.web_recipes.Repository;

import com.projectTP.web_recipes.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Message,Long> {
}
