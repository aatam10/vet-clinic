package serenitylabs.tutorials.vetclinic.webdriver;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Objects;

/**
 * Created by aatchoud on 9/11/2016.
 */
public class TripPreferences {

    private final String arriveOrDepart;
    private final String fromStation;
    private final String toStation;
    private final String selectedDay;
    private final String selectedHour;
    private final String selectedMinute;

    public TripPreferences(String arriveOrDepart,
                           String fromStation,
                           String toStation,
                           String selectedDay,
                           String selectedHour,
                           String selectedMinute) {
        this.arriveOrDepart = arriveOrDepart;
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.selectedDay = selectedDay;
        this.selectedHour = selectedHour;
        this.selectedMinute = selectedMinute;
    }


    public String getArriveOrDepart() {
        return arriveOrDepart;
    }

    public String getFromStation() {
        return fromStation;
    }

    public String getToStation() {
        return toStation;
    }

    public String getSelectedDay() {
        return selectedDay;
    }

    public String getSelectedHour() {
        return selectedHour;
    }

    public String getSelectedMinute() {
        return selectedMinute;
    }

    public static TripPreferencesBuilder arrivingOrDeparting(String arriveOrDepart) {
        return new TripPreferencesBuilder(arriveOrDepart);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TripPreferences that = (TripPreferences) o;

        return Objects.equals(arriveOrDepart,that.arriveOrDepart) &&
                Objects.equals(fromStation,that.fromStation) &&
                Objects.equals(toStation,that.toStation) &&
                Objects.equals(shortened(selectedDay),shortened(that.selectedDay)) &&
                Objects.equals(selectedHour,that.selectedHour) &&
                Objects.equals(selectedMinute,that.selectedMinute);
    }

    private String shortened(String selectedDay) {
        return selectedDay.split("\\(")[0].trim();
    }

    @Override
    public int hashCode() {
        return Objects.hash(arriveOrDepart,fromStation,toStation,selectedDay,selectedHour,selectedMinute);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("arriveOrDepart",arriveOrDepart)
                .append("fromStation",fromStation)
                .append("toStation",toStation)
                .append("selectedDay",selectedDay)
                .append("selectedHour",selectedHour)
                .append("selectedMinute",selectedMinute)
                .toString();
    }

    public static class TripPreferencesBuilder {
        private final String arriveOrDepart;
        private String fromStation;
        private String toStation;
        private String selectedDay;

        public TripPreferencesBuilder(String arriveOrDepart) {
            this.arriveOrDepart = arriveOrDepart;
        }

        public TripPreferencesBuilder from(String fromStation) {
                this.fromStation = fromStation;
            return this;
        }

        public TripPreferencesBuilder to(String toStation) {
            this.toStation = toStation;
            return this;
        }

        public TripPreferencesBuilder arrivingOn(String selectedDay) {
            this.selectedDay = selectedDay;
            return this;
        }

        public TripPreferences at(String selectedHour, String selectedMinute) {
            return new TripPreferences(arriveOrDepart,
                    fromStation,
                    toStation,
                    selectedDay,
                    selectedHour,
                    selectedMinute);

        }
    }
}
