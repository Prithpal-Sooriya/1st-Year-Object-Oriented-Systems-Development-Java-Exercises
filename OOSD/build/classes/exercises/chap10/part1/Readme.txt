The time class

Design a class called time
--> Datafield: hour, minute, second that represent time

--> no arg constructor that creates a Time object for the current time
(values of data fields will represent current time)
--> constructor that constructs Time object with a specified elapsed time since Jan 1 1970 in milliseconds
--> constructor that constructs Time object for the data fields hour, minute, second, respectively

--> three get methods for hour, minute and second
--> method names setTime(long elapsedTime) that sets a new time for the object

Create a UML, class

Write a test class with 2 Time objects (new Time(); new Time(555550000)l)

**hint**
1st 2nd constructors extract hour, minute, second from the elapsed time
no arg constructor gets current time

use System.currentTimeMillis