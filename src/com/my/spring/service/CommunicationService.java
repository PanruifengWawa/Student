package com.my.spring.service;

import com.my.spring.model.CommunicationCounts;
import com.my.spring.model.CommunicationEntity;
import com.my.spring.utils.DataWrapper;

import java.util.List;

/**
 * Created by nixinan on 2017/1/18.
 */
public interface CommunicationService {
	DataWrapper<CommunicationCounts> getCount();
    DataWrapper<List<CommunicationEntity>> getCommunicationList(Integer numPerPage,Integer pageNum,String theme,String title);
}
