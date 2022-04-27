package com.udacity.jwdnd.course1.cloudstorage.mappers;

import com.udacity.jwdnd.course1.cloudstorage.models.File;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FileMapper {

    //Insert the files
    @Insert("INSERT INTO FILES(" +
            "filename, " +
            "contenttype, " +
            "filesize, " +
            "filedata, " +
            "userid) VALUES (" +
            "#{filename}, " +
            "#{contenttype}, " +
            "#{filesize}, " +
            "#{filedata}, " +
            "#{userid})")
    @Options(useGeneratedKeys = true, keyProperty = "fileid")
    int insert(File file);
    //Get all FILES
    @Select("SELECT * FROM FILES")
    List<File> getAllFiles();

    //Get File by fileid
    @Select("SELECT * FROM FILES WHERE fileid = #{fileid}")
    File getFileById(Integer fileid);

    //Delete File by fileid
    @Delete("DELETE FROM FILES WHERE fileid = #{fileid}")
    void delete(Integer fileid);

    //Delete All Files
    @Delete("DELETE FROM FILES")
    void deleteAll();

}
