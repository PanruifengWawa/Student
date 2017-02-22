package com.my.spring.DAO;
import java.math.BigInteger;
import java.util.List;

import com.my.spring.model.CommentEntity;
import com.my.spring.utils.DataWrapper;
/**
 * Created by nixinan on 2017/1/17.
 */
public interface CommentDao {
    boolean add(CommentEntity comment);
    boolean delete(Long commentid);
    BigInteger getCommentCount(Long postsid);
    CommentEntity getLatestCommentByPostsid(Long postsid);
    DataWrapper<List<CommentEntity>> getByPostId(Integer numPerPage, Integer pageNum,Long postsId);

}
