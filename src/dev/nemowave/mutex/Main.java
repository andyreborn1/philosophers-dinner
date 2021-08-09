
/**
 * Usando a solução de dijkstra para evitar deadlock
 * o filósofo sempre irá pegar o garfo de menor id
 */

package dev.nemowave.mutex;

public class Main {
    public static void main(String[] args) {
        int size = 5;

        Philosopher[] philosophers = new Philosopher[size];
        Fork[] forks = new Fork[size];

        for (int i = 0; i < size; i++) {
            forks[i] = new Fork();
        }

        for (int i = 0; i < size; i++) {
            Fork leftFork = forks[i];
            Fork rightFork = forks[(i + 1) % size];

            if (i == size - 1) {
                philosophers[i] = new Philosopher(i, rightFork, leftFork);
            } else {
                philosophers[i] = new Philosopher(i, leftFork, rightFork);
            }

            Thread thread = new Thread(philosophers[i]);
            thread.start();
        }
    }
}
