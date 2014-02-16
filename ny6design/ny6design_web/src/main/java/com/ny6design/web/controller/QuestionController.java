package com.ny6design.web.controller;

import java.util.Date;

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

import com.ny6design.model.Question;
import com.ny6design.service.QuestionService;

/**
 * 
 * @author kevin
 * 
 */
@Controller
public class QuestionController {
	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private QuestionService questionService;

	@RequestMapping("getUnrepliedQuestions")
	public ModelAndView listUnrepliedQuestion(ModelMap model) {
		model.put("unrepliedQuestions",
				questionService.findAllUnreplyQuestion());
		return new ModelAndView("question-list", model);
	}

	@RequestMapping("/searchQuestion")
	public ModelAndView searchQuestion(@RequestParam("keyword") String keyword,
			ModelMap modelMap) {
		modelMap.put("unrepliedQuestions",
				questionService.findAllUnreplyQuestionByKeyword(keyword));
		return new ModelAndView("question-list", modelMap);
	}

	@ResponseBody
	@RequestMapping(value = "submitQuestion", method = { RequestMethod.POST,
			RequestMethod.GET })
	public int saveQuesion(HttpServletRequest request) {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String extra = request.getParameter("extra");
		Question question = new Question();
		if (StringUtils.isNotEmpty(firstName)) {
			question.setFirstname(firstName);
		}
		if (StringUtils.isNotEmpty(lastName)) {
			question.setLastname(lastName);
		}

		if (StringUtils.isNotEmpty(tel)) {
			question.setTelephone(tel);
		}
		if (StringUtils.isNotEmpty(email)) {
			question.setEmailaddress(email);
		}

		question.setAddress(address);
		if (StringUtils.isNotEmpty(extra)) {
			question.setExtra(extra);
		}
		/**
		 * set extra fields
		 */
		question.setStatus(0);
		question.setSubmittime(new Date());

		/**
		 * if user had login in, set userId
		 */
		if (request.getSession().getAttribute("userid") != null) {
			String userId = request.getSession().getAttribute("userid")
					.toString();
			question.setUserid(Integer.parseInt(userId));
		}
		try {
			questionService.submitQuestion(question);
			return 0;
		} catch (Exception e) {
			log.error("Submit Question Failed!" + e.getMessage());
		}
		return 1;
	}

}
