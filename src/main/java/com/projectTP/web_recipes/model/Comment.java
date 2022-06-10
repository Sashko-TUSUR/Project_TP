package com.projectTP.web_recipes.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Comment {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id_comment;

@NotNull
private String text;
@Column(updatable = false)
@JsonFormat(shape = JsonFormat.Shape.STRING,pattern ="yyyy-MM-dd HH-mm:ss")
private LocalDateTime date;

@ManyToOne
private User user;

@ManyToMany(mappedBy = "comments",cascade = CascadeType.ALL)
@JsonIgnore
private Set<Recipes> recipes;





}
