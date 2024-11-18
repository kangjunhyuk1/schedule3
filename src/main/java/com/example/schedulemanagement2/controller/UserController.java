package com.example.schedulemanagement2.controller;

import com.example.schedulemanagement2.dto.ScheduleResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> signUp() {
        return null;
    }
}
