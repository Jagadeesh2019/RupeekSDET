package customerSearchApp;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class HttpUtils {


    public Response HttpsGET(String path){
        setAppHeader();
        RestAssured.baseURI = Constants.baseURL;
        Response response = given().headers(CommonUtils.headers).get(path);
        response.then().log().all();
        return response;
    }


    public Response HttpsPOST(String requestBody,String additionalPath){
        setAppHeader();
        RestAssured.baseURI = Constants.baseURL;
        Response response = given().headers(CommonUtils.headers).body(requestBody).post(additionalPath);
        response.then().log().all();
        return response;
    }


    private void setAppHeader(){

    }


}
