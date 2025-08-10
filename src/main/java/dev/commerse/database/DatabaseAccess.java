package dev.commerse.database;


import dev.commerse.models.Item;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DatabaseAccess {

    private final NamedParameterJdbcTemplate jdbc;

    public DatabaseAccess(NamedParameterJdbcTemplate jdbc)
    {
        this.jdbc = jdbc;
    }

    public List<Item> getItemsList()
    {
        //MapSqlParameterSource params = new MapSqlParameterSource();
        String sql = "select * from item;";
        return  jdbc.query(sql,  new BeanPropertyRowMapper<Item>(Item.class));
    }
}
