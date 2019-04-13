package com.veontomo.todo.persistence;

import java.util.ArrayList;
import java.sql.Date;

import com.veontomo.todo.model.Item;
import com.veontomo.todo.model.ItemStatus;
import com.veontomo.todo.model.User;

/**
 * Implementation of {@link ItemRepository}.
 * 
 * It is a in-memory implementation of a repository.
 * @author Andrew
 *
 */
public class ItemRepositoryImpl implements ItemRepository {

    @Override
    public Iterable<Item> getAll() {
        // TODO Auto-generated method stub
        return new ArrayList<Item>(3) {{
            add(new Item(1l, "todo app", "finish the app", ItemStatus.INPROGRESS, new Date(System.currentTimeMillis()), new User()));
            add(new Item(2l, "add tests", "finish the app", ItemStatus.INPROGRESS, new Date(System.currentTimeMillis()), new User()));
            add(new Item(3l, "add actuators", "finish the app", ItemStatus.INPROGRESS, new Date(System.currentTimeMillis()), new User()));
        }};
    }

    @Override
    public Item save(Item item) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Item findById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        // TODO Auto-generated method stub
        return false;
    }

}
