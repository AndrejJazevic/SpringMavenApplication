package com.maven.repository;

import com.maven.entity.Item;

import java.util.List;

public interface ItemRepository{
    List<Item> findAllItems();
}
