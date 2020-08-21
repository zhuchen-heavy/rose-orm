package com.rose.h2.repository;

import com.rose.h2.entity.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 自定义sql
 * </p>
 * <h>
 *
 * @Query ：仅仅适用于select语句
 * 若需要使用insert、delete语句，则需要加上 @Modifying + @Transactional
 * </h>
 * @author: zhu.chen
 * @date: 2020/8/21
 * @version: v1.0.0
 */
public interface StudentJpaRepository extends JpaRepository<StudentInfo, String> {

    /**
     * 查询id最大的值
     *
     * @return
     */
    @Query(value = "select * from student_info where id = (select max(id) from student_info)", nativeQuery = true)
    StudentInfo selectMaxIdData();

    /**
     * 删除id最大值
     *
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    @Query(value = "delete from student_info where id = (select max(id) from student_info);", nativeQuery = true)
    void deleteMaxIdData();

}
