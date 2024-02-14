# USE CASE: 7 Produce a Report on the populations of any given continent, region or country that are living in cities and those that are not.


## CHARACTERISTIC INFORMATION

### Goal in Context

As an **Employee** I want to produce a report **on the populations of any given continent, region or country that are living in cities and those that are not** so that **I am able to assist in the reporting on population figures**

### Scope

Organisation.

### Level

Primary task.

### Preconditions

We know if the report is searching for which continent, region or country.  Database contains the population counts of all cities in the world and the population count of all countries in the world discernibly.

### Success End Condition

A report is available for the employee to use in their work.

### Failed End Condition

No report is produced.

### Primary Actor

Employee.

### Trigger

A request by a client or senior member of staff to gather the statistics required in this report.

## MAIN SUCCESS SCENARIO

1. Client requests the top 5 most populated capital cities of a given continent.
2. Employee captures name of the desired continent to obtain capital city information.
3. Employee extracts list of capital city information from the given continent.
4. Employee provides report to client.

## EXTENSIONS

3. **Population counts in the report are incorrect as populations from countries outside the scope of the report have found themselves included in the report**:
    1. Employee who reviews the report notifies IT of the issue.

## SUB-VARIATIONS

None.

## SCHEDULE

undetermined
