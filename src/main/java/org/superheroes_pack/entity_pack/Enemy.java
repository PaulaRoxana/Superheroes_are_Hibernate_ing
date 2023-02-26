package org.superheroes_pack.entity_pack;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Enemy extends CommonAttributes {

    @Column(name = "real_name", nullable = false, unique = true, length = 45)
    private String realName;

    @ToString.Exclude
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "enemy")
    private Superhero superhero;


    public Enemy(String name, String realName) {
        this.name = name;
        this.realName = realName;
    }
}
