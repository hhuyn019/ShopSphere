package com.cogent.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WishlistService {
	private final WishlistRepository wishlistRepository;
	private final ProductClient productClient;

	public List<Product> getProductList(int id) {
		if (wishlistRepository.findByUserId(id).isEmpty()) {
			throw new RuntimeException("User not found");
		}

		WishlistEntity dataList = wishlistRepository.findByUserId(id).get();

		List<Integer> dataInt = dataList.getData();
		return getProducts(dataInt);
	}

	public List<Product> addItem(int userId, int productId) {
		if (wishlistRepository.findByUserId(userId).isEmpty()) {
			throw new RuntimeException("User not Found");
		}

		WishlistEntity dataList = wishlistRepository.findByUserId(userId).get();

		List<Integer> dataInt = dataList.getData();
		dataInt.add(productId);
		dataList.setData(dataInt);
		wishlistRepository.save(dataList);
		return getProducts(dataInt);
	}

	public List<Product> removeItem(int userId, int productId) {
		if (wishlistRepository.findByUserId(userId).isEmpty()) {
			throw new RuntimeException("User not Found");
		}

		WishlistEntity dataList = wishlistRepository.findByUserId(userId).get();

		List<Integer> dataInt = dataList.getData();
		dataInt.remove(Integer.valueOf(productId));
		dataList.setData(dataInt);
		wishlistRepository.save(dataList);
		return getProducts(dataInt);
	}

	public void initList(int userId) {
		if (wishlistRepository.findByUserId(userId).isEmpty()) {
			wishlistRepository.save(WishlistEntity.builder()
					.data("")
					.userId(userId)
					.build());
		} else {
			throw new RuntimeException("User already has a wishlist");
		}
	}

	public List<Product> getProducts(List<Integer> nums) {
		List<Product> wishlist = new ArrayList<Product>();
		nums.stream()
				.forEach(d -> wishlist.add(productClient.oneProduct(d)));
		return wishlist;
	}

	public void deleteList(int userId) {
		wishlistRepository.deleteById(wishlistRepository.findByUserId(userId).get().getId());
	}
}
