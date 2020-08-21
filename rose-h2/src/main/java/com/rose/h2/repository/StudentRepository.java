package com.rose.h2.repository;

import com.rose.h2.entity.StudentInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * <p>
 * CrudRepository封装了curd的操作
 * </p>
 *
 * @author: zhu.chen
 * @date: 2020/8/21
 * @version: v1.0.0
 */
public interface StudentRepository extends CrudRepository<StudentInfo, Integer> {
}
