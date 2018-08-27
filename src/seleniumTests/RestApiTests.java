package seleniumTests;

import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.junit.Assert.assertEquals;

import java.util.List;
import org.json.simple.*;


 
public class RestApiTests {	
	int postId;
 
	

	//Find the highest possible id and return response details for this id
	//Compare details with already known values
	
	
	@Test
	public void GetBodyForTheHighestId()
	{   
		
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		int expectedHighestId = 100;
		
		int statusCode = 200;
		int highestId = 1;
		int id = 1;
		String bodyForHighestId = "";
		
		
		while(statusCode == 200)
		 {
			Response response = httpRequest.request(Method.GET, "/posts/" + id);
			statusCode = response.getStatusCode();
			if (statusCode != 200) {
				break;
			}
			highestId = id;
			bodyForHighestId = response.getBody().asString();
			id = id + 1;
		} 
		
		System.out.println("HighestId is =>  " + highestId);
		assertEquals(highestId, expectedHighestId);
		
		System.out.println("Response for highestId:" + bodyForHighestId);
	} 
	
	
	
	//For given userId find the value with the highest id
	//And return postId for the highest id found in previous step
	
	@Test
	public void GetTheHighestBodyForUserId()
	{   
		
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		int userId = 9;
		
		
		Response response = httpRequest.request(Method.GET, "/posts/?userId=" + userId);
		
		List<UserIdData> userIdAllData = response.jsonPath().getList("", UserIdData.class);
		int highestId = 0;
		int expectedHighestId = 90;
		int expectedPostId = 18;
		
		
		for(UserIdData entry: userIdAllData)
		{
			if (entry.id > highestId) {
				highestId = entry.id;
			}
			
		}
		
		System.out.println("Highest id for given userId: " + highestId);
		assertEquals(highestId, expectedHighestId);
		
        response = httpRequest.request(Method.GET, "/comments/?id=" + highestId);
         
		List<PostIdData> postIdAllData = response.jsonPath().getList("", PostIdData.class);
		
		
		for(PostIdData entry: postIdAllData)
		{
			postId = entry.postId;
		}
		
		assertEquals(postId, expectedPostId);
				
	} 
	
	
	
	//Add new comment for postId equal to 19
	//Tests are not dependent on each other
	
	@Test
	public void ChangeCommentForPostId()
	{   
		
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		RequestSpecification httpRequest = RestAssured.given();
		
		System.out.println("postId in 3rd test:" + 18);
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("postId", 18);
		requestParams.put("name", "Piotr"); 
		requestParams.put("email", "peter.lasecc@gmail.com");
		requestParams.put("body", "My comment");
		
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParams.toJSONString());
		 
		Response postResponse = httpRequest.post("/comments");
		assertEquals(postResponse.getStatusCode(), 201);
	};
	
	
	
	private class UserIdData {
		int userId;
		int id;
		String title;
		String body;
	}
	
	private class PostIdData {
		int postId;
		int id;
		String name;
		String email;
		String body;
	}
 
}
