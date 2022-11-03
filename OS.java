import java.util.PriorityQueue;

public class OS {

    private static PriorityQueue<Job> sleepingJobs = new PriorityQueue<>(new JobsTimeComparator());
    private static PriorityQueue<Job> runningJobs = new PriorityQueue<>(new JobsTimeComparator());


    /**
     * Should put the job in the 'sleepingJobs' data structure.
     * @param job
     * @param milliSeconds
     */
    public static void sleep(Job job, long milliSeconds) {
        job.setOriginalTimeToSleep(milliSeconds);
        job.setCurrTimeToSleep(milliSeconds);
        sleepingJobs.add(job);
    }

    /**
     * Should move the jobs from 'sleepingJobs' to 'runningJobs' when the time to sleep is up.
     */
    public static void awake() {
        if(!sleepingJobs.isEmpty()) {
            updateLowestTimeJob();
            while (sleepingJobs.peek().getCurrTimeToSleep() == 0) { // while there is a job ready to running
                Job jobToRunning = updateRunningJobs();
                if(sleepingJobs.isEmpty()) {
                    break;
                }
                updateNextSleepingJob(jobToRunning);
            }
        }
    }

    private static void updateLowestTimeJob() {
        Job lowestTimeJob = sleepingJobs.peek();
        lowestTimeJob.setCurrTimeToSleep(lowestTimeJob.getCurrTimeToSleep() - 1);
    }

    private static Job updateRunningJobs() {
        Job jobToRunning = sleepingJobs.poll();
        runningJobs.add(jobToRunning);
        return jobToRunning;
    }

    private static void updateNextSleepingJob(Job jobToRunning) {
        Job nextSleepingJob = sleepingJobs.peek();
        nextSleepingJob.setCurrTimeToSleep
                (nextSleepingJob.getCurrTimeToSleep() -
                        jobToRunning.getOriginalTimeToSleep());
    }


}