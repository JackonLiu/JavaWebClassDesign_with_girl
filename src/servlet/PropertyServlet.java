package servlet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Category;
import bean.Property;
import util.Page;


public class PropertyServlet extends BaseBackServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String add(HttpServletRequest request, HttpServletResponse response, Page page) {
		int cid = Integer.parseInt(request.getParameter("cid"));
		Category c = categoryDAO.get(cid,null);
		
		String name = request.getParameter("name");
		Property p = new Property();
		p.setCategory(c);
		p.setName(name);
		propertyDAO.add(p);
		return "@admin_property_list?cid="+cid;
	}

	@Override
	public String delete(HttpServletRequest request, HttpServletResponse response, Page page) {
		int id = Integer.parseInt(request.getParameter("id"));
		Property p = propertyDAO.get(id);
		Category c = p.getCategory();
		int cid = c.getId();
		propertyDAO.delete(id);
		return "@admin_property_list?cid="+cid;
	}

	@Override
	public String edit(HttpServletRequest request, HttpServletResponse response, Page page) {
		int id = Integer.parseInt(request.getParameter("id"));
		Property p = propertyDAO.get(id);
		request.setAttribute("p", p);
		return "admin/editProperty.jsp";
	}

	@Override
	public String update(HttpServletRequest request, HttpServletResponse response, Page page) {
		int id = Integer.parseInt(request.getParameter("id"));
		int cid = Integer.parseInt(request.getParameter("cid"));
		Category c = categoryDAO.get(cid,null);
		Property p = new Property();
		String name = request.getParameter("name");
		p.setId(id);
		p.setCategory(c);
		p.setName(name);
		propertyDAO.update(p);
		return "@admin_property_list?cid="+cid;
	}

	@Override
	public String list(HttpServletRequest request, HttpServletResponse response, Page page) {
		int cid = Integer.parseInt(request.getParameter("cid"));
		Category c = categoryDAO.get(cid,null);
		List<Property> ps = propertyDAO.list(cid);
		int total = propertyDAO.getTotal(cid);
		page.setTotal(total);
		page.setParam("&cid="+c.getId());
		request.setAttribute("ps", ps);
        request.setAttribute("c", c);
        request.setAttribute("page", page);
         
        return "admin/listProperty.jsp";
	}

}
