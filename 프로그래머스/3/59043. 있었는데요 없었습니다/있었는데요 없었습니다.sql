SELECT i.animal_id, i.name
from animal_ins as i
join animal_outs as o on o.animal_id = i.animal_id
where i.datetime > o.datetime
order by i.datetime