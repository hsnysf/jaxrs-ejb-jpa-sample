package employee.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import employee.entity.Address;
import employee.entity.Address_;
import employee.entity.Certificate;
import employee.entity.Manager;
import employee.entity.Manager_;

public class ManagerDao {

	EntityManager entityManager;
	
	public ManagerDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public static boolean isNotEmpty(Object object){
		return object != null && !object.toString().trim().isEmpty() && !"0".equals(object.toString().trim());
	}
	
	public List<Manager> searchManagers(Manager managerSearch) throws Exception {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Manager> criteria = builder.createQuery(Manager.class);

		Root<Manager> manager = criteria.from(Manager.class);
		
		Join<Manager, Address> managerAddress = manager.join(Manager_.address);

		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if(managerSearch != null && isNotEmpty(managerSearch.getId())){
			predicates.add(builder.equal(manager.get(Manager_.id), managerSearch.getId()));
		}
		if(managerSearch != null && isNotEmpty(managerSearch.getCpr())){
			predicates.add(builder.equal(manager.get(Manager_.cpr), managerSearch.getCpr()));
		}
		if(managerSearch != null && isNotEmpty(managerSearch.getName())){
			predicates.add(builder.equal(manager.get(Manager_.name), managerSearch.getName()));
		}
		if(managerSearch != null && isNotEmpty(managerSearch.getAge())){
			System.out.println("test");
			predicates.add(builder.equal(manager.get(Manager_.age), managerSearch.getAge()));
		}
		if(managerSearch != null && isNotEmpty(managerSearch.getEmail())){
			predicates.add(builder.equal(manager.get(Manager_.email), managerSearch.getEmail()));
		}
		if(managerSearch != null && isNotEmpty(managerSearch.getGender())){
			predicates.add(builder.equal(manager.get(Manager_.gender), managerSearch.getGender()));
		}
		if(managerSearch != null && isNotEmpty(managerSearch.getMobile())){
			predicates.add(builder.equal(manager.get(Manager_.mobile), managerSearch.getMobile()));
		}
		if(managerSearch != null && isNotEmpty(managerSearch.getSalary())){
			predicates.add(builder.equal(manager.get(Manager_.salary), managerSearch.getSalary()));
		}
		if(managerSearch != null && managerSearch.getAddress() != null && managerSearch.getAddress().getId() != null && isNotEmpty(managerSearch.getAddress().getId())){
			predicates.add(builder.equal(managerAddress.get(Address_.id), managerSearch.getAddress().getId()));
		}
		if(managerSearch != null && managerSearch.getAddress() != null && managerSearch.getAddress().getBuilding() != null && isNotEmpty(managerSearch.getAddress().getBuilding())){
			predicates.add(builder.equal(managerAddress.get(Address_.building), managerSearch.getAddress().getBuilding()));
		}
		if(managerSearch != null && managerSearch.getAddress() != null && managerSearch.getAddress().getRoad() != null && isNotEmpty(managerSearch.getAddress().getRoad())){
			predicates.add(builder.equal(managerAddress.get(Address_.road), managerSearch.getAddress().getRoad()));
		}
		if(managerSearch != null && managerSearch.getAddress() != null && managerSearch.getAddress().getBlock() != null && isNotEmpty(managerSearch.getAddress().getBlock())){
			predicates.add(builder.equal(managerAddress.get(Address_.block), managerSearch.getAddress().getBlock()));
		}
		if(managerSearch != null && managerSearch.getAddress() != null && managerSearch.getAddress().getCity() != null && isNotEmpty(managerSearch.getAddress().getCity())){
			predicates.add(builder.equal(managerAddress.get(Address_.city), managerSearch.getAddress().getCity()));
		}
		if(managerSearch != null && managerSearch.getAddress() != null && managerSearch.getAddress().getActive() != null && isNotEmpty(managerSearch.getAddress().getActive())){
			predicates.add(builder.equal(managerAddress.get(Address_.active), managerSearch.getAddress().getActive()));
		}
		if(managerSearch != null && managerSearch.getAddress() != null && managerSearch.getAddress().getCreationDate() != null && isNotEmpty(managerSearch.getAddress().getCreationDate())){
			predicates.add(builder.equal(managerAddress.get(Address_.creationDate), managerSearch.getAddress().getCreationDate()));
		}
		if(managerSearch != null && managerSearch.getAddress() != null && managerSearch.getAddress().getCreationUser() != null && isNotEmpty(managerSearch.getAddress().getCreationUser())){
			predicates.add(builder.equal(managerAddress.get(Address_.creationUser), managerSearch.getAddress().getCreationUser()));
		}
		if(managerSearch != null && managerSearch.getAddress() != null && managerSearch.getAddress().getUpdateDate() != null && isNotEmpty(managerSearch.getAddress().getUpdateDate())){
			predicates.add(builder.equal(managerAddress.get(Address_.updateDate), managerSearch.getAddress().getUpdateDate()));
		}
		if(managerSearch != null && managerSearch.getAddress() != null && managerSearch.getAddress().getUpdateUser() != null && isNotEmpty(managerSearch.getAddress().getUpdateUser())){
			predicates.add(builder.equal(managerAddress.get(Address_.updateUser), managerSearch.getAddress().getUpdateUser()));
		}
		if(managerSearch != null && isNotEmpty(managerSearch.getActive())){
			predicates.add(builder.equal(manager.get(Manager_.active), managerSearch.getActive()));
		}
		if(managerSearch != null && isNotEmpty(managerSearch.getCreationDate())){
			predicates.add(builder.equal(manager.get(Manager_.creationDate), managerSearch.getCreationDate()));
		}
		if(managerSearch != null && isNotEmpty(managerSearch.getCreationUser())){
			predicates.add(builder.equal(manager.get(Manager_.creationUser), managerSearch.getCreationUser()));
		}
		if(managerSearch != null && isNotEmpty(managerSearch.getUpdateDate())){
			predicates.add(builder.equal(manager.get(Manager_.updateDate), managerSearch.getUpdateDate()));
		}
		if(managerSearch != null && isNotEmpty(managerSearch.getUpdateUser())){
			predicates.add(builder.equal(manager.get(Manager_.updateUser), managerSearch.getUpdateUser()));
		}
		if(managerSearch != null && isNotEmpty(managerSearch.getDegree())){
			predicates.add(builder.equal(manager.get(Manager_.degree), managerSearch.getDegree()));
		}
		if(managerSearch != null && isNotEmpty(managerSearch.getAllowance())){
			predicates.add(builder.equal(manager.get(Manager_.allowance), managerSearch.getAllowance()));
		}
		if(managerSearch != null && isNotEmpty(managerSearch.getActive())){
			predicates.add(builder.equal(manager.get(Manager_.active), managerSearch.getActive()));
		}
		
		criteria.select(manager).where(predicates.toArray(new Predicate[]{}));
		
		criteria.orderBy(builder.asc(manager.get(Manager_.id)));

		TypedQuery<Manager> query = entityManager.createQuery(criteria);

		query.setFirstResult(managerSearch.getOffset());
		query.setMaxResults(managerSearch.getRowCount());

		return query.getResultList();
	}

