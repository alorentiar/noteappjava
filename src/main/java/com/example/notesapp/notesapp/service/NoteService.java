package com.example.notesapp.notesapp.service;

import com.example.notesapp.notesapp.exception.NoteNotFoundException;
import com.example.notesapp.notesapp.model.Note;
import com.example.notesapp.notesapp.repo.NoteRepo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;

@Service

public class NoteService {
    private final NoteRepo noteRepo;

    @Autowired
    public NoteService(NoteRepo noteRepo){
        this.noteRepo = noteRepo;
    }

    public Note addNote(Note note){
        return noteRepo.save(note);
    }

    public List<Note> findAllNotes(){
        return noteRepo.findAll();
    }

    public Note updateNote(Note note){
        return noteRepo.save(note);
    }

    public Note findNoteByID(Long id){
        return noteRepo.findNoteById(id).orElseThrow(()->new NoteNotFoundException("Note by id"+ id +"was not found"));
    }
    @JsonIgnore
    public void deleteNote(Long id){
        noteRepo.deleteNoteById(id);
    }
}
