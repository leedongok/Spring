package com.apress.isf.spring.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.apress.isf.java.model.Document;
import com.apress.isf.java.model.Type;
import com.apress.isf.java.service.SearchEngine;
import com.apress.isf.spring.data.DocumentDAO;

public class SearchEngineService implements SearchEngine {

	private DocumentDAO documentDAO;
	//DAO와 의존관계 선언

	public DocumentDAO getDocumentDAO() {
		return documentDAO;
	}
	//세터메서드를 통해 주입
	public void setDocumentDAO(DocumentDAO documentDAO) {
		this.documentDAO = documentDAO;
	}
	
	public List<Document> findByType(Type documentType) {
		List<Document> result = new ArrayList<Document>();
		for (Document doc : listAll()) {
			if (doc.getType().getName().equals(documentType.getName()))
				result.add(doc);
		}
		return result;
	}

	public List<Document> listAll() {
		return Arrays.asList(documentDAO.getAll());
	}

}
