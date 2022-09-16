package com.StopWatch;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class StopWatch {
    public static void main(String[] args) {
        int []a= new int [100000];
        for (int i = 0; i < 100000; i++) {
            a[i]=(int)(Math.random()*1000);
        }
        LocalTime start,end;
        start=LocalTime.now();
        a=OOPstopWatch.selectionSort(a);
        end=LocalTime.now();
        stopWatch sw = new stopWatch(start,end);
        System.out.println(start);
        System.out.println(end);
        System.out.println(sw.getElapsedTime());
    }
    public static class stopWatch{
        private LocalTime startTime,endTime;
        public stopWatch(){
            startTime=LocalTime.now();
        }
        public stopWatch(LocalTime startTime,LocalTime endTime){
            this.startTime=startTime;
            this.endTime=endTime;
        }
        public void start(){
            startTime=LocalTime.now();
        }
        public void end(){
            endTime=LocalTime.now();
        }
        public int getElapsedTime(){
            int milisecond=-(((startTime.getHour()-endTime.getHour())*3600+(startTime.getMinute()-endTime.getMinute())*60+(startTime.getSecond()-endTime.getSecond()))*1000);
            return milisecond;
        }
    }


    public static class OOPstopWatch {
        public static int[] selectionSort(int... a) {
            for (int i = 0; i < a.length - 1; i++) {
                for (int j = i + 1; j < a.length; j++) {
                    if (a[j] < a[i]) {
                        int tempt = a[i];
                        a[i] = a[j];
                        a[j] = tempt;
                    }
                }
            }
            return a;
        }
    }
}
