Ivan Lee Xin Liang
20411640

Starting Instructions:
Load the source code into an IDE of your choice, ensure JavaFX is added to the project. Under "Main" class, run. 

Javadocs Location:


Working Features
- Accurate Highscore
- Start Screen
- Theme Selection
- Only arrow keys will spawn new cells
- Grid selection
- Display score at end


Implemented but not working features
- Only spawn new cells when the existing cells have moved (Previously, cells will spawn when button press regardless of movement)


Not implemented features with reason of why they were not implemented
- 2 different pairs of the same cell in a horizontal row will result in only one pair being combined.


New Java Classes Introduced
- StartController
- EndController


List of Java classes that have been modified
- Controller class broken down into multiple Controller class


List of Java classes that have been modified
GameScene Class
- n changed to GRID
- haveSameNumberNearly changed to haveSameNumber

TextMaker Class
- decreased cell font size

Endgame Class
- Class deleted
