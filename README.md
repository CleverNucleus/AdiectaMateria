# AdiectaMateria 2.2.3 for MC 1.12.2
A Minecraft mod designed to add custom utilities &amp; material effects to a private modpack, now released to the public.

# What's Changed?
This version is a complete rewrite of the mod for *Minecraft 1.12.2*. The previous version avaiable for the same version of Minecraft was mostly just a port from the 1.7.10 version, with some small additions.

# Dependencies
Baubles is no longer even an optional dependency, as Trinkets have been removed. The only dependency for this mod is *Minecraft 1.12.2* and a minimum version of *Forge 14.23.5.2768*.

# Gameplay Tutorial / Getting Started
 1). Smelt *Flint* in a Furnace to obtain *Melty Flint*.
 2). Right-click (item use action) with *Melty Flint* on a *Bookshelf* to obtain the mod's guide book; *Ex Materiae Vicipaedia*.
 3). Right-click (item use action) the guide book and inside are a series of tabs (topics) on the right hand side; each tab discusses a particular aspect of the mod, including a tab for all crafting/smelting/transforming recipes implemented by the mod.
 
 The Mod has some recipe interaction with *Applied Energistics 2* (for *MC 1.12.2*), *Tinkers Construct* (for *MC 1.12.2*) and *Thermal Foundation* (for *MC 1.12.2*). The following interactions exist when the above mods are loaded:
 
 *Applied Energistics 2*:
  - 1x Sky Stone = {*shapeless*, Stone, Glowstone}
  - 1x Certus Quartz Crystal = {*shapeless*, Nether Quartz, Redstone}
  - 1x Charged Certus Quartz Crystal = {*shapeless*, Certus Quartz Crystal, Redstone}
  - 1x Fluix Quartz = {*shapeless*, Charged Certus Quartz Crystal, Redstone}
  - 1x Calculation Processor = {*shapeless*, Charged Certus Quartz Crystal, Redstone, Iron Ingot}
  - 1x Logic Processor = {*shapeless*, Charged Certus Quartz Crystal, Redstone, Gold Ingot}
  - 1x Engineering Processor = {*shapeless*, Charged Certus Quartz Crystal, Redstone, Diamond}
  - 1x Pure Nether Quartz Crystal = {*shaped*, "ABA", "ABA", "ABA", 'A': Nether Quartz, 'B': Redstone}
  - 1x Pure Certus Quartz Crystal = {*shaped*, "ABA", "ABA", "ABA", 'A': Certus Quartz Crystal, 'B': Redstone}
  - 1x Pure Fluix Crystal = {*shaped*, "ABA", "ABA", "ABA", 'A': Fluix Crystal, 'B': Redstone}
  
*Tinkers Construct*:
  - 1x Necrotic Bone = {*smelting*, Bone}
  - 1x Wither Skeleton Skull = {*shaped*, "AAA", "ABA", "AAA", 'A': Necrotic Bone, 'B': Skeleton Skull}
  
*Thermal Foundation*:
  - 1x Blitz Rod = {*smelting*, Blaze Rod}
  - 1x Basalz Rod = {*smelting*, Blitz Rod}
  - 1x Blizz Rod = {*smelting*, Basalz Rod}
  
# Dev / Changelog
This is a complete rewrite, but some core aspects have remained; note that the mod is not built with cross version world compatibility, as I usually start a new world with every version anyway - my mod, my rules.

 - +Added *Melty Flint*: This item functions as a core aspect of the mod.
 - +Added a fully fleshed out guide book, *Ex Materiae Vicipaedia*.
 - +Implemented a *"world crafting"* system: This is how *Melty Flint* is used - in essence, one can transform/transmute many different types of blocks into many different other blocks/variants/items --> all recipes are listed in the book and how to use them.
 - +Added *Rice*: Rice is a seed/food, used to plant rice crop and make other rice related foods.
 - +Added *Flax*: Flax is a really good looking 4 block tall fast growing crop that literally only exists to produce string.
 - +Added *Bone Crop*: Bones can now be planted into the ground to grow a new bush, which drops more bones.
 - +Added the *Grafter*: A hoe/scythe type tool that is used to initially get Rice/Flax - the book explains how.
 - +Added Custom Decorative Blocks/Panes/Panels:
   - +*Paper Wall*: Japan style Pane.
   - +*Paper Woven Straw*: Aesthetic Block.
   - +*Sand Lamp*: A light source that actually looks nice.
   - +*Sand Lamp Brick*: Sand Lamp variant.
   - +*Mud Brick*: Stronger Dirt that looks nice.

 - +Added *Papery Sheet*: An item made from rice that can be used to make paper more efficiently, and other things like nametags - look in the guide book.
 - +Added *Infinite Lava Crystal*: Basically a really expensive bucket that has infinite lava.
 - +Added *Infinite Water Crystal*: Another really expensive bucket that has infinite water.
  - *Thermal Foundation/Dynamics interaction*: These infinite liquid crystals can be used in the *Fluid Transposer* to provide infinite volumes of their respective liquids - at a very rapid rate as well.

 - +Added *Gold Bars*: An aesthetic form of gold - equivalent to 3 gold ingots. 
 - +Added *Gold Bars* as loot to *Underground Mineshafts*, *Desert Pyramids*, *Jungle Temples* and *Village Blacksmiths*. Note that they have a 50% chance to occur. 

**Guide Book** 
The guide book necessitated a custom recipe implementation so that the extra recipes could not only be registered to the game but also to the book for display purposes. This implementation has been refined and polished into an efficient loading mechanic - that registers the recipes on game init, but only registers them to the book when the book is opened so that minimum memory is used. When the book is closed the recipes are unloaded again. This involves extra processing, however this only occurs on the client as it is only for display use. 
The mod features a lot of world interactions with *Melty Flint* - i.e. world crafting. These world recipes do not yet have support for JEI/NEI, but are however listed in the book. 

This cannot be stressed enough - the book IS THE TUTORIAL. 

The mod does not offer a progression direction or motive, like *Mekanism* or *Thermal Foundation*, instead it should be thought of as a vanilla-like utility mod that enhances gameplay *slightly*. All textures are themed after *MC 1.14*, some are taken from other mods where licensing allows for it. 
