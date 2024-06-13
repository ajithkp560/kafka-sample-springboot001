package com.blogspot.terminalcoders.service;

import com.blogspot.terminalcoders.repo.Employee;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.blogspot.terminalcoders.config.KafkaProperties;

@Service
public class KafkaService {


  @Autowired
  KafkaProperties kafkaProperties;

  @Value("${kafka.topic}")
  String topicName;

  public KafkaService() {
  }

  public boolean sendEmployeeData(Employee employee) {
    try {
      Producer<Long, Employee> producer = new KafkaProducer<Long, Employee> (kafkaProperties.getProperties());
      producer.send(new ProducerRecord<Long, Employee>(topicName, employee.getId(), employee ));
      producer.close();
    } catch (Exception ex) {
      ex.printStackTrace();
      return false;
    }
    return true;
  }
}
