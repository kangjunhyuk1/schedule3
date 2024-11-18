package com.example.schedulemanagement2.controller;

import com.example.schedulemanagement2.dto.ScheduleRequestDto;
import com.example.schedulemanagement2.dto.ScheduleResponseDto;
import com.example.schedulemanagement2.repository.ScheduleRepository;
import com.example.schedulemanagement2.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedules")
public class scheduleController {

    private final ScheduleService scheduleService;
    private final ScheduleRepository scheduleRepository;

    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAll() {
        return ResponseEntity.ok().body(scheduleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findOne(@PathVariable Long scheduleId) {
        return ResponseEntity.ok().body(scheduleService.findById(scheduleId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSchedule(@PathVariable Long scheduleId) {
        scheduleService.deleteSchedule(scheduleId);
        return ResponseEntity.ok().body("정상적으로 삭제되었습니다");
    }

    @PostMapping
    public ResponseEntity<ScheduleRequestDto> createSchedule(@RequestBody ScheduleResponseDto scheduleResponseDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(scheduleService.createSchedule(scheduleRepository));
    }
}
