package com.udacity.jwdnd.course1.cloudstorage.mappers;

import com.udacity.jwdnd.course1.cloudstorage.models.Note;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoteMapper {
    //Get all notes
    @Select("SELECT * FROM NOTES")
    List<Note> getAllNotes();

    //Get Notes by noteid
    @Select("SELECT * FROM NOTES WHERE noteid = #{noteid}")
    Note getNoteById(Integer noteid);

    //Insert Notes and PK noteid
    @Insert("INSERT INTO NOTES(notetitle, notedescription, userid) VALUES (" +
            "#{notetitle}, #{notedescription), #{userid}")
    @Options(useGeneratedKeys = true, keyProperty = "noteid")
    int insert(Note note);

    //Delete Notes by noteid
    @Delete("DELETE FROM NOTES WHERE noteid = #{noteid}")
    void delete(Integer noteid);

    //Delete All Notes
    @Delete("DELETE FROM NOTES")
    void deleteAll();
}
