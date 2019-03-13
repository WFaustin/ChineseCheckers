Chinese Checkers README/Release Notes
Widchard Faustin
CS338

Version 1.0

This project was made by Widchard Faustin. 

RULES: 
	To play Chinese Checkers, you need at least 2 to 6 people. Each player chooses a color (different
	from other players, and their pieces are placed on the board. 1 player goes first, and chooses to move
	one of their pieces. 
	
	Valid moves are the following:
		Moving to any adjacent hole as long as there is no piece residing there. 
		Moving to a hole that is 2 spaces away, as long as in between the space that
			the piece is currently at and the space the piece will be moved to has a hole
			in between them, and there is a piece filling that hole. This is called jumping. 
			
	If a player jumps, they are allowed to go again, as long as they have a jump move. In this
	iteration, a player's max consecutive move turn is twice, so they can only jump twice. Once the 
	move has been done, click on the piece that was just moved, and then that will transfer turns to the 
	next player.
	
	WIN CONDITIONS: 
		 The first player to get their 10 pieces into the triangle formulation directly across from them wins!
		 

Things that do not have functionality/Things that should be known before looking into the code: 
	- TEAM Games do not work as of yet. I did not have time to implement them. 
	- The About/Rules option on the Menu Bar does not work on other screens BESIDES the main Menu. I disabled it due to layout issues
	- The Settings Menu has not been implemented, again, due to time constraints. 
	- All of the windows are also not resizable due to layout issues. 
	- Double jumping does work, however, anything higher than double jumping does not. 
	- Some graphical bugs when it comes to double jumping. 
	
	

Overall, what does work:
	- Traversing between menus. 
	- Choosing color (however, you can choose the same color as the opponent)
	- Turn order and movement
	- General game flow
	- Buttons (other than settings)
	
	

Overview:
	This CS338 Project is a Chinese Checkers Board Game that houses 2 - 6 players. It uses
	Java and Swing to make a windows application to play the game. While this game does support
	multiple players, it does not have AI opponents. The play button leads to a screen that asks 
	the user to input the number of players, and whether it is a team or individual game, but 
	currently only Individual works. That then leads to a screen where each player can choose their
	color, and once that has been done, the game is started. 
	

Extra Implementation Details and Final Thoughts:
	This was a really hard and really overscoped project. I'm just happy to have gotten it done. Most
	of the methods are self explanatory, and I tried to make my classes lead into each other to make 
	up for my lack of comments. 


	

	