package oatest.secure;

import java.security.Principal;

public class UsuarioAutenticado implements Principal {
	String nome;
	String funcional;

	public UsuarioAutenticado(String nome, String funcional) {
		this.nome = nome;
		this.funcional = funcional;
	}

	@Override
	public String getName() {
		return nome;
	}

	public String getFuncional() {
		return funcional;
	}

}
