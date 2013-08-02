//Registers the skeleton type with Cleansanity
sanity.define_skeleton_type("humanoid_skeleton");




humanoid_skeleton.on_create = function(){

	//Tells Cleansanity that the humanoid_skeleton type has the following animations
	//and the following length in frames.
	//Defining a new limb automatically selects it as if the following were typed:
	//THIS.SKELETON.select_limb(0);
	THIS.SKELETON.define_limb_quad(-0.025, 0.0, 0.7, -0.025, 0.0, 0.6, 0.025, 0.0, 0.6, 0.025, 0.0, 0.7);
	THIS.SKELETON.set_limb_colour(1.0, 0.25, 0.10);
	THIS.SKELETON.set_limb_size(5.0);
	
	THIS.SKELETON.define_limb_quad(-0.05, 0.0, 0.6, 0.05, 0.0, 0.6, 0.05, 0.0, 0.3, -0.05, 0.0, 0.3);
	THIS.SKELETON.set_limb_colour(0.0, 0.25, 1.00);
	THIS.SKELETON.set_limb_size(3.0);
	
	THIS.SKELETON.define_limb_quad(-0.05, 0.0, 0.3, 0.0, 0.0, 0.3, 0.0, 0.0, 0.0, -0.05, 0.0, 0.0);
	THIS.SKELETON.set_limb_colour(0.5, 1.00, 0.10);
	THIS.SKELETON.set_limb_size(2.0);
	
	THIS.SKELETON.define_limb_quad(0.05, 0.0, 0.3, 0.0, 0.0, 0.3, 0.0, 0.0, 0.0, 0.05, 0.0, 0.0);
	THIS.SKELETON.set_limb_colour(0.5, 0.25, 0.10);
	THIS.SKELETON.set_limb_size(2.0);
	
	THIS.SKELETON.define_limb_quad(0.05, 0.0, 0.6, 0.05, 0.0, 0.55, 0.15, 0.0, 0.55, 0.15, 0.0, 0.6);
	THIS.SKELETON.set_limb_colour(0.2, 0.25, 0.40);
	THIS.SKELETON.set_limb_size(2.0);
	
	THIS.SKELETON.define_limb_quad(-0.05, 0.0, 0.6, -0.05, 0.0, 0.55, -0.15, 0.0, 0.55, -0.15, 0.0, 0.6);
	THIS.SKELETON.set_limb_colour(0.8, 0.25, 0.40);
	THIS.SKELETON.set_limb_size(2.0);
	
	THIS.SKELETON.define_animation("walk_body" , 60);
	THIS.SKELETON.define_animation("walk_legs" , 60);
	THIS.SKELETON.define_animation("idle" , 60);	
	
}

humanoid_skeleton.walk_body = function(frame){
	THIS.SKELETON.select_limb(0);
}

humanoid_skeleton.walk_legs = function(frame){
	THIS.SKELETON.select_limb(0)
}