package com.rose.sqlite.helper;

import com.rose.sqlite.entity.HealthMessageDO;
import com.rose.sqlite.entity.KeepalivedMessageDO;

import java.util.List;

/**
 * <p>
 * 生成sql的相关工具类
 * </p>
 *
 * @author: zhu.chen
 * @date: 2020/8/21
 * @version: v1.0.0
 */
public class SqlGeneratorHelper {

    // ------------------ ha_health_message ------------------
    /**
     * ha_health_message的建表语句
     */
    public static final String healthMessageCreateTableSql = "" +
            "create table ha_health_message (\n" +
            "  id            integer not null primary key,\n" +
            "  component_id  varchar(255),\n" +
            "  name          varchar(255),\n" +
            "  segment_id    varchar(255),\n" +
            "  service_state varchar(255),\n" +
            "  collect_time  varchar(255),\n" +
            "  collect_count varchar(255)\n" +
            ");";

    /**
     * ha_health_message查询语句
     */
    public static final String healthMessageQuerySql = "" +
            "select\n" +
            "  id,\n" +
            "  component_id,\n" +
            "  name,\n" +
            "  segment_id,\n" +
            "  service_state,\n" +
            "  collect_time,\n" +
            "  collect_count\n" +
            "from ha_health_message;";

    /**
     * ha_health_message全量删除语句
     */
    public static final String healthMessageDeleteSql = "delete from ha_health_message";

    /**
     * ha_health_message保留当前一天语句
     */
    public static final String healthMessageDeleteDataBeforeConcurrentDaySql = "delete from ha_health_message where collect_time < date();";

    /**
     * ha_health_message中collect_count最大值的记录
     */
    public static final String healthMessageMaxCountMessageSql = "select * from ha_health_message where collect_count = (select MAX(collect_count) from ha_health_message);";

    // ------------------ ha_keepalived_message ------------------

    /**
     * ha_keepalived_message的建表语句
     */
    public static final String keepalivedMessageCreateTableSql = "" +
            "create table ha_keepalived_message (\n" +
            "  id          integer not null primary key,\n" +
            "  state       varchar(255),\n" +
            "  switch_time varchar(255)\n" +
            ");";

    /**
     * ha_keepalived_message查询语句
     */
    public static final String keepalivedMessageQuerySql = "" +
            "select\n" +
            "  id,\n" +
            "  state,\n" +
            "  switch_time\n" +
            "from ha_keepalived_message;";

    /**
     * ha_keepalived_message全量删除语句
     */
    public static final String keepalivedMessageDeleteSql = "delete from ha_keepalived_message;";

    /**
     * ha_keepalived_message保留当前一天语句
     */
    public static final String keepalivedMessageDeleteDataBeforeConcurrentDaySql = "delete from ha_keepalived_message where switch_time < date();";

    /**
     * ha_keepalived_message中最大的2条值
     */
    public static final String keepalivedMessageMaxTwoData = "select * from ha_keepalived_message order by switch_time desc limit 0, 2;";

    /**
     * insert into ha_health_message (component_id, name, segment_id, service_state, collect_time, collect_count)
     * values
     * (1, date(), 'lsm', 'zhangsan', 'cas', 0),
     * (1, date(), 'lsm', 'zhangsan', 'cas', 0);
     *
     * @param healthMessageDOList
     * @return
     */
    public static String generateHealthMessageInsertSql(List<HealthMessageDO> healthMessageDOList) {
        StringBuilder stringBuilder = new StringBuilder();
        String insertSql = "insert into ha_health_message (component_id, name, segment_id, service_state, collect_time, collect_count) values ";
        stringBuilder.append(insertSql);
        int size = healthMessageDOList.size();
        for (int i = 0; i < size; i++) {
            if (i != size - 1) {
                stringBuilder.append("(");
                stringBuilder.append("'" + healthMessageDOList.get(i).getComponentId() + "', ");
                stringBuilder.append("'" + healthMessageDOList.get(i).getName() + "', ");
                stringBuilder.append("'" + healthMessageDOList.get(i).getSegmentId() + "', ");
                stringBuilder.append("'" + healthMessageDOList.get(i).getServiceState() + "', ");
                stringBuilder.append("'" + healthMessageDOList.get(i).getCollectTime() + "', ");
                stringBuilder.append("'" + healthMessageDOList.get(i).getCollectCount() + "'");
                stringBuilder.append("),");
            } else {
                stringBuilder.append("(");
                stringBuilder.append("'" + healthMessageDOList.get(i).getComponentId() + "', ");
                stringBuilder.append("'" + healthMessageDOList.get(i).getName() + "', ");
                stringBuilder.append("'" + healthMessageDOList.get(i).getSegmentId() + "', ");
                stringBuilder.append("'" + healthMessageDOList.get(i).getServiceState() + "', ");
                stringBuilder.append("'" + healthMessageDOList.get(i).getCollectTime() + "', ");
                stringBuilder.append("'" + healthMessageDOList.get(i).getCollectCount() + "'");
                stringBuilder.append(")");
            }
        }
        return stringBuilder.toString();
    }

    /**
     * insert into ha_keepalived_message (state, switch_time)
     * values
     * ('master', date()),
     * ('master', date());
     *
     * @param keepalivedMessageDOList
     * @return
     */
    public static String generateKeepalivedMessageInsertSql(List<KeepalivedMessageDO> keepalivedMessageDOList) {
        StringBuilder stringBuilder = new StringBuilder();
        String insertSql = "insert into ha_keepalived_message (state, switch_time) values ";
        stringBuilder.append(insertSql);
        int size = keepalivedMessageDOList.size();
        for (int i = 0; i < size; i++) {
            if (i != size - 1) {
                stringBuilder.append("(");
                stringBuilder.append("'" + keepalivedMessageDOList.get(i).getState() + "', ");
                stringBuilder.append("'" + keepalivedMessageDOList.get(i).getSwitchTime() + "'");
                stringBuilder.append("),");
            } else {
                stringBuilder.append("(");
                stringBuilder.append("'" + keepalivedMessageDOList.get(i).getState() + "', ");
                stringBuilder.append("'" + keepalivedMessageDOList.get(i).getSwitchTime() + "'");
                stringBuilder.append(")");
            }
        }
        return stringBuilder.toString();
    }

}
