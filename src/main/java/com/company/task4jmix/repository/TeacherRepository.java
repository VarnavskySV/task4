package com.company.task4jmix.repository;

import com.company.task4jmix.entity.Teacher;
import io.jmix.core.repository.JmixDataRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeacherRepository extends JmixDataRepository<Teacher, String> {

    List<Teacher> findByNameLike(String name);

}
