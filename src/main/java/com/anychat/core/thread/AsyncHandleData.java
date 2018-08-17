package com.anychat.core.thread;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author lijian
 * @version V1.0 创建时间：2018/8/16 0016
 * Copyright 2018 by landray & STIC
 */
public class AsyncHandleData {
    public LinkedBlockingQueue<IHandle> waitHandleQueue = new LinkedBlockingQueue();
    private ArrayList<IHandle> handleArray = new ArrayList();
    public ArrayList<ICycle> cycleArray = new ArrayList();
    public LinkedBlockingQueue<ICycle> waitAddCycleQueue = new LinkedBlockingQueue();
    private ArrayList<ICycle> addCycleArray = new ArrayList();
    public LinkedBlockingQueue<ICycle> waitRemoveCycleQueue = new LinkedBlockingQueue();
    private ArrayList<ICycle> removeCycleArray = new ArrayList();

    public AsyncHandleData() {
    }

    public ArrayList<IHandle> getHandleArray() {
        this.handleArray.clear();
        this.waitHandleQueue.drainTo(this.handleArray);
        return this.handleArray;
    }

    public ArrayList<ICycle> getAddCycleArray() {
        this.addCycleArray.clear();
        this.waitAddCycleQueue.drainTo(this.addCycleArray);
        return this.addCycleArray;
    }

    public ArrayList<ICycle> getRemoveCycleArray() {
        this.removeCycleArray.clear();
        this.waitRemoveCycleQueue.drainTo(this.removeCycleArray);
        return this.removeCycleArray;
    }
}
