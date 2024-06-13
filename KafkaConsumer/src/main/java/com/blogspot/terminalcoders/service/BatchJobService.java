package com.blogspot.terminalcoders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BatchJobService {

  @Autowired
  KafkaService kafkaService;

  @EventListener(ApplicationReadyEvent.class)
  public void getMessages() {
    System.out.println("AKP # ScheduledJob");
    kafkaService.getEmployeeData();
  }
}