	public Manager getManagerCount(Manager managerSearch) throws Exception {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);

		Root<Manager> manager = criteria.from(Manager.class);
		
		Join<Manager, Address> managerAddress = manager.join(Manager_.address);

		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if(managerSearch != null && isNotEmpty(managerSearch.getId())){
			predicates.add(builder.equal(manager.get(Manager_.id), managerSearch.getId()));
		}
		if(managerSearch != null && isNotEmpty(managerSearch.getCpr())){
			predicates.add(builder.equal(manager.get(Manager_.cpr), managerSearch.getCpr()));
		}
		if(managerSearch != null && isNotEmpty(managerSearch.getName())){
			predicates.add(builder.equal(manager.get(Manager_.name), managerSearch.getName()));
		}
		if(managerSearch != null && isNotEmpty(managerSearch.getAge())){
			predicates.add(builder.equal(manager.get(Manager_.age), managerSearch.getAge()));
		}
		if(managerSearch != null && isNotEmpty(managerSearch.getEmail())){
			predicates.add(builder.equal(manager.get(Manager_.email), managerSearch.getEmail()));
		}
		if(managerSearch != null && isNotEmpty(managerSearch.getGender())){
			predicates.add(builder.equal(manager.get(Manager_.gender), managerSearch.getGender()));
		}
		if(managerSearch != null && isNotEmpty(managerSearch.getMobile())){
			predicates.add(builder.equal(manager.get(Manager_.mobile), managerSearch.getMobile()));
		}
		if(managerSearch != null && isNotEmpty(managerSearch.getSalary())){
			predicates.add(builder.equal(manager.get(Manager_.salary), managerSearch.getSalary()));
		}
		if(managerSearch != null && managerSearch.getAddress() != null && managerSearch.getAddress().getId() != null && isNotEmpty(managerSearch.getAddress().getId())){
			predicates.add(builder.equal(managerAddress.get(Address_.id), managerSearch.getAddress().getId()));
		}
		if(managerSearch != null && managerSearch.getAddress() != null && managerSearch.getAddress().getBuilding() != null && isNotEmpty(managerSearch.getAddress().getBuilding())){
			predicates.add(builder.equal(managerAddress.get(Address_.building), managerSearch.getAddress().getBuilding()));
		}
		if(managerSearch != null && managerSearch.getAddress() != null && managerSearch.getAddress().getRoad() != null && isNotEmpty(managerSearch.getAddress().getRoad())){
			predicates.add(builder.equal(managerAddress.get(Address_.road), managerSearch.getAddress().getRoad()));
		}
		if(managerSearch != null && managerSearch.getAddress() != null && managerSearch.getAddress().getBlock() != null && isNotEmpty(managerSearch.getAddress().getBlock())){
			predicates.add(builder.equal(managerAddress.get(Address_.block), managerSearch.getAddress().getBlock()));
		}
		if(managerSearch != null && managerSearch.getAddress() != null && managerSearch.getAddress().getCity() != null && isNotEmpty(managerSearch.getAddress().getCity())){
			predicates.add(builder.equal(managerAddress.get(Address_.city), managerSearch.getAddress().getCity()));
		}
		if(managerSearch != null && managerSearch.getAddress() != null && managerSearch.getAddress().getActive() != null && isNotEmpty(managerSearch.getAddress().getActive())){
			predicates.add(builder.equal(managerAddress.get(Address_.active), managerSearch.getAddress().getActive()));
		}
		if(managerSearch != null && managerSearch.getAddress() != null && managerSearch.getAddress().getCreationDate() != null && isNotEmpty(managerSearch.getAddress().getCreationDate())){
			predicates.add(builder.equal(managerAddress.get(Address_.creationDate), managerSearch.getAddress().getCreationDate()));
		}
		if(managerSearch != null && managerSearch.getAddress() != null && managerSearch.getAddress().getCreationUser() != null && isNotEmpty(managerSearch.getAddress().getCreationUser())){
			predicates.add(builder.equal(managerAddress.get(Address_.creationUser), managerSearch.getAddress().getCreationUser()));
		}
		if(managerSearch != null && managerSearch.getAddress() != null && managerSearch.getAddress().getUpdateDate() != null && isNotEmpty(managerSearch.getAddress().getUpdateDate())){
			predicates.add(builder.equal(managerAddress.get(Address_.updateDate), managerSearch.getAddress().getUpdateDate()));
		}
		if(managerSearch != null && managerSearch.getAddress() != null && managerSearch.getAddress().getUpdateUser() != null && isNotEmpty(managerSearch.getAddress().getUpdateUser())){
			predicates.add(builder.equal(managerAddress.get(Address_.updateUser), managerSearch.getAddress().getUpdateUser()));
		}
		if(managerSearch != null && isNotEmpty(managerSearch.getActive())){
			predicates.add(builder.equal(manager.get(Manager_.active), managerSearch.getActive()));
		}
		if(managerSearch != null && isNotEmpty(managerSearch.getCreationDate())){
			predicates.add(builder.equal(manager.get(Manager_.creationDate), managerSearch.getCreationDate()));
		}
		if(managerSearch != null && isNotEmpty(managerSearch.getCreationUser())){
			predicates.add(builder.equal(manager.get(Manager_.creationUser), managerSearch.getCreationUser()));
		}
		if(managerSearch != null && isNotEmpty(managerSearch.getUpdateDate())){
			predicates.add(builder.equal(manager.get(Manager_.updateDate), managerSearch.getUpdateDate()));
		}
		if(managerSearch != null && isNotEmpty(managerSearch.getUpdateUser())){
			predicates.add(builder.equal(manager.get(Manager_.updateUser), managerSearch.getUpdateUser()));
		}
		if(managerSearch != null && isNotEmpty(managerSearch.getDegree())){
			predicates.add(builder.equal(manager.get(Manager_.degree), managerSearch.getDegree()));
		}
		if(managerSearch != null && isNotEmpty(managerSearch.getAllowance())){
			predicates.add(builder.equal(manager.get(Manager_.allowance), managerSearch.getAllowance()));
		}
		
