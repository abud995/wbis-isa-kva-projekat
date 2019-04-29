package wis.web.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.annotation.JsonView;

import wis.domain.AccountData;
import wis.service.AccountDataService;
import wis.utils.View.HideOptionalProperties;

@Controller
public class AccountDataController {

	@Autowired
	AccountDataService ads;
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping()
	public ResponseEntity<Iterable<AccountData>> getAccountData() {
		return new ResponseEntity<Iterable<AccountData>>(ads.getAccountDatas(), HttpStatus.OK);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<AccountData> addAccountData(@RequestBody AccountData AccountData) {
		ads.addAccountData(AccountData);
		return new ResponseEntity<AccountData>(AccountData, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<AccountData> updateAccountData(@PathVariable Long id, @RequestBody AccountData AccountData) {
		ads.updateAccountData(id, AccountData);
		return new ResponseEntity<AccountData>(AccountData, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<AccountData> getAccountDataById(@PathVariable Long id) {
		Optional<AccountData> AccountData = ads.getAccountDataById(id);
		if(AccountData.isPresent()) {
			return new ResponseEntity<AccountData>(AccountData.get(), HttpStatus.OK);
		}
		return new ResponseEntity<AccountData>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<AccountData> removeAccountData(@PathVariable Long id) {
		try {
			ads.removeAccountData(id);
		}catch (Exception e) {
			return new ResponseEntity<AccountData>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<AccountData>(HttpStatus.NO_CONTENT);
	}
	
	
}
