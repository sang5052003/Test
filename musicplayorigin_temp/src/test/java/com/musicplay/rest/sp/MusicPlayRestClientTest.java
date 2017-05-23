package com.musicplay.rest.sp;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.musicplay.rest.domain.User;

public class MusicPlayRestClientTest {
	//
	@Test
	public void testUserList() throws ClientProtocolException, IOException {
		//
		String url = "http://localhost:8080/musicplayrest/users";
		HttpGet httpGet = new HttpGet(url);
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = httpClient.execute(httpGet);
		
		int responseStatusCode = getResponseStatus(response);
		String responseContent = getResponseContent(response);
		System.out.println(responseStatusCode);
		
		// json to object
		TypeToken<List<User>> typeToken = new TypeToken<List<User>>(){};
		Type type = typeToken.getType();
	    List<User> users = new Gson().fromJson(responseContent, type);
	    
	    for(User user : users) {
	    	System.out.print(user.getLoginId());
	    	System.out.print(", " + user.getName());
	    	System.out.println(", " + user.getPassword());
	    }
		
		response.close();
		
	}
	
	@Test
	public void testUser() throws ClientProtocolException, IOException {
		//
		String url = "http://localhost:8080/musicplayrest/users/kim";
		HttpGet httpGet = new HttpGet(url);
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = httpClient.execute(httpGet);
		
		int responseStatusCode = getResponseStatus(response);
		String responseContent = getResponseContent(response);
		System.out.println(responseStatusCode);
		
		// json to object
	    User user = new Gson().fromJson(responseContent, User.class);
	    
    	System.out.print(user.getLoginId());
    	System.out.print(", " + user.getName());
    	System.out.println(", " + user.getPassword());
		
		response.close();
	}
	
	/**
	 * 응답내용
	 * @param response
	 * @return
	 */
	private String getResponseContent(CloseableHttpResponse response)  {
		//
		HttpEntity httpEntity = response.getEntity();
		InputStream is = null;
		StringBuilder contentBuilder = new StringBuilder();
		try {
			is = httpEntity.getContent();
			byte[] contentBytes = new byte[1024];
			while(true) {
				int readCount = is.read(contentBytes);
				if(readCount == -1) {
					break;
				}
				
				contentBuilder.append(new String(contentBytes, 0, readCount));
			}
		} catch (UnsupportedOperationException | IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(is != null) { is.close(); }
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return contentBuilder.toString();
	}
	
	/**
	 * 응답상태코드
	 * @param response
	 * @return
	 */
	private int getResponseStatus(CloseableHttpResponse response) {
		//
		return response.getStatusLine().getStatusCode();
	}
}
