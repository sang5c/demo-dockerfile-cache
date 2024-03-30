package com.example.demodockerfilecache.hello;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class HelloController {

    private final HelloRepository helloRepository;

    @GetMapping("/hello")
    public List<Hello> hello() {
        log.info("hello");
        return helloRepository.findAll();
    }

    @GetMapping("/")
    public void hello2() {
        Hello hello = new Hello();
        hello.setMessage("asdf");
        helloRepository.save(hello);
    }
}
