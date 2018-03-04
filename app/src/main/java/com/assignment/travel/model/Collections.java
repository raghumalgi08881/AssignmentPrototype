package com.assignment.travel.model;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Collections {
    @SerializedName("vibrant_color")
    public String vibrantColor;
    @SerializedName("count_text")
    public String countText;
    public String image;
    public Integer id;
   public List<String> categories = new ArrayList<>();

    public String collection_name;

}
