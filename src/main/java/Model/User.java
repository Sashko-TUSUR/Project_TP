package Model;

import javax.persistence.*;

@Entity

public class User {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

private String Log, Pass, Mail;
private Long id_role, id_comment, id_recipes;


@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "id_role")
private Role role;

@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name="id_comment")
private Comment comment;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_recipes")
    private Recipes recipes;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLog() {
        return Log;
    }

    public void setLog(String log) {
        Log = log;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public Long getId_role() {
        return id_role;
    }

    public void setId_role(Long id_role) {
        this.id_role = id_role;
    }

    public Long getId_comment() {
        return id_comment;
    }

    public void setId_comment(Long id_comment) {
        this.id_comment = id_comment;
    }

    public Long getId_recipes() {
        return id_recipes;
    }

    public void setId_recipes(Long id_recipes) {
        this.id_recipes = id_recipes;
    }




}
