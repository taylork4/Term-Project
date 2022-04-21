# Term-Project

                                         Noah Arden
                                        Owen Carroll
                                         Kyle Taylor

                                    CIS 350-02 Winter 2022

Project Description:
The goal of our project is to create a Grand Valley State Lakers inspired edition of the
popular card game Rummy. The game has been crafted meticulously and each card suit is a uniquely designed twist to the traditional card style. Rummy, as it plays outside of the digital realm, is a game in which four players compete to discard all of their cards first by adding cards to a meld. A Meld is essentially a fancy word for a set of three cards that are the same number or a run of three sequential cards of the same suit. Laker’s Rummy, while mostly the same, includes a modification to the traditional Rummy by altering the way the game is scored. Traditionally, the number of cards left over in someone’s hand after another player discards all of their cards receives a score based on what cards they have left over. The player who discards all of their cards is left with zero points at the end of a round. In Laker’s Rummy, however, the number of melds each individual player makes will modify the player’s end score. So, if a player places six melds, their score will be deducted by a margin of 6\*3 (3 points for every meld).
Some features that have been implemented in release 2 include the game initializer,
actions for players including drawing cards, playing melds, and adding cards to a meld. Additionally a GUI has been created including graphics for the game and menu options.

--------------------------------------------------------------------------------------------------- -- Features --
GUI capabilities:
~ Main Menu: - Main menu to the game screen by clicking the ‘Play’ button. - Main menu to the settings screen by clicking the ‘Settings’ menu item. - Main menu to the how to play screen by clicking the ‘How to Play - Rummy’ menu item. - Clicking on the ‘Lakers Rummy’ button selects the Lakers Rummy game mode and fades out  
 the option to play the ‘Rummy’ button option. - Clicking on the ‘Rummy’ button selects the Rummy game mode and fades out the option to
play the ‘Lakers Rummy’ button option - ‘Exit’ menu item button closes out of the main menu screen
~ How to Play: - How to play screen to the main menu by clicking the ‘Return to Menu’ menu item. - ‘Exit’ menu item button closes out of the how to play screen
~ Settings: - Settings screen to the main menu by clicking the ‘Return to Menu’ menu item. - Clicking on the ‘Blue-Green’ button changes the color of the background in the game  
 screen and the settings screen to a blue-green color as well as fades out the other color options. - Clicking on the ‘Dark Green’ button changes the color of the background in the game
screen and the settings screen to a dark green color as well as fades out the other color options. - Clicking on the ‘Tan’ button changes the color of the background in the game screen and
the settings screen to a tan color as well as fades out the other color options. - ‘Exit’ menu item button closes out of the settings screen
~ Game: - Clicking on the deck card on the game screen draws a card for the current player and
displays that card as well as the ability to discard cards, make melds, or add to melds. - Clicking on a discarded card on the game screen grabs that card for the current player
and displays that card as well as the ability to discard cards, make melds, or add to melds. - Upon first clicking on the deck card or discard pile, by clicking on the newly appearing
‘Discard’ buttons on screen discards the selected card and adds it to the discard pile. - Upon first clicking on the deck card or discard pile, clicking on the newly appearing
‘Make Meld’ button on screen makes ‘Select’ buttons appear. - Upon first clicking on the deck/discard pile, clicking on the newly appearing ‘Add to
Meld’ button makes ‘Select’ buttons, ‘Confirm’ button, and ‘Cancel’ button appear. - Upon first clicking on the ‘Make Meld’ button, every click of the appearing ‘Select’
buttons adds the cards to a meld. Upon clicking confirm, the meld is created if it is correct. - Upon first clicking on the ‘Make Meld’ button, every click of the appearing ‘Select’
buttons adds the cards to a meld. Upon clicking cancel, the meld is canceled and the player is given the option to discard. - Upon first clicking on the Add to Meld’ button, every click of the appearing ‘Select’
buttons adds the cards to an existing meld. Upon clicking confirm, the meld is added to if it is allowed. - Upon first clicking on the ‘Add to Meld’ button, every click of the appearing ‘Select’
buttons adds the cards to an existing meld. Upon clicking cancel, the addition is canceled and the player is given the option to discard. - ‘Exit’ menu item button closes out of the game screen
