# spider solitaire

***hello there!*** 

want to play a text-based version of spider solitaire? welcome!

---

# the rules of the game

this game automatically uses 5 decks of cards and 7 stacks. your goal is to move cards around to create a perfect run, which starts with a K and goes all the way down to an A. once this is done, the deck gets moved to "completed stacks", and you don't need to worry about it. 

*in order to win the game, you must create 5 perfect runs, since there are 5 decks of cards.* 

---

# how to play

there are 5 possible commands that you can use:

***move***: this command lets you move a card or a group of cards from one stack to another. note: a group of cards can *only* be moved if they are a perfect run.
in order to use this command, you must type `move [card] [source stack] [destination stack]`. for example, if you're trying to move the K from stack 2 to stack 4, you would need to type `move K 2 4`. if your move goes against the rules of the game, an error message will be printed with a brief explanation of what went wrong.

***draw***: it's possible that at some point in the game, there may not be any moves left. if this is the case, you will want to draw from the draw pile. this command will distribute one card to each of the stacks. 

***clear***: once you have created a perfect run (from K to A), you will need to clear it from the board. in order to do so, you will need to type `clear [stack]`. for example, if there is a perfect run in stack 3, you would need to enter `clear 3`.

***restart***: if you'd like to start the game all over again, you can enter restart. this will create a whole new game.

**quit**: if you're done playing and would like to end the game, you can enter `quit` in order to stop the code from running. 

---

# about the creator

hi there! i'm aashna, a current student at UC Berkeley studying computer science. i created this game in my junior year of high school in an effort to explore game development and continue to develop my java skills. i hope you enjoy playing :)
