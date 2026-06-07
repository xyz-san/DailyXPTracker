# DailyXPTracker
# Daily XP Tracker

This is a beginner Java project I built while learning Java through the University of Helsinki MOOC Java Programming course.

The goal of this project is to practice the Java concepts I have learned so far while also building something useful for my own productivity. This program lets me add daily tasks, mark them as complete, and earn XP based on the type of task I complete.

## Why I Built This

I wanted to start using GitHub early while learning Java so I can build familiarity with version control and gradually improve my project-building skills.

Since I am still early in my Java learning journey, I wanted to create a project that uses the concepts I currently understand, such as:

* Variables
* Conditionals
* Loops
* Methods
* Scanner input
* ArrayLists
* Basic program structure

## Features

* Add a task
* Choose a skill category for the task
* Assign an XP value
* View all tasks
* Mark tasks as complete
* Track XP by category
* View total XP
* Display a rank based on total XP

## Example Menu

```text
=== Daily XP Tracker ===
1. Add task
2. View tasks
3. Complete task
4. View XP summary
5. Exit
Choose:
```

## Example Task

```text
Task name: Finish Java MOOC exercises
Skill category: Java
XP value: 25
```

## XP Categories

The current version tracks XP in these categories:

* Java
* Finance
* Fitness
* Other

## Rank System

The program gives a rank based on total XP:

```text
0-49 XP: Beginner
50-149 XP: Locked In
150-299 XP: Serious
300+ XP: Machine
```

## Current Limitations

This is the first version of the project, so the data does not save after the program ends. Tasks and XP reset every time the program is closed.

In the future, I want to add file saving so the program can remember tasks and XP between sessions.

## Future Improvements

Some features I want to add later:

* Save tasks to a file
* Load previous tasks when the program starts
* Delete tasks
* Edit tasks
* Add due dates
* Track streaks
* Improve the XP system
* Build a cleaner version using classes and objects

## What I Practiced

While building this project, I practiced using Java to create an interactive terminal program. I also practiced breaking a program into smaller methods instead of putting everything inside `main`.

This project is part of my effort to build one small project every day while improving my programming skills.
