# USE CASE: 6 Produce a Report on the most populated capital cities in the world, continent or region that is of variable length determined by user input

## CHARACTERISTIC INFORMATION

### Goal in Context

As an **Employee** **I want to produce a report **on the top N most populated capital cities for the world or any given region or continent** so that **I can support population reporting for the organisation.**

### Scope

Organisation.

### Level

Primary task.

### Preconditions

We know if the report is searching for the world, continent or region and we know the desired length .  Database contains the population counts of all cities in the world, with capital cities being discernible by specified metrics.

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

3. **Correct capital cities are in the list but are not ordered correctly**:
    1. Employee who reviews the report notifies IT of the issue.

## SUB-VARIATIONS

None.

## SCHEDULE

undetermined
