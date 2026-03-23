package es.uma.informatica.daw.practicajpa.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "estado")
@Getter
@Setter
public class Pais {
    @Id
    private Long id;
    @Column(name = "nombre_pais")
    private String nombre;
    @Column(name = "nb_habitantes")
    private Long habitantes;
    @ManyToOne()
    private Federacion federacion;
    @ManyToMany()
    private Set<Pais> colindantes;
}
