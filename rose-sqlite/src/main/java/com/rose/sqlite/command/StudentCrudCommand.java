//package com.rose.sqlite.command;
//
//import com.rose.sqlite.entity.StudentInfo;
//import com.rose.sqlite.repository.StudentJpaRepository;
//import com.rose.sqlite.repository.StudentRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
///**
// * <p>
// * StudentRepository的测试
// * </p>
// *
// * @author: zhu.chen
// * @date: 2020/8/21
// * @version: v1.0.0
// */
//@Component
//public class StudentCrudCommand implements CommandLineRunner {
//
//    @Autowired
//    private StudentRepository studentRepository;
//
//    @Autowired
//    private StudentJpaRepository studentJpaRepository;
//
//    @Override
//    public void run(String... args) throws Exception {
//        testStudentRepository();
//    }
//
//    private void testStudentJpaRepository() {
//        List<StudentInfo> list = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            StudentInfo studentInfo = new StudentInfo();
//            studentInfo.setName("zhangsan" + i);
//            studentInfo.setAge(i);
//            studentInfo.setStudentId("23");
//            studentInfo.setClassNumber("1220114");
//            list.add(studentInfo);
//        }
//        studentJpaRepository.saveAll(list);
//
//        // 1:
//        StudentInfo maxDataBefore = studentJpaRepository.selectMaxIdData();
//        System.out.println("maxDataBefore : " + maxDataBefore);
//        // 2
//        studentJpaRepository.deleteMaxIdData();
//        StudentInfo maxDataAfter = studentJpaRepository.selectMaxIdData();
//        System.out.println("maxDataAfter : " + maxDataAfter);
//    }
//
//    private void testStudentRepository() {
//        StudentInfo studentInfo = new StudentInfo("zhangsan", 11, "23", "1220114");
//        // 增加
//        StudentInfo save = studentRepository.save(studentInfo);
//        System.out.println("save : " + save);
//        // 查找
//        Optional<StudentInfo> find = studentRepository.findById(save.getId());
//        System.out.println("find : " + find.get());
//        // 删除
//        studentRepository.deleteById(save.getId());
//        Iterable<StudentInfo> findAll = studentRepository.findAll();
//        System.out.println("findAll : " + findAll.toString());
//    }
//
//}
