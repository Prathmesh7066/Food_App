package foodApp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import foodApp.dto.User;

public class UserDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("prathmesh");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public User saveUser(User user) {

		entityTransaction.begin();
		entityManager.merge(user);
		entityTransaction.commit();

		return user;
	}

	public User getUserByEmail(String email) {
		Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.email=?1");
		query.setParameter(1, email);
		User user = (User) query.getSingleResult();
		return user;
	}

	public User updateUser(User user) {

		entityTransaction.begin();
		entityManager.merge(user);
		entityTransaction.commit();

		return user;
	}

	public User getUserById(int id) {
		User user = entityManager.find(User.class, id);
		return user;
	}

}
