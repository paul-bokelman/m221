package com.example.sping_portfolio.database;


import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Setter
@Getter
@ToString
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    // Name of the player
    @NonNull
    @Size(min=2, max=100, message = "Name")
    private String name;

    // Where the players image is located so we can display it easily
    @NonNull
    @Size(min=2, max=300, message="ImgURL")
    private String imgURL;

    // Look at PlayerState enum for corresponding states (alive, dead, out)
    @NonNull
    private int state;

    // One to many relationship to hold all the people player killed
    @OneToMany(mappedBy = "kills")
    private Set<Player> kills;

    // Each player has only one partner
    @OneToOne(cascade = CascadeType.ALL)
    private Player partner;
}
