package com.company.task4jmix.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "TEACHER")
@Entity
public class Teacher {


    @Id
    @Column(name="NAME", nullable = false)
    private String name;

    @Composition
    @OneToMany(mappedBy = "teacher")
    private List<SheetMark> sheetMarkList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SheetMark> getSheetMarkList() {
        return sheetMarkList;
    }

    public void setSheetMarkList(List<SheetMark> sheetMarkList) {
        this.sheetMarkList = sheetMarkList;
    }

    public Teacher() {
    }

    public Teacher(String name) {
        this.name = name;
    }

}