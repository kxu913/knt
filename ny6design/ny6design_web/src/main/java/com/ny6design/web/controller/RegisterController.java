package com.ny6design.web.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kevin.notification.core.MimeMailService;
import com.kevin.notification.model.EmailNotify;
import com.ny6design.mapper.AddressMapper;
import com.ny6design.mapper.CountryMapper;
import com.ny6design.mapper.FromMessageMapper;
import com.ny6design.mapper.StatesMapper;
import com.ny6design.mapper.UserAddressMapper;
import com.ny6design.model.Address;
import com.ny6design.model.Country;
import com.ny6design.model.FromMessage;
import com.ny6design.model.States;
import com.ny6design.model.User;
import com.ny6design.model.UserAddress;
import com.ny6design.service.UserService;
import com.ny6design.web.constant.CONSTANT;

/**
 * 
 * @author kevin
 * 
 */
@Controller
public class RegisterController {
	@Autowired
	MimeMailService mimeMailService;
	@Autowired
	CountryMapper contryMapper;
	@Autowired
	StatesMapper statesMapper;
	@Autowired
	FromMessageMapper fromMessageMapper;
	@Autowired
	AddressMapper addressMapper;
	@Autowired
	UserAddressMapper userAddressMapper;
	@Autowired
	UserService userService;

	private final ExecutorService executor = Executors
			.newSingleThreadExecutor();

	@RequestMapping("/getAllCountries")
	@ResponseBody
	public List<Country> getAllCountries() {
		return contryMapper.getAllCountries();
	}

	@RequestMapping("/getAllStates")
	@ResponseBody
	public List<States> getAllStates() {
		return statesMapper.getAllStates();
	}

	@RequestMapping("/verifyEmail")
	public String verifyEmail(HttpServletRequest request,
			@RequestParam int userId, @RequestParam long time) {
		User user = userService.selectByPrimaryKey(userId);
		if (user != null) {
			user.setFactive("1");
			userService.updateByPrimaryKey(user);
			request.getSession().setAttribute("userName",
					user.getFirstname() + " " + user.getLastname());
		}
		return "redirect:index.html";
	}

	@RequestMapping("/getAllFromMessage")
	@ResponseBody
	public List<FromMessage> getAllFromMessage() {
		return fromMessageMapper.getAllFromMessage();
	}

