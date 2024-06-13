package com.blogspot.terminalcoders.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import java.util.Properties;
import java.util.function.Consumer;

@Component
public class KafkaProperties {
  @Autowired
  private Environment env;

  @Value("${kafka.topic}")
  String topic;

  @Value("${kafka.broker}")
  String broker;

  @Value("${kafka.keydeserializerclass}")
  String keyDeserializerClass;

  @Value("${kafka.valdeserializerclass}")
  String valDerializerClass;

  @Value("${kafka.group}")
  String group;

  @Autowired
  public Properties properties;



  public String getBroker() {
    return broker;
  }

  public String getKeyDeserializerClass() {
    return keyDeserializerClass;
  }

  public String getValDerializerClass() {
    return valDerializerClass;
  }

  public String getGroup() {
    return group;
  }

  public String getTopic() {
    return topic;
  }

//  @Value("$kafka.topic")
//  String topic;
//
//  @Value("$kafka.group")
//  String group;

  public Properties getProperties() {
    System.out.println("AKP - " + broker);
    properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, broker);
    properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, keyDeserializerClass);
    properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, valDerializerClass);
    properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, group);
    return properties;
  }
}
