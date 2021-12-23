package ru.andri.simplepdm.item.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.andri.simplepdm.item.dto.ItemDto;
import ru.andri.simplepdm.item.dto.ItemEditDto;


public interface ItemService {

    Page<ItemDto> findAllItems(Pageable pageable);

    ItemDto byId(Long itemId);

    ItemDto createItem(ItemEditDto itemEditDto);

    ItemDto updateItem(ItemEditDto itemEditDto, Long itemId);

    void deleteItem(Long itemId);

}
