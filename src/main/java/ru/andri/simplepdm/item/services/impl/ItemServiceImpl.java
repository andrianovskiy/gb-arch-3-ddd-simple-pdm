package ru.andri.simplepdm.item.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.andri.simplepdm.item.dao.ItemRepository;
import ru.andri.simplepdm.item.dao.entities.Item;
import ru.andri.simplepdm.item.dto.ItemDto;
import ru.andri.simplepdm.item.dto.ItemEditDto;
import ru.andri.simplepdm.item.mappers.ItemMapper;
import ru.andri.simplepdm.item.services.ItemService;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    @Override
    public Page<ItemDto> findAllItems(Pageable pageable) {
        return itemRepository.findAll(pageable)
                .map(itemMapper::entityToItemDto);
    }

    @Override
    public ItemDto byId(Long itemId) {
        return itemRepository.findById(itemId)
                .map(itemMapper::entityToItemDto)
                .orElseThrow(() -> new NoSuchElementException("item.not.found.exception"));
    }

    @Override
    public ItemDto createItem(ItemEditDto itemEditDto) {
        Item item = itemMapper.itemEditDtoToEntity(itemEditDto, null);
        item = itemRepository.save(item);
        return itemMapper.entityToItemDto(item);
    }

    @Override
    public ItemDto updateItem(ItemEditDto itemEditDto, Long itemId) {
        Item item = itemMapper.itemEditDtoToEntity(itemEditDto, itemId);
        item = itemRepository.save(item);
        return itemMapper.entityToItemDto(item);
    }

    @Override
    public void deleteItem(Long itemId) {
        itemRepository.deleteById(itemId);
    }

}
