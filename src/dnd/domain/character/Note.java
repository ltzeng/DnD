package dnd.domain.character;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class Note {

    private int noteID;
    private String title;
    private String note;
    private Timestamp date;
    
    public int getNoteID() {
        return noteID;
    }
    public void setNoteID(int noteID) {
        this.noteID = noteID;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Timestamp getDate() {
        return date;
    }
    public void setDate(Timestamp date) {
        this.date = date;
    }
    
    
}
