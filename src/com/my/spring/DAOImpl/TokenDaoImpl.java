package com.my.spring.DAOImpl;

import com.my.spring.DAO.BaseDao;
import com.my.spring.DAO.TokenDao;
import com.my.spring.model.TokenEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by nixinan on 2017/2/14.
 */
public class TokenDaoImpl extends BaseDao<TokenEntity> implements TokenDao
{
    @Override
    public boolean addToken(TokenEntity token) {
        return save(token);
    }

    @Override
    public boolean deleteToken(TokenEntity token) {
        return delete(token);
    }

    @Override
    public boolean updateToken(TokenEntity token) {
        return update(token);
    }

    @Override
    public TokenEntity findByTokenString(String token) {
        Session session = getSession();
        Criteria criteria = session.createCriteria(TokenEntity.class);
        criteria.add(Restrictions.eq("token", token));
        List<TokenEntity> result = criteria.list();
        if (result != null && result.size() > 0) {
            return (TokenEntity) result.get(0);
        }
        return null;
    }

    @Override
    public TokenEntity findByUserId(Long userid) {
        Session session = getSession();
        Criteria criteria = session.createCriteria(TokenEntity.class);
        criteria.add(Restrictions.eq("userid", userid));
        List<TokenEntity> result = criteria.list();
        if (result != null && result.size() > 0) {
            return (TokenEntity) result.get(0);
        }
        return null;
    }
}
