select max.prod, max.max_q, maxcust.cust, maxdate.month||'/'||maxdate.day||'/'||maxdate.year date, maxdate.st, min.min_q, mincust.cust, mindate.day, mindate.month, mindate.year, mindate.st, round(max.avg_q) avg_q from
(select prod, min(quant) as min_q from sales group by prod) min
 
inner join 

(select prod, max(quant) as max_q, avg(quant) as avg_q from sales group by prod) max on min.prod = max.prod 

inner join 

(select prod, cust, quant as q from sales) maxcust on max.prod = maxcust.prod and max.max_q = maxcust.q

inner join 

(select prod, cust, quant as q from sales) mincust on min.prod = mincust.prod and min.min_q = mincust.q

inner join

(select prod, quant as q, day, month, year, state as st from sales)maxdate on max.prod = maxdate.prod and max.max_q = maxdate.q

inner join

(select prod, quant as q, day, month, year, state as st from sales)mindate on min.prod = mindate.prod and min.min_q = mindate.q;