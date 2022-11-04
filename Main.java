public class Main {
    public static void main(String[] args) {

        Job j1 = new Job();
        j1.sleep(9);

        Job j2 = new Job();
        j2.sleep(2);

        Job j3 = new Job();
        j3.sleep(6);

        Job j4 = new Job();
        j4.sleep(2);

        OS.awake();
        /*
         sleeping jobs {j1: currTimeToSleep = 9, j2: currTimeToSleep = 1(updated),
                      j3: currTimeToSleep = 6, j4: currTimeToSleep = 2}
         running jobs {empty}
         */
        OS.awake();
        /*
         sleeping jobs {j1: currTimeToSleep = 9, j3: currTimeToSleep = 4(updated)}
         running jobs {j2, j4}
         */
        Job j5 = new Job();
        j5.sleep(8);

        /*
         sleeping jobs {j1: currTimeToSleep = 7(updated), j3: currTimeToSleep = 4,
                        j5: currTimeToSleep = 8}
         running jobs {j2, j4}
         */
        OS.awake();
        OS.awake();
        OS.awake();
        OS.awake();
        /*
         sleeping jobs {j1: currTimeToSleep = 3(updated), j5: currTimeToSleep = 8}
         running jobs {j2, j4, j3}
         */
        OS.awake();
        OS.awake();
        OS.awake();
        /*
         sleeping jobs {j5: currTimeToSleep = 1}
         running jobs {j2, j4, j3, j1}
         */

    }
}