package com.projectTP.web_recipes.model;

import javax.persistence.*;
import java.util.Date;

@Entity

public class Comment {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id_comment;

private String comment;

private Date date;

@ManyToOne
@JoinColumn(name = "id_user")
private User user;

        public Date getDate() {
                return date;
        }

        public void setDate(Date date) {
                this.date = date;
        }

        public User getUser() {
                return user;
        }
        public void setUser(User user) {
                this.user = user;
        }
        public Long getId_comment() {
        return id_comment;
        }

        public Comment(String comment) {
                this.comment = comment;
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

        public Comment() {
        }
}
