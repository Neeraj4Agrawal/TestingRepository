package com.matellio.brideside.gift;

import com.matellio.brideside.util.BaseUtil;

import org.junit.Assert;

public class GiftPage extends BaseUtil {
	
	
	
	
	
  public void entertextIntextbox(String objLocator, String value)
  {
	  enterText(objLocator,value);
	  
  }
	
  
  public void clickonElement(String objLocator)
  {
	  click(objLocator);
  }
	
	public void verifytext(String expected, String actual)
	{
		Assert.assertEquals("Title value is not matching",expected, actual);
	}

}
