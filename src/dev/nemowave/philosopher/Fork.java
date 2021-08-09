/**
 * O garfo pode ter o valor de 0 ou 1
 * 1 indica que ele está livre e 0 indica que ele está em uso
 */

package dev.nemowave.philosopher;

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

    public void put() {
        this.value = 1;
    }
}
