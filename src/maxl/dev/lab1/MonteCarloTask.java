package maxl.dev.lab1;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Максим
 * Date: 16.09.13
 * Time: 22:28
 */
class MonteCarloTask implements Runnable {
    private long mDotNum;

    public MonteCarloTask(long dotNum) {
        mDotNum = dotNum;
    }

    @Override
    public void run() {
        Random r = new Random(System.currentTimeMillis());
        long count = 0;

        for (long i = 0; i < mDotNum; ++i) {
            Double x = r.nextDouble();
            Double y = r.nextDouble();

            if (Math.sqrt(x * x + y * y) <= 1.0)
                ++count;
        }

        ParallelMonteCarloPi.fullCount.addAndGet(count);
    }
}
