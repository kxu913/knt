package com.ny6design.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.xpath.XPathExpressionException;

import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import com.ny6design.utility.HtmlGenerator;

/**
 * 
 * @author kevin
 * 
 */
@Service
public class FileGeneratorService {

	public String parse(String templateContent, String xslFileName, String xpath)
			throws SAXException, IOException, ParserConfigurationException,
			TransformerFactoryConfigurationError, TransformerException,
			XPathExpressionException {

		String returnValue = null;
		InputStream inputStream = new ByteArrayInputStream(
				templateContent.getBytes());

		returnValue = HtmlGenerator.convert(inputStream, xslFileName);

		if (xpath != null && xpath.length() > 0) {
			returnValue = HtmlGenerator.search(returnValue, xpath);
		}

		return returnValue;
	}

}
