package Resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.User;

@Path("/users")
public class UserResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> findAll(){
		List<User> users = new ArrayList<User>();
		users.add(new User("1", "joaquin", "leonelli"));
		users.add(new User("2", "paulo", "magnago"));
		return users;
	}
}
