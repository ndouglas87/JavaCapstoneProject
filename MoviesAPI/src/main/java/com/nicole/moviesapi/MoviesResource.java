/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nicole.moviesapi;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author newtonacho
 */
@Path("movies")
@RequestScoped
public class MoviesResource {

    @Context
    private UriInfo context;
    /**
     * Creates a new instance of MoviesResource
     */
    public MoviesResource() {
    }

    /**
     * Retrieves representation of an instance of com.nicole.moviesapi.MoviesResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() throws ProtocolException, IOException {
        //TODO return proper representation object
        URL url = new URL("http://api.themoviedb.org/3/movie/top_rated?api_key=60d845e8c73c057b896bc5aecb81a86c&append_to_response=videos,credits,images&include_image_language=en,null");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setDoOutput(true);
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");

        BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));

        String output;
        Response jsonObject = null;
        
        while ((output = br.readLine()) != null) {
            jsonObject = new Gson().fromJson(output, Response.class);
        }
        return jsonObject;
    }

    /**
     * PUT method for updating or creating an instance of MoviesResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
