package ru.andri.simplepdm.item.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.andri.simplepdm.item.dto.ItemDto;
import ru.andri.simplepdm.item.dto.ItemEditDto;
import ru.andri.simplepdm.item.services.ItemService;

@RestController
@RequestMapping("/v1/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping()
    public Page<ItemDto> getItems(Pageable pageable) {
        return itemService.findAllItems(pageable);
    }

    @GetMapping(value = "/{itemId}")
    public ItemDto getItem(@PathVariable Long itemId) {
        return itemService.byId(itemId);
    }

    @PostMapping()
    public ItemDto createItem(@RequestBody ItemEditDto itemEditDto) {
        return itemService.createItem(itemEditDto);
    }

    @PutMapping("/{itemId}")
    public ItemDto updateItem(@RequestBody ItemEditDto itemEditDto, @PathVariable Long itemId) {
        return itemService.updateItem(itemEditDto, itemId);
    }

    @DeleteMapping(value = "/{itemId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteItem(@PathVariable Long itemId) {
        itemService.deleteItem(itemId);
    }


}
