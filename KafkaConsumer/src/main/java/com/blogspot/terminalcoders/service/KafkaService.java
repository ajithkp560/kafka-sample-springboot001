package com.blogspot.terminalcoders.service;

import com.blogspot.terminalcoders.repo.Employee;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.blogspot.terminalcoders.config.KafkaProperties;

import java.util.Arrays;

@Service
public class KafkaService {

  @Autowired
  KafkaProperties kafkaProperties;

  @Value("${kafka.topic}")
  String topicName;

  public KafkaService() {
  }

  public void getEmployeeData() {
    KafkaConsumer<Long, Employee> consumer = new KafkaConsumer<Long, Employee>(kafkaProperties.getProperties());
    try {
      consumer.subscribe(Arrays.asList(topicName));
      while(true) {
        ConsumerRecords<Long, Employee> records = consumer.poll(100);
        for (ConsumerRecord<Long, Employee> record : records) {
          System.out.printf("AKP # offset = %d, key = %s, value = %s\n",
              record.offset(), record.key(), record.value());
        }
      }

    } catch (Exception ex) {
      ex.printStackTrace();
    }
    finally {
      consumer.close();
    }
  }
}
