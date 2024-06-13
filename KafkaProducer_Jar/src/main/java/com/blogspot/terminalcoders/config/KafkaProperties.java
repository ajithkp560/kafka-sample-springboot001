package com.blogspot.terminalcoders.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import java.util.Properties;

@Component
public class KafkaProperties {
  @Autowired
  private Environment env;

  @Value("${kafka.broker}")
  String broker;

  @Value("${kafka.keyserializerclass}")
  String keySerializerClass;

  @Value("${kafka.valserializerclass}")
  String valSerializerClass;

  @Autowired
  public Properties properties;

//  @Value("$kafka.topic")
//  String topic;
//
//  @Value("$kafka.group")
//  String group;

  public Properties getProperties() {
    System.out.println("AKP - " + broker);
    properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, broker);
    properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, keySerializerClass);
    properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, valSerializerClass);
    return properties;
  }
}
