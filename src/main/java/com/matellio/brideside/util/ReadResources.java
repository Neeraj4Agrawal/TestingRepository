package com.matellio.brideside.util;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class ReadResources {

	private Logger logger = Logger.getLogger(ReadResources.class);

	private Document domDocument;
	private Map<String, String> elementXml;

	public ReadResources() {
	}

	private Document parseXMl(String fileName) {
		//factory is used when we have to work with document
		// new instance an static object , which will return an document builder factory  object
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance(); //it return an object of document
		try {
			// it return an document builder object
			DocumentBuilder builder = builderFactory.newDocumentBuilder();  //it build an document
			
			domDocument = builder.parse(getFilePath(fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return domDocument;
	}

	public Map<String, String> getValuesFromXml(String fileName, String tagName) {
		domDocument = parseXMl(fileName);
		elementXml = new HashMap<String, String>();
		NodeList nodeList = domDocument.getElementsByTagName(tagName);
		for (int j = 0; j < nodeList.item(0).getChildNodes().getLength(); j++) {
			if (j % 2 != 0) {
				elementXml.put(nodeList.item(0).getChildNodes().item(j).getNodeName(),
						nodeList.item(0).getChildNodes().item(j).getTextContent());
			}
		}
		return elementXml;
	}

	public String getFilePath(String sFilepath) {
		String sPath = System.getProperty("user.dir") + "\\src\\main\\resources\\" + sFilepath;
		sPath = sPath.replace('\\', '/');
		File file = new File(sPath);
		if (file.exists()) {
			logger.info("The File is Present wih the Path" + sPath);
		} else {
			logger.error("File not Found");
		}
		return sPath;
	}
}
