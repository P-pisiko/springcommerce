package dev.commerse.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Item {
    private int itemID;
    private int vendorID;
    private float price;
    private List<String> images_name;
    private String item_name;
    private String item_description;
    private int amount_sold;
    
}
