package support;

import static support.Driver.getDriver;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertTrue;
	

public class DSL {
	
	public int tempoEspera = 15;

	//método genérico responsavel por preencher um campo texto.
	public void escrever(By propriedade, String texto) throws InterruptedException {
	 	aguardarObj(propriedade);
	 	aguardarVisibilidadeObj(propriedade);
	 	if (getDriver().findElement(propriedade).getText() != "" ||getDriver().findElement(propriedade).getText() != null)
	 		limpar(propriedade);
			assertTrue(getDriver().findElement(propriedade).isDisplayed());
		getDriver().findElement(propriedade).setValue(texto);
	}
	
	public void escreverSemLimpar(By propriedade, String texto) throws InterruptedException {
	 	aguardarObj(propriedade);
	 	aguardarVisibilidadeObj(propriedade);
			assertTrue(getDriver().findElement(propriedade).isDisplayed());
		getDriver().findElement(propriedade).setValue(texto);
	}
	
	//método genérico responsavel por preencher um campo texto.
	public void limpar(By propriedade) throws InterruptedException {
		aguardarObj(propriedade);
		aguardarVisibilidadeObj(propriedade);
		assertTrue(getDriver().findElement(propriedade).isDisplayed());
		getDriver().findElement(propriedade).clear();
		
	}
	
	//Método genérico para clicar em um elemento.
	public void clicarLink(By propriedade) throws InterruptedException {
		aguardarObj(propriedade);
		aguardarVisibilidadeObj(propriedade);
		assertTrue(getDriver().findElement(propriedade).isDisplayed());
		getDriver().findElement(propriedade).click();
	}
	
	//Método genérico para clicar em um elemento.
	public void clicarLinkSemAguardar(By propriedade) throws InterruptedException {
		getDriver().findElement(propriedade).click();
	}
	//Método genérico para clicar em um elemento.
	public void submeterLink(By propriedade) throws InterruptedException {
		aguardarObj(propriedade);
		aguardarVisibilidadeObj(propriedade);
		assertTrue(getDriver().findElement(propriedade).isDisplayed());
		getDriver().findElement(propriedade).submit();
	}
	
	//método genérico para validar label
	public boolean validar(By propriedade) throws InterruptedException{
			aguardarObj(propriedade);
			aguardarVisibilidadeObj(propriedade);
			if (getDriver().findElement(propriedade).isDisplayed()) {			
				return true;	
			}
			else
			{
				return false;
			}
		
	}
	
	//método genérico para validar label
	public boolean validarExibicao(By propriedade) throws InterruptedException{
		
			try {
				if (getDriver().findElement(propriedade).isDisplayed()) {			
					return true;	
				}
				else
				{
					return false;
				}
			} catch (InterruptedException e) {
				return false;
				
			}
		
	}
	
	public boolean aguardarObj(By propriedade) throws InterruptedException {
		try {
		new WebDriverWait(getDriver(), tempoEspera)
					.ignoring(NoSuchElementException.class, TimeoutException.class)
					.until(ExpectedConditions.elementToBeClickable(propriedade));
			return true;
		} catch (NoSuchElementException e) {
			return false;
		} catch (TimeoutException f) {
			return false;
		}
		 
	}
	
	public void aguardarVisibilidadeObj(By propriedade) throws InterruptedException {
		try {
			new WebDriverWait(getDriver(), tempoEspera).until(ExpectedConditions.visibilityOfElementLocated(propriedade));
		} catch (InterruptedException e) {
			e.printStackTrace();
			throw new InterruptedException("Objeto Não encontrado no tempo esperado");
		}
	}
	
}

