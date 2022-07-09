package employee.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import employee.bean.ManagerBean;
import employee.entity.Manager;

@Path("/")
public class ManagerService {

	@EJB
	ManagerBean managerBean;
	
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("searchManagers")
	@POST
	public List<Manager> searchManagers(Manager managerSearch) throws Exception {
		
		return managerBean.searchManagers(managerSearch);
	}
	
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("getManagerCount")
	@POST
	public Manager getManagerCount(Manager managerSearch) throws Exception {
		
		return managerBean.getManagerCount(managerSearch);
	}
	
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("getManager")
	@POST
	public Manager getManager(Manager manager) throws Exception {
		
		return managerBean.getManager(manager);
	}
	
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("saveManager")
	@POST
	public Manager saveManager(Manager manager) throws Exception {
		
		return managerBean.saveManager(manager);
	}
	
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("updateManagerActive")
	@POST
	public Manager updateManagerActive(Manager manager) throws Exception {
		
		return managerBean.updateManagerActive(manager);
	}
}
