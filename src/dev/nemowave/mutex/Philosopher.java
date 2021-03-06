package dev.nemowave.mutex;

public class Philosopher implements Runnable {

    public int id;
    public Fork leftFork;
    public Fork rightFork;

    public Philosopher(int id, Fork leftFork, Fork rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.id = id;
    }

    public void think() {
        System.out.printf("Filósofo %d está pensando\n", this.id);
        aMimir((int) (Math.random() * 3000));
    }

    public void aMimir(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            think();
            leftFork.get();
            System.out.printf("Filósofo %d pegou o garfo esquerdo\n", this.id);
            rightFork.get();
            System.out.printf("Filósofo %d pegou o garfo direito\n", this.id);

            System.out.format("Filósofo %d está comendo\n", this.id);

            aMimir(2000);

            leftFork.put();
            rightFork.put();
        }
    }
}
