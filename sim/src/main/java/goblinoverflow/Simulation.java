package goblinoverflow;

public class Simulation implements Runnable{
    private String name;

    private boolean isRunning;
    private int framesPerSecond = 60;
    private int timePerLoop = 1000000000 / framesPerSecond;


    public Simulation(String name) {
        this.name = name;
        this.isRunning = false;
    }


    @Override
    public void run() {
        isRunning = true;

        while (isRunning) {
            long start = System.nanoTime();

            // Update

            // Render

            long end = System.nanoTime();
            long elapsed = end - start;

            if (elapsed < timePerLoop) {
                try {
                    Thread.sleep((timePerLoop - elapsed) / 1000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
