package com.example.notesapp.notesapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Note implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String titleNote;
    private String descNote;

    public Note(Long id, String titleNote, String descNote) {
        this.id = id;
        this.titleNote = titleNote;
        this.descNote = descNote;
    }

    public Note() {

    }

    public Long getId() {
        return id;
    }

    public String getTitleNote() {
        return titleNote;
    }

    public String getDescNote() {
        return descNote;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitleNote(String titleNote) {
        this.titleNote = titleNote;
    }

    public void setDescNote(String descNote) {
        this.descNote = descNote;
    }

    @Override
    public String toString(){
        return "Note{" +
                "id="+id+
                ", name='"+ titleNote + '\''+
                ", email='"+ descNote + '\''+
                '}';
    }
}
