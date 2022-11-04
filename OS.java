import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class OS {

    private static PriorityQueue<Job> sleepingJobs = new PriorityQueue<>(new JobsTimeComparator());
    private static Queue<Job> runningJobs = new LinkedList<>();


    /**
     * Should put the job in the 'sleepingJobs' data structure.
     * @param job
     * @param milliSeconds
     */
    public static void sleep(Job job, long milliSeconds) {
        updateTimeToSleep();
        job.setOriginalTimeToSleep(milliSeconds);
        job.setCurrTimeToSleep(milliSeconds);
        sleepingJobs.add(job);
    }

    private static void updateTimeToSleep() {
        if(!sleepingJobs.isEmpty()) {
            Job lowestTimeJob = sleepingJobs.peek();
            long timePassed = lowestTimeJob.getOriginalTimeToSleep() - lowestTimeJob.getCurrTimeToSleep();
            for(Job j: sleepingJobs) {
                if(!j.equals(lowestTimeJob)) { // lowestTimeJob is already updated
                    j.setOriginalTimeToSleep(j.getCurrTimeToSleep() - timePassed);
                    j.setCurrTimeToSleep(j.getCurrTimeToSleep() - timePassed);
                }
                else { // lowestTimeJob current time is already updated, set the original time to the current time
                    lowestTimeJob.setOriginalTimeToSleep(lowestTimeJob.getCurrTimeToSleep());
                }
            }
        }
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
