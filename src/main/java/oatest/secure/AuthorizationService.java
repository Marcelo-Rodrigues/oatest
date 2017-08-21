package oatest.secure;

public class AuthorizationService {
	public String[] getRoles(String userCode) {
		if (userCode.equals("A"))
			return new String[] { "A" };

		if (userCode.equals("AB"))
			return new String[] { "A", "B" };

		if (userCode.equals("ABC"))
			return new String[] { "A", "B", "C" };

		return null;
	}
}
