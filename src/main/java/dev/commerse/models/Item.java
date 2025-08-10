package dev.commerse.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Item {
    private int itemID;
    private int vendorID;
    private float price;
    private String item_name;
    private String item_description;
    private int amount_sold;
    
}
