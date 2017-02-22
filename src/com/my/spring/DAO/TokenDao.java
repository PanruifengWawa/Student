package com.my.spring.DAO;
import com.my.spring.model.TokenEntity;
/**
 * Created by nixinan on 2017/2/14.
 */
public interface TokenDao {
    boolean addToken(TokenEntity token);
    boolean deleteToken(TokenEntity token);
    boolean updateToken(TokenEntity token);
    TokenEntity findByTokenString(String token);
    TokenEntity findByUserId(Long userid);
}
