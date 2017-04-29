select sales.cust, sales.prod,  ct.ct_max, ctdate.day||'/'||ctdate.month||'/'||ctdate.year date, ny.ny_min, nydate.day, nydate.month, nydate.year, nj.nj_min, njdate.day, njdate.month, njdate.year from
(select cust, prod from sales group by prod, cust) sales

full outer join

(select cust, prod, max(quant) as ct_max from sales where state = 'CT' and year between 2000 and 2005 group by prod, cust) ct on ct.cust = sales.cust and ct.prod = sales.prod

left outer join

(select cust, prod, quant as q, day, month, year from sales where state = 'CT' and year >= 2000 and year <= 2005) ctdate on ctdate.q = ct_max and ctdate.cust = sales.cust and ctdate.prod = sales.prod

left outer join

(select cust, prod, min(quant) as ny_min from sales where state ='NY' group by prod, cust) ny on ny.cust = sales.cust and ny.prod = sales.prod

left outer join

(select cust, prod, quant as q, day, month, year from sales where state = 'NY') nydate on nydate.q = ny.ny_min and nydate.cust = sales.cust and nydate.prod = ny.prod

left outer join

(select cust, prod, min(quant) as nj_min from sales where state ='NJ' group by prod, cust) nj on nj.cust = sales.cust and nj.prod = sales.prod

left outer join

(select cust, prod, quant as q, day, month, year from sales where state = 'NJ') njdate on njdate.q = nj.nj_min and njdate.cust = nj.cust and njdate.prod = nj.prod;