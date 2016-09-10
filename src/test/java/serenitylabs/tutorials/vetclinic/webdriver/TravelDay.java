package serenitylabs.tutorials.vetclinic.webdriver;

/**
 * Created by aatchoud on 9/10/2016.
 */
public enum TravelDay {
    Today(0),Tomorrow(1);

    private final int daysInFuture;

    TravelDay(int daysInFuture) {
        this.daysInFuture = daysInFuture;
    }

    public int getDaysInFuture() {
        return daysInFuture;
    }

}
