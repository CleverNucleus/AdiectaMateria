# AdiectaMateria (MC 1.12.2, MOD VERSION 2.1.5)
A Minecraft mod designed to add custom utilities &amp; material effects to a private modpack, now released to the public.

# Changelog
- -Removed Dependency on Baubles: Baubles is now optional, but note that Trinkets will ony work with it installed.
- -Removed Tinkers Construct recipe for green heart canisters (they no longer exist).
- -Removed chest spawning for Trinkets.
- -Removed all MineFactoryReloaded interactions (mod not updated to 1.12.2).
- ~Changed the Trinket mob drop code slightly; they still have a 1 in 100 chance to drop from killing either a zombie or skeleton and a further 1 in 6 chance for a specific Trinket.
- ~Restructured entire code layout to make it more streamlined and dynamic.
- ~Changed the way Lightning in a Jar shoots lightning: Instead of firing a bolt of lightning at a target point, it now summons bolts of lightning to strike every mob in a 32 block radius of the player (still has 24 uses).
- ~Changed the way Fire in a Jar sets fire: Instead of causing an explosion and a carpet of flame at a target point, it now sets fire to every mob in a 32 block radius of the player, for duration *max health / burn dmg* i.e. the fire will burn until the mob dies (still has 24 uses).
- ~Changed a few potion effects around.
- ~Changed most of the fundemental item crafting recipes (e.g. glowstone can now be made from 1xPulvis Impirium and 2xRedstone).
- ~Changed the item that performs world crafting from Catalytic Dust (*Pulvis Impirium*) to Catalytic Dust (*Altera Impirium*).
- +Added an item Catalytic Dust (*Pulvis Impirium*). This item is a higher status version of Pulvis Impirium and right clicks blocks to change them (think of the philosopher's stone from EE2).
- +Added an item *The End in a Jar*. When used this will teleport every mob in a 32 block radius to the mobs original position + 100 blocks in the air, making them all die from fall damage (has 24 uses).
- +Added custom sound effects for every item action.
- +Added more world crafting recipes to keep up to date with the aditional dye blocks in MC 1.12.2 (e.g. Glazed Terracotta).
- +Added a simple guide book that catalogues all the world crafting recipes *Altera Impirium* can do (including all dye recipes such as white wool to orange wool etc.).
- +Added slightly new textures and a gui feature to help wher JEI/NEI is unable.
- +Added compatibility between Thermal Foundations Fluid Transposer and the infinte Water in a jar and Lava in a jar items. They can now be placed in the transposer to provide an infinte source of fluid at the maximum rate possible.
- -Removed Herobr. - no just kidding lol.

# Dependencies
- Minecraft Forge 1.12.2-14.23.5.2768 (minimum).

# Optional Dependencies (Trinkets)
- Baubles MC 1.12.2 (THIS IS ONLY NEEDED FOR THE TRINKETS TO WORK).

# Dev notes
- ~Cleaned up all the code and added a comment to every method for easier understanding and reading when next updating.
- ~Made sure that Akashic tome is compatible with the book.
- ~the book can't be crafted. You get it by right clicking a bookshelf with a Catalytic Dust(*Altera Impirium*) - think of Thaumcraft 4/5.
- ~The trinkets can't be crafted, the only way of obtaining them is to kill zombies or skeletons. Note (again) that they are literally useless without Baubles, and must be equipped in their respective Bauble slots to give the active effects. Effects include constant application of *Instant Health* (Really OP), *Saturation* (You don't need to eat), *Night Vision*, *Speed II* (move speed not mining speed), *Invisibility* and *water breathing*.
- ~Use JEI / NEI for a list of crafting / smelting recipes, and the book added for a list of Altera Impirium right click recipes.
- +Added a modID logo file (finally).
