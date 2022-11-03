import java.util.Comparator;

public class JobsTimeComparator implements Comparator<Job> {

    @Override
    public int compare(Job j1, Job j2) {
        return j1.getCurrTimeToSleep() > j2.getCurrTimeToSleep() ? 1 : -1;
    }
}
