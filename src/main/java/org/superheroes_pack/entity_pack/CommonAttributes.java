package org.superheroes_pack.entity_pack;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CommonAttributes {
    @Id //-Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // - AUTO_INCREMENT
    Integer id;
    @Column(name = "name", nullable = false, unique = true, length = 45)
    String name;
}
