select count(*) as fish_count, month(time) as month
from fish_info
group by month(time)
having count(*) > 0
order by month