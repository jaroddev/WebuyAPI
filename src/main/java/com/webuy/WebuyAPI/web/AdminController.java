package com.webuy.WebuyAPI.web;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/admin")
@RestController
public class AdminController {

	private String getContents(String filePath) {
		try {
			FileReader fileReader = new FileReader(filePath);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String line = null;
			StringBuffer res = new StringBuffer();

			while ((line = bufferedReader.readLine()) != null) {
				res.append(line).append("\n");
			}

			bufferedReader.close();
			fileReader.close();

			return res.toString();
		} catch (FileNotFoundException e) {
			return e.toString();
		} catch (IOException e) {
			return e.toString();
		}
	}

	@RequestMapping({ "/shops", "/shop-groups", "/products", "/offers" })
	public String showAdminList() {
		return getContents("admin/list.html");
	}

	@RequestMapping({ "/shops/create", "/shop-groups/create", "/products/create", "/offers/create" })
	public String showAdminCreate() {
		return getContents("admin/create.html");
	}

	@RequestMapping({ "/shops/edit/{id}", "/shop-groups/edit/{id}", "/products/edit/{id}", "/offers/edit/{id}" })
	public String showAdminEdit(@PathVariable Long id) {
		return getContents("admin/create.html");
	}

	@RequestMapping({ "/login" })
	public String showAdminLogin() {
		return getContents("admin/login.html");
	}

}
