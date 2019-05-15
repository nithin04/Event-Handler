package com.event.beans.model;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovingAvg {
	
	private String category;
//	private String standard;
	private List<PricingModel> pricingModels = null;
//	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public String getCategory() {
	return category;
	}

	public void setCategory(String category) {
	this.category = category;
	}

	public List<PricingModel> getPricingModels() {
	return pricingModels;
	}

	public void setPricingModels(List<PricingModel> pricingModels) {
	this.pricingModels = pricingModels;
	}

	}


