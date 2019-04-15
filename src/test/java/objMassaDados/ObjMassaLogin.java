package objMassaDados;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ObjMassaLogin {
	private JSONObject jsonObject;
	private JSONParser parser = new JSONParser();
	
	private String login;
	private String senha;
	private String loginInvalido;
	private String senhaInvalida;
	
	public void carregarArquivo() throws FileNotFoundException, IOException, ParseException {
		jsonObject = (JSONObject) parser.parse(new FileReader("/Users/alefrer/eclipse-workspace/Automacao_Mobile/src/test/java/massaDados/login.json"));

		setLogin((String) jsonObject.get("login"));
		setSenha((String) jsonObject.get("senha"));
		setLoginInvalido((String) jsonObject.get("loginInvalido"));
		setSenhaInvalida((String) jsonObject.get("senhaInvalida"));
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLoginInvalido() {
		return loginInvalido;
	}

	public void setLoginInvalido(String loginInvalido) {
		this.loginInvalido = loginInvalido;
	}

	public String getSenhaInvalida() {
		return senhaInvalida;
	}

	public void setSenhaInvalida(String senhaInvalida) {
		this.senhaInvalida = senhaInvalida;
	}

	
	
}
