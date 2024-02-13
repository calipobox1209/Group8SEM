# USE CASE: 4 Generate list, of user determined length, of most populated cities in any district, country, region, continent, or in the whole world.

## CHARACTERISTIC INFORMATION

### Goal in context 

  As an **employee of my organization** I need to be able to **produce a list of my desired length that includes the top populated cities in order in any district, country, region, or continent of my choosing or in the whole world** in order to **aid in brand research**.

### Scope

  Organization

### Level 

  Primary task

### Preconditions

  How many cities to include and the area to specify. Database with populations of every city in the world discernible by area.

### Success end condition

  Employee recieves the specified list of cities

### Failure end condition 

  No list is produced.

### Primary actor

  Employee

### Trigger

  List of specified size including population info on cities is requested for brand research.


## MAIN SUCCESS SCENARIO 

  1. Organization requests brand research that requires checking against total populations of cities in any area.
  2. Employee specifies the area to be queried and number of cities to be queried.
  3. Employee produces specified list of specified size and area.
  4. Employee returns list to organization.

## EXTENSIONS

  4. List of specified area can't be produced.
       i. Employee tells organization specified area isn't found in databse.

## SUB-VARIATIONS

  None

## SCHEDULE 

  Undetermined
