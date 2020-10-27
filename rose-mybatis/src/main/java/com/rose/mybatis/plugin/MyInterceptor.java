package com.rose.mybatis.plugin;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;

import java.sql.Connection;
import java.util.Properties;

/**
 * <p>
 * Mybatis的自定义插件机制
 * </p>
 * 实现Interceptor的类必须使用注解@Intercepts，Plugin类中的getSignatureMap函数就是来解析这个注解获得注解中的相关信息，
 * 比如拦截的method，拦截的接口实现类，以及method的函数参数等。
 *
 * @author: zhu.chen
 * @date: 2020/10/22
 * @version: v1.0.0
 */
//@Intercepts({
//        @Signature(method = "query", type = Executor.class, args = {
//                MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class
//        })
//})
@Intercepts({
        // args：指的是StatementHandler接口的prepare方法的方法参数。
        @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})
})
public class MyInterceptor implements Interceptor {

    private long time;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        //通过StatementHandler获取执行的sql
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        BoundSql boundSql = statementHandler.getBoundSql();
        String sql = boundSql.getSql();

        long start = System.currentTimeMillis();
        Object proceed = invocation.proceed();
        long end = System.currentTimeMillis();
        if ((end - start) > time) {
            System.out.println("本次数据库操作是慢查询，sql是:" + sql);
        }
        return proceed;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        this.time = Long.parseLong(properties.getProperty("time"));
    }
}
