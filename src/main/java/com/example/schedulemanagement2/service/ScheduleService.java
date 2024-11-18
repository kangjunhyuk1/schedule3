package com.example.schedulemanagement2.service;

import com.example.schedulemanagement2.dto.ScheduleRequestDto;
import com.example.schedulemanagement2.dto.ScheduleResponseDto;
import com.example.schedulemanagement2.entity.ScheduleEntity;
import com.example.schedulemanagement2.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public List<ScheduleResponseDto> findAll() {
        List<ScheduleEntity> schedules = scheduleRepository.findAll();

        return schedules
                .stream()
                .map(ScheduleResponseDto :: toDto)
                .toList();
    }

    public ScheduleResponseDto findById(Long scheduleId) {
        return ScheduleResponseDto.toDto(findScheduleById(scheduleId));
    }

    private ScheduleEntity findScheduleById(Long scheduleId) {
        return scheduleRepository.findById(scheduleId).orElseThrow(() -> new IllegalArgumentException("잘못된 ID 값입니다"));
    }

    public void deleteSchedule(Long scheduleId) {
        findScheduleById(scheduleId);
        scheduleRepository.deleteById(scheduleId);
    }


    public ScheduleResponseDto createSchedule(ScheduleRequestDto scheduleRequestDto) {
        ScheduleEntity scheduleEntity = new ScheduleEntity(scheduleRequestDto.getScheduleName(), scheduleRequestDto.getTask(), scheduleRequestDto.getWriterName());

        ScheduleEntity savedSchedule = scheduleRepository.save(scheduleEntity);
        return ScheduleResponseDto.toDto(savedSchedule);
    }
}
