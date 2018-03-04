package com.assignment.travel.model;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Carousel {

    public List<Images> images = new ArrayList<>();
    public String product;

    @SerializedName("sub_title")
    public String subTitle;
    public String callback;
    @SerializedName("tag_text")
    public String tagText;

    public Integer id;
    public String title;
    public String type;



}
