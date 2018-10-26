# Ye Olde Nonogram Nannick - Ryan's To-Do
Branch: Ryan-InProgress

To-Do for this version of the code:
- "Solve" screen
  - Have nonogram.java store details about the nonogram being used such as:
    - length (DONE)
    - width (DONE)
    - max number of parameters for each row/column (DONE)
    - parameters (DONE)
    - numbers per each row/column (DONE)
  - Draw the grid
    - Draw grid itself based off length and width (DONE)
    - Draw text fields based off of max number of parameters (DONE)
    - Draw a solve button to send parameters to the solving algorithm (DONE)
  - Solve button
    - Pass all parameters as .txt file to solving algorithm (DONE)
    - receive .txt file from algorithm with solution 
      - receives 0's for blanks and 2's for fills
    - read through .txt file, drawing the nonogram square for square
      - nested for loop?
      
- "Settings" screen
  - Allow user to set default length x width (DONE)
  - Allow user to set default max number of parameters per row/column (DONE)
  - Save user settings (DONE)

Extras:
- Colors (DONE)
- Music (for maximum immersiveness?)
- Create menu (probably won't be implemented)
