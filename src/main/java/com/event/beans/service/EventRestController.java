package com.event.beans.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.BeanParam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.event.beans.model.Events;
import com.event.beans.model.MovingAvg;
import com.event.beans.model.PricingModel;

@RestController
public class EventRestController {

	@RequestMapping("/event")
	public MovingAvg geteventcategory(@BeanParam Events events) {
		MovingAvg movingAvg = null;
		try {
			movingAvg = new MovingAvg();
			List<PricingModel> pricingModels = DBConnector.avgprice(events);
			movingAvg.setCategory(events.getCategory());
//			ArrayList<PricingModel> pricingModels = new ArrayList<>();
			movingAvg.setPricingModels(pricingModels);
		} catch (Exception e) {
			
		}
		return movingAvg;
	}

}
