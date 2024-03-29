import java.util.concurrent.Semaphore;

/**
 * 1117. Building H2O
 * Hard
 * https://leetcode.com/problems/building-h2o/
 * 20
 *
 * 3
 *
 * Favorite
 *
 * Share
 * There are two kinds of threads, oxygen and hydrogen. Your goal is to group these threads to form water molecules. There is a barrier where each thread has to wait until a complete molecule can be formed. Hydrogen and oxygen threads will be given a releaseHydrogen and releaseOxygen method respectfully, which will allow them to pass the barrier. These threads should pass the barrier in groups of three, and they must be able to immediately bond with each other to form a water molecule. You must guarantee that all the threads from one molecule bond before any other threads from the next molecule do.
 *
 * In other words:
 *
 * If an oxygen thread arrives at the barrier when no hydrogen threads are present, it has to wait for two hydrogen threads.
 * If a hydrogen thread arrives at the barrier when no other threads are present, it has to wait for an oxygen thread and another hydrogen thread.
 * Write synchronization code for oxygen and hydrogen molecules that enforces these constraints.
 *
 *
 *
 * Example 1:
 *
 * Input: "HOH"
 * Output: "HHO"
 * Explanation: "HOH" and "OHH" are also valid answers.
 * Example 2:
 *
 * Input: "OOHHHH"
 * Output: "HHOHHO"
 * Explanation: "HOHHHO", "OHHHHO", "HHOHOH", "HOHHOH", "OHHHOH", "HHOOHH", "HOHOHH" and "OHHOHH" are also valid answers.
 *
 *
 * Constraints:
 *
 * Total length of input string will be 3n, where 1 ≤ n ≤ 30.
 * Total number of H will be 2n in the input string.
 * Total number of O will be n in the input string.
 */
class H2O {
    private Semaphore h = new Semaphore(2);
    private Semaphore o = new Semaphore(1);

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        h.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        if (h.availablePermits() == 0) {
            o.release();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        // releaseOxygen.run() outputs "H". Do not change or remove this line.
        o.acquire();
        releaseOxygen.run();
        h.release(2);
    }
}
