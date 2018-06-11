package com.stackthreads;

/**
 * 
 * @author nverma4
 *
 */
public class TestProducer {

	public static void main(String[] args) {
		TestKafkaProducer producer = new TestKafkaProducer();
		producer.sendMessage("hello");
		System.out.println("sent");
	}
}
