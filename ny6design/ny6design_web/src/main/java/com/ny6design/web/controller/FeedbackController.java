package com.ny6design.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ny6design.model.FeedBack;
import com.ny6design.service.FeedbackService;

/**
 * 
 * @author kevin
 * 
 */
@Controller
public class FeedbackController {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private FeedbackService feedbackService;

	@ResponseBody
	@RequestMapping("/latestMessage")
	public List<FeedBack> getRecommendFeedback() {
		return feedbackService.getRecommendFeedback();
	}

	@RequestMapping("/listFeedback")
	public ModelAndView getAllFeedBack(ModelMap modelMap) {
		modelMap.put("feedbackList", feedbackService.getAllFeedback());
		return new ModelAndView("feedback-list", modelMap);
	}

	@RequestMapping("/searchFeedback")
	public ModelAndView searchFeedback(@RequestParam("keyword") String keyword,
			ModelMap modelMap) {
		modelMap.put("feedbackList",
				feedbackService.getFeedbackBykeyword(keyword));
		return new ModelAndView("feedback-list-admin", modelMap);
	}

	@RequestMapping("/listFeedbackForAdminpage")
	public ModelAndView getAllFeedBackForAdminPage(ModelMap modelMap) {
		modelMap.put("feedbackList", feedbackService.getAllFeedback());
		return new ModelAndView("feedback-list-admin", modelMap);
	}

	@ResponseBody
	@RequestMapping(value = "submitFeedback", method = { RequestMethod.POST,
			RequestMethod.GET })
	public int saveQuesion(HttpServletRequest request) {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String extra = request.getParameter("extra");
		FeedBack feedback = new FeedBack();
		if (StringUtils.isNotEmpty(firstName)) {
			feedback.setFirstname(firstName);
		}
		if (StringUtils.isNotEmpty(lastName)) {
			feedback.setLastname(lastName);
		}

		if (StringUtils.isNotEmpty(tel)) {
			feedback.setTelephone(tel);
		}
		if (StringUtils.isNotEmpty(email)) {
			feedback.setEmailaddress(email);
		}

		feedback.setAddress(address);
		if (StringUtils.isNotEmpty(extra)) {
			feedback.setFdescription(extra);
		}
		/**
		 * set extra fields
		 */
		feedback.setFupdatetime(new Date());
		feedback.setRecommend((short) 0);

		/**
		 * if user had login in, set userId
		 */
		if (request.getSession().getAttribute("userid") != null) {
			String userId = request.getSession().getAttribute("userid")
					.toString();
			feedback.setFuserid(Integer.parseInt(userId));
		}
		try {
			feedbackService.submitFeedback(feedback);
			return 0;
		} catch (Exception e) {
			log.error("Submit Feedback Failed!" + e.getMessage());
		}
		return 1;
	}

	@ResponseBody
	@RequestMapping(value = "updateRecommend", method = { RequestMethod.POST,
			RequestMethod.GET })
	public int updateRecommend(HttpServletRequest request) {
		String feedbackId = request.getParameter("feedbackId");
		if (StringUtils.isEmpty(feedbackId)) {
			return 0;
		}
		int _feedbackId = Integer.parseInt(feedbackId);
		String recommend = request.getParameter("recommend");
		if (StringUtils.isEmpty(recommend)) {
			return 0;
		}

		return feedbackService.updateRecommend(_feedbackId, recommend);
	}
}
