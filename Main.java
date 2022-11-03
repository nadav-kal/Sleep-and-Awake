public class Main {
    public static void main(String[] args) {

        Job j1 = new Job();
        j1.sleep(15);

        Job j2 = new Job();
        j2.sleep(4);

        Job j3 = new Job();
        j3.sleep(9);

//        OS.awake();
//        OS.awake();
//        OS.awake();
//        OS.awake();
//        OS.awake();
//        OS.awake();
//        OS.awake();
//        OS.awake();
//        OS.awake();
//        OS.awake();
//        OS.awake();
//        OS.awake();
//        OS.awake();
//        OS.awake();



//        OS.sleep(j2, 5);


        System.out.println(OS.getSleepingJobs().poll().getCurrTimeToSleep());
        System.out.println(OS.getSleepingJobs().poll().getCurrTimeToSleep());
        System.out.println(OS.getSleepingJobs().poll().getCurrTimeToSleep());

//        System.out.println(OS.getRunningJobs().poll().getCurrTimeToSleep());
//        System.out.println(OS.getRunningJobs().poll().getCurrTimeToSleep());
//        System.out.println(OS.getRunningJobs().poll().getCurrTimeToSleep());



//        System.out.println(OS.getRunningJobs().poll());

//        System.out.println(OS.getSleepingJobs().poll().getTimeToSleep());


    }
}