package com.ny6design.utility;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
/**
 * 
 * @author kevin
 *
 */
public class HtmlGenerator {

	public static String convert(InputStream inputStream, String xslFile)
			throws SAXException, IOException, ParserConfigurationException,
			TransformerFactoryConfigurationError, TransformerException {


			Document doc = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder().parse(inputStream);
			DOMSource source = new DOMSource(doc);

			StringWriter stringWriter = new StringWriter();
			Result outputTarget = new StreamResult(stringWriter);

			Transformer transformer = TransformerFactory.newInstance()
					.newTransformer(
							new StreamSource(HtmlGenerator.class
									.getResourceAsStream("/" + xslFile)));
			transformer.setOutputProperty("encoding", "UTF-8");
			transformer.transform(source, outputTarget);

			stringWriter.flush();
			String htmlString = stringWriter.toString();

			stringWriter.close();

			return htmlString;


	}

	public static String search(String htmlString, String xpath)
			throws ParserConfigurationException, SAXException, IOException,
			XPathExpressionException, TransformerFactoryConfigurationError,
			TransformerException {

		InputStream inputStream = new ByteArrayInputStream(
				htmlString.getBytes());
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(false);
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(inputStream);

		Document newDocument = builder.newDocument();

		XPathExpression expr = XPathFactory.newInstance().newXPath()
				.compile(xpath);
		NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

		Node newNode = null;
		for (int i = 0; i < nodes.getLength(); i++) {

			newNode = newDocument.importNode(nodes.item(i), true);
			newDocument.appendChild(newNode);
		}

		DOMSource domSource = new DOMSource(newDocument);
		StringWriter writer = new StringWriter();
		StreamResult result = new StreamResult(writer);
		TransformerFactory tfactory = TransformerFactory.newInstance();
		Transformer transformer = tfactory.newTransformer();
		transformer.transform(domSource, result);

		String xmlFragment = writer.toString();
		inputStream.close();
		writer.close();

		return xmlFragment;
	}


}
