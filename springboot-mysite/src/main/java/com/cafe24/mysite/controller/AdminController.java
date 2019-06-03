package com.cafe24.mysite.controller;

import com.cafe24.security.Authorization;
import com.cafe24.security.Authorization.Role;

@Authorization(role = Role.ADMIN)
public class AdminController {
	
}