	@RequestMapping(value = "/register", method = { RequestMethod.POST,
			RequestMethod.GET })
	@ResponseBody
	public Map<String, Object> register(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		String userid = request.getParameter("userid");
		boolean isUpdate = StringUtils.isNotEmpty(userid)
				&& !"0".equalsIgnoreCase(userid);
		final String emailAddress = request.getParameter("emailAddress");
		if (!isUpdate && StringUtils.isEmpty(emailAddress)) {
			rtn.put("index", 0);
			rtn.put(CONSTANT.ERROR_MESSAGE, "email address can't be null");
			return rtn;
		}
		String password = request.getParameter("password");
		if (StringUtils.isEmpty(password)) {
			rtn.put("index", 1);
			rtn.put(CONSTANT.ERROR_MESSAGE, "password can't be null");
			return rtn;
		}
		String confirmedPassword = request.getParameter("confirmedPassword");
		if (StringUtils.isEmpty(password)
				|| !password.equals(confirmedPassword)) {
			rtn.put("index", 2);
			rtn.put(CONSTANT.ERROR_MESSAGE, "twice passwords don't same!");
			return rtn;
		}
		String firstName = request.getParameter("firstName");
		if (StringUtils.isEmpty(firstName)) {
			rtn.put("index", 3);
			rtn.put(CONSTANT.ERROR_MESSAGE, "firstName can't be null");
			return rtn;
		}
		String lastName = request.getParameter("lastName");
		if (StringUtils.isEmpty(lastName)) {
			rtn.put("index", 4);
			rtn.put(CONSTANT.ERROR_MESSAGE, "lastName can't be null");
			return rtn;
		}
		String address = request.getParameter("address");
		if (StringUtils.isEmpty(address)) {
			rtn.put("index", 5);
			rtn.put(CONSTANT.ERROR_MESSAGE, "address can't be null");
			return rtn;
		}
		String town = request.getParameter("town");
		if (StringUtils.isEmpty(town)) {
			rtn.put("index", 6);
			rtn.put(CONSTANT.ERROR_MESSAGE, "town can't be null");
			return rtn;
		}
		String state = request.getParameter("state");
		if (StringUtils.isEmpty(state)) {
			rtn.put("index", 7);
			rtn.put(CONSTANT.ERROR_MESSAGE, "state can't be null");
			return rtn;
		}
		String zipcode = request.getParameter("zipcode");
		if (StringUtils.isEmpty(zipcode)) {
			rtn.put("index", 8);
			rtn.put(CONSTANT.ERROR_MESSAGE, "zipcode can't be null");
			return rtn;
		}
		String country = request.getParameter("country");
		if (StringUtils.isEmpty(country)) {
			rtn.put("index", 9);
			rtn.put(CONSTANT.ERROR_MESSAGE, "country can't be null");
			return rtn;
		}
		String telephone = request.getParameter("telephone");
		if (StringUtils.isEmpty(telephone)) {
			rtn.put("index", 10);
			rtn.put(CONSTANT.ERROR_MESSAGE, "telephone can't be null");
			return rtn;
		}
		String fax = request.getParameter("fax");
		if (StringUtils.isEmpty(fax)) {
			rtn.put("index", 11);
			rtn.put(CONSTANT.ERROR_MESSAGE, "fax can't be null");
			return rtn;
		}
		String taxId = request.getParameter("taxId");
		if ("TX".equals(state) && StringUtils.isEmpty(taxId)) {
			rtn.put("index", 12);
			rtn.put(CONSTANT.ERROR_MESSAGE, "taxId can't be null in Texas");
			return rtn;
		}
		String hearUs = request.getParameter("hearUs");
		if (!isUpdate && StringUtils.isEmpty(hearUs)) {
			rtn.put("index", 13);
			rtn.put(CONSTANT.ERROR_MESSAGE, "please select one!");
			return rtn;
		}
		final String url = request.getParameter("url");
		rtn.put("url", url);

		Address _address = new Address();
		_address.setAddress(address);
		_address.setCountrycode(country);
		_address.setStatecode(state);
		_address.setTown(town);
		_address.setZipcode(zipcode);
		_address.setFirstname(firstName);
		_address.setLastname(lastName);
		_address.setEmailaddress(emailAddress);
		_address.setTelephone(telephone);
		_address.setIsDefault(1);
		addressMapper.insert(_address);

		User user = new User();
		// if contains userId, update user.
		if (isUpdate) {
			user.setUserid(Integer.parseInt(userid));
		}
		user.setAddressid(_address.getAddressid());
		if (!isUpdate) {
			user.setEmailaddress(emailAddress);
		}
		user.setFactive("0");
		user.setFax(fax);
		user.setFirstname(firstName);
		if (!isUpdate) {
			user.setFromid(Integer.parseInt(hearUs));
		}
		user.setLastname(lastName);
		user.setPassword(password);
		if (!isUpdate) {
			user.setTaxid(new BigDecimal(taxId));
		}
		user.setTelephone(telephone);
		userService.save(user);
		final int userId = user.getUserid();

		UserAddress userAddress = new UserAddress();
		userAddress.setAddressid(_address.getAddressid());
		userAddress.setUserid(userId);
		userAddressMapper.insert(userAddress);
		if (!isUpdate) {
			executor.submit(new Runnable() {

				@Override
				public void run() {
					EmailNotify notify = new EmailNotify();
					notify.setFromEmail("kxu913@gmail.com");
					notify.setSubject("Verify email");
					notify.setToEmail(emailAddress);
					Map<String, Object> context = new HashMap<String, Object>();
					context.put(
							"link",
							"http://localhost:8080/ny6design_web/verifyEmail?userId="
									+ userId + "&time="
									+ System.currentTimeMillis());

					notify.setTemplateName("test.vm");
					notify.setContext(context);
					try {
						mimeMailService.sendPredefinedTemplateMail(notify);
					} catch (MessagingException e) {
						e.printStackTrace();
					}
				}
			});
		}
		return rtn;
	}

}