		criteria = criteria.select(builder.count(manager.get(Manager_.id)))
							.where(predicates.toArray(new Predicate[]{}));

		TypedQuery<Long> query = entityManager.createQuery(criteria);

		managerSearch.setTotalRows(query.getSingleResult().intValue());

		return managerSearch;
	}
	
	public Manager getManager(Manager manager) throws Exception {

		return entityManager.find(Manager.class, manager.getId());
	}
	
	public Manager saveManager(Manager manager) throws Exception {
		
		if (manager.getAddress().getId() == null) {

			manager.getAddress().setActive(true);
			manager.getAddress().setCreationUser("Test");
			manager.getAddress().setCreationDate(new Timestamp(System.currentTimeMillis()));

		} else {

			manager.getAddress().setUpdateUser("Test");
			manager.getAddress().setUpdateDate(new Timestamp(System.currentTimeMillis()));
		}
		
		for(Certificate certificate : manager.getCertificates()){
			
			certificate.setEmployee(manager);
			
			if (certificate.getId() == null) {

				certificate.setActive(true);
				certificate.setCreationUser("Test");
				certificate.setCreationDate(new Timestamp(System.currentTimeMillis()));

			} else {

				certificate.setUpdateUser("Test");
				certificate.setUpdateDate(new Timestamp(System.currentTimeMillis()));
			}
		}

		if (manager.getId() == null) {

			manager.setActive(true);
			manager.setCreationUser("Test");
			manager.setCreationDate(new Timestamp(System.currentTimeMillis()));
			
			entityManager.persist(manager);

		} else {

			manager.setUpdateUser("Test");
			manager.setUpdateDate(new Timestamp(System.currentTimeMillis()));
			
			entityManager.merge(manager);
		}
		
		return manager;
	}
	
	public Manager updateManagerActive(Manager manager) throws Exception {
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		
        CriteriaUpdate<Manager> criteria = builder.createCriteriaUpdate(Manager.class);
        
        Root<Manager> root = criteria.from(Manager.class);
        
        criteria.set(root.get(Manager_.active), manager.getActive());
        criteria.where(builder.equal(root.get(Manager_.id), manager.getId()));
        
        Query query = entityManager.createQuery(criteria);
        
        query.executeUpdate();
        
		return manager;
	}
}
