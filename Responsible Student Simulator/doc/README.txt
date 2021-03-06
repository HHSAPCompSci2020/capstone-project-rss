AP Computer Science Final Project - README Template

Responsible Student Simulator
Authors: Jeremie Park, Megan Choy
Revision: 5/14/21

Introduction: 
	Responsible Student Simulator (RSS) is an idle simulator game for people who enjoy seeing numbers grow. Users control a student in high school and try to survive through various events, including passing hard courses, attending school events, and managing stress, sleep, and happiness. The currency used in this game are brain cells that are gained by the second and the rate can be increased by upgrading the student’s supplies and attending harder courses. However, there are ways that brain cell production can decrease, such as negative emotions and not getting enough sleep. The ultimate goal is to finish 4 years of high school!
	Upgrades such as phone and computer upgrades will add to braincell rate. These upgrades will help the player progress as it increases passive brain cell production rate, effectiveness of courses, emotional state gain and loss, and cost of purchases.
	Courses can be bought with brain cells and every time the student attends a course, brain cells will be earned, but stress will increase and sleep will decrease. More advanced courses will produce more brain cells, but will be slower and affect sleep and stress more. 
	The menu shows the student in the top left corner with the stress and sleep bars below it. The passive brain cell production rate and total brain cells is shown at the top right. Below the student’s picture is a menu where the player can switch between upgrades, courses, and prestige pages. On each of the pages, there is a picture and description of all the upgrades and courses.
	




Instructions:
	When the game is first opened, the user will see the main panel with the brain cell count, the student’s stats, and various courses. The first step is for the user to unlock and start the first course. It gives active income and the users can use the brain cells earned to buy upgrades. The upgrade buttons increase the production of brain cells and there are tabs to navigate between “upgrades”, “courses”, and “other”.
	The student’s sleep, stress, and happiness levels will change while the game is running. If levels are too low, then it will affect brain cell production negatively. To increase sleep, the user can go to the “other” panel and go to sleep. There are also extra activities that will cost brain cells but will decrease stress and increase happiness. 
	When the user earns enough brain cells, prestige can be bought and it will reset all current progress, but make a permanent production multiplier!


        


Features List (THE ONLY SECTION THAT CANNOT CHANGE LATER):
Must-have Features:
[These are features that we agree you will definitely have by the project due date. A good final project would have all of these completed. At least 5 are required. Each feature should be fully described (at least a few full sentences for each)]
*  Upgrades: By purchasing upgrades with currency (brain cells), the player can improve various things such as passive brain cell production rate,  effectiveness of courses, emotional state gain and loss, and cost of purchases.
*  Stress and sleep bar. Stress - goes down at a fixed rate, but when the student attends courses, it increases. High levels of stress will result in decreased brain cell production. Sleep - goes down at a fixed rate and attending social activities will make it decrease more, but one click will fill it right up! Being sleep deprived will decrease brain cell production.
*  Courses: The student can attend a course to get an instant gain of brain cells (active income), but will increase stress and decrease sleep. Courses can be unlocked by spending brain cells. Each course is rated on a difficulty level of 1-5 stars, with increasing stress/production gains.
*  Prestige: After completing a certain number of courses, the user has the option to reset all their current progress in exchange for permanent benefits that remain after prestige again. As your prestige gets higher, emotional effects such as sleep and stress will intensify.
*  GUI: Menu with brain cell production rate, total number of brain cells, the student and the stress/sleep bars, the upgrade/course/prestige menu at the bottom[l]
* Link to doc with list of upgrades and courses


Want-to-have Features:
*   Happiness bar - goes down when student is studying/attending courses, but goes up from other activities other than just school
*  Prestige currency: can pick which buffs to buy after prestige. Amount could possibly depend on the ending amount of brain cells
*  Pop up events: Various events that the user can choose an option to react to the event. Depending what they pick, it could negatively or positively affect the student. (Like bitcoin billionaire or sims) Could also possibly be actual questions, like a trivia question on science or a math problem
*  Student facial expressions - depending on happiness/stress/sleep, the student would visibly show different emotions
*  Desk upgrades on GUI - as the user buys upgrades, the desk would show those different upgrades (i.e. a lamp is bought so now there is a lamp on the desk)


Stretch Features:
* Automation: Upgrades and perks that allow the player to automate certain tasks like coursesor buying upgrades.
*  Customizing your own student: when you first start the game, you can pick features for the student, various hats/collectibles can be unlocked
*  Schedule: Time will pass as you play the game; certain features will be restricted, while others may be unlocked. For example, courses will not be usable during weekends, but 




Class List:
* BrainCell: handles the math of total brain cells including the rate of the brain cell 
* Course: super class of all the courses that the student can take
* CoursePanel: contains all buttons and classes related to courses, used to start production for courses and displaying buttons
* Happiness: Class that holds the happiness value, can be decreased or increased
* Main: Main: Contains main method
* Menu: The window that gets refreshed to show the totals from BrainCell
* OtherPanel: panel that contains the prestige buttons
* Prestige: The class that represents the number of times the user has prestiged
* Sleep: class that holds the percentage of sleep, can be decreased or increased
* Stress: class that holds the stress value, can be decreased or increased
* Upgrade: abstract class representing an upgrade; this includes both upgrades bought with brain cells and prestige currency
* UpgradePanel: contains all buttons and classes related to the upgrades; used to buy upgrades, process upgrade production rate, and displaying buttons to the panel.
* Window: The main window that contains all GUI and math components



Credits:
* Jeremie Park: Class worked on: BrainCell, Upgrade, UpgradePanel, Other panel, Prestige, Happiness, Sleep, and Stress. Also created the math to calculate braincell fields across classes, the layout for the panels, and brought up the general idea of the code.
* Megan Choy: Class worked on: Course, CoursePanel, Main, Menu, Window. Also created most of the GUI, thought of most of the upgrade ideas, made the upgrades and courses more efficient, provided the majority of the pictures, and did most of the updating for the ReadME and UML diagram. 
* Thonk images: angrythonk - Alex Um, bonk thonk - Megan Choy, and thonk - memes
* Upgrade images: drawn by Megan Choy and Jeremie Park