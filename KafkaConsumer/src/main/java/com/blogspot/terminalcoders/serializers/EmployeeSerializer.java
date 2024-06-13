package com.blogspot.terminalcoders.serializers;

import com.blogspot.terminalcoders.repo.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class EmployeeSerializer implements Serializer<Employee> {
  private final ObjectMapper objectMapper = new ObjectMapper();
  @Override
  public void configure(Map<String, ?> configs, boolean isKey) {
    Serializer.super.configure(configs, isKey);
  }

  @Override
  public byte[] serialize(String s, Employee employee) {
    try {
      return objectMapper.writeValueAsBytes(employee);
    } catch (JsonProcessingException e) {
      return null;
    }
  }

  @Override
  public byte[] serialize(String topic, Headers headers, Employee data) {
    return Serializer.super.serialize(topic, headers, data);
  }

  @Override
  public void close() {
    Serializer.super.close();
  }
}