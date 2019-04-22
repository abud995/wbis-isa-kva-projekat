package wis.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis.domain.Address;
import wis.repository.AddressRepository;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    
    public AddressService() {
    }

    public Iterable<Address> getAddresses() {
        return addressRepository.findAll();
    }

    public Optional<Address> getAddressById(Long id) {
        return addressRepository.findById(id);
    }

    public void addAddress(Address address) {
    	addressRepository.save(address);
    }

    public void removeAddress(Long id) {
        Optional<Address> address = addressRepository.findById(id);
        addressRepository.delete(address.get());
    }

    public void updateAddress(Long id, Address address) {
        Optional<Address> upAddress = addressRepository.findById(id);
        if(upAddress.isPresent()) {
            address.setId(upAddress.get().getId());
            addressRepository.save(address);
        }
    }
	
}
