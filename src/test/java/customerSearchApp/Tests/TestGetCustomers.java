package customerSearchApp.Tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import customerSearchApp.CommonUtils;
import customerSearchApp.Constants;
import customerSearchApp.FileUtils;
import customerSearchApp.HttpUtils;
import io.restassured.response.Response;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import responseModels.AllCustomersDetailsModel;
import responseModels.CustomerDetailsModel;
import responseModels.LoginResponseModel;

import java.util.List;

public class TestGetCustomers {

    public String loginFilePath;
    public HttpUtils httpUtils = new HttpUtils();
    public CommonUtils commonUtils = new CommonUtils();
    public Gson gson;



    @BeforeSuite
    public void setup(){
        loginFilePath = FileUtils.authenticatinFilePath;
        commonUtils.setUpHeaders("Content-Type","application/json");
        String request = commonUtils.convertJSONTORequestString(loginFilePath);
        Response loginResponse = httpUtils.HttpsPOST(request,"authenticate");
        loginResponse.then().log().all();

        //Response Assertions
        loginResponse.then().assertThat().statusCode(200);

        gson = new Gson();
        LoginResponseModel loginResponseModel =
                gson.fromJson(loginResponse.getBody().asString(), LoginResponseModel.class);
        commonUtils.setUpHeaders("Authorization","Bearer " + loginResponseModel.getToken());

    }


    @Test(priority = 1)
    public void fetchAllUserDetails(){

        gson = new Gson();

        //fetch All users
        Response response = httpUtils.HttpsGET(Constants.getUsersPath);
        response.then().log().all();

        //Response Assertions
        response.then().assertThat().statusCode(200);

        //Used Type Token to forcefully create pojo
        List<AllCustomersDetailsModel> customersDetailsModelsList =
                gson.fromJson(response.getBody().asString(),new TypeToken<List<AllCustomersDetailsModel>>(){}.getType());


    }


    @Test(priority = 2)
    public void fetchUsersByPhoneNumber(){
        gson = new Gson();
        Response response = httpUtils.HttpsGET(Constants.getUsersPath+"/9972939567");

        //Response Assertions
        response.then().assertThat().statusCode(200);
        response.then().log().all();

        CustomerDetailsModel customerDetailsModel =
                gson.fromJson(response.getBody().asString(), CustomerDetailsModel.class);
    }


    @AfterSuite
    public void clearData(){
        commonUtils.clearHeader();
    }
}
