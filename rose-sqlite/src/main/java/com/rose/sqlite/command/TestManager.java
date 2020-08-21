package com.rose.sqlite.command;

import com.rose.sqlite.entity.HealthMessageDO;
import com.rose.sqlite.entity.KeepalivedMessageDO;
import com.rose.sqlite.helper.SqlGeneratorHelper;
import com.rose.sqlite.helper.SqliteExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class TestManager implements CommandLineRunner {

    @Autowired
    private SqliteExecutor sqliteExecutor;

    @Override
    public void run(String... args) throws Exception {
        healthMessage();
    }

    private void healthMessage() {
        List<HealthMessageDO> list = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            HealthMessageDO healthMessageDO = new HealthMessageDO();
            healthMessageDO.setComponentId("lsm" + i);
            healthMessageDO.setSegmentId("cas" + i);
            healthMessageDO.setName("登录服务");
            healthMessageDO.setServiceState("0");
            healthMessageDO.setCollectTime(LocalDateTime.now().toString());
            healthMessageDO.setCollectCount("0");
            list.add(healthMessageDO);
        }
        String sql = SqlGeneratorHelper.generateHealthMessageInsertSql(list);
        System.out.println(sql);
        sqliteExecutor.executeSql(sqliteExecutor.getDbPath(), sql);
        System.out.println(sqliteExecutor.executeHealthMessageQuerySql(sqliteExecutor.getDbPath(), SqlGeneratorHelper.healthMessageMaxCountMessageSql));
    }

    private void testKeepalivedMessage() {
        List<KeepalivedMessageDO> list = new ArrayList<>();
        KeepalivedMessageDO keepalivedMessageDO1 = new KeepalivedMessageDO();
        keepalivedMessageDO1.setState("master");
        keepalivedMessageDO1.setSwitchTime(LocalDateTime.now().toString());
        list.add(keepalivedMessageDO1);
        KeepalivedMessageDO keepalivedMessageDO2 = new KeepalivedMessageDO();
        keepalivedMessageDO2.setState("slave");
        keepalivedMessageDO2.setSwitchTime(LocalDateTime.now().toString());
        list.add(keepalivedMessageDO2);
        String sql = SqlGeneratorHelper.generateKeepalivedMessageInsertSql(list);
        System.out.println(sql);
        sqliteExecutor.executeSql(sqliteExecutor.getDbPath(), sql);

        sqliteExecutor.executeSql(sqliteExecutor.getDbPath(), SqlGeneratorHelper.keepalivedMessageDeleteSql);
        System.out.println(sqliteExecutor.executeKeepalivedMessageQuerySql(sqliteExecutor.getDbPath(), SqlGeneratorHelper.keepalivedMessageMaxTwoData));
    }

}
