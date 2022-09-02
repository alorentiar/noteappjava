package com.example.notesapp.notesapp.exception;

public class NoteNotFoundException extends RuntimeException{
    public NoteNotFoundException(String s) {
        super(s);
    }
}
