package com.app.twitchly.service;

import com.app.twitchly.dao.FavoriteDao;
import com.app.twitchly.entity.db.Item;
import com.app.twitchly.entity.db.ItemType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteDao favoriteDao;

    public void setFavoriteItem(String userId, Item item) {
        favoriteDao.setFavoriteItem(userId, item);


    }

    // get item id (primary key) to delete
    public void unsetFavoriteItem(String userID, String itemId) {
        favoriteDao.unsetFavoriteItem(userID, itemId);

    }

    public Map<String, List<Item>> getFavoriteItems(String userId) {
        Map<String, List<Item>> itemMap = new HashMap<>();
        for (ItemType type : ItemType.values()) {
            itemMap.put(type.toString(), new ArrayList<>());
        }
        Set<Item> favorites = favoriteDao.getFavoriteItems(userId);
        for(Item item : favorites) {
            itemMap.get(item.getType().toString()).add(item);
        }
        return itemMap;

    }
}
