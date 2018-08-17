package com.anychat.core.log;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lijian
 * @version V1.0 创建时间：2018/8/17 0017
 * Copyright 2018 by landray & STIC
 */
public class RunMonitor {
    private List<String> contentList;
    private List<Long> timeList;
    private String type;
    private String opCode;

    public RunMonitor(String type, String opCode) {
        this.type = type;
        this.opCode = opCode;
        this.contentList = new ArrayList();
        this.timeList = new ArrayList();
    }

    public void putMonitor(String content) {
        long time = System.currentTimeMillis();
        this.contentList.add(content);
        this.timeList.add(time);
    }

    public String toString(String opCode) {
        this.opCode = opCode;
        return this.toString();
    }
    @Override
    public String toString() {
        if (this.contentList.size() >= 2) {
            long totalTime = ((Long)this.timeList.get(this.timeList.size() - 1)).longValue() - ((Long)this.timeList.get(0)).longValue();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\r\n===========================\r\n");
            stringBuilder.append("RunMonitor:" + this.type);
            stringBuilder.append("\r\n---------------------------\r\n");
            stringBuilder.append("No.\tContent\tTime");

            for(int i = 0; i < this.contentList.size(); ++i) {
                stringBuilder.append("\r\n").append(i);
                stringBuilder.append("\t").append((String)this.contentList.get(i));
                long time = 0L;
                if (i != 0) {
                    time = ((Long)this.timeList.get(i)).longValue() - ((Long)this.timeList.get(i - 1)).longValue();
                }

                stringBuilder.append("\t").append(time).append("ms");
            }

            stringBuilder.append("\r\n---------------------------\r\n");
            stringBuilder.append(this.type + ":");
            stringBuilder.append(this.opCode).append(",TotalTime:").append(totalTime).append("ms");
            stringBuilder.append("\r\n===========================\r\n");
            return stringBuilder.toString();
        } else {
            return "contentList < 2";
        }
    }
}
