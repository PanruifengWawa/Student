package com.my.spring.DAO;

import com.my.spring.utils.DataWrapper;
import com.my.spring.model.PostsEntity;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by nixinan on 2017/1/17.
 */
public interface PostsDao {
    boolean add(PostsEntity posts);
    boolean delete(Long postsId);
    boolean readPost(Long postsId);
    DataWrapper<List<PostsEntity>> getPostsList(Integer numPerPage,Integer pageNum,String theme,String title, String startTime, String endTime);
    PostsEntity getPosts(Long postsId);
    BigInteger getPostCount();
    BigInteger getTodayPostCount();
}
