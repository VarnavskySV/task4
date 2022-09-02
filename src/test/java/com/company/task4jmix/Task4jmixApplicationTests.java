package com.company.task4jmix;

import com.company.task4jmix.entity.SheetMark;
import com.company.task4jmix.entity.Teacher;
import com.company.task4jmix.entity.User;
import com.company.task4jmix.repository.SheetMarkRepository;
import com.company.task4jmix.repository.TeacherRepository;
import com.company.task4jmix.security.DatabaseUserRepository;

import io.jmix.core.FetchPlan;
import io.jmix.core.FetchPlans;
import io.jmix.core.security.SystemAuthenticator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Task4jmixApplicationTests {

	@Autowired
	private DatabaseUserRepository databaseUserRepository;

	@Autowired
	private SheetMarkRepository sheetMarkRepository;

	@Autowired
	private TeacherRepository teacherRepository;
	@Autowired
	private FetchPlans fetchPlans;

	@Autowired
	SystemAuthenticator systemAuthenticator;

	@BeforeEach
	void setUp(){

		systemAuthenticator.begin();

		sheetMarkRepository.deleteAll();

		teacherRepository.deleteAll();;

	}
	@AfterEach
	void setDown(){
		systemAuthenticator.end();
	}
	@Test
	void contextLoads() {
	}

	@Test
	void getSystemUser(){

		//List<User> user = databaseUserRepository.getByUsernameLike(databaseUserRepository.getSystemUser().getUsername());

		Assertions.assertEquals(databaseUserRepository.getSystemUser().getUsername(), "system");

	}

	@Test
	void getSheetMarkById(){

		SheetMark mark = new SheetMark(1);

		sheetMarkRepository.save(mark);
		
		SheetMark mark1 = sheetMarkRepository.getSheetMarkById(mark.getId());

		Assertions.assertEquals(mark.getId(), mark1.getId());

	}
	@Test
	void getSheetMarksByTeacher(){

		Teacher teacher = new Teacher("Sergei");
		SheetMark mark = new SheetMark(1, teacher);

		teacherRepository.save(teacher);
		sheetMarkRepository.save(mark);

		List<SheetMark> sheetMarks = sheetMarkRepository.getSheetMarkByTeacher(teacher);

		Assertions.assertEquals(mark.getId(), sheetMarks.get(0).getId());

	}

	@Test
	void getTeacherByName(){

		Teacher teacher = new Teacher("Sergei");

		teacherRepository.save(teacher);

		teacher = new Teacher("Serge");

		teacherRepository.save(teacher);

		List<Teacher> teachers = teacherRepository.findByNameLike(teacher.getName());

		Assertions.assertEquals(teachers.size(),2);

	}
	@Test
	public void getSheetMarkByTeacher(){
		var teacher1 =teacherRepository.create();
		var teacher2 = teacherRepository.create();
		teacher1.setName("t1");
		teacher2.setName("t2");
		teacherRepository.saveAll(List.of(teacher1, teacher2));
		var sheetMark = sheetMarkRepository.create();
		sheetMark.setId(1);
		sheetMark.setTeacher(teacher1);
		sheetMarkRepository.save(sheetMark);
		var fetchPlan = fetchPlans.builder(SheetMark.class)
				.add("teacher", FetchPlan.LOCAL)
				.build();

		var sheetMarks = sheetMarkRepository.getSheetMarkByTeacher(teacher1, fetchPlan);

		Assertions.assertEquals(teacher1.getName(), sheetMarks.get(0).getTeacher(), "Teachers are empty");

	}

}
