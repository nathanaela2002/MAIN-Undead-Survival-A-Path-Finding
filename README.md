# Undead Escape
Undead Escape is a 2D top-down shooter where players must survive waves of zombies in a post-apocalyptic world. This project, developed in Java using Swing, features an intelligent zombie AI powered by the A* Pathfinding algorithm, ensuring dynamic and challenging gameplay.

## Features
## 1. A Pathfinding Algorithm for Zombie AI
The zombies in Undead Escape use the A* Pathfinding algorithm, allowing them to intelligently navigate around obstacles and track the player. This algorithm ensures that the enemies find the most efficient path to the player, adding a strategic element as players must constantly move to avoid being cornered.

- Efficient Navigation: Zombies calculate the shortest path to the player, taking into account barriers and obstacles.
- Dynamic AI Behavior: The AI adjusts its path in real-time as the player moves and new obstacles emerge.

## 2. Intuitive Controls and Smooth Gameplay
Movement: Use the arrow keys (or WASD) to move your character around the map.
Shooting: Aim using the mouse, and click to shoot bullets at the approaching zombie hordes.
Weapon Upgrades: As the game progresses, collect different weapons and upgrades to fend off increasingly difficult zombie waves.

## 3. Progressive Difficulty
As waves of zombies increase, the game's difficulty ramps up, introducing faster and stronger enemies.
Players must use their surroundings and upgrade their weapons to survive longer.

## 4. Multiple Map Layouts
The game includes multiple map layouts, each with its unique set of obstacles and design. This creates a variety of challenges, requiring the player to adapt their strategies to different environments.

## 5. Scoring System
Each zombie kill earns points. Surviving multiple waves grants higher scores, and players can aim to beat their personal best.

## 6. Immersive Visuals
Despite being a 2D game, Undead Escape features engaging visuals with detailed sprites, fluid animations, and immersive environments that enhance the overall gameplay experience.
Gameplay Instructions

Objective: Survive as long as possible while fending off waves of zombies.

Movement: Use the arrow keys or WASD to move your character.

Aiming and Shooting: Move the mouse to aim at the zombies and click tofire.

Avoid Obstacles: Strategically move around obstacles to avoid being trapped by the zombie hordes.

Weapon Upgrades: Collect weapons and upgrades scattered around the map to boost your survival chances.

Zombie AI: Zombies will dynamically adjust their path using the A* algorithm to find the most optimal way to reach you.

## A* Pathfinding Algorithm
The A Pathfinding algorithm* is a widely used search algorithm that determines the shortest path between two points. In Undead Escape, the zombies use this algorithm to navigate toward the player, making the game more challenging. Here’s how it works:

Cost Calculation: The algorithm calculates the total cost (F) for each possible path, combining:

G Cost: The cost of moving from the starting point to the current node.

H Cost: The estimated cost from the current node to the target (player).

Obstacle Avoidance: The algorithm intelligently routes around obstacles, ensuring that zombies do not get stuck.

Dynamic Updates: As the player moves, the zombies continuously update their path, allowing them to adjust in real time.

This sophisticated AI system results in challenging enemies that can predict the player's movements and adjust their approach accordingly, enhancing the depth of the gameplay.

## Project Design and Technologies
Language: Java

Graphics: Java Swing for 2D rendering

AI: A* Pathfinding Algorithm

Game Mechanics: Object-oriented programming principles were used to structure the player, enemies, obstacles, and game logic, ensuring modular and scalable code.

Version Control: Managed using Git for tracking development and changes.

## Installation
Clone the repository:
1. git clone https://github.com/yourusername/UndeadEscape.git
2. cd UndeadEscape
3. javac Main.java
java Main

## Video Demo
https://www.youtube.com/watch?v=XEsub33nYww&t=2s&ab_channel=NathanL
