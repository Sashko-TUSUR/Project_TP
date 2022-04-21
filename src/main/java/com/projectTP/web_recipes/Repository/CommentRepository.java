package com.projectTP.web_recipes.Repository;

import com.projectTP.web_recipes.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CommentRepository extends JpaRepository<Comment, Long> {
}
