package ru.andri.simplepdm.item.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.andri.simplepdm.item.dao.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}