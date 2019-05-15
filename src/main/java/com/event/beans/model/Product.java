package com.event.beans.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class Product
{

    private Integer id;
    private String category;
    private double price;
    @JsonProperty("pricing_model")
    private String pricingModel;
    private String attribute2;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPricingModel() {
        return pricingModel;
    }

    public void setPricingModel(String pricingModel) {
        this.pricingModel = pricingModel;
    }

    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", pricingModel='" + pricingModel + '\'' +
                ", attribute2='" + attribute2 + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}