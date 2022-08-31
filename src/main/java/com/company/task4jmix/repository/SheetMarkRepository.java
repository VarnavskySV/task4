package com.company.task4jmix.repository;

import com.company.task4jmix.entity.SheetMark;
import com.company.task4jmix.entity.Teacher;
import io.jmix.core.repository.JmixDataRepository;
import io.jmix.core.repository.Query;

import java.util.List;

public interface SheetMarkRepository extends JmixDataRepository<SheetMark, Integer> {

    SheetMark getSheetMarkById(Integer id);

    List<SheetMark> getSheetMarkByTeacher(Teacher teacher_id);

}
