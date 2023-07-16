package com.laptrinhweb.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhweb.dto.AddressDto;
import com.laptrinhweb.dto.ResponseObject;
import com.laptrinhweb.service.IAddressService;

@RestController
@RequestMapping("/api/dia-chi")
public class AddressAPI {
	@Autowired
	private IAddressService addressService;

	@GetMapping("/xoa")
	public ResponseEntity<ResponseObject> deleteAddress(@RequestParam(value = "addressId") Integer addressId) {
		AddressDto address = addressService.getById(addressId);
		if (address != null) {
			addressService.deleteAddress(addressId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT)
					.body(new ResponseObject(String.format("Delete address have id = %d success", addressId)));
		} else
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponseObject("Not found address have id = " + addressId));

	}

	@PostMapping("/chinh-sua")
	public ResponseEntity<ResponseObject> updateAddress(@RequestBody AddressDto address) {
		AddressDto addressDto = addressService.addAndUpdateAddress(address);
		String message = "";
		if (address.getId() == 0)
			message = "Added address successfully";
		else
			message = String.format("Updated address with id = %d successfully", address.getId());
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(message, addressDto));

	}

	@GetMapping("/mac-dinh/{addressId}")
	public ResponseEntity<ResponseObject> makeDefaultAddress(@PathVariable("addressId") Integer addressId) {
		addressService.makeDefaultAddress(addressId);
		return ResponseEntity.noContent().build();
	}
}
