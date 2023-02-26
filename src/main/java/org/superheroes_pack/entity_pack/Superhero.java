package org.superheroes_pack.entity_pack;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Superhero extends CommonAttributes {

    @Column(name = "hero_name", nullable = false, unique = true, length = 45)
    private String heroName;
    @ToString.Exclude
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Enemy enemy;

    @ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy ="superhero")
    private Set<Sidekick> sidekicks = new HashSet<>();
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
//    @JoinTable(
//            name="superhero_power",
//            joinColumns=@JoinColumn(name="superhero_id"),
//            inverseJoinColumns=@JoinColumn(name="power_id")
//    )
    private Set<Power> powers = new HashSet<>();


    public void addSidekickToSuperhero(Sidekick sidekick) {
        sidekicks.add(sidekick);
    }

    public void removeSidekickFromSuperhero(Sidekick sidekick) {
        sidekicks.remove(sidekick);
    }

    public void addPowerToSuperhero(Power power) {
        powers.add(power);
    }

    public void removePowerFromSuperhero(Power power) {
        powers.remove(power);
    }

}
