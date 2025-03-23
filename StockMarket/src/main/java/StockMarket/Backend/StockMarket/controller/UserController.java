package StockMarket.Backend.StockMarket.controller;

import org.springframework.web.bind.annotation.*;

import StockMarket.Backend.StockMarket.dao.UserDao;
import StockMarket.Backend.StockMarket.entity.User;

@RestController
@RequestMapping("/users")
public class UserController {

	private final UserDao userDao;

	public UserController(UserDao userDao) {
		this.userDao = userDao;
	}

	@PostMapping("/register")
	public void registerUser(@RequestBody User user) {
		userDao.save(user);
	}
}
