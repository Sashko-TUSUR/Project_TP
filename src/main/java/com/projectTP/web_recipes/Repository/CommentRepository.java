package com.projectTP.web_recipes.Repository;

import com.projectTP.web_recipes.model.Comment;
import com.projectTP.web_recipes.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;


public interface CommentRepository extends JpaRepository<Comment, Long> {


    @Query(value = "SELECT DISTINCT * FROM comment INNER JOIN recipes_comment " +
            "ON comment.id_comment = recipes_comment.id_comment WHERE recipes_comment.id_recipes =:id",
            nativeQuery = true)
    List<Comment> findByCommentIn(@Param("id") Long id);




    @Modifying
    @Transactional
    @Query(value = "INSERT INTO recipes_comment VALUES (:id_r,:id_com)",
            nativeQuery = true)
    public void addCommentRecipes(@Param("id_r") Long id_recipes, @Param("id_com") Long id_comment);
}
