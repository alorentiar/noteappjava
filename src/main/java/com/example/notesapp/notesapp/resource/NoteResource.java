package com.example.notesapp.notesapp.resource;

import com.example.notesapp.notesapp.model.Note;
import com.example.notesapp.notesapp.service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
public class NoteResource {

    private final NoteService noteService;


    public NoteResource(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Note>> getAllNotes(){
        List<Note> notes = noteService.findAllNotes();
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable("id") Long id){
        Note note = noteService.findNoteByID(id);
        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Note> addNote(@RequestBody Note note){
        Note newNote = noteService.addNote(note);
        return new ResponseEntity<>(newNote, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Note> updateNote(@RequestBody Note note){
        Note updateNote = noteService.updateNote(note);
        return new ResponseEntity<>(updateNote, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable("id") Long id){
        noteService.deleteNote(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
