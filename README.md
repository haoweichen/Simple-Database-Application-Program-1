# Simple-Database-Application-Program-1

Generate 2 separate reports based on the following queries (one report for query #1 and
another for query #2):
1. For each product, compute the maximum and minimum sales quantities along with the corresponding customers, dates (i.e., customers who made those maximum and minimum purchases, and the dates when those maximum and minimum sales quantities were made) and the states in which the sale transactions took place. If there are >1 occurrences of the max or min, choose one – do not display all.
For each product, also compute the average sales quantity.
2. For each combination of customer and product, output the maximum sales quantities for CT and minimum sales quantities for NY and NJ in 3 separate columns. Like the first report, display the corresponding dates (i.e., dates of those maximum and minimum sales quantities). Furthermore, for CT, include only the sales that occurred between 2000 and 2005; for NY and NJ, include all sales.
For this assignment, you can use a simple data structure (e.g., an array) to maintain the list of “information” being computed/captured (we will discuss the type of information you will need to compute/capture and maintain internally for the report over the next couple of lectures).
The following is a sample output – quantities displayed are for illustration only (not the actual values).

![reflection](https://6-t.imgbox.com/LPezHevo.jpg)

Make sure that:
1. “select * from sales” is the ONLY SQL statement allowed in your program.
2. Character string data (e.g., customer name and product name) are left justified.
3. Numeric data (e.g., Maximum/minimum Sales Quantities) are right justified.
4. The Date fields are in the format of MM/DD/YYYY (i.e., 01/02/2002 instead of 1/2/2002).
5. The reports must be generated with a single scan of the ‘sales’ table.
