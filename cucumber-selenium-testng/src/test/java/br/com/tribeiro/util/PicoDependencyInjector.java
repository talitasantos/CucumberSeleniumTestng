package br.com.tribeiro.util;

import cucumber.runtime.java.picocontainer.PicoFactory;

public class PicoDependencyInjector extends PicoFactory {
	
	public PicoDependencyInjector() {  
        addClass(SharedDriver.class);  
  }  

}
