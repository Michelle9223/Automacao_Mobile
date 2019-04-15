package steps;

import org.openqa.selenium.By;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import objMassaDados.ObjMassaLogin;
import support.DSL;
import support.Driver;
import support.MensagensErro;

public class LoginSteps {
	
	private AndroidDriver<MobileElement> driver;
	private DSL dsl = new DSL();
	private MensagensErro mensagemErro = new MensagensErro();
	private ObjMassaLogin objMassaLogin = new ObjMassaLogin();
	
	private String xpathClicarImagem = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.ImageView";
	private String idEscreverLogin = "br.com.netshoes.showcase:id/login_user";
	private String idEscreverSenha = "br.com.netshoes.showcase:id/login_password";
	private String idBotaoLogin = "br.com.netshoes.showcase:id/login_button";
	private String xpathValidarImagem = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView";
	private String xpathValidarErro = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView"; 
	
	@Before
	public void inicializarApp() throws Exception {
		driver = Driver.getDriver();
	}
	
	@After
	public void finalizarCenario() throws Exception {
			driver.closeApp();
			driver.launchApp();
	}
	
	@Dado("^que estou na tela Login$")
	public void que_estou_na_tela_Login() throws Exception {
		try {
			dsl.clicarLink(By.xpath(xpathClicarImagem));
		}catch (Exception e) {
			throw new Exception(mensagemErro.getMensagemErroLogin());
		}
		
	}
	
	@Quando("^insiro Login e Senha validos$")
	public void insiro_login_e_senha_validos() throws Exception {
		try {
			objMassaLogin.carregarArquivo();
			dsl.escrever(By.id(idEscreverLogin), objMassaLogin.getLogin());
			dsl.escrever(By.id(idEscreverSenha), objMassaLogin.getSenha());
			dsl.clicarLink(By.id(idBotaoLogin));
		}catch (Exception e) {
			throw new Exception(mensagemErro.getMensagemErroLogin());
		}
	}
	
	@Entao("devo visualizar tela de listagem$")
	public void devo_visualizar_tela_de_listagem() throws Exception {
		try {
			dsl.validar(By.xpath(xpathValidarImagem));
		}catch (Exception e) {
			throw new Exception(mensagemErro.getMensagemErroLogin());
		}
	}
	
	@Quando("^insiro Login e Senha invalidos$")
	public void insiro_Login_e_Senha_invalidos() throws Exception {
		try {
			objMassaLogin.carregarArquivo();
			dsl.escrever(By.id(idEscreverLogin), objMassaLogin.getLoginInvalido());
			dsl.escrever(By.id(idEscreverSenha), objMassaLogin.getSenhaInvalida());
			dsl.clicarLink(By.id(idBotaoLogin));
		}catch (Exception e) {
			throw new Exception(mensagemErro.getMensagemErroLogin());
		}
	}
	
	@Entao("^devo visualizar mensagem de erro$")
	public void devo_visualizar_mensagem_de_erro() throws Exception {
		try {
			dsl.validar(By.xpath(xpathValidarErro));
		}catch (Exception e) {
			throw new Exception(mensagemErro.getMensagemErroLogin());
		}
	}
	
}
