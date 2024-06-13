package com.blogspot.terminalcoders.service;

import com.blogspot.terminalcoders.repo.Employee;
import com.blogspot.terminalcoders.serializers.EmployeeDeserializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaListenerService {
  @KafkaListener(topics = "${kafka.topic}", groupId = "${kafka.group}", properties = {
      ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG + "=${kafka.valdeserializerclass}" })
  public void consumeMessage(Employee employee) {
    System.out.println("AKP # From Listener");
    System.out.println(employee.toString());
  }
}
