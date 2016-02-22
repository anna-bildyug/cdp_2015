package by.epam.cdp.framework.test;
import org.testng.annotations.Test;

import by.epam.cdp.framework.actions.BusinessActions;

public class ArticlePageTest extends CommonTest{
	
	@Test
	public void findTextOnArticlePage (){
		BusinessActions action = new BusinessActions();
		action.findLinkOnArticlePage();
	}
}