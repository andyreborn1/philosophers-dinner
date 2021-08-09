package dev.nemowave;

import java.util.concurrent.Semaphore;

public class Fork {

    private int value;

    public Fork(int value) {
        this.value = value;
    }

    public boolean get() {
        if (this.value == 1) {
            this.value = 0;
            return true;
        }
        return false;
    }

    public int getValue() {
        return value;
    }

    public void put() {
        this.value = 1;
    }

    public boolean free() {
        if (this.value == 1) {
            return true;
        }
        return false;
    }
}
