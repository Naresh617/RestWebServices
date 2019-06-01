package com.apspdcl.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.apspdcl.modal.Item;

@Repository
public class ItemRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	//Getting all items from table 
	public List<Item> getAllItems()
	{
		return jdbcTemplate.query("select id,name,category from item",(result,rowNum)->new Item(result.getInt("id"), result.getString("name"), result.getString("category")));
	}
	
	public Item getItemById(int id)
	{
		return jdbcTemplate.queryForObject("select * from item where id=?",new Object[]{id}, new BeanPropertyRowMapper<>(Item.class));
	}

}
