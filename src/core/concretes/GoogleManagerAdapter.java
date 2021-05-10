package core.concretes;

import core.abstracts.RegisterService;
import google.googleManager;

public class GoogleManagerAdapter implements RegisterService{

	@Override
	public void register() {
		googleManager manager = new googleManager();
		manager.register();
		
	}

}
