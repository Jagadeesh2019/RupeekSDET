package responseModels;

import com.google.gson.annotations.SerializedName;

public class AllCustomersDetailsModel {


    /**
     * first_name : Aliko
     * last_name : Dangote
     * career : Billionaire Industrialist
     * phone : 8037602400
     */

    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
    @SerializedName("career")
    private String career;
    @SerializedName("phone")
    private String phone;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
