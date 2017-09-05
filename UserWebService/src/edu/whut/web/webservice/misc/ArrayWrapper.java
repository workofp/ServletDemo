package edu.whut.web.webservice.misc;

import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.Root;

import edu.whut.web.domain.Organization;
import edu.whut.web.domain.Role;
import edu.whut.web.domain.User;

@Root
public class ArrayWrapper {

	@ElementArray(required = false)
	public User[] users;
	
	@ElementArray(required = false)
	public Organization[] organizations;
	
	@ElementArray(required = false)
	public Role[] roles;	

}
