public class Job {

    private long originalTimeToSleep;
    private long currTimeToSleep;

    // A function for sleep which called by a job
    public void sleep(long ms)  {
        OS.sleep(this, ms);
    }

    public long getOriginalTimeToSleep() {
        return originalTimeToSleep;
    }

    public void setOriginalTimeToSleep(long originalTimeToSleep) {
        this.originalTimeToSleep = originalTimeToSleep;
    }

    public long getCurrTimeToSleep() {
        return currTimeToSleep;
    }

    public void setCurrTimeToSleep(long currTimeToSleep) {
        this.currTimeToSleep = currTimeToSleep;
    }
}