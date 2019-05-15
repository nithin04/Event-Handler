package com.event.beans.model;

import javax.ws.rs.QueryParam;

public class Events {
	
	@QueryParam("category")
	private String category;
	@QueryParam("pricingmodel")
	private String pricing_model;
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * @return the pricing_model
	 */
	public String getPricing_model() {
		return pricing_model;
	}
	/**
	 * @param pricing_model the pricing_model to set
	 */
	public void setPricing_model(String pricing_model) {
		this.pricing_model = pricing_model;
	}
	

}
