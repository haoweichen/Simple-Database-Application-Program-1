# Simple-Database-Application-Program-1

Generate 2 separate reports based on the following queries (one report for query #1 and
another for query #2):
1. For each product, compute the maximum and minimum sales quantities along with the corresponding customers, dates (i.e., customers who made those maximum and minimum purchases, and the dates when those maximum and minimum sales quantities were made) and the states in which the sale transactions took place. If there are >1 occurrences of the max or min, choose one – do not display all.
For each product, also compute the average sales quantity.
2. For each combination of customer and product, output the maximum sales quantities for CT and minimum sales quantities for NY and NJ in 3 separate columns. Like the first report, display the corresponding dates (i.e., dates of those maximum and minimum sales quantities). Furthermore, for CT, include only the sales that occurred between 2000 and 2005; for NY and NJ, include all sales.
For this assignment, you can use a simple data structure (e.g., an array) to maintain the list of “information” being computed/captured (we will discuss the type of information you will need to compute/capture and maintain internally for the report over the next couple of lectures).
The following is a sample output – quantities displayed are for illustration only (not the actual values).

PRODUCT  MAX_Q    CUSTOMER   DATE         ST   MIN_Q   CUSTOMER   DATE          ST   AVG_Q
=======  ======   ========   ==========   ==   =====   ========   ===========   ==   =====
Pepsi    2893     Bloom      01/01/2006   NJ      12   Sam        09/25/2001    NY    1435
Mile     159      Sam        02/15/2002   NJ       1   Emily      03/23/2004    CT      56
Bread    3087     Emily      07/01/2005   NY       2   Helen      02/02/2001    NJ    1512
 
CUSTOMER  PRODUCT  CT_MAX   DATE         NY_MIN   DATE         NJ_MIN    DATE
========  =======  ======   ==========   ======   ==========   ========  ==========
Sam       Egg        1908   01/11/2011      234   07/24/2005          2  11/03/2008
Helen     Cookies     392   03/31/2002     2342   09/14/2000         11  07/23/2002
Bloom     Butter     7045   09/22/2003      923   03/10/2004          8  09/11/2006

Make sure that:
1. “select * from sales” is the ONLY SQL statement allowed in your program.
2. Character string data (e.g., customer name and product name) are left justified.
3. Numeric data (e.g., Maximum/minimum Sales Quantities) are right justified.
4. The Date fields are in the format of MM/DD/YYYY (i.e., 01/02/2002 instead of 1/2/2002).
5. The reports must be generated with a single scan of the ‘sales’ table.
