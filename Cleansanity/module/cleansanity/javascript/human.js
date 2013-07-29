//Sample Human.js file for module syntax defining purposes.
//Also for the purposes of defining a human.

//Declaring a new object called Human
//human = new Object();
//That can happen in the next line. define_entity_type method can have its own javascript eval that does human = new Object()

//Telling Cleansanity that human is an entity type
sanity.define_entity_type("human");

//Gives the human object an on_create function, which will dicate what happens when a human is created
human.on_create = function(){
	
	//Gives the entity a name.
	THIS.set_name("Human");
	//Gives the entity a description
	THIS.set_description("Humans are a bipedal race known for their general apathy. Regardless of their apathy (or perhaps because of it), they display great innovation in their cleaning technologies.");
	
	
	//Calls upon the "define_health" function in another .js file.
	//That function contains a lot of the jargon necessary to create a health bar.
	//The number inside the brackets, a parameter, indicates what the maximum health will be
	//(because that's what the method says that number does)
	define_health(100);
	define_stamina(50);
	

	//Sets the entity's speed in blocks per gametick.
	THIS.set_speed(0.1);
	
	//Sets the skeleton of the entity to the 
	THIS.define_skeleton("humanoid_skeleton");
	
	
	//Defines actions to the entity. Actions are what an entity is capable of doing consciously (or in some rare cases, unconsciously).
	//They update every gametick, right before an entity's on_update() function.
	//They are often used by AI's to control their entity, or by players through the mouse and keyboard to control theirs.
	THIS.define_action("move");
	THIS.define_action("sprint");
	
	THIS.define_action("humanoid_attack_use_primary");
	THIS.define_action("humanoid_attack_use_secondary");
	
	
}

//Gives the human object an on_update function, which will dictate what happens every gametick.
human.on_update = function(){
	
	//Selects the health meter for the upcoming if-statement
	THIS.select_meter("health");
	
	//An if-statement. If the statement inside the brackets is true, the stuff inside
	//the braces will happen.
	//In this case, the if-statement is asking whether the meter level (which is the health meter selected previously)
	//is under-or-equal-to zero.
	if (THIS.get_meter_level() <= 0){
	
		//If it is, then it sets this entity as removable.
		//Removable means that the game engine will overwrite this entity with another entity if the time comes for it.
		THIS.set_removable();
		
	}
	
	//Shifts the level of the selected meter (in this case, health again).
	//This statement is acting as a health-regeneration mechanism. Every time the entity updates,
	//its health will increase by 0.01 points.
	//Logic-wise, this has to be after the death-check, otherwise the human would be immortal
	//(the human would constantly be at 0.01 health or more, because he would regenerate just a bit before the death check)
	THIS.shift_meter_level(0.01);
	
	
	
}