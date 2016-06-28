Use of animations:

animations (simplistic ones, like moving an object in a fixed path) just relies on a timer

the timer will continue and will cause the repaint method to be called once the delay on the timer has ended
--> the delay is in milliseconds

--> to reformat the timer, we need to create a Timer and have its constructor be an ActionListener (or a class that implements the ActionListener)
