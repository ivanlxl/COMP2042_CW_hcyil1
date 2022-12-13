Ivan Lee Xin Liang
20411640

Starting Instructions:
Load the source code into an IDE of your choice, ensure JavaFX is added to the project. Under "Main" class, run. 

Javadocs Location:

Bugs Fixed
- Accurate Highscore
- Only arrow keys spawns new cells

Working Features
- Start Screen
- Theme Selection
- Grid selection
- Display score at end
- Win Screen leading to Scoreboard
- Lose Screen leading to Scoreboard


Implemented but not working features
- Only spawn new cells when the existing cells have moved
  Attempt : create a temporary cell that stores the values of the previous layout of the board before the user preses an arrow key. If the current board matches the previous version of the board, no cells were moved.

Not implemented features with reason of why they were not implemented
- Highscore lists displays automatically. Was able to display highscore list without user intervention, however, saving the new score proved a problem

New Java Classes Introduced
- StartController
- LoseController
- WinController

List of Java classes that have been modified
GameScene Class
- n changed to GRID
- haveSameNumberNearly changed to haveSameNumber

TextMaker Class
- decreased cell font size

Endgame Class
- Class deleted

Account Class
- Class deleted
