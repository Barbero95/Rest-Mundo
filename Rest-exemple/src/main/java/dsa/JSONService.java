package dsa;

import Mundo.Objeto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/json")
public class JSONService {

    protected List<Track> tracks;

    protected Mundo mundo;

    public JSONService() {
        tracks = Singleton.getInstance().getTrack();
        mundo = Singleton.getInstance().getMundo();

        if (tracks.size()==0) {
            Track t1 = new Track();
            t1.setTitle("Enter Sandman");
            t1.setSinger("Metallica");
            tracks.add(t1);

            Track t2 = new Track();
            t2.setTitle("La Barbacoa");
            t2.setSinger("Georgie Dann");
            tracks.add(t2);
        }

    }

    @GET
    @Path("/user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario getUser(@PathParam("id") String id) {
        return mundo.consultarUsuario(id);
    }
    //Preguntar!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    @GET
    @Path("/obj/{user}/{obj}")
    @Produces(MediaType.APPLICATION_JSON)
    public Objeto getObj(@PathParam("user"+"obj") Usuario user, String nomObj) {
        return mundo.consultarObjetoDeUsuario(user, nomObj );
    }

    @POST
    @Path("/user")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newUser(Usuario user) {
        boolean result = mundo.crearUsuario(user);

        if(result) {
            return Response.status(201).entity("User added correctly").build();
        } else {
            return Response.status(409).entity("User already exists").build();
        }

    }
    @POST
    @Path("/obj")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newObj (Usuario user, Objeto o) {
        mundo.añadirObjetoAUsuario(user, o);
        return Response.status(201).entity("Object added correctly").build();

    }

    @GET
    @Path("/got/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Track getTrack(@PathParam("id") int id) {
        return tracks.get(id);
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Track getTrackInJSON() {

        Track track = new Track();
        track.setTitle("Enter Sandman");
        track.setSinger("Metallica");

        return track;

    }

    @POST
    @Path("/new")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newTrack(Track track) {
        tracks.add(track);
        // Atencion: siempre añade en la misma posicion por el scope de tracks
        return Response.status(201).entity("Track added in position "+tracks.size()).build();
    }
    /*
    @POST
    @Path("/newObj")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newTrack(Track track) {
        tracks.add(track);
        // Atencion: siempre añade en la misma posicion por el scope de tracks
        return Response.status(201).entity("Track added in position "+tracks.size()).build();
    }
    */

    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createTrackInJSON(Track track) {

        String result = "Track saved : " + track;
        return Response.status(201).entity(result).build();
    }

}