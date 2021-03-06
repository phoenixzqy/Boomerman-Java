package client;

import shared.controller.INavigator;
import shared.controller.Navigator;
import shared.view.IMenuViewBuilder;
import shared.view.IViewFactory;
import shared.view.IViewStack;
import shared.view.MenuViewBuilder;
import shared.view.ViewStack;
import client.controller.ControllerFactory;
import client.controller.IControllerFactory;
import client.controller.IMainMenuController;
import client.view.ViewFactory;

/**
 * Handles the client application set up and launching.
 */
public class Main 
{
	/**
	 * Main program method which launches the application.
	 * @param args This application ignores any command line arguments.
	 */
	public static void main(String[] args) 
	{
		// set up the navigator
		IViewStack viewStack = new ViewStack("Bomberman");
		IMenuViewBuilder menuViewBuilder = new MenuViewBuilder();
		IViewFactory viewFactory = new ViewFactory(menuViewBuilder);
		INavigator navigator = new Navigator(viewStack, viewFactory);
		
		// set up the controller
		IControllerFactory controllerFactory = new ControllerFactory();
		IMainMenuController mainMenuController = controllerFactory.
			createMainMenuController(navigator);
		
		// start the application
		navigator.push(mainMenuController);
	}
}

                                                    
