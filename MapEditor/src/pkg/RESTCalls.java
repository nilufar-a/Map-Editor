package pkg;

import java.awt.List;
import java.util.ArrayList;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.internal.guava.Maps;


@Path("/map-editor")
public class RESTCalls {
	MapEditor me = new MapEditor();
	 @GET
	 @Produces(MediaType.APPLICATION_JSON)
	 @Path ("/getMap")
	 public Map getMap(@QueryParam ("MapID") int MapID) {
		 return me.maps.get(MapID);
	 }
	 
	 @GET
	 @Produces(MediaType.APPLICATION_JSON)
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
	 @Path("/getAllMaps")
	 public Response getAllMaps() {		 
		 return Response.ok(me.maps).build();
	 }
	 
	 @POST
	 @Produces(MediaType.TEXT_HTML)
	 @Path("/uploadMap")
	 public String uploadMap(@QueryParam("xPos") String xPos) {
		 
		 return xPos;
	 }
	 
	 @PUT
	 @Produces(MediaType.APPLICATION_JSON)
	 @Path("/updateMap")
	 public String updateMap(@QueryParam("id") int id, @QueryParam("mapGrid") String[][] mapgrid) {
		 //
		 return "success";
	 }
	 
	 @DELETE
	 @Produces(MediaType.APPLICATION_JSON)
	 @Path("/deleteMap")
	 public String deleteMap(@QueryParam("id") int id) {

		 me.maps.remove(id);
		 
		 return "success";
	 }
	 

}
