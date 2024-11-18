package com.example.schedulemanagement2.repository;

import com.example.schedulemanagement2.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Long> {


}
