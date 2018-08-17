package com;

import com.anychat.core.log.ILog;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author lijian
 * @version V1.0 创建时间：2018/8/17 0017
 * Copyright 2018 by landray & STIC
 */
public class MybatisManager {
    private static SqlSessionFactory sqlSessionFactory;
    public static ILog log;

    public static void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        MybatisManager.sqlSessionFactory = sqlSessionFactory;
    }

    public static void setLog(ILog log) {
        MybatisManager.log = log;
    }

    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession(true);
    }
}
