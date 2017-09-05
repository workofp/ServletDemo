package edu.whut.web.webservice;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import edu.whut.web.domain.User;
import edu.whut.web.service.UserService;
import edu.whut.web.webservice.misc.ArrayWrapper;

@WebService
public class UserWebService {
	private UserService userService;

	public String getUser(long id) throws IOException {
		try {
			User user = getUserService().getUser(id);
			if (user != null) {
				Serializer serializer = new Persister();
				StringWriter writer = new StringWriter();
				serializer.write(user, writer);
				return writer.toString();
			}
		} catch (IOException e) {
			throw e;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getAllUser() throws IOException {
		try {
			List<User> userList = userService.getAllUsers();
			User[] users = new User[userList.size()];
			users = userList.toArray(users);
			
			ArrayWrapper wrapper = new ArrayWrapper();
			wrapper.users = users;
			Serializer serializer = new Persister();
			StringWriter writer = new StringWriter();
			serializer.write(wrapper, writer);
			return writer.toString();
		} catch (IOException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}	
	
	@WebMethod(exclude = true)
	public UserService getUserService() {
		return userService;
	}

	@WebMethod(exclude = true)
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
