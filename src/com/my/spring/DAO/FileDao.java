package com.my.spring.DAO;

import com.my.spring.model.FileEntity;
import com.my.spring.utils.DataWrapper;

import java.util.List;

/**
 * Created by nixinan on 2017/2/14.
 */
public interface FileDao {
    boolean addFile(FileEntity file);
    boolean deleteFile(Long fileId);
    boolean updateFile(FileEntity file);
    DataWrapper<List<FileEntity>> findByType(Integer type,Integer numPerPage,Integer pageNum);
    FileEntity getFileById(Long id);
    List<FileEntity> getFileByIds(String ids);
}
