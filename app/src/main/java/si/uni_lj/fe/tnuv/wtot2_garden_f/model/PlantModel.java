package si.uni_lj.fe.tnuv.wtot2_garden_f.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class PlantModel implements Parcelable {

    private String name;
    private String address;
    private String image;
    // to del
    private float delivery_charge;
    private Hours hours;
    private List<Menu> menus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getDelivery_charge() {
        return delivery_charge;
    }

    public void setDelivery_charge(float delivery_charge) {
        this.delivery_charge = delivery_charge;
    }

    public Hours getHours() {
        return hours;
    }

    public void setHours(Hours hours) {
        this.hours = hours;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    protected PlantModel(Parcel in) {
        name = in.readString();
        address = in.readString();
        image = in.readString();
        delivery_charge = in.readFloat();
        menus = in.createTypedArrayList(Menu.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(address);
        dest.writeString(image);
        dest.writeFloat(delivery_charge);
        dest.writeTypedList(menus);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PlantModel> CREATOR = new Creator<PlantModel>() {
        @Override
        public PlantModel createFromParcel(Parcel in) {
            return new PlantModel(in);
        }

        @Override
        public PlantModel[] newArray(int size) {
            return new PlantModel[size];
        }
    };
}
