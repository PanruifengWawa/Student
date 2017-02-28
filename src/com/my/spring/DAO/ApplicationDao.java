package com.my.spring.DAO;

import java.util.List;

import com.my.spring.model.ApplicationEntity;
import com.my.spring.utils.DataWrapper;

public interface ApplicationDao {
	boolean addApplication(ApplicationEntity applicationEntity);
	boolean handleApplication(Long applicationId,Integer state);
	DataWrapper<List<ApplicationEntity>> getApplicationList(Long itemsid,Integer state);

}
