package com.barclays.compliance.delegation.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

	@GetMapping({ "/" })
	public String showView(HttpServletRequest req, HttpServletResponse res) {
		return "delegations";
	}
}
