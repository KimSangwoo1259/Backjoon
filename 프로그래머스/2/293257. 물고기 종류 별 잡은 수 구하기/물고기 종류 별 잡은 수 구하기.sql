select count(*) as fish_count, n.fish_name
from fish_info as i
join fish_name_info as n on n.fish_type = i.fish_type
group by n.fish_name
order by count(*) desc