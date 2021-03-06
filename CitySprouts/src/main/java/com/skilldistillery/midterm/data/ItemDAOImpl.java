package com.skilldistillery.midterm.data;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.midterm.entities.Category;
import com.skilldistillery.midterm.entities.Commodity;
import com.skilldistillery.midterm.entities.Inventory;
import com.skilldistillery.midterm.entities.Item;
import com.skilldistillery.midterm.entities.Purchase;
import com.skilldistillery.midterm.entities.PurchaseStatus;
import com.skilldistillery.midterm.entities.Seller;
import com.skilldistillery.midterm.entities.Unit;
import com.skilldistillery.midterm.entities.Variety;

@Transactional
@Service
public class ItemDAOImpl implements ItemDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Item> getAllItems() {
		String query = "Select i from Item i";
		List<Item> items = em.createQuery(query, Item.class).getResultList();
		return items;
	}

	@Override
	public List<Item> getItemsByVarietyId(int id) {
		String query = "Select item from Item item where item.variety.id = :id";
		List<Item> items = em.createQuery(query, Item.class).setParameter("id", id).getResultList();
		return items;
	}

	@Override
	public List<Item> getItemsByCommodityId(int id) {
		String query = "Select item from Item item where item.commodity.id = :id";
		List<Item> items = em.createQuery(query, Item.class).setParameter("id", id).getResultList();
		return items;
	}

	@Override
	public Item getItemByItemId(int id) {
		String query = "Select item from Item item where item.id = :id";
		Item item = em.createQuery(query, Item.class).setParameter("id", id).getResultList().get(0);
		return item;
	}

	@Override
	public List<Inventory> getItemsByKeyword(String keyword) {
		String query = "Select i from Inventory i where (i.item.name LIKE :keyword OR i.item.description LIKE :keyword OR i.item.category.name LIKE :keyword OR i.seller.storeName LIKE :keyword) AND i.purchase is null";
		List<Inventory> items = em.createQuery(query, Inventory.class).setParameter("keyword", '%' + keyword + '%')
				.getResultList();
		return items;
	}

	@Override
	public List<Item> getItemsByUnitId(int id) {
		String query = "Select item from Item item where item.unit.id = :id";
		List<Item> items = em.createQuery(query, Item.class).setParameter("id", id).getResultList();
		return items;
	}

	@Override
	public List<Unit> getAllUnits() {
		String query = "Select unit from Unit unit";
		List<Unit> units = em.createQuery(query, Unit.class).getResultList();
		System.out.println(units);
		return units;
	}

	@Override
	public List<Commodity> getAllCommodities() {
		String query = "Select c from Commodity c";
		List<Commodity> comms = em.createQuery(query, Commodity.class).getResultList();
		return comms;
	}

	@Override
	public List<Variety> getAllVariety() {
		String query = "Select v from Variety v";
		List<Variety> vars = em.createQuery(query, Variety.class).getResultList();
		return vars;
	}

	@Override
	public List<Category> getAllCategory() {
		String query = "Select c from Category c";
		List<Category> cats = em.createQuery(query, Category.class).getResultList();
		return cats;
	}

	@Override
	public List<Item> getItemsByCategoryId(int id) {
		String query = "Select item from Item item where item.category.id = :id";
		List<Item> items = em.createQuery(query, Item.class).setParameter("id", id).getResultList();
		return items;
	}

	@Override
	public List<Item> getItemsByCategoryName(String name) {
		String query = "Select item from Item item where item.category.name = :name";
		List<Item> items = em.createQuery(query, Item.class).setParameter("name", name).getResultList();
		return items;
	}

	@Override
	public List<Item> getItemsByVarietyName(String name) {
		String query = "Select item from Item item where item.variety.name = :name";
		List<Item> items = em.createQuery(query, Item.class).setParameter("name", name).getResultList();
		return items;
	}

	@Override
	public List<Item> getItemsByCommodityName(String name) {
		String query = "Select item from Item item where item.variety.name = :name";
		List<Item> items = em.createQuery(query, Item.class).setParameter("name", name).getResultList();
		return items;
	}

	@Override
	public List<Item> getItemsByUnitName(String name) {
		String query = "Select item from Item item where item.unit.name = :name";
		List<Item> items = em.createQuery(query, Item.class).setParameter("name", name).getResultList();
		return items;
	}

	@Override
	public List<Item> getItemsSortedByPickedDate() {
		String query = "Select i from Item i order by i.picked";
		List<Item> items = em.createQuery(query, Item.class).getResultList();
		return items;
	}

	@Override
	public List<Item> getItemsSortedByPrice(String name) {
		String query = "Select item from Item item order by price";
		List<Item> items = em.createQuery(query, Item.class).getResultList();
		return items;
	}

	@Override
	public List<Item> getItemsSortedByBestByDate(String name) {
		String query = "Select item from Item item order by bestBy";
		List<Item> items = em.createQuery(query, Item.class).getResultList();
		return items;
	}
	
	@Override
	public Item getItemByInvetoryId(int id) {
		String query = "Select i.item from Inventory i where i.id = :id";
		Item items = em.createQuery(query, Item.class).setParameter("id", id).getResultList().get(0);
		return items;
	}

	@Override
	public Item addItem(Item i, Seller s) {
		Item item = new Item();
		System.out.println(item);
		Seller seller = em.find(Seller.class, s.getId());
		item.setSeller(seller);
		item.setBestBy(i.getBestBy());
		item.setCategory(i.getCategory());
		item.setCommodity(i.getCommodity());
		item.setDescription(i.getDescription());
		item.setInventories(i.getInventories());
		item.setLastUpdated(i.getLastUpdated());
		item.setName(i.getName());
		item.setPicked(i.getPicked());
		item.setPrice(i.getPrice());
		item.setUnit(i.getUnit());
		item.setVariety(i.getVariety());
		item.setActive(i.getActive());
		item.setImgUrl(i.getImgUrl());
		em.persist(item);
		em.flush();
		return item;
	}

	@Override
	public Item updateItem(Item i) {
		Item item = em.find(Item.class, i.getId());
		item.setBestBy(i.getBestBy());
		item.setCategory(i.getCategory());
		item.setCommodity(i.getCommodity());
		item.setDescription(i.getDescription());
		item.setInventories(i.getInventories());
		item.setLastUpdated(i.getLastUpdated());
		item.setName(i.getName());
		item.setPicked(i.getPicked());
		item.setPrice(i.getPrice());
		item.setUnit(i.getUnit());
		item.setVariety(i.getVariety());
		item.setActive(i.getActive());
		item.setImgUrl(i.getImgUrl());
		em.persist(item);
		em.flush();
		return item;
	}
	@Override
	public Inventory updateInventory(Inventory inventory) {
		Inventory i = em.find(Inventory.class, inventory.getId());
		i.setPurchase(inventory.getPurchase());
		em.persist(i);
		em.flush();
		return i;
	}
	
	@Override
	public Purchase addPurchase(Purchase p) {
		em.persist(p);
		em.flush();
		return p;
	}
	@Override
	public Inventory addInventory(Inventory p) {
		em.persist(p);
		em.flush();
		return p;
	}

	@Override
	public Item deleteItem(Item i) {
		Item item = em.find(Item.class, i.getId());
		em.remove(item);
		return item;
	}

	@Override
	public Inventory addItemToInventory(Item item, Seller s) {
		Inventory i = new Inventory();
		Seller seller = em.find(Seller.class, s.getId());
		Item addItem = em.find(Item.class, item.getId());
		i.setItem(addItem);
		i.setSeller(seller);


		em.persist(i);
		em.flush();
		System.out.println("In inventory: " + i);
		return i;
	}

	@Override
	public List<Inventory> getSellerInventory(Seller seller) {
		String query = "Select i from Inventory i where i.seller.id = :id";
		List<Inventory> inventories = em.createQuery(query, Inventory.class).setParameter("id", seller.getId())
				.getResultList();
		return inventories;
	}

	@Override
	public List<Inventory> getSellerInventoryById(int id) {
		String query = "Select i from Inventory i where i.seller.id = :id";
		List<Inventory> inventories = em.createQuery(query, Inventory.class).setParameter("id", id).getResultList();
		return inventories;

	}


	@Override
	public Inventory getInventoryByItemId(int id) {
		String query = "Select i from Inventory i where i.item.id = :id";
		Inventory i = em.createQuery(query, Inventory.class).setParameter("id", id).getResultList().get(0);
		return i;
	}
	@Override
	public PurchaseStatus getPurchaseStatusById(int i) {
		return em.find(PurchaseStatus.class, i);
	}

	@Override
	public int getPriceOfAllItemsInCart(int id) {
		String query = "Select sum(item.price) from Item item where purchase.id  = id:";
		long sum = em.createQuery(query, Long.class).setParameter("id", id).getResultList().get(0);
		
		return (int)sum;
	}
	@Override
	public List<Purchase> getPurchaseByBuyerId(int id) {
		String query = "Select p from Purchase p where p.buyer.id = :id";
		List<Purchase> p = em.createQuery(query, Purchase.class).setParameter("id", id).getResultList();
		return p;
		}
	@Override
	public Purchase getPurchaseById(int id) {
		String query = "Select p from Purchase p where p.id = :id";
		Purchase p = em.createQuery(query, Purchase.class).setParameter("id", id).getResultList().get(0);
		return p;
	}
	@Override
	public PurchaseStatus getPurchaseStatusByName(String name) {
		String query = "Select p from PurchaseStatus p where p.status = :name";
		return em.createQuery(query, PurchaseStatus.class).setParameter("name", name).getResultList().get(0);
		
	}
	@Override
	public Inventory getInventoryById(int id) {
		String query = "Select i from Inventory i where i.id = :id";
		return em.createQuery(query, Inventory.class).setParameter("id", id).getResultList().get(0);
		
	}
	@Override
	public Inventory[] getAllInventory() {
		String query = "Select i from Inventory i where i.purchase is null";
		List<Inventory> invlist = em.createQuery(query, Inventory.class).getResultList();
		Collections.shuffle(invlist);
		Inventory[] invArray = new Inventory[12];
		for (int i = 0; i < 12 ; i++) {
			invArray[i]= invlist.get(i);
		}
		return invArray;
		
	}
	@Override
	public Inventory getInventoryItemBySellerIdAndItemId(int sId, int itemId) {
		String query = "Select i from Inventory i where i.seller.id = :sId and i.id = :itemId";
		Inventory inventory = em.createQuery(query, Inventory.class).setParameter("sId"	, sId).setParameter("itemId", itemId).getResultList().get(0);
		return inventory;
	}
			
	@Override
	public Category getCategoryIdByCategoryId(int id) {
		String query = "Select c from Category c where c.id = :id";
		return em.createQuery(query, Category.class).setParameter("id", id).getResultList().get(0);
	}
	@Override
	public Unit getUnitIdByUnitId(int id) {
		String query = "Select u from Unit u where u.name = :id";
		return em.createQuery(query, Unit.class).setParameter("id", id).getResultList().get(0);
	}

	@Override
	public int getCategoryIdByCategoryName(String name) {
		String query = "Select c.id from Category c where c.name = :name";
		return em.createQuery(query, Integer.class).setParameter("name", name).getResultList().get(0);
	}

	@Override
	public int getUnitIdByUnitName(String name) {
		String query = "Select u.id from Unit u where u.name = :name";
		return em.createQuery(query, Integer.class).setParameter("name", name).getResultList().get(0);
	}

	@Override
	public Unit getUnitByUnitId(int id) {
		String query = "Select u from Unit u where u.id = :id";
		return em.createQuery(query, Unit.class).setParameter("id", id).getResultList().get(0);
	}

	@Override
	public Category getCategoryByCategoryId(int id) {
		String query = "Select c from Category c where c.id = :id";
		return em.createQuery(query, Category.class).setParameter("id", id).getResultList().get(0);
	}



 	
}
