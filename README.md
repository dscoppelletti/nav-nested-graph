Back button doesn't work properly between top-level destinations in a nested graph
==================================================================================

> This repository is archived: refer to Issue Tracker.

This project comes with two flavors `flat` and `nested`

## flat

I have only one navigation graph with three destination fragments and all of the
destinations are considered top-level destinations.  
I use the bottom navigation bar for switching between the fragments and
whatever the navigation state, the Back button returns always to the start
destination of the navigation graph and next exits the App.  
That sounds good!

## nested

I have a top navigation graph with one destination fragment (the _top
fragment_) and a nested navigation graph with three destination fragments.  
All of the four fragments are considered top-level destinations.  
The top fragment has a button that runs an action to navigate to the nested
navigation graph.  
The bottom navigation bar is visible only when I switch to the nested navigation
graph. I use the bottom navigation bar for switching between the fragments in
the nested navigation graph.  
Whatever the navigation state, the Back button returns always to the previous
fragment in the back stack, not right to the start destination of the nested
navigation graph.  
That is different from the `flat` flavor behaviour.
