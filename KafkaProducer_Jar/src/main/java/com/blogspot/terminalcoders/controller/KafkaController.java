package com.blogspot.terminalcoders.controller;

import com.blogspot.terminalcoders.repo.Employee;
import com.blogspot.terminalcoders.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class KafkaController {
  @Autowired
  KafkaService kafkaService;

  @PostMapping("/employees")
  public boolean sendEmployee(@RequestBody Employee newEmployee) {
    return kafkaService.sendEmployeeData(newEmployee);
  }

  @GetMapping("/index")
  public boolean index() {
    return true;
  }
}
