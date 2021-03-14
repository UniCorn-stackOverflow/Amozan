package org.example.Model;

import javafx.scene.image.Image;

public class Item
{
    private String name;
    private double price;
    private Image pictureOfItem;
    public Item(String name, double price, Image pictureOfItem)
    {
        this.name = name;
        this.price = price;
        this.pictureOfItem = pictureOfItem;
    }
}
