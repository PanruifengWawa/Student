package com.my.spring.DAO;
import com.my.spring.utils.DataWrapper;
import com.my.spring.model.ItemsEntity;
import java.util.List;
/**
 * Created by nixinan on 2017/1/18.
 */
public interface ItemsDao {
    boolean add(ItemsEntity items);
    boolean updateItem(ItemsEntity items);
    boolean delete(Long itemsid);
    boolean verify(Long itemsid,Long state);
    DataWrapper<List<ItemsEntity>> getItemsList(Integer numPerPage,Integer pageNum,String itemtype,String itemname, String teacher, String starttime, String endtime,Long type, Long state,Long userid, String projectdirection,String labels);
    ItemsEntity getItems(Long itemsid);
}
