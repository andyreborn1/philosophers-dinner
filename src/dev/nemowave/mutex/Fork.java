/**
 * implementação usando semáforo do java
 */

package dev.nemowave.mutex;

import java.util.concurrent.Semaphore;

public class Fork {

    Semaphore mutex = new Semaphore(1);

    public void get() {
        try {
            mutex.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void put() {
        mutex.release();
    }
}
