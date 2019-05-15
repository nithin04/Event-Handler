/*package com.event.beans.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.event.beans.model.Product;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class ProductDeserializer implements Deserializer {
    public void close() {
    }

    public void configure(Map map, boolean b) {

    }

    public Product deserialize(String arg0, byte[] arg1) {
        ObjectMapper mapper = new ObjectMapper();
        Product product = null;
        try {
            product = mapper.readValue(arg1, Product.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }
}*/