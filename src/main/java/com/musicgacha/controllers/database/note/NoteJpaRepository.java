package com.musicgacha.controllers.database.note;

import com.musicgacha.controllers.database.person.Person;
import com.musicgacha.controllers.database.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteJpaRepository extends JpaRepository<Note, Long> {
    List<Note> findAllByPerson(Person p);
}
