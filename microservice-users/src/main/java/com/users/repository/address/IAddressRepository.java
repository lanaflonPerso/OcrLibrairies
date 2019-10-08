package com.users.repository.address;

import com.users.model.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository<Address,Long> {
}
