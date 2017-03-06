package com.my.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.my.spring.model.FileEntity;
import com.my.spring.service.FileService;
import com.my.spring.utils.DataWrapper;

/**
 * Created by Administrator on 2016/6/22.
 */
@Controller
@RequestMapping(value="api/file")
public class FileController {
	
//    @Autowired
//    FileService fileService;
//    @RequestMapping(value="uploadFile",method = RequestMethod.POST)
//    @ResponseBody
//    public DataWrapper<Void> uploadFile(
//            @RequestParam(value = "file", required = false) MultipartFile file,
//            HttpServletRequest request,
//            @RequestParam(value = "token",required = false) String token){
//        return fileService.uploadFile(request,file);
//    }
	@Autowired
	FileService fileService;
	@RequestMapping(value="materialUpload",method = RequestMethod.POST)
	@ResponseBody
	public DataWrapper<Void> uploadMaterial(
          @RequestParam(value = "file", required = false) MultipartFile file,
          @ModelAttribute FileEntity fileEntity,
          HttpServletRequest request,
          @RequestParam(value = "token",required = false) String token) {
		
		return fileService.uploadMaterial(file,fileEntity,request, token);
	}
	
	 @RequestMapping(value="getMaterialList",method = RequestMethod.GET)
	 @ResponseBody
	 public DataWrapper<List<FileEntity>> getMaterialList(
			 @RequestParam(value = "numperpage",required = false) Integer numPerPage,
	         @RequestParam(value = "pagenum",required = false) Integer pageNum) {
		 return fileService.getMaterialList(numPerPage,pageNum);
	 }	
	 
	 @RequestMapping(value="delete",method = RequestMethod.GET)
	 @ResponseBody
	 public DataWrapper<Void> deleteFile(
			 @RequestParam(value = "fileid",required = false) Long fileId,
			 @RequestParam(value = "token",required = false) String token) {
		 return fileService.deleteFile(fileId,token);
	 }	
	 
	 
	 @RequestMapping(value="upload",method = RequestMethod.POST)
	@ResponseBody
	public DataWrapper<String> upload(
	          @RequestParam(value = "file", required = false) MultipartFile file,
	          HttpServletRequest request,
	          @RequestParam(value = "token",required = false) String token) {
			
		return fileService.uploadFile(request, file, token);
	}
}
