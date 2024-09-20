SELECT i.animal_id, i.name
from animal_ins as i
left outer join animal_outs as o on o.animal_id = i.animal_id
where o.datetime is not null
order by (o.datetime - i.datetime) desc
limit 2