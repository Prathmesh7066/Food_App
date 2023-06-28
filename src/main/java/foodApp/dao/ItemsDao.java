package foodApp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import foodApp.dto.Items;

public class ItemsDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("prathmesh");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public Items saveItems(Items items) {

		entityTransaction.begin();
		entityManager.persist(items);
		entityTransaction.commit();

		return items;
	}

	public List<Items> getAllItems() {
		Query query = entityManager.createQuery("SELECT i FROM Items i");
		List<Items> items = query.getResultList();
		return items;
	}

	public Items getItemsById(int id) {
		return entityManager.find(Items.class, id);
	}

	public Items updateItems(Items items) {

		entityTransaction.begin();
		entityManager.merge(items);
		entityTransaction.commit();

		return items;
	}

	public boolean deleteItems(int id) {
		Items items = entityManager.find(Items.class, id);
		if (items != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(items);
			entityTransaction.commit();

			return true;
		}
		return false;
	}

}
