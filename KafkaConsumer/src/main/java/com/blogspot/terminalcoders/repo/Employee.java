package com.blogspot.terminalcoders.repo;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Builder
public class Employee {
  private long id;
  private String name;
  private String post;

  public Employee() {}

  public Employee(Long id, String name, String post) {
    this.id = id;
    this.name = name;
    this.post = post;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPost() {
    return post;
  }

  public void setPost(String post) {
    this.post = post;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", post='" + post + '\'' +
        '}';
  }
}
