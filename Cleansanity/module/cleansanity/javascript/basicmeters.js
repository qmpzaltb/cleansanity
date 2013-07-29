//This file holds some of the basic meter-creating 

//Creates a function that you can call elsewhere, such as in the human creation function.
//maxHealth is a parameter of the method. When this method is called, a variable will be placed in the brackets.
//This variable is the maximum health. This specific method uses the parameter to determine the entity's maximum health.
function define_health(maxHealth){
	
	//THIS refers to the entity that the function will be called from.
	//So calling this function from the human.on_create function will mean that "THIS" will be the newly-created human
	//Creates a new meter called "health"
	THIS.define_meter("health");
	
	//Sets the current scope of any meter accessing methods to the health meter
	THIS.select_meter("health");
	
	//Sets the in-game name of the meter
	THIS.set_meter_name("Health");
	
	
	//Gives the meter a red color (arguments are the meter, r, g, and b)
	THIS.set_meter_color(1 , 0 , 0);
	
	//Sets the minimum and the maximum of the meter
	THIS.set_meter_minimum(0);
	THIS.set_meter_maximum(maxHealth);
	
	//Sets the current level of the meter
	THIS.set_meter_level(maxHealth);
	
	//A lower priority (like 0) means that it will show up before the other.
	//This depends on how the HUD is set up, but generally, if the GUI is on the bottom-left,
	//a lower priority integer would put it on the top or on the left (depending on if bars will be horizontal or vertical)
	THIS.set_meter_display_priority(0);
	
	//Sets if the meter is visible on the HUD
	THIS.set_meter_visible_HUD(true);
	
	//Sets if the meter is visible on the player screen
	THIS.set_meter_visible_playerscreen(true);
	
	//Sets if the meter is visible above the entity
	THIS.set_meter_visible_public(true)
}

//Much like the Health function, but for stamina. The most notable differences are the name, colour, and public visibility.
function define_stamina(maxStamina){
	THIS.define_meter("stamina");
	THIS.select_meter("stamina");
	
	THIS.set_meter_color(1, 0.5, 0);
	
	THIS.set_meter_minimum(0);
	THIS.set_meter_maximum(maxStamina);
	
	THIS.set_meter_level(maxStamina);
	
	THIS.set_meter_visible_HUD(true);
	THIS.set_meter_visible_playerscreen(true);
	THIS.set_meter_visible_public(false);
}