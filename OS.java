import java.util.PriorityQueue;

public class OS {

    // Add additional functions and data members as you find fit

    // You should define & implement the data structures below.

    private static PriorityQueue<Job> sleepingJobs = new PriorityQueue<>(new JobsTimeComparator());
    private static PriorityQueue<Job> runningJobs = new PriorityQueue<>(new JobsTimeComparator());


    /**
     * Should put the job in the 'sleepingJobs' data structure.
     * @param job
     * @param milliSeconds
     */
    public static void sleep(Job job, long milliSeconds) {
        // Your implementation here
        job.setOriginalTimeToSleep(milliSeconds);
        job.setCurrTimeToSleep(milliSeconds);
        sleepingJobs.add(job);
    }

    /**
     * Should move the jobs from 'sleepingJobs' to 'runningJobs' when the time to sleep is up.
     */
    public static void awake() {
        // Your implementation here
        if(!sleepingJobs.isEmpty()) {
            Job lowestTimeJob = sleepingJobs.peek();
            lowestTimeJob.setCurrTimeToSleep(lowestTimeJob.getCurrTimeToSleep() - 1);
            while (sleepingJobs.peek().getCurrTimeToSleep() == 0) {
                Job jobToRunning = sleepingJobs.poll();
                runningJobs.add(jobToRunning);
                if(sleepingJobs.isEmpty()) {
                    break;
                }
                Job nextSleepingJob = sleepingJobs.peek();
                    nextSleepingJob.setCurrTimeToSleep
                            (nextSleepingJob.getCurrTimeToSleep() -
                                    jobToRunning.getOriginalTimeToSleep());
            }
        }
    }

    public static PriorityQueue<Job> getSleepingJobs() {
        return sleepingJobs;
    }

    public static PriorityQueue<Job> getRunningJobs() {
        return runningJobs;
    }

//    public static void awake() {
//        // Your implementation here
//        for(Job j: sleepingJobs) {
//            j.setTimeToSleep(j.getTimeToSleep() - 1);
//        }
//        while(sleepingJobs.peek().getTimeToSleep() == 0) {
//            runningJobs.add(sleepingJobs.poll());
//        }
////        if(sleepingJobs.peek().getTimeToSleep() == 0.0) {
////        }
//    }
}