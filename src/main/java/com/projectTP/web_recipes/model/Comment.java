package com.projectTP.web_recipes.model;

import javax.persistence.*;

@Entity

public class Comment {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id_comment;

private String comment;


public Long getId_comment() {
        return id_comment;
        }

public void setId_comment(Long id_comment) {
        this.id_comment = id_comment;
        }

public String getComment() {
        return comment;
        }

public void setComment(String comment) {
        this.comment = comment;
        }
        }
