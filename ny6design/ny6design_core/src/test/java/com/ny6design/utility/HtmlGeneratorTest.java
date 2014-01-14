package com.ny6design.utility;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.xpath.XPathExpressionException;

import org.junit.Test;
import org.xml.sax.SAXException;

public class HtmlGeneratorTest {

	@Test
	public void test() throws Exception {

		InputStream inputStream = HtmlGenerator.class
				.getResourceAsStream("/template.xml");
		try {

			String convertHtml = HtmlGenerator.convert(inputStream,
					"convert.xsl");

			System.out.println(HtmlGenerator.search(convertHtml, "//h3/.."));
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}

	}

}
