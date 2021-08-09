package dev.nemowave.philosopher;

public class Main {
    public static void main(String[] args) {
        int size = 5;

        Philosopher[] philosophers = new Philosopher[size];
        PhilosopherTwo[] philosopherTwo = new PhilosopherTwo[size];

        Fork[] forks = new Fork[size];

        for (int i = 0; i < size; i++) {
            forks[i] = new Fork(1);
        }

        for (int i = 0; i < size; i++) {
            Fork leftFork = forks[i];
            Fork rightFork = forks[(i + 1) % size];

            Thread thread;

//            philosophers[i] = new Philosopher(i,leftFork,rightFork);
//            thread = new Thread(philosophers[i]);

            philosopherTwo[i] = new PhilosopherTwo(i, leftFork, rightFork);
            thread = new Thread(philosopherTwo[i]);

            thread.start();
        }
    }
}
