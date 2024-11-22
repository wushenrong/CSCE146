/*
 * Samuel Wu
 * 2024-11-22
 */

package homework.homework06;

import labs.lab08.MinHeap;

public class SheepShearer {
    private MinHeap<Sheep> sheep;
    private Sheep currentSheep;
    private int timeLeftToShear;

    public SheepShearer() {
        sheep = new MinHeap<>();
        currentSheep = null;
        timeLeftToShear = 0;
    }

    public void addSheep(Sheep data) {
        if (data == null) {
            return;
        }

        if (currentSheep == null) {
            currentSheep = data;
            timeLeftToShear = currentSheep.getShearingTime();
            return;
        }

        sheep.add(data);
    }

    /**
     * Shear a sheep by decreasing the time left to shear the sheep. If the
     * sheep is done shearing, return the sheep after a new sheep is ready to be
     * sheared. Else return null.
     */
    public Sheep shearSheep() {
        timeLeftToShear--;

        if (timeLeftToShear == 0) {
            Sheep ret = currentSheep;
            currentSheep = sheep.remove();

            if (currentSheep != null) {
                timeLeftToShear = currentSheep.getShearingTime();
            }

            return ret;
        }

        return null;
    }

    public boolean isDone() {
        return currentSheep == null;
    }
}
