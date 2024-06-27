### How to Generate Logs

- When pulling the latest branch, the run configurations of the project should already be set up.

1) Add the program to analyze to Group16Project2/parser/resources/src. This should contain the Main.java file of the program.

2) Run ` Group16Project2/parser/src/AddTelemetry.java` to inject telemetry code for dynamic analysis.

3) Set the program arguments in the run configuration. For example, in Intellij, clicking the option "Modify run configuration..." in the run button dropdown should open the following modal where the arguments to Main can be set:

<img width="780" alt="Screenshot 2024-04-10 at 3 14 53 PM" src="https://media.github.students.cs.ubc.ca/user/15490/files/afdc886a-ab21-40f6-ad06-f1880f15b772">

4) Run `Group16Project2/parsedcode/src/Main.java` which will run the parsed code and generate logs inside of 
`Group16Project2/parsedcode/log`.

5) Repeat steps 3 and 4 to generate logs for different program arguments. 

6) Once all desired logs are generated, cd into the `ui` directory .

7) Run `npm install` to install packages and dependendies.

8) Run `npm run dev` to start the client in a local port.

9) Open the corresponding port and add the logs from `Group16Project2/parsedcode/log` as per the instructions on the ui.

10) Click analyze to compare and contrast the runs for different program arguments.

11) Click each function call to see the functions that were called within that function, as well as the function parameters that the function was called with.
