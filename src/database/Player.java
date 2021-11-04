package com.example.sping_portfolio.database;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class }) 
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    // Name of the player
    @Size(min=2, max=100, message = "Name")
    private String name;

    // Where the players image is located so we can display it easily
    @Size(min=2, max=300, message="ImgURL")
    private String imgURL;

    // Look at PlayerState enum for corresponding states (alive, dead, out)
    private int state;

    // One to many relationship to hold all the people player killed
    @OneToMany(mappedBy = "kills")
    private Set<Player> kills;

    // Each player has only one partner
    @OneToOne(cascade = CascadeType.ALL)
    private Player partner;
}
