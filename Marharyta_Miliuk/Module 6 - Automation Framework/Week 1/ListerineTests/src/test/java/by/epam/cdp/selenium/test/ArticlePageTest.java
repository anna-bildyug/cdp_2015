package by.epam.cdp.selenium.test;
import org.testng.annotations.Test;
import by.epam.cdp.selenium.actions.BusinessActions;

public class ArticlePageTest extends CommonTest{
	
	@Test
	public void findTextOnArticlePage (){
		BusinessActions action = new BusinessActions();
		action.findLinkOnArticlePage();
	}
}