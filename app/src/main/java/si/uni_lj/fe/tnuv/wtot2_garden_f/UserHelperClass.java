package si.uni_lj.fe.tnuv.wtot2_garden_f;

public class UserHelperClass {

    String name, room;
    String watering;
    String last_watering;


    public UserHelperClass(){

    }
    public UserHelperClass(String name, String room, String watering, String last_watering) {
        this.name = name;
        this.room = room;
        this.watering = watering;
        this.last_watering = last_watering;
    }
    public String getLast_watering() {
        return last_watering;
    }

    public void setLast_watering(String last_watering) {
        this.last_watering = last_watering;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getWatering() {
        return watering;
    }

    public void setWatering(String watering) {
        this.watering = watering;
    }
}
