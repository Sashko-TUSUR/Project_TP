package com.projectTP.web_recipes.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Comment {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id_comment;

private String comment;
@Column(updatable = false)
@JsonFormat(shape = JsonFormat.Shape.STRING,pattern ="yyyy-MM-dd HH-mm:ss")
private LocalDateTime date;

@ManyToOne
@JoinColumn(name = "id_user")
private User user;

    public Comment(String comment) {
        this.comment = comment;
    }
}
