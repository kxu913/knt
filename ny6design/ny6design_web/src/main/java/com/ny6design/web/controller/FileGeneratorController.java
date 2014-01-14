package com.ny6design.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ny6design.service.FileGeneratorService;
import com.ny6design.utility.ReturnStatus;
/**
 * 
 * @author kevin
 *
 */
@Controller
public class FileGeneratorController {

	@Autowired
	FileGeneratorService fileGeneratorService;

	@ResponseBody
	@RequestMapping("/xmlParse")
	public Map<String, Object> parse(HttpServletRequest request) {

		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String xmlContent = request.getParameter("xmlContent");
			String xslName = request.getParameter("xslName");
			String xpath = request.getParameter("xpath");

			if (xslName == null || xslName.length() == 0) {
				xslName = "convert.xsl";
			}
			String value = fileGeneratorService.parse(xmlContent, xslName,
					xpath);
			map.put(ReturnStatus.STATUS, ReturnStatus.SUCCESS_CODE);
			map.put(ReturnStatus.MESSAGE, ReturnStatus.SUCCESS);
			map.put(ReturnStatus.RESULT, value);

		} catch (Exception e) {

			e.printStackTrace();
			map.put(ReturnStatus.STATUS, ReturnStatus.FAILURE);
			map.put(ReturnStatus.MESSAGE, e.getMessage());
		}

		return map;

	}
}
