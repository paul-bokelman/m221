package com.example.sping_portfolio;

import com.example.sping_portfolio.Student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.List;


@SpringBootApplication
@RestController
public class demoapplication {

    public static void main(String[] args) {
        SpringApplication.run(demoapplication.class, args);
    }
    @GetMapping
    public List<Student> hello() {
        return List.of(
                new Student(
                        1L,
                        "Mariam",
                        "mariam@gasljdfgmail.com",
                        LocalDate.of(2000, Month.JANUARY, 5),
                        21
                )
        );