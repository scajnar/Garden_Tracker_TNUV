package si.uni_lj.fe.tnuv.wtot2_garden_f;

public class UserHelperClass {

    String name, room;
    Integer watering;
    public UserHelperClass(){

    }
    public UserHelperClass(String name, String room, Integer watering) {
        this.name = name;
        this.room = room;
        this.watering = watering;
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

    public Integer getWatering() {
        return watering;
    }

    public void setWatering(Integer watering) {
        this.watering = watering;
    }
}
