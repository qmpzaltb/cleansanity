//Registers the skeleton type with Cleansanity
sanity.define_skeleton_type("humanoid_skeleton");

//Tells Cleansanity that the humanoid_skeleton type has the following animations
//and the following length in frames.
humanoid_skeleton.define_animation("walk_body" , 60);
humanoid_skeleton.define_animation("walk_legs" , 60);
humanoid_skeleton.define_animation("idle" , 60);

humanoid_skeleton.on_create = function(){
	THIS_SKELETON.define_limb_line()
	
	
}

humanoid_skeleton.walk_body = function(frame){
	THIS.SKELETON.select_limb("");





}