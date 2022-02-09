package edu.escuelaing.arep.concurrency;

import java.util.ArrayList;

public class RobotMaster {
    int totalThreads;
    ArrayList<Robot> myThreads;

    RobotMaster(int totalThreads) {
        this.totalThreads = totalThreads;

        this.createThreads();
        this.startThreads();
    }

    private void createThreads() {
        myThreads = new ArrayList<>();

        for(int i = 0; i < this.totalThreads; i++){
            myThreads.add(new Robot(i));
        }
    }

    private void startThreads() {
        for(Robot robot : myThreads) {
            robot.startThread();
        }
    }
}
