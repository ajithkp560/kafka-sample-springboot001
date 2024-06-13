package com.blogspot.terminalcoders.serializers;

import com.blogspot.terminalcoders.repo.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;

import java.nio.ByteBuffer;
import java.util.Map;

public class EmployeeDeserializer  implements Deserializer<Employee> {
  private ObjectMapper objectMapper = new ObjectMapper();
  @Override
  public void configure(Map<String, ?> configs, boolean isKey) {
    Deserializer.super.configure(configs, isKey);
  }

  @Override
  public Employee deserialize(String s, byte[] bytes) {
    return null;
  }

  @Override
  public Employee deserialize(String topic, Headers headers, byte[] data) {
    return Deserializer.super.deserialize(topic, headers, data);
  }

  @Override
  public Employee deserialize(String topic, Headers headers, ByteBuffer data) {
    return Deserializer.super.deserialize(topic, headers, data);
  }

  @Override
  public void close() {
    Deserializer.super.close();
  }
}
