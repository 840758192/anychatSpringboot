package com.anychat.core.thread;

import com.anychat.core.log.ILog;

import java.util.HashMap;

/**
 * @author lijian
 * @version V1.0 创建时间：2018/8/16 0016
 * Copyright 2018 by landray & STIC
 */
public class AsyncThreadManager {
    private static int asyncThreadNum;
    private static int asyncThreadPriorityNum;
    private static int lockThreadNum;
    private static ILog log;
    private static HashMap<Integer, AsyncThread> asyncThreadMap = new HashMap();

    public AsyncThreadManager() {
    }

    public static void init(int asyncThreadCycleInterval, int asyncThreadNum, int asyncThreadPriorityNum, int lockThreadNum, ILog log) throws Exception {
        asyncThreadNum = asyncThreadNum;
        asyncThreadPriorityNum = asyncThreadPriorityNum;
        lockThreadNum = lockThreadNum;
        log = log;
        if (asyncThreadNum <= lockThreadNum) {
            if (log != null) {
                log.warn("总线程数量必须大于锁定线程数量");
            }

            throw new Exception("总线程数量必须大于锁定线程数量");
        } else if (asyncThreadNum >= 1 && asyncThreadPriorityNum >= 1) {
            for(int i = 1; i <= asyncThreadNum; ++i) {
                AsyncThread asyncThread = new AsyncThread(asyncThreadCycleInterval, "AsyncThread_" + i, log);
                asyncThreadMap.put(i, asyncThread);

                for(int j = 1; j <= asyncThreadPriorityNum; ++j) {
                    AsyncHandleData asyncHandleData = new AsyncHandleData();
                    asyncThread.asyncHandleDataMap.put(j, asyncHandleData);
                }
            }

        } else {
            if (log != null) {
                log.warn("异步线程数量与优先级至少有一个");
            }

            throw new Exception("异步线程数量与优先级至少有一个");
        }
    }

    public static boolean addHandle(IHandle handle, int threadId, int priority) {
        if (handle == null) {
            if (log != null) {
                log.warn("handle为空");
            }

            return false;
        } else {
            AsyncThread asyncThread = (AsyncThread)asyncThreadMap.get(threadId);
            if (asyncThread == null) {
                if (log != null) {
                    log.warn("不存在线程id：" + threadId);
                }

                return false;
            } else {
                AsyncHandleData asyncHandleData = (AsyncHandleData)asyncThread.asyncHandleDataMap.get(priority);
                if (asyncHandleData == null) {
                    if (log != null) {
                        log.warn("不存在优先级：" + priority);
                    }

                    return false;
                } else {
                    try {
                        asyncHandleData.waitHandleQueue.put(handle);
                        return true;
                    } catch (InterruptedException var6) {
                        if (log != null) {
                            log.error("放入handle至异步线程列队失败", var6);
                        }

                        return false;
                    }
                }
            }
        }
    }

    public static boolean addCycle(ICycle cycle, int threadId, int priority) {
        if (cycle == null) {
            if (log != null) {
                log.warn("ICycle为空");
            }

            return false;
        } else {
            AsyncThread asyncThread = (AsyncThread)asyncThreadMap.get(threadId);
            if (asyncThread == null) {
                if (log != null) {
                    log.warn("不存在线程id：" + threadId);
                }

                return false;
            } else {
                AsyncHandleData asyncHandleData = (AsyncHandleData)asyncThread.asyncHandleDataMap.get(priority);
                if (asyncHandleData == null) {
                    if (log != null) {
                        log.warn("不存在优先级：" + priority);
                    }

                    return false;
                } else {
                    try {
                        asyncHandleData.waitAddCycleQueue.put(cycle);
                        return true;
                    } catch (InterruptedException var6) {
                        if (log != null) {
                            log.error("放入ICycle至异步线程列队失败", var6);
                        }

                        return false;
                    }
                }
            }
        }
    }

    public static boolean removeCycle(ICycle cycle, int threadId, int priority) {
        if (cycle == null) {
            if (log != null) {
                log.warn("ICycle为空");
            }

            return false;
        } else {
            AsyncThread asyncThread = (AsyncThread)asyncThreadMap.get(threadId);
            if (asyncThread == null) {
                if (log != null) {
                    log.warn("不存在线程id：" + threadId);
                }

                return false;
            } else {
                AsyncHandleData asyncHandleData = (AsyncHandleData)asyncThread.asyncHandleDataMap.get(priority);
                if (asyncHandleData == null) {
                    if (log != null) {
                        log.warn("不存在优先级：" + priority);
                    }

                    return false;
                } else {
                    try {
                        asyncHandleData.waitRemoveCycleQueue.put(cycle);
                        return true;
                    } catch (InterruptedException var6) {
                        if (log != null) {
                            log.error("移除ICycle至异步线程列队失败", var6);
                        }

                        return false;
                    }
                }
            }
        }
    }

    public static int[] getRandomThreadPriority() {
        int thread = (int)(Math.random() * (double)(asyncThreadNum - lockThreadNum) + 1.0D);
        int priority = (int)(Math.random() * (double)asyncThreadPriorityNum + 1.0D);
        return new int[]{thread, priority};
    }

    public static int[] getRandomThread() {
        int thread = (int)(Math.random() * (double)(asyncThreadNum - lockThreadNum) + 1.0D);
        return new int[]{thread, 1};
    }

    public static int[] getLockThreadPriority(int lockNum) {
        return new int[]{asyncThreadNum - lockThreadNum + lockNum, 1};
    }

    public static void start() {
        for(int i = 1; i <= asyncThreadNum; ++i) {
            AsyncThread asyncThread = (AsyncThread)asyncThreadMap.get(i);
            asyncThread.start();
        }

    }
}
