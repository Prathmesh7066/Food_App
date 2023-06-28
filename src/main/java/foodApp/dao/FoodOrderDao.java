package foodApp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import foodApp.dto.FoodOrder;

public class FoodOrderDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("prathmesh");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public FoodOrder saveFoodOrder(FoodOrder foodOrder) {

		entityTransaction.begin();
		entityManager.merge(foodOrder);
		entityTransaction.commit();

		return foodOrder;
	}

	public FoodOrder getById(int id) {
		return entityManager.find(FoodOrder.class, id);
	}

	public List<FoodOrder> getFoodOrder() {
		Query query = entityManager.createQuery("select p from FoodOrder p");
		return query.getResultList();
	}

}
