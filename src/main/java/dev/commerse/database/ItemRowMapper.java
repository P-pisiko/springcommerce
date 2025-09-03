package dev.commerse.database;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.commerse.models.Item;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ItemRowMapper implements RowMapper<Item> {
    private final ObjectMapper objectMapper = new ObjectMapper();
    // delegate to let Spring map the simple fields
    private final BeanPropertyRowMapper<Item> delegate = new BeanPropertyRowMapper<>(Item.class);

    @Override
    public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
        // let the delegate populate basic fields
        Item item = delegate.mapRow(rs, rowNum);

        // handle JSON column
        String json = rs.getString("images_name");
        if (json != null && !json.isBlank()) {
            try {
                List<String> images = objectMapper.readValue(json, new TypeReference<List<String>>() {});
                item.setImages_name(images); // use setImagesName(...) if you renamed the field
            } catch (Exception ex) {
                // fallback to empty list on parse error
                item.setImages_name(new ArrayList<>());
            }
        } else {
            item.setImages_name(new ArrayList<>());
        }

        return item;
    }
}
