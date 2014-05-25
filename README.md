Cleansanity
===========

Changing Literally Everything AgainN edition.

obligatory screenshot: [map generation and display](http://i.imgur.com/EQdhzj6.jpg)

Recreating and improving the ideas of qmpzaltb/cptgame. Libraries! Time! Profanities in the code!
But now we're starting all over again. Whee!
And then we shall start ONCE AGAIN.

"perfection stems from persistence" - qmpzaltb
"making your quote seem poignant is of utmost importance when writing poignant quotes" - qmpzaltb

This time, things will be different.
This time, commentation.
This time, a slightly better understanding of object-oriented principles.

Feature list

  - Map generation
    - Currently uses a butchered (inefficient) version of Prim's algorithm to create a tree-like map
  - Input
    - Yeah that needs to be done too. Very basic version exists right now where "QWERASDF ARROW KEYS" controls the camera location and rotation.
  - Graphics
    - Shaders need to be written
    - Before that, though, shaders need to be learned
  - Entities
    - The bane of object-oriented programming. How to make entities follow proper OOP principles?
    - Currently uses a spaghetti version of controllers (intelligences), actions, and flags.
      - Controllers can be an AI, user input-based, a network connection, or whatever else can be though of
  - Scalability
  - High map features
    - For a later time
  - Multiplayer
    - Current idea is to use entity controllers on a network level.
  - Entity Upgrades & Upgrade GUI
    - And also HUD
  - Items
    - Because the code needs more spaghetti to distinguish entities from items on the ground.
  - Modularity
    - Jar loaders are the current general direction.
  - Graphics
