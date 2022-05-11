package com.rest.test.client;	

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.test.client.beans.Comment;
import com.rest.test.client.beans.Post;
import com.rest.test.client.beans.User;

@Path("/")
public class PostClient {
	
	Client client;
	String baseUri = "https://jsonplaceholder.typicode.com";
	
	public PostClient() {
		this.client = ClientBuilder.newClient();
	}

	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers() {
		
		List<User> users = client.target(baseUri)
				.path("/users")
				.request(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<User>>() {
					
				});
		
		try {
			return Response.ok(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(users), MediaType.APPLICATION_JSON).build();
		} catch (JsonProcessingException e) {
			return Response.ok(users, MediaType.APPLICATION_JSON).build();
		}

	}
	
	@GET
	@Path("/posts")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPosts() {
		
		List<Post> posts = client.target(baseUri)
				.path("/posts")
				.request(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<Post>>() {
					
				});
		
		try {
			return Response.ok(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(posts), MediaType.APPLICATION_JSON).build();
		} catch (JsonProcessingException e) {
			return Response.ok(posts, MediaType.APPLICATION_JSON).build();
		}

	}
	
	@GET
	@Path("/users/{userId}/posts")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserPosts(@PathParam("userId") String userId) {
		
		List<Post> posts = client.target(baseUri)
				.path("/user/"+userId+"/posts")
				.request(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<Post>>() {
					
				});
		
		try {
			return Response.ok(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(posts), MediaType.APPLICATION_JSON).build();
		} catch (JsonProcessingException e) {
			return Response.ok(posts, MediaType.APPLICATION_JSON).build();
		}

	}
	
	@GET
	@Path("/comments")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getComments() {
		
		List<Comment> comments = client.target(baseUri)
				.path("/comments")
				.request(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<Comment>>() {
					
				});
		
		try {
			return Response.ok(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(comments), MediaType.APPLICATION_JSON).build();
		} catch (JsonProcessingException e) {
			return Response.ok(comments, MediaType.APPLICATION_JSON).build();
		}

	}
	
	@GET
	@Path("/posts/{postId}/comments")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPostComments(@PathParam("postId") String postId) {
		
		List<Comment> comments = client.target(baseUri)
				.path("/post/"+postId+"/comments")
				.request(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<Comment>>() {
					
				});
		
		try {
			return Response.ok(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(comments), MediaType.APPLICATION_JSON).build();
		} catch (JsonProcessingException e) {
			return Response.ok(comments, MediaType.APPLICATION_JSON).build();
		}

	}

}
