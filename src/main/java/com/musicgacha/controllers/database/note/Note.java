package com.musicgacha.controllers.database.note;

import com.musicgacha.controllers.database.person.Person;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="person_id")
    private Person person;

    @NotNull
    @Column(columnDefinition="TEXT")
    private String text;
}

