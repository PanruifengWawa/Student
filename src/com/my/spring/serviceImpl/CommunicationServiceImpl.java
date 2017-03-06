package com.my.spring.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.spring.DAO.CommentDao;
import com.my.spring.DAO.CommunicationDao;
import com.my.spring.DAO.PostsDao;
import com.my.spring.model.CommentEntity;
import com.my.spring.model.CommunicationCounts;
import com.my.spring.model.CommunicationEntity;
import com.my.spring.service.CommunicationService;
import com.my.spring.utils.DataWrapper;

/**
 * Created by nixinan on 2017/1/18.
 */
@Service("communicationService")
public class CommunicationServiceImpl implements CommunicationService {
    @Autowired
    CommunicationDao communicationDao;
    
    @Autowired
    CommentDao commentDao;
    
    @Autowired
    PostsDao postsDao;
    
    @Override
    public DataWrapper<List<CommunicationEntity>> getCommunicationList(Integer numPerPage, Integer pageNum, String theme, String title,Integer state) {
    	DataWrapper<List<CommunicationEntity>> dataWrapper = communicationDao.getCommunicationList(numPerPage, pageNum, theme, title,state);
    	for(CommunicationEntity communicationEntity: dataWrapper.getData()) {
    		communicationEntity.setReplyCount(commentDao.getCommentCount(communicationEntity.getPostsId()));
    		CommentEntity commentEntity = commentDao.getLatestCommentByPostsid(communicationEntity.getPostsId());
    		if (commentEntity != null) {
    			communicationEntity.setReplyTime(commentEntity.getTime());
        		communicationEntity.setReplyContents(commentEntity.getContents());
			}
    	}
    	
    	return dataWrapper;
    }
	@Override
	public DataWrapper<CommunicationCounts> getCount() {
		// TODO Auto-generated method stub
		DataWrapper<CommunicationCounts> dataWrapper = new DataWrapper<CommunicationCounts>();
		CommunicationCounts communicationCounts = new CommunicationCounts();
		communicationCounts.setAllCommentCount(commentDao.getCommentCount(null));
		communicationCounts.setAllPostCount(postsDao.getPostCount());
		communicationCounts.setTodayPostCount(postsDao.getTodayPostCount());
		dataWrapper.setData(communicationCounts);
		return dataWrapper;
	}
}
