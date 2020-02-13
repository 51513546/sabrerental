package com.infogain.stacksimplify.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infogain.stacksimplify.entities.Order;
import com.infogain.stacksimplify.entities.User;
import com.infogain.stacksimplify.exception.UserNotFoundException;
import com.infogain.stacksimplify.repository.OrderRepository;
import com.infogain.stacksimplify.repository.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class OrderController {

	@Autowired
	private UserRepository userRepopsitory;
	
	@Autowired
	private OrderRepository orderRepopsitory;

	//getAllOrders
	@GetMapping("/{id}/orders")
	public List<Order> getAllOrders(@PathVariable Long id) throws UserNotFoundException {
		Optional<User> optionaluser = userRepopsitory.findById(id);
		if (!optionaluser.isPresent()) {
			throw new UserNotFoundException("User Not Found");
		}
		return optionaluser.get().getListOfOrder();

	}//getAllOrders

	@PostMapping("{userId}/orders")
	public Order createOrder(@PathVariable Long userId,@RequestBody Order order)throws UserNotFoundException {
		Optional<User> optionaluser = userRepopsitory.findById(userId);
		if (!optionaluser.isPresent()) {
			throw new UserNotFoundException("User Not Found");
		}
		User user=optionaluser.get();
		order.setUser(user);
		return orderRepopsitory.save(order);
	}
}
