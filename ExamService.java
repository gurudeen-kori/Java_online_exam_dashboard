package com.exam.service;

import com.exam.model.Exam;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExamService {
    private Map<Long, Exam> examMap = new HashMap<>();

    public ExamService() {
        // seed with some data
        examMap.put(1L, new Exam(1L, "Java Basics", 20));
        examMap.put(2L, new Exam(2L, "Spring Boot", 25));
    }

    public List<Exam> getAllExams() {
        return new ArrayList<>(examMap.values());
    }

    public Optional<Exam> getExamById(Long id) {
        return Optional.ofNullable(examMap.get(id));
    }
}
