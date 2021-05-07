AP Computer Science Final Project - README Template

Responsible Student Simulator
Authors: Jeremie Park, Megan Choy
Revision: 4/23/21


Introduction: 
[In a few paragraphs totaling about ½ page, introduce the high-level concept of your program. What this looks like depends a lot on what type of thing you are making. An introduction for an application will look different than one for a game. In general, your introduction should address questions like these:
What does your program do?
What problem does it solve? Why did you write it?
What is the story?
What are the rules? What is the goal?
Who would want to use your program?
What are the primary features of your program?]


Introduction: 
Responsible Student Simulator (RSS) is an idle simulator game for people who enjoy seeing numbers grow. Users control a student in high school and try to survive through various events, including passing hard courses, attending school events, and managing stress and sleep. The currency used in this game are brain cells that are gained by the second and the rate can be increased by upgrading the student’s supplies and attending harder courses. However, there are ways that brain cell production can decrease, such as negative emotions and not getting enough sleep. The ultimate goal is to finish 4 years of highschool!

        Supplies such as, technological devices, writing utensils, paper, textbooks, and desk upgrades will add to braincell rate or increase happiness. These upgrades will help the player progress as it increases passive brain cell production rate,  effectiveness of courses, emotional state gain and loss, and cost of purchases.
Courses can be bought with brain cells and every time the student attends a course, braincells will be earned, but stress will increase and sleep will decrease. Courses can be upgraded to improve the amount of brain cells gained and time required for completion. More advanced courses will produce more brain cells, but will be slower and affect sleep and stress more. The difficulty of the courses are shown by the number of stars on the course description, 1 being easy and 5 being very difficult.
The menu shows the student in the top left corner with the stress and sleep bars below it. The passive brain cell production rate and total brain cells is shown at the top right. Below the student’s picture is a menu where the player can switch between upgrades, courses, and prestige pages. On each of the pages, there is a picture and description of all the upgrades and courses.




Instructions:
[Explain how to use the program. This needs to be specific: 
Which keyboard keys will do what? 
Where will you need to click? 
Will you have menus that need to be navigated? What will they look like? 
Do actions need to be taken in a certain order?]


        When the game is first opened, users will be prompted to input a student name. That name will be used for the current save file and carried on throughout the game. After, the user will see the main panel with the brain cell count, the student’s stats, and various upgrades. The user can click on the upgrade buttons to increase the production of brain cells and also click between “upgrades”, “courses”, and “prestige”.
        The student’s sleep and stress levels will change while the game is running. To increase sleep, the user will click on the bed and have to wait 20 seconds while the student is sleeping. During that time, no upgrades can be bought and no courses can be taken. There will be extra activities that will cost brain cells but will decrease stress.

        


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
[These are features that you would like to have by the project due date, but you’re unsure whether you’ll hit all of them. A good final project would have perhaps half of these completed. At least 5 are required. Again, fully describe each.]
*   Happiness bar - goes down when student is studying/attending courses, but goes up from other activities other than just school
*  Prestige currency: can pick which buffs to buy after prestige. Amount could possibly depend on the ending amount of brain cells
*  Pop up events: Various events that the user can choose an option to react to the event. Depending what they pick, it could negatively or positively affect the student. (Like bitcoin billionaire or sims) Could also possibly be actual questions, like a trivia question on science or a math problem
*  Student facial expressions - depending on happiness/stress/sleep, the student would visibly show different emotions
*  Desk upgrades on GUI - as the user buys upgrades, the desk would show those different upgrades (i.e. a lamp is bought so now there is a lamp on the desk)


Stretch Features:
[These are features that we agree a fully complete version of this program would have, but that you probably will not have time to implement. A good final project does not necessarily need to have any of these completed at all. At least 3 are required. Again, fully describe each.]
* Automation: Upgrades and perks that allow the player to automate certain tasks like coursesor buying upgrades.
*  Customizing your own student: when you first start the game, you can pick features for the student, various hats/collectibles can be unlocked
*  Schedule: Time will pass as you play the game; certain features will be restricted, while others may be unlocked. For example, courses will not be usable during weekends, but 




Class List:
[This section lists the Java classes that make up the program and very briefly describes what each represents. It’s totally fine to put this section in list format and not to use full sentences.][m]


* BrainCell: handles the math of total brain cells including the rate of the brain cell 
* Course(name, time, payout, intensity): super class of all the courses that the student can take
* Upgrade(name, rate, level): abstract class representing an upgrade; this includes both upgrades bought with brain cells and prestige currency
* UpgradeButton(Upgrade): The button on the menu and when clicked, will change the Upgrade class
* CourseButton: The button on the menu to start a course; when clicked, the course will start its timer, adding its respective amount of brain cells to the total balance
* PrestigeButton: The button on the menu to reset current progress and add a multiplier[n]
* Menu: The actual window with all the components of the GUI
* Sleep: class that holds the percentage of sleep, can be decreased or increased
* Stress: class that holds the stress value, can be decreased or increased


Credits:
[Gives credit for project components. This includes both internal credit (your group members) and external credit (other people, websites, libraries). To do this:
* List the group members and describe how each member contributed to the completion of the final program. This could be classes written, art assets created, leadership/organizational skills exercises, or other tasks. Initially, this is how you plan on splitting the work.
* Give credit to all outside resources used. This includes downloaded images or sounds, external java libraries, parent/tutor/student coding help, etc.]

Jeremie: BrainCell, Upgrade 
Megan: Menu, Course, CourseButton
TBD: Prestige, Sleep, Stress