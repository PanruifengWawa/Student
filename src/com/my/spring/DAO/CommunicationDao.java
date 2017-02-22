package com.my.spring.DAO;

import com.my.spring.model.CommunicationEntity;
import com.my.spring.utils.DataWrapper;

import java.util.List;

/**
 * Created by nixinan on 2017/1/18.
 */
public interface CommunicationDao {
	 DataWrapper<List<CommunicationEntity>> getCommunicationList(Integer numPerPage, Integer pageNum, String theme, String title);
//    DataWrapper<List<CommunicationEntity>> getCommunicationList(Integer numPerPage,Integer pageNum,String theme,String title,String userName,Long replyQuantity,String contents);
}
