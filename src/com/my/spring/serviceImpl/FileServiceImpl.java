package com.my.spring.serviceImpl;

import com.my.spring.DAO.FileDao;
import com.my.spring.enums.ErrorCodeEnum;
import com.my.spring.model.FileEntity;
import com.my.spring.model.UserEntity;
import com.my.spring.service.FileService;
import com.my.spring.utils.DataWrapper;
import com.my.spring.utils.MD5Util;
import com.my.spring.utils.SessionManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * Created by Administrator on 2016/6/22.
 */
@Service("fileService")
public class FileServiceImpl implements FileService{
	
	@Autowired
	FileDao fileDao;
	
    @Override
    public DataWrapper<Void> uploadFile(HttpServletRequest request, MultipartFile file) {
        DataWrapper<Void> retDataWrapper = new DataWrapper<Void>();
        String filePath = request.getSession().getServletContext().getRealPath("/") + "upload";
        String newFileName = MD5Util.getMD5String(file.getOriginalFilename() + new Date() + UUID.randomUUID().toString()).replace(".","")
                    + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

        File fileDir = new File(filePath);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        try {
            FileOutputStream out = new FileOutputStream(filePath + "\\"
                    + newFileName);
                // 写入文件
            out.write(file.getBytes());
            out.flush();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
            retDataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return retDataWrapper;
    }

	@Override
	public DataWrapper<Void> uploadMaterial(MultipartFile file, FileEntity fileEntity, HttpServletRequest request,
			String token) {
		DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
		UserEntity userEntity = SessionManager.getSession(token);
        if (userEntity == null || fileEntity ==null) {
        	dataWrapper.setErrorCode(ErrorCodeEnum.Error);
		} else {
			String filePath = request.getSession().getServletContext().getRealPath("/") + "/material/";
			String newFileName = MD5Util.getMD5String(file.getOriginalFilename() + new Date() + UUID.randomUUID().toString()).replace(".","")
                    + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

			File fileDir = new File(filePath);
			if (!fileDir.exists()) {
				fileDir.mkdirs();
			}
			try {
	            FileOutputStream out = new FileOutputStream(filePath + newFileName);
	                // 写入文件
	            out.write(file.getBytes());
	            out.flush();
	            out.close();
			} catch (Exception e) {
	            e.printStackTrace();
	            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
	        }
			fileEntity.setSrc("/material/" + newFileName);
			fileEntity.setType(0);
			if (!fileDao.addFile(fileEntity)) {
				dataWrapper.setErrorCode(ErrorCodeEnum.Error);
			}

		}
		return dataWrapper;
	}

	@Override
	public DataWrapper<List<FileEntity>> getMaterialList(Integer numPerPage,Integer pageNum) {
		// TODO Auto-generated method stub
		return fileDao.findByType(0, numPerPage, pageNum);
	}

	@Override
	public DataWrapper<Void> deleteFile(Long fileId, String token) {
		// TODO Auto-generated method stub
		DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
		UserEntity userEntity = SessionManager.getSession(token);
        if (userEntity == null) {
        	dataWrapper.setErrorCode(ErrorCodeEnum.Error);
		} else {
			if (!fileDao.deleteFile(fileId)) {
				dataWrapper.setErrorCode(ErrorCodeEnum.Error);
			}
		}
        
        return dataWrapper;
	}

	@Override
	public DataWrapper<String> uploadFile(HttpServletRequest request, MultipartFile file, String token) {
		// TODO Auto-generated method stub
		DataWrapper<String> dataWrapper = new DataWrapper<String>();
		UserEntity userEntity = SessionManager.getSession(token);
        if (userEntity == null || file == null) {
        	dataWrapper.setErrorCode(ErrorCodeEnum.Error);
		} else {
			String filePath = request.getSession().getServletContext().getRealPath("/") + "/upload_files/";
			String newFileName = MD5Util.getMD5String(file.getOriginalFilename() + new Date() + UUID.randomUUID().toString()).replace(".","")
                    + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

			File fileDir = new File(filePath);
			if (!fileDir.exists()) {
				fileDir.mkdirs();
			}
			try {
	            FileOutputStream out = new FileOutputStream(filePath + newFileName);
	                // 写入文件
	            out.write(file.getBytes());
	            out.flush();
	            out.close();
	            dataWrapper.setData("/upload_files/" + newFileName);
			} catch (Exception e) {
	            e.printStackTrace();
	            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
	        }
			

		}
		return dataWrapper;
	}
}
