package com.ny6design.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ny6design.mapper.UserAddressMapper;
import com.ny6design.model.Address;
import com.ny6design.model.AddressDetail;
import com.ny6design.model.UserAddress;
import com.ny6design.service.AddressService;

/**
 * 
 * @author kxu
 * 
 */
@Controller
public class AddressController {
	@Autowired
	private AddressService addressService;
	@Autowired
	UserAddressMapper userAddressMapper;

	@RequestMapping("/listAddress")
	public ModelAndView listAllAddresses(HttpServletRequest request,
			ModelMap model) {
		List<AddressDetail> list = new ArrayList<AddressDetail>();
		if (request.getSession().getAttribute("userid") != null) {
			String userId = request.getSession().getAttribute("userid")
					.toString();
			list = addressService.selectAllAddressByUserId(userId);
		}
		model.put("addressList", list);
		return new ModelAndView("address-list", model);

	}

	@RequestMapping("/submitAddress")
	@ResponseBody
	public int addAddress(HttpServletRequest request, ModelMap model) {
		if (request.getSession().getAttribute("userid") != null) {
			try {
				String userId = request.getSession().getAttribute("userid")
						.toString();
				String firstName = request.getParameter("firstName");
				String lastName = request.getParameter("lastName");
				String tel = request.getParameter("tel");
				String email = request.getParameter("email");
				String address = request.getParameter("address");
				String town = request.getParameter("town");
				String country = request.getParameter("country");
				String zipcode = request.getParameter("zipcode");
				String statedId = request.getParameter("statedId");
				Address _address = new Address();
				_address.setAddress(address);
				_address.setCountrycode(country);
				_address.setEmailaddress(email);
				_address.setFirstname(firstName);
				_address.setLastname(lastName);
				_address.setIsDefault(0);
				_address.setStatecode(statedId);
				_address.setTelephone(tel);
				_address.setTown(town);
				_address.setZipcode(zipcode);
				addressService.insert(_address);
				UserAddress userAddress = new UserAddress();
				userAddress.setAddressid(_address.getAddressid());
				userAddress.setUserid(Integer.parseInt(userId));
				userAddressMapper.insert(userAddress);
				return 0;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 1;

	}

	@RequestMapping("/updateDefault")
	@ResponseBody
	public int updateDefault(HttpServletRequest request,
			@RequestParam("addressId") String addressId) {
		if (request.getSession().getAttribute("userid") != null) {
			String userId = request.getSession().getAttribute("userid")
					.toString();
			addressService.updateToNonDefault(userId);
			addressService.updateToDefault(addressId);
			return 0;
		}
		return 1;

	}
}
