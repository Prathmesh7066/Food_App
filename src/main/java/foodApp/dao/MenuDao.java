package foodApp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import foodApp.dto.Menu;

public class MenuDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("prathmesh");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public Menu saveMenu(Menu menu) {

		entityTransaction.begin();
		entityManager.persist(menu);
		entityTransaction.commit();

		return menu;
	}

	public Menu getMenuById(int id) {
		return entityManager.find(Menu.class, id);
	}

	public Menu updateMenu(Menu menu) {

		entityTransaction.begin();
		entityManager.merge(menu);
		entityTransaction.commit();

		return menu;
	}

	public boolean deleteMenu(int id) {
		Menu menu = entityManager.find(Menu.class, id);
		if (menu != null) {
			entityTransaction.begin();
			entityManager.remove(menu);
			entityTransaction.commit();

			return true;
		}
		return false;
	}

	public List<Menu> getAllMenus() {
		Query query = entityManager.createQuery("SELECT m FROM Menu m");
		List<Menu> menus = query.getResultList();
		return menus;
	}

}
