package si.uni_lj.fe.tnuv.wtot2_garden_f.finals;

public class Plant {
    String name, room, watering;
    String last_watering;
    String id;

    public String getLast_watering() {
        /*Calendar calendar = Calendar.getInstance();
        Integer dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
        Integer int_last_watered = Integer.parseInt(last_watered);
        last_watered = String.valueOf(dayOfYear - int_last_watered);*/
        return last_watering;
    }

    public String getId() { return id; }

    public String getName() {
        return name;
    }

    public String getRoom() {
        return room;
    }

    public String getWatering() {
        return watering;
    }
}
