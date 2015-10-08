package Resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.UserDAO;
import model.User;

@Path("/users")
public class UserResource {

	UserDAO userDAO = new UserDAO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> findAll() {
		return userDAO.findAll();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User findById(@PathParam("id") String id) {
		User user = new User();
		return user;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void createUser(User user) {

		userDAO.saveOrUpdate(user);
	}
}
