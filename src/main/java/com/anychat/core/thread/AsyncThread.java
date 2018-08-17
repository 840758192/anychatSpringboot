package com.anychat.core.thread;

import com.anychat.core.log.ILog;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author lijian
 * @version V1.0 创建时间：2018/8/16 0016
 * Copyright 2018 by landray & STIC
 */
public class AsyncThread extends Thread {
    private int asyncThreadCycleInterval;
    private ILog log;
    public HashMap<Integer, AsyncHandleData> asyncHandleDataMap = new HashMap();

    public AsyncThread(int asyncThreadCycleInterval, String name, ILog log) {
        this.asyncThreadCycleInterval = asyncThreadCycleInterval;
        this.log = log;
        this.setName(name);
    }

    public void run() {
        while(true) {
            long startTime = System.currentTimeMillis();
            Object[] priorityArray = this.asyncHandleDataMap.keySet().toArray();

            for(int i = 0; i < this.asyncHandleDataMap.size(); ++i) {
                AsyncHandleData asyncHandleData = (AsyncHandleData)this.asyncHandleDataMap.get(priorityArray[i]);
                ArrayList<ICycle> addCycleArray = asyncHandleData.getAddCycleArray();
                ArrayList<ICycle> removeCycleArray = asyncHandleData.getRemoveCycleArray();

                int j;
                ICycle changeCycle;
                for(j = 0; j < asyncHandleData.cycleArray.size(); ++j) {
                    changeCycle = (ICycle)asyncHandleData.cycleArray.get(j);

                    try {
                        changeCycle.cycle();
                    } catch (Exception var13) {
                        if (this.log != null) {
                            this.log.error("异步线程异常ICycle cycle:" + changeCycle.getClass().getName(), var13);
                        }
                    }
                }

                for(j = 0; j < addCycleArray.size(); ++j) {
                    changeCycle = (ICycle)addCycleArray.get(j);
                    asyncHandleData.cycleArray.add(changeCycle);

                    try {
                        changeCycle.onAdd();
                    } catch (Exception var14) {
                        if (this.log != null) {
                            this.log.error("异步线程异常ICycle onAdd:" + changeCycle.getClass().getName(), var14);
                        }
                    }
                }

                for(j = 0; j < removeCycleArray.size(); ++j) {
                    changeCycle = (ICycle)removeCycleArray.get(j);
                    asyncHandleData.cycleArray.remove(changeCycle);

                    try {
                        changeCycle.onRemove();
                    } catch (Exception var15) {
                        if (this.log != null) {
                            this.log.error("异步线程异常ICycle onRemove:" + changeCycle.getClass().getName(), var15);
                        }
                    }
                }

                ArrayList<IHandle> handleArray = asyncHandleData.getHandleArray();

                for(int m = 0; m < handleArray.size(); ++m) {
                    IHandle handle = (IHandle)handleArray.get(m);

                    try {
                        handle.getMethod().invoke(handle.getInstance(), handle.getPacket());
                    } catch (Exception var16) {
                        if (this.log != null) {
                            this.log.error("异步线程异常handle:", var16);
                        }
                    }
                }
            }

            long endTime = System.currentTimeMillis();
            if (endTime - startTime < (long)this.asyncThreadCycleInterval) {
                try {
                    Thread.sleep((long)this.asyncThreadCycleInterval - (endTime - startTime));
                } catch (InterruptedException var12) {
                    if (this.log != null) {
                        this.log.error("异步线程睡眠异常", var12);
                    }
                }
            }
        }
    }
}
