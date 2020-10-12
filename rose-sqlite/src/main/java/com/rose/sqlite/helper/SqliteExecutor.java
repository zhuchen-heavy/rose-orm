package com.rose.sqlite.helper;

import com.rose.sqlite.entity.HealthMessageDO;
import com.rose.sqlite.entity.KeepalivedMessageDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Sqlite的执行器
 * </p>
 *
 * @author: zhu.chen
 * @date: 2020/8/21
 * @version: v1.0.0
 */
@Component
public class SqliteExecutor {

    private static final Logger logger = LoggerFactory.getLogger(SqliteExecutor.class);

    private final Object object = new Object();

    /**
     * 得到path路径
     *
     * @return
     */
    public String getDbPath() {
        return "C:\\Users\\zhuchen8\\Desktop\\" + File.separator + "manager_db" + File.separator + "manager.db";
    }

    /**
     * <p>
     * 执行ha_health_message查询语句
     * </p>
     *
     * @param dbFile
     * @param sql
     * @return
     */
    public List<HealthMessageDO> executeHealthMessageQuerySql(String dbFile, String sql) {
        Connection connection = getConnection(dbFile);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<HealthMessageDO> healthMessageDOList = new ArrayList<>();
            while (resultSet.next()) {
                HealthMessageDO healthMessageDO = new HealthMessageDO();
                healthMessageDO.setId(resultSet.getInt("id"));
                healthMessageDO.setComponentId(resultSet.getString("component_id"));
                healthMessageDO.setName(resultSet.getString("name"));
                healthMessageDO.setSegmentId(resultSet.getString("segment_id"));
                healthMessageDO.setServiceState(resultSet.getString("service_state"));
                healthMessageDO.setCollectTime(resultSet.getString("collect_time"));
                healthMessageDO.setCollectCount(resultSet.getString("collect_count"));
                healthMessageDOList.add(healthMessageDO);
            }
            return healthMessageDOList;
        } catch (SQLException e) {
            logger.info("Connection#prepareStatement has a error.", e);
            return null;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.info("Connection#close has a error.", e);
            }
        }
    }

    /**
     * <p>
     * 执行ha_keepalived_message查询语句
     * </p>
     *
     * @param dbFile
     * @param sql
     * @return
     */
    public List<KeepalivedMessageDO> executeKeepalivedMessageQuerySql(String dbFile, String sql) {
        Connection connection = getConnection(dbFile);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<KeepalivedMessageDO> keepalivedMessageDOList = new ArrayList<>();
            while (resultSet.next()) {
                KeepalivedMessageDO keepalivedMessageDO = new KeepalivedMessageDO();
                keepalivedMessageDO.setId(resultSet.getInt("id"));
                keepalivedMessageDO.setState(resultSet.getString("state"));
                keepalivedMessageDO.setSwitchTime(resultSet.getString("switch_time"));
                keepalivedMessageDOList.add(keepalivedMessageDO);
            }
            return keepalivedMessageDOList;
        } catch (SQLException e) {
            logger.info("Connection#prepareStatement has a error.", e);
            return null;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.info("Connection#close has a error.", e);
            }
        }
    }

    /**
     * <p>
     * 执行无返回值的sql
     * </p>
     *
     * @param dbFile
     * @param sql
     * @return
     */
    public boolean executeSql(String dbFile, String sql) {
        Connection connection = null;
        synchronized (object) {
            connection = getConnection(dbFile);
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            return preparedStatement.execute();
        } catch (SQLException e) {
            logger.info("Connection#prepareStatement has a error.", e);
            return false;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.info("Connection#close has a error.", e);
            }
        }
    }

    /**
     * <p>
     * 获取连接
     * </p>
     *
     * @param dbFile
     * @return
     */
    private Connection getConnection(String dbFile) {
        Connection connection = null;
        try {
            String url = "jdbc:sqlite:" + dbFile;
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
        } catch (ClassNotFoundException | SQLException e) {
            logger.error("connect to sqlite error.", e);
        }
        return connection;
    }

}
