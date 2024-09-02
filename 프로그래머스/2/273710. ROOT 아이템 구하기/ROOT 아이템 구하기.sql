select i.item_id, i.item_name
from item_info as i
join item_tree as t on t.item_id = i.item_id
where isnull(t.parent_item_id)
order by i.item_id