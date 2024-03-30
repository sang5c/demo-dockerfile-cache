package com.example.demodockerfilecache.hello;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Hello {

    @GeneratedValue @Id
    private Long id;

    private String message;
}
