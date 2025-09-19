package com.exam.controller;

import com.exam.model.Exam;
import com.exam.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exams")
public class ExamController {

    @Autowired
    private ExamService examService;

    @GetMapping
    public List<Exam> allExams() {
        return examService.getAllExams();
    }

    @GetMapping("/{id}")
    public Exam getExam(@PathVariable Long id) {
        return examService.getExamById(id)
                .orElseThrow(() -> new RuntimeException("Exam not found: " + id));
    }
}
