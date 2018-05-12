package com.raju.selenium.business;

import org.testng.annotations.Test;

import com.raju.selenium.base.BaseEngine;

public class GmailTest extends BaseEngine {
@Test
public void login() {
	getWebdriver().get("https://www.gmail.com");
}
}
