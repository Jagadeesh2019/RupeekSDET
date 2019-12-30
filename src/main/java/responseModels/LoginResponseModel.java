package responseModels;

import com.google.gson.annotations.SerializedName;


public class LoginResponseModel {


    /**
     * token : eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJydXBlZWsiLCJleHAiOjE1Nzc3MDQ4MzcsImlhdCI6MTU3NzY4NjgzN30.86_J9UBWIiuGWVwS8jtbZDj08KwojU6H3tahPf5p0suYZiBiwqjjXOz6-Nm_S8Dl6JiJsm47Sf4d4IbCjx_EtA
     */
    @SerializedName("token")
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
