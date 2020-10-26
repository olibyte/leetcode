SELECT id,
    sum(case when month = 'Jan' then Revenue end) as Jan_Revenue,
    sum(case when month = 'Feb' then Revenue end) as Feb_Revenue,
    sum(case when month = 'Mar' then Revenue end) as Mar_Revenue,
    sum(case when month = 'Apr' then Revenue end) as Apr_Revenue,
    sum(case when month = 'May' then Revenue end) as May_Revenue,
    sum(case when month = 'Jun' then Revenue end) as Jun_Revenue,
    sum(case when month = 'Jul' then Revenue end) as Jul_Revenue,
    sum(case when month = 'Aug' then Revenue end) as Aug_Revenue,
    sum(case when month = 'Sep' then Revenue end) as Sep_Revenue,
    sum(case when month = 'Oct' then Revenue end) as Oct_Revenue,
    sum(case when month = 'Nov' then Revenue end) as Nov_Revenue,
    sum(case when month = 'Dec' then Revenue end) as Dec_Revenue
FROM Department
GROUP BY id