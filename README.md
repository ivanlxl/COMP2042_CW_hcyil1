Ivan Lee Xin Liang
20411640

Starting Instructions:
1. Load the source code into an IDE of your choice, ensure JavaFX is added to the project. Under "Main" class, run. 
2. In the main menu, select colour theme for the background using the ColourPicker. You can also select grid size to change the dimensions of the Grid.
3. Once the game ends (either by victory or lose), appropriate screen will show. Click Next to enter highscore section
4. Dialog will be prompted, choose corresponding file for the grid size (if grid size 4 was selected, choose the 4x4). 
5. Existing scores will be displayed, enter your username in the textfield and submit to save your score. Dialog will appear again, select the same file. File replace warning may show, click yes. 


Javadocs Location: COMP2042LeeIvanXinLiang\javadoc\com.example.demo\module-summary

Bugs Fixed
- Accurate Highscore
- Only arrow keys spawns new cells
- Only when a cell is combined or move will a new cell be spawned

Working Features
- Start Screen
- Theme Selection
- Grid selection
- Display score at end
- Win / Lose Screen leading to Scoreboard
- Quit button at Highscore scene


Implemented but not working features
- JUnit
Attempt : Most likely due to file dependencies, but when I load Maven in to create JUnit tests, i can run my JUnit tests, but errors occur when trying to run application. If I don't load Maven, I can run my application but not JUnit tests. 
Temp. Solution : Run all JUnit tests with Maven, then copy paste them into the project without Maven. JUnit tests wont be able to run in this file, but it exists. 

Not implemented features with reason of why they were not implemented
- Highscore lists displays automatically. Was able to display highscore list without user intervention, however, saving the new score proved a problem
- Highscore lists only stores the highest scores. Unable to extract only integers from the file. 

New Java Classes Introduced
- StartController
- LoseController
- WinController
- HighScoreController

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
