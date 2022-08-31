package com.company.task4jmix.repository;

import com.company.task4jmix.entity.SheetMark;
import com.company.task4jmix.entity.Teacher;
import io.jmix.core.repository.JmixDataRepository;
import io.jmix.core.repository.Query;

import java.util.List;

public interface TeacherRepository extends JmixDataRepository<Teacher, String> {

    List<Teacher> getTeacherByName(String name);

    //@Query("SELECT e FROM Teacher e WHERE e.name LIKE :1%")
    List<Teacher> findByNameLike(String name);

    
}
