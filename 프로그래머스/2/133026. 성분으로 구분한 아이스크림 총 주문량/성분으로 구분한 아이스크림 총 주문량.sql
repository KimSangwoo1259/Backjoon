
SELECT i.ingredient_type, sum(f.total_order)
from icecream_info as i
join first_half as f on f.flavor = i.flavor
group by i.ingredient_type
order by sum(f.total_order)