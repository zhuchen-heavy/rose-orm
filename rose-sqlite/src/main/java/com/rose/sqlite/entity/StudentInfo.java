package com.rose.sqlite.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * <p>
 *  学生信息
 * </p>
 *
 * @author: zhu.chen
 * @date: 2020/8/21
 * @version: v1.0.0
 */
@Entity
public class StudentInfo {

    /**
     * 使用默认的id生成器sequence来生成
     */
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private Integer age;

    private String studentId;

    private String classNumber;

    // 必须要有无参构造
    public StudentInfo() {
    }

    public StudentInfo(String name, Integer age, String studentId, String classNumber) {
        this.name = name;
        this.age = age;
        this.studentId = studentId;
        this.classNumber = classNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    @Override
    public String toString() {
        return "StudentInfo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", studentId='" + studentId + '\'' +
                ", classNumber='" + classNumber + '\'' +
                '}';
    }
}
