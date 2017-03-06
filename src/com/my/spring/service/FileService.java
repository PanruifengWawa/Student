package com.my.spring.service;

import com.my.spring.model.FileEntity;
import com.my.spring.utils.DataWrapper;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016/6/22.
 */
public interface FileService {
    DataWrapper<Void> uploadFile(HttpServletRequest request,MultipartFile file);
    DataWrapper<Void> uploadMaterial(MultipartFile file,FileEntity fileEntity,HttpServletRequest request,String token);
    DataWrapper<List<FileEntity>> getMaterialList(Integer numPerPage,Integer pageNum);
    DataWrapper<Void> deleteFile(Long fileId,String token);
    DataWrapper<String> uploadFile(HttpServletRequest request,MultipartFile file,String token);
}
