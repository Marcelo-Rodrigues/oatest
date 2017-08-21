package oatest.secure;

import java.util.ArrayList;
import java.util.Hashtable;

public class Authorization {
	final Hashtable<String, String[]> routeRoleMap;
	final ArrayList<String> publicRoutes;
	final AuthorizationService authService;

	public Authorization(AuthorizationService authService) {
		routeRoleMap = new Hashtable<>();
		publicRoutes = new ArrayList<>();
		this.authService = authService;
		FillRouteRoleMap();
	}

	private void FillRouteRoleMap() {
		addRole("*", "/urlPublicRole");
		addRole("clientes", "/clientes");
		addRole("A", "/urlRoleA", "/urlRoleA2");
		addRole("B", "/urlRoleB");
		addRole("C", "/urlRoleC");
	}

	void addRole(String role, String... serviceUrls) {
		if (role.equals("*")) {
			for (String serviceUrl : serviceUrls) {
				publicRoutes.add(serviceUrl);
			}
		} else {
			routeRoleMap.put(role, serviceUrls);
		}
	}

	public boolean authorizeUser(String userCode, String url) {
		if(publicRoleMatch(url)){
			return true;
		}		
		String[] roles = authService.getRoles(userCode);
		return roleMatch(url, roles);		
	}

	public boolean publicRoleMatch(String url) {
		for (String publicRoute : publicRoutes) {
			if (url.startsWith(publicRoute)) {
				return true;
			}
		}
		return false;
	}

	public boolean roleMatch(String url, String[] roles) {
		for (String role : roles) {
			String paths[] = routeRoleMap.get(role);
			for (String path : paths) {
				if (url.startsWith(path)) {
					return true;
				}
			}
		}
		return false;
	}
}
