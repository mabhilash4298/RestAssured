package steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import config.ConfigReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.internal.mapping.GsonMapper;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

import static io.restassured.RestAssured.given;


public class UserSteps {
    Response response;
 
 RequestSpecification requestSpecification=new RequestSpecBuilder().build();




    @Given("the API base URI is set")
    public void setApiBaseUri() throws IOException, ClassNotFoundException {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("Test");
        // Create or read JSON root node
        JsonNode rootNode = mapper.readTree("{\"name\":\"John\"}");
        ObjectNode objectNode = (ObjectNode) rootNode;
        objectNode.put("country", "India");
        objectNode.put("age", 35);

        System.out.println(mapper.writeValueAsString(objectNode));
        System.out.println(objectNode.get("name").asText());


        List<Map<String,String>> value=new ArrayList<>();

        Map<String, String> map=new HashMap<>();
        map.put("name","Ranger");
        map.put("Age","35");
        value.add(map);

        System.out.println(value);

        ObjectMapper mapper1=new ObjectMapper();

        JsonNode node=mapper1.readTree( mapper1.writeValueAsString(value));

        System.out.println(node.get(0).get("name").asText());

            JavaClassTest javaClassTest=new JavaClassTest(1,"Abhilash",25);

            mapper.writeValue(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\test\\value.json"),javaClassTest);

            String objectString= mapper.writeValueAsString(javaClassTest);

        System.out.println(objectString);

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("person.ser"));
        out.writeObject(javaClassTest);
        out.close();

        ObjectInputStream in=new ObjectInputStream(new FileInputStream("person.ser"));

        FileInputStream fileIn=new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\test\\value.json"));

        String classValue=new String(fileIn.readAllBytes(), StandardCharsets.UTF_8);
        System.out.println("class Test "+classValue);

        JsonNode nodetest=mapper.readTree(classValue);

        System.out.println(nodetest.getNodeType()+" "+nodetest.size());


        for(int i=0;i< nodetest.size();i++){
            System.out.println("Node Value at "+nodetest.get(i));
        }

        JavaClassTest javaClassTest1=(JavaClassTest) in.readObject();
        in.close();

        System.out.println(javaClassTest1.toString());


//        RestAssured.baseURI = ConfigReader.get("baseURI");
    }

    @When("I send a GET request to {string}")
    public void sendGetRequest(String endpoint) {
//        response = given().headers("Authorization","Bearer "+ RestAssured.sessionId)
//                .when().get(endpoint);
//
//        response=given().spec(requestSpecification).put();
//
//        ObjectMapper mapper =new ObjectMapper();
//        String value=mapper.writeValueAsString(response);

    }

    @When("I send a POST request to {string} with body:")
    public void sendPostRequest(String endpoint, DataTable table) {
//        Map<String, String> body = table.asMap(String.class, String.class);
//        response = given()
//                .header("Content-Type", "application/json")
//                .body(body)
//                .when()
//                .post(endpoint);

    }
    @Then("the response status code should be {int} TokenSet")
    public void verifyStatusCodeSetToken(int statusCode) {
//        response.then().statusCode(statusCode);
//        String Token=response.body().asPrettyString();
//        System.out.println(Token);
//
//        RestAssured.sessionId= response.body().asPrettyString();

    }

    @Then("the response status code should be {int}")
    public void verifyStatusCode(int statusCode) {
//        response.then().statusCode(statusCode);
//
//        String bodyData=response.body().asPrettyString();
//        JsonPath json = new JsonPath(bodyData);
//        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//        File filevalue=new File("src/test/resources/loginResponse_"+timestamp+".json");
//
//        try (FileWriter file = new FileWriter(filevalue)) {
//
//            file.write(bodyData);
//            System.out.println("JSON saved to loginResponse.json");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }




//    @Then("the response should contain {string} as {string}")
//    public void verifyResponseField(String jsonPath, String expectedValue) {
//        response.then().body(jsonPath, equalTo(expectedValue));
//    }
//
//    @Then("the response should contain {string} as {int}")
//    public void verifyResponseFieldInt(String jsonPath, int expectedValue) {
//        response.then().body(jsonPath, equalTo(expectedValue));
//    }
}
