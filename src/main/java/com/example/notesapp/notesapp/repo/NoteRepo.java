package com.example.notesapp.notesapp.repo;

import com.example.notesapp.notesapp.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NoteRepo extends JpaRepository<Note, Long> {
    void deleteNoteById(Long id);

    Optional<Note> findNoteById(Long id);
}
