### Group 16 Project 2 Check-in 2A

*Brief description of your planned program analysis (and visualization, if applicable) ideas.*

Static analysis of code to measure level of coupling between classes in Java. Would assign a coupling score between each class and display results as a matrix showing relation of all classes to all other classes. Users would be developers learning about coupling in object oriented programs and developers being introduced to new code bases to get an overview of how classes interact. The visualization of our results would come in the form of a graph, table or something similar.

*Notes of any important changes/feedback from TA discussion.*

Our TA provided useful feedback which included reducing the scope of our original implementation and having us decide on which of the 3 requirements to implement. We were also encouraged to think of a more specific use case and user for our program analysis. 

*Any planned follow-up tasks or features still to design*

We plan to do more program analysis review so that we can clearly define the roadmap next week and do a proper breakdown of responsibilities.

*Planned division of main responsibilities between team members*

Here is our rough breakdown of tasks. We will have more clarity on exacts tasks as the weeks progress.

1. Visualization Component (if required) (Sophia, Will)
- Endpoint/Data handoff
- Data model
- View model

2. Java Program Analysis (Jeffrey, Taylor, Dave)
- Static Analysis
- Dynamic Analysis

*Summary of progress so far.*

Decided that Java will be the language we will analyze. We made a rough outline of tasks for the upcoming weeks. We have also split up modules of the program.

*Roadmap / Timeline*

Mar 15th
- Review the libraries for Java AST
- Brainstorm potential data points to collect
- Complete draft of user study

Mar 22nd
- Finalize data points to collect

Mar 29th
- Final user study plan
- Bug fixes
- User study improvements to codebase

April 5th
- Have the initial version of end-to-end product done
- Film/Edit video

Project 2 Deadline (April 8th 2024)
- Completed Video

### Group 16 Project 2 Check-in 1

*Brief description of your discussions within your team so far, and any current candidate ideas for your project. You should talk with your TA/Alex/Caroline as soon as possible about these ideas; due to the project starting mid-week it's OK if you have not yet done this, but make sure to note the progress you have made so far. Any planned follow-up tasks for the next week.*

So far we have discussed two potential ideas for our project 2. Both of these projects will be satisfying requirements 2 and 3 of the project.

**Monitor Stack Allocation**
- Map functions to their stack allocations
- Display a chart or bar graph or something that shows the size/location of their stack allocations (not static but would work on C or C++ so would meet req. 2 and 3)
- Find libraries that look at the call stack (or similar)
- Research other dynamic analysis tools in C++

**Visualizing Execution workflow for Java.**
- We were thinking of generating an output similar to the sequence diagrams from CPSC210.
- ![](sequence_diagram.png)
- Time spent on each function, number of calls
- Some potential relevant libraries: javaparser, graphviz, BTrace

*Any planned follow-up tasks for the next week.*

Based on discussions with our TA Madonna, we will be researching libraries and frameworks mentioned in the shared class [google doc](https://docs.google.com/document/d/1NADVQ4aqwoTfCv7ajVWa0dFxXJAGMKoVMVtgxaF0gWw/edit) to do our own program analysis. We will also plan to meet and discuss the distribution of tasks for the next project.
