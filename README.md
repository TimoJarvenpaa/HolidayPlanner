# HolidayPlanner

I decided to approach this task with a simple layered architecture model in mind.

- The [ui package](holidayplanner/src/main/java/ui) contains classes that are responsible for presenting the text based user interface and handling the user input
- The [domain package](holidayplanner/src/main/java/domain) contains the actual business logic of the application i.e. the [HolidayPlanner](holidayplanner/src/main/java/domain/HolidayPlanner.java) class
- The [dao package](holidayplanner/src/main/java/dao) contains tools for accessing and reading the required information i.e. the list of national holidays into the application

As it stands, the application is just a crude walking skeleton and the CLI is not very user friendly but the main goal was to implement the actual HolidayPlanner class.
Throughout the app I used the LocalDate object and it's various methods from the java.time libary to transform, handle and compare the user input. The class itself contains multiple methods that are used to validate all the requirements of the user input and of course calculate the amount of days within the given time span that do consume holiday days.

My main challenges had to do with simple but elusive bugs in the file reading process of the national holidays which in itself wasn't even a requirement but I didn't want the national holidays hard coded into the source code. I wrote a few [unit tests](holidayplanner/src/test/java/domain/HolidayPlannerTest.java) for the HolidayPlanner class as examples but they are by no means sufficient enough so that would be the area I'd focus on improving next. I also didn't have time to test whether the maven project builds/compiles without any issues but at least I was able to run the project and the unit tests on my machine.