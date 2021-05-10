package business.abstracts;

import entities.concretes.User;

public interface UserService {
	
	void register(User user);
	void SignIn(String email,String password,User user);

}
