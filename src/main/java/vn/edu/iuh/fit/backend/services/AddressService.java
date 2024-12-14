package vn.edu.iuh.fit.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.edu.iuh.fit.backend.models.Address;
import vn.edu.iuh.fit.backend.repositories.AddressRepository;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    // Thêm một Address
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    // Lấy danh sách tất cả các Address
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    // Lấy một Address theo ID
    public Address getAddressById(Long id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found"));
    }

    // Sửa một Address
    public Address updateAddress(Long id, Address updatedAddress) {
        Address address = getAddressById(id);
        address.setStreet(updatedAddress.getStreet());
        address.setCity(updatedAddress.getCity());
        address.setCountry(updatedAddress.getCountry());
        address.setNumber(updatedAddress.getNumber());
        address.setZipcode(updatedAddress.getZipcode());
        return addressRepository.save(address);
    }

    // Xóa một Address
    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }

}
