package com.cogent.main;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
	private final OrderRepository orderRepository;
	private final CartClient cartClient;
	private final IdentityClient identityClient;

	public List<OrderEntity> getOrders(int id) {
		return orderRepository.findByUserId(id).get();
	}

	public void createOrder(int userId) {

		List<Product> products = cartClient.getCart(userId);
		String shippingDetails = identityClient.getAddress(userId);

		OrderEntity oe = orderRepository.save(OrderEntity.builder()
				.userId(userId)
				.products(products.stream()
						.map(p -> p.getName() + " x " + p.getQuantity() + " = $"
								+ String.format("%.2f", p.getPrice() * p.getQuantity()))
						.collect(Collectors.joining("<br>")))
						//.collect(Collectors.joining("\n")))
				.shippingDetails(shippingDetails)
				.total(products.stream()
						.map(d -> d.getPrice() * d.getQuantity())
						.reduce(0.0, (a, b) -> (a + b)))
				.build());
		System.out.println(oe.getProducts());
		System.out.println("Order Successfully placed");
	}
	
	public OrderEntity getDetailedOrder(int orderId) throws Exception {
		return orderRepository.findById(orderId).orElseThrow(()->new Exception("Order id not found."));
	}

}
