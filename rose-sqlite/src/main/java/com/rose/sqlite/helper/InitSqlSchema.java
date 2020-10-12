package com.rose.sqlite.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;

/**
 * <p>
 * 初始化建表
 * </p>
 *
 * @author: zhu.chen
 * @date: 2020/8/21
 * @version: v1.0.0
 */
@Component
public class InitSqlSchema {

    @Autowired
    private SqliteExecutor sqliteExecutor;

    @PostConstruct
    public void initSqlSchema() {
        String initDb = "C:\\Users\\zhuchen8\\Desktop\\" + File.separator + "manager_db" + File.separator + "manager.db";
        File initDbFile = new File(initDb);
        if (initDbFile.exists()) {
            initDbFile.delete();
        }
        // 3：初始化建表
        sqliteExecutor.executeSql(initDb, SqlGeneratorHelper.healthMessageCreateTableSql);
        sqliteExecutor.executeSql(initDb, SqlGeneratorHelper.keepalivedMessageCreateTableSql);
    }

}
