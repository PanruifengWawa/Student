package com.my.spring.service;

import com.my.spring.model.PostsEntity;
import com.my.spring.utils.DataWrapper;
import java.util.List;
/**
 * Created by nixinan on 2017/1/17.
 */

public interface PostsService {
    DataWrapper<Void> add(PostsEntity posts,String token);
    DataWrapper<Void> delete(Long postsId,String token);
    DataWrapper<PostsEntity> getPostsById(Long postsId);
    DataWrapper<List<PostsEntity>> getPostsList(Integer numPerPage,Integer pageNum,String theme,String title, String startTime, String endTime);
}
