package shop.doshoes.util;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtils {

	public static HttpSession getSession() {
		return (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
	}

	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest();
	}

	public static String getCustomerID() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		return session.getAttribute("cust_id").toString();
	}

	public static String getEmail() {
		HttpSession session = getSession();
		if (session != null)
			return (String) session.getAttribute("email");
		else
			return null;
	}
	
	public static String getFirstName() {
		HttpSession session = getSession();
		if (session != null)
			return (String) session.getAttribute("firstname");
		else
			return null;
	}
}
