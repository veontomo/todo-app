package com.veontomo.todo.persistence;

import java.util.ArrayList;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

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
        return new ArrayList<Item>();
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
