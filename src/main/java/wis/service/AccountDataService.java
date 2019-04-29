package wis.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis.domain.AccountData;
import wis.repository.AccountDataRepository;

@Service
public class AccountDataService {

	@Autowired
	private AccountDataRepository accountDataRepository;

	public AccountDataService() {
	}

	public Iterable<AccountData> getAccountDatas() {
		return accountDataRepository.findAll();
	}

	public Optional<AccountData> getAccountDataById(Long id) {
		return accountDataRepository.findById(id);
	}

	public void addAccountData(AccountData accountData) {
		accountDataRepository.save(accountData);
	}

	public void removeAccountData(Long id) {
		Optional<AccountData> accountData = accountDataRepository.findById(id);
		accountDataRepository.delete(accountData.get());
	}

	public void updateAccountData(Long id, AccountData accountData) {
		Optional<AccountData> upAccountData = accountDataRepository.findById(id);
		if (upAccountData.isPresent()) {
			accountData.setId(upAccountData.get().getId());
			accountDataRepository.save(accountData);
		}
	}

}
