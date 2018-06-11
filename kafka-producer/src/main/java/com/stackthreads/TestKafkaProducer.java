package com.stackthreads;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class TestKafkaProducer {

	/** The props. */
	private static Properties props = new Properties();

	/** The producer. */
	/** producer generics can be of any type (key value) */
	private Producer<String, String> producer = null;

	public TestKafkaProducer() {
		// Must: bootstrap server where messages has to produced
		props.put("bootstrap.servers", "localhost:9092");
		// Must: key serializer to be used for serialization of key
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		// Must: value serializer to be used for serialization of value
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		producer = new KafkaProducer<String, String>(props);
	}

	public void sendMessage(String message) {
		try {
			producer.send(new ProducerRecord<String, String>("test.topic", message)).get();
		} catch (InterruptedException | ExecutionException e) {

			e.printStackTrace();
		}
	}

}
