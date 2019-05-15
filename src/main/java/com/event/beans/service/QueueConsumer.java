package com.event.beans.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.event.beans.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

/*package com.event.beans.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.event.beans.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@DependsOn({"eventRestController"})
public class QueueConsumer {
	
	public QueueConsumer() {
		Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "test");
        props.put("enable.auto.commit", "false");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
        consumer.subscribe(Arrays.asList("my-topic"));
        initiateListener(consumer);
	}
	
	@Async
	private void initiateListener(KafkaConsumer<String, String> consumer) {
		List<ConsumerRecord<String, String>> buffer = new ArrayList<ConsumerRecord<String, String>>();
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                ObjectMapper mapper = new ObjectMapper();
                Product product = null;
                try {
                    product = mapper.readValue(record.value(), Product.class);
                    DBConnector.dbcommit(product);
                    System.out.println(DBConnector.avgprice(product));
                } catch (Exception e) {
                    e.printStackTrace();
                }
//                Connection connection = DBConnector.createConnection();
//                System.out.println(product);
            }
        }
	}
	
}
*/

@Service
public class QueueConsumer {

    private final Logger logger = LoggerFactory.getLogger(Producer.class);

    @KafkaListener(topics = "my-topic", groupId = "group_id")
    public void consume(String message) throws IOException {
        logger.info(String.format("#### -> Consumed message -> %s", message));
        ObjectMapper mapper = new ObjectMapper();
        Product product = null;
        try {
            product = mapper.readValue(message, Product.class);
            DBConnector.dbcommit(product);
//            System.out.println(DBConnector.avgprice(product));
        } catch (Exception e) {
            e.printStackTrace();
        }
//        Connection connection = DBConnector.createConnection();
//        System.out.println(product);
    }
}