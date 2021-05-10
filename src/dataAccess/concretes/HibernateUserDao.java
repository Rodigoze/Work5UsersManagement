package dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class HibernateUserDao implements UserDao {
	private List<User> users;

	public HibernateUserDao(List<User> users) {
		super();
		this.users = new ArrayList<User>();
	}

	@Override
	public void add(User user) {
		this.users.add(user);
		System.out.println("User added : "+ user.getFirstName());
		
		
	}

	@Override
	public void update(User user) {
		System.out.println("User updated");
		
	}

	@Override
	public void delete(User user) {
		System.out.println("User deleted");
		
	}

	@Override
	public List<User> getAll() {
		return this.users;
	}

	
	

}
