package business.concretes;

import business.abstracts.ValidityService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class ValidityManager implements ValidityService {
	
	private UserDao userDao;

	public ValidityManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public boolean isValid(String email) {
		for(User user : userDao.getAll()) {
			if(email.equals(user.getEmail())) {
				System.out.println("This e-mail has been used");
				return false;
			}
		}
		return true;
	}

}
