SELECT i.name, i.datetime
from animal_ins as i
left outer join animal_outs as o on o.animal_id = i.animal_id
where isnull(o.datetime)
order by i.datetime asc
limit 3