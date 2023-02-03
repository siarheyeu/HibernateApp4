package ru.alishev.springcourse.repositories;


import org.springframework.stereotype.Repository;
import ru.alishev.springcourse.models.Item;
import ru.alishev.springcourse.models.Person;

import java.util.List;

@Repository
public interface ItemsRepository extends JpaRepository<Item, Integer>{
    List<Item> findByItemName(String itemName);

    //person.getItems()
    List<Item> findByOwner(Person owner);
}
