package edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases;

import java.util.List;

import javax.jdo.PersistenceManager;

import edu.uwm.cs361.fantastic_five.training_tracker.app.entities.account;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.requests.ListAccountsRequest;
import edu.uwm.cs361.fantastic_five.training_tracker.app.use_cases.responses.ListAccountsResponse;
import edu.uwm.cs361.fantastic_five.training_tracker.services.PersistenceService;

public class AccountFinder {
	@SuppressWarnings("unchecked")
	public ListAccountsResponse listAccounts(ListAccountsRequest req) {
		ListAccountsResponse resp = new ListAccountsResponse();

		PersistenceManager pm = getPersistenceManager();

		resp.accounts = (List<account>) pm.newQuery(account.class).execute();

		return resp;
	}

	public ListAccountsResponse listAccounts() {
		return listAccounts(new ListAccountsRequest());
	}

	private PersistenceManager getPersistenceManager()
	{
		return PersistenceService.getPersistenceManager();
	}
}