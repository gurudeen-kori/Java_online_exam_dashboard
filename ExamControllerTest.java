package com.exam;

import com.exam.model.Exam;
import com.exam.service.ExamService;
import com.exam.controller.ExamController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

@SpringBootTest
public class ExamControllerTest {

    @Test
    public void testGetAllExams() {
        ExamService service = new ExamService();
        List<Exam> exams = service.getAllExams();
        assertThat(exams).isNotNull();
        assertThat(exams.size()).isGreaterThan(0);
    }

    @Test
    public void testGetExamById() {
        ExamService service = new ExamService();
        Exam exam = service.getExamById(1L).orElse(null);
        assertThat(exam).isNotNull();
        assertThat(exam.getName()).isEqualTo("Java Basics");
    }
}
