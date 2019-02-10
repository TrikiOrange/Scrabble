package com.nexeo.scrabble.main;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyTestClient {

	 public static void main(String[] args) {

			try {

				Client client = Client.create();

				WebResource webResource = client
				   .resource("http://192.168.1.21:8080/eff/rest/book/test");

				String input = "Hello";

				ClientResponse response = webResource.post(ClientResponse.class, input);

				if (response.getStatus() != 201) {
					throw new RuntimeException("Failed : HTTP error code : "
					     + response.getStatus());
				}

				System.out.println("Output from Server .... \n");
				String output = response.getEntity(String.class);
				System.out.println(output);

			  } catch (Exception e) {

				e.printStackTrace();

			  }

			}
	
}
