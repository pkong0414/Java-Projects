This is the readme file for: pkhc5P1

The goal of project 1 is to make a rock, paper, scissors game based on hunter, bear, and ninja.
We'll assign each choices a value: 
	
	Hunter: 1
	Beear: 2
	Ninja: 3

So the idea is that: 
	
	Hunter shoots Bear: 1 < 2.
	Bear eats Ninja: 2 < 3.
	Ninja kills Hunter: 3 < 1.
	
We want to ask input from the user and the comp will make a pick.

So based on a little research: 

I've decided not to go the way of statistics, but rather information from: 
	https://motherboard.vice.com/en_us/article/gvym4x/game-theory-rock-paper-scissors
	https://youtu.be/rudzYPHuewc

The research from that is when playing with human players these are things that tend to happen:

1. people who win tend to repeat strategy.
2. losers tend to change.

This is the basis on how the computer will try to outsmart the player.
Rather than try to use statistics, it will instead employ these tips:
	I.   if the comp loses. It will play the thing that didn't come up.
	II.  if the comp wins. It will play what the opponent just played.
	III. if there is a draw. It will play randomly.
	
Also the comp will lie or tell the truth to trip the player up.

**I've commented out the lie and truth percentiles since it was used to debug.