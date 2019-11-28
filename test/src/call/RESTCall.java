package call;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.hk2.api.Immediate;
import org.glassfish.jersey.process.internal.RequestScoped;

import call.MapEditor;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import javax.sound.midi.Track;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.Application;

import java.io.FileNotFoundException; 
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Singleton
@Path("/")
public class RESTCall {
	private ArrayList<Map> maps = new ArrayList<Map>();
	
	
	public void addMap(int width, int height, int numberOfPlayers, String name) {// exceptions! w,h, min max 0
		
		Map newMap = new Map(width, height, numberOfPlayers, maps.size()+1, name);
		maps.add(newMap);
		
	}
	
	public void removeMap(int id) { // it doesn't check for duplicates yet tho

				maps.remove(id);
	}
	
	 
	 @GET
	 @Produces(MediaType.APPLICATION_JSON)
	 @Singleton
	 @Path ("/test")
	 public Map test() {
		 addMap(64, 64, 4, "Stubydoobydoo");
		 return maps.get(0);
	 }
	 /*
	 
	 @GET
	 @Produces(MediaType.APPLICATION_JSON)
	 @Singleton
	 @Path ("/getMap")
	 public Map getMap(@QueryParam ("MapID") int MapID) {
		 return me.maps.get(MapID);
	 }
	 
	 @GET
	 @Produces(MediaType.APPLICATION_JSON)
	 @Singleton
	 @Path ("/isNameOccupied")
	 public Boolean isNameOccupied(@QueryParam ("mapName") String mapName) {
		 Boolean isOccupied = Boolean.FALSE;
		 for(int i = 0; i < me.maps.size(); i++) {
			 if(me.maps.get(i).getName().equals(mapName)) {
				 isOccupied = Boolean.TRUE;
			 }
		 }
		 return isOccupied;
	 }
	 
	 @GET
	 @Produces(MediaType.APPLICATION_JSON)
	 @Singleton
	 @Path("/getMapsWithXPlayers/{NumberOfPlayers}")
	 public Response getMapsWithXPlayers(@QueryParam("NumberOfPlayers") int NumberOfPlayers) {
		 ArrayList<Map> temp = new ArrayList<Map>();
		 
		 for (int i =0; i< me.maps.size(); i++) {
			 if(me.maps.get(i).getNumberOfPlayers() == NumberOfPlayers)
				 temp.add(me.maps.get(i));
		 }
		 
		 return Response.ok(temp).build();
	 }
	 
	 @GET
	 @Produces(MediaType.APPLICATION_JSON)
	 @Singleton
	 @Path("/getAllMaps")
	 public Response getAllMaps() {		 
		 return Response.ok(me.maps).build();
	 }
	 
	 @POST
	 @Produces(MediaType.TEXT_HTML)
	 @Singleton
	 @Path("/uploadMap")
	 public String uploadMap(@QueryParam("xPos") String xPos) {
		 
		 return xPos;
	 }
	 
	 @PUT
	 @Produces(MediaType.APPLICATION_JSON)
	 @Singleton
	 @Path("/updateMap")
	 public String updateMap(@QueryParam("id") int id, @QueryParam("mapGrid") String[][] mapgrid) {
		 //
		 return "success";
	 }
	 
	 @DELETE
	 @Produces(MediaType.APPLICATION_JSON)
	 @Singleton
	 @Path("/deleteMap")
	 public String deleteMap(@QueryParam("id") int id) {

		 me.maps.remove(id);
		 
		 return "success";
	 }*/
	 

}