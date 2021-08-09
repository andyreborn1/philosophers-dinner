package dev.nemowave;

public class PhilosopherTwo extends Philosopher {
    private int eatCount = 0;

    public PhilosopherTwo(int id, Fork leftFork, Fork rightFork) {
        super(id, leftFork, rightFork);
    }

    @Override
    public void run() {
        while (true) {
            think();
            if ( leftFork.get()) {
                System.out.printf("Filósofo %d pegou o garfo esquerdo\n", this.id);

                if (rightFork.get()) {
                    System.out.printf("Filósofo %d pegou o garfo direito\n", this.id);
                    System.out.format("Filósofo %d está comendo\n", this.id);

                    aMimir(2000);
                    leftFork.put();
                    rightFork.put();
                } else {
                    System.out.printf("Filósofo %d não pegou o garfo direito\n", this.id);
                    leftFork.put();
                }
            }
        }
    }
}
