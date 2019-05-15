package com.event.beans.service;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.event.beans.model.Events;
import com.event.beans.model.PricingModel;
import com.event.beans.model.Product;

public class DBConnector {
    private static Connection connection = null;
    
    private static Connection retunConnection=null;

    private final static String QUERY = "insert into event_org values(?,?,?,?,?)";
    
    private final static String Return_QUERY = "SELECT pricing_model,avg(price) as avgprice FROM wawa_events.event_org where category=? group by pricing_model";

    private DBConnector() {
    }

    public static Connection createConnection(Connection connection){
        if(connection == null){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                connection= DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/wawa_events","root","Narsingarao4");
            }catch(Exception e){ System.out.println(e);}
        }
        return connection;
    }

    public static boolean dbcommit(Product product) throws Exception {
        connection = createConnection(connection);
        PreparedStatement stmt=connection.prepareStatement(QUERY);
        stmt.setInt(1,product.getId());
        stmt.setString(2,product.getCategory());
        stmt.setDouble(3,product.getPrice());
        stmt.setString(4, product.getPricingModel());
        stmt.setString(5,product.getAttribute2());
        boolean result = stmt.execute();
//        connection.commit();
        return result;
    }
    
    public static java.util.List<PricingModel> avgprice(Events event) throws Exception {
		retunConnection = createConnection(retunConnection);
		PreparedStatement stmt=retunConnection.prepareStatement(Return_QUERY);
		//stmt.setString(1, product.getCategory());
		stmt.setString(1, event.getCategory());
		ResultSet result = stmt.executeQuery();
		java.util.List<PricingModel> pricingModels = new ArrayList<>();
		while(result.next()) {
			PricingModel pricing = new PricingModel();
			pricing.setPricingModel(result.getString(1));
			pricing.setAverage(result.getDouble(2));
			pricingModels.add(pricing);
		}
		return pricingModels;
	
    }
}
