Project Status:
  Hunter's and Ryan's menus were merged successfully into one complete menu. DrawSolution (Ryan) to Algo (Laura and Robyn) integration is still not running as intended.

Next Steps (if there were to be a Sprint 4, this is what we would've done):
- Ryan: Make the menu look nicer and get DrawSolution working with Algo.
- Robyn: The algorithm ended Sprint 3 in an infinite loop, so the next step would be breaking down the density of the algorithm and finding the loop that is causing the problem. Continue to debug after that until it solved nonograms as desired. 
- Laura:  Continue to try to get the algorithym to produce the correct solution
- Hunter: Same with what Ryan said, perhaps target the color scheme and suitable music tracks in terms of functionality. 

Team Contributions/Artifacts:
- Ryan:
  - DrawNonogram.java - Takes information about the nonogram and draws the grid and text fields for editing. This process is started upon clicking Solve in the program. Found in master branch; JavaApplication7/src/menu/DrawNonogram.java
  - DrawSolution.java - Passes entered markers of nonogram to Algo.java, then takes the solution and draws it. This process is started upon clicking the finalization button in the Solve menu. Found in master branch; JavaApplication7/src/menu/DrawSolution.java
  - Nonogram.java - Intended to save data of the grid for solve menu and allow for personalization and editing. Exception failures prevented this during merging of menu, and is currently omitted from the program.  Found in master branch; JavaApplication7/src/menu/Nonogram.java
- Robyn: assisted is merg and algo.java bug fix attempts
- Laura: continued attempts to bug fix Algo.java, as well as preparing algo.java to merge with menues
- Hunter:
  - Menu.java- Serves as the foundation of the project. Allows user to change the options of the program (colors/music/avatars), create the nonograms via input, draws the inputed parameters. 
 - Various .jpg files, initially served as placeholders for the pictures but were scrapped due to the new implementation of the interactive parameters.
 - .mp4/music files- Serve as the background music for the program. We kept it in there, however the audio wouldn't work with the HDMI cable so you couldn't hear it :]
