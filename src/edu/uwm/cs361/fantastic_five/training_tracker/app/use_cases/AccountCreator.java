package edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases;

import javax.jdo.PersistenceManager;

import edu.uwm.cs361.fantastic_five.training_tracker.app.entities.Student;
import edu.uwm.cs361.fantastic_five.training_tracker.app.entities.account;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.requests.CreateAccountRequest;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.responses.CreateAccountResponse;
import edu.uwm.cs361.fantastic_five.training_tracker.services.AccountValidator;
import edu.uwm.cs361.fantastic_five.training_tracker.services.PersistenceService;

public class AccountCreator {
	public CreateAccountResponse createAccount(CreateAccountRequest req) {
		PersistenceManager pm = getPersistenceManager();
		CreateAccountResponse resp = new CreateAccountResponse();
		
		resp.success = false;
		resp.errors = new AccountValidator().validate(req.address, req.phone);
		if (!resp.errors.isEmpty()) {
			return resp;
		}

		try {
			Student student = pm.getObjectById(Student.class,Long.parseLong(req.primary));
			pm.makePersistent(new account(student, req.address, req.phone));
			resp.success = true;
		} finally {
			pm.close();
		}

		return resp;
	}
	public CreateAccountResponse createDependent(CreateAccountRequest req) {
		PersistenceManager pm = getPersistenceManager();
		CreateAccountResponse resp = new CreateAccountResponse();
		try {
			account account = pm.getObjectById(account.class,Long.parseLong(req.primary));
			account.addDependent(pm.getObjectById(Student.class,Long.parseLong(req.student)));
			resp.success = true;
			} catch(Exception e) {
				resp.success = false;
			}
		
		return resp;
	}
	private PersistenceManager getPersistenceManager()
	{
		return PersistenceService.getPersistenceManager();
	}
}
