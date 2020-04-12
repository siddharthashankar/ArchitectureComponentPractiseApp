package com.sid.architecture.component.retrofit.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MultipleResource {
    @SerializedName("page")
    public Integer page;
    @SerializedName("per_page")
    public Integer per_page;
    @SerializedName("total")
    public Integer total;
    @SerializedName("total_pages")
    public Integer total_pages;
    @SerializedName("data")
    public List<DataRecords> data = null;

    public class DataRecords{
        @SerializedName("name")
        public String name;
        @SerializedName("year")
        public Integer year;
        @SerializedName("color")
        public String color;
        @SerializedName("pantone_value")
        public String pantone_value;
    }
}

