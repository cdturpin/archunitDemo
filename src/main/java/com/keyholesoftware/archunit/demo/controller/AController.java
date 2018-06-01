package com.keyholesoftware.archunit.demo.controller;

import com.keyholesoftware.archunit.demo.repository.Repository;

public class AController {
	 protected Repository repository;

	public Repository getRepository() {
		return repository;
	}

	public void setRepository(Repository repository) {
		this.repository = repository;
	}
}
