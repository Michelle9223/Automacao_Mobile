package steps;

import javax.swing.JScrollPane;

import org.openqa.selenium.By;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import support.DSL;
import support.Driver;
import support.MensagensErro;

public class ListagemSteps {

	private AndroidDriver<MobileElement> driver;
	private DSL dsl = new DSL();
	private MensagensErro mensagemErro = new MensagensErro();
	private LoginSteps login = new LoginSteps();
	private JScrollPane panelScroll = new JScrollPane();
	
	private String xpathClicarImagem = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.ImageView";
	private String xpathInformacoes = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.TextView[2]";
	private String xpathClicarUltimaImagem = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[6]/android.widget.ImageView";
	private String xpathInformacoesUltimaImagem = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.TextView[2]";
	@Before
	public void inicializarApp() throws Exception {
		driver = Driver.getDriver();
	}
	
	@After
	public void finalizarCenario() throws Exception {
		driver.closeApp();
		driver.launchApp();
	}

	@Dado("^que estou na tela Listagem$")
	public void que_estou_na_tela_Listagem() throws Exception{
		try {
			login.insiro_login_e_senha_validos();
			dsl.validar(By.xpath(xpathClicarImagem));
		}catch (Exception e) {
			throw new Exception(mensagemErro.getMemsagemErroListagem());
		}
	}
	
	@Quando("^clico na primeira imagem$")
	public void clico_na_primeira_imagem() throws Exception{
		try {
			dsl.clicarLink(By.xpath(xpathClicarImagem));
		}catch (Exception e) {
			throw new Exception(mensagemErro.getMemsagemErroListagem());
		}
	}
	
	@Entao("^devo visualizar tela com mais informacoes da imagem$")
	public void devo_visualizar_tela_com_mais_informacoes_da_imagem() throws Exception{
		try {
			dsl.validar(By.xpath(xpathInformacoes));
		}catch (Exception e) {
			throw new Exception(mensagemErro.getMemsagemErroListagem());
		}
	}
	
	@Quando("^faço scroll")
	public void faco_scroll() throws Exception{
		try {
			panelScroll.getVerticalScrollBar();
		}catch (Exception e) {
			throw new Exception(mensagemErro.getMemsagemErroListagem());
		}
	}
	
	@E("^clico na ultima imagem$")
	public void clico_na_ultima_imagem() throws Exception{
		try {
			dsl.clicarLink(By.xpath(xpathClicarUltimaImagem));
		}catch (Exception e) {
			throw new Exception(mensagemErro.getMemsagemErroListagem());
		}
	}
	
	@Entao("^devo visualizar tela com mais informacoes da ultima imagem$")
	public void devo_visualizar_tela_com_mais_informacoes_da_ultima_imagem() throws Exception{
		try {
			dsl.validar(By.xpath(xpathInformacoesUltimaImagem));
		}catch (Exception e) {
			throw new Exception(mensagemErro.getMemsagemErroListagem());
		}
	}
}
