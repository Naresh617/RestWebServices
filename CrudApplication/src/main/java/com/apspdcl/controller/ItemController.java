package com.apspdcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.apspdcl.modal.Item;
import com.apspdcl.repository.ItemRepository;

@RestController
public class ItemController 
{
	@Autowired
	ItemRepository itemRepository;
	
	@GetMapping("/getAllItems")
	@ResponseBody
	public List<Item> getAllItems(){
        return itemRepository.getAllItems();
    }
	
	
	@GetMapping("/getItem")
	@ResponseBody
	public Item getItemById(@RequestParam("itemId") int itemId)
	{
		return itemRepository.getItemById(itemId);
	}
	
}
