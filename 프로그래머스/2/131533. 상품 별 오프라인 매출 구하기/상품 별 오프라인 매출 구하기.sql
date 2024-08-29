SELECT p.product_code as product_code, p.price * sum(o.sales_amount) as sales
from product as p
join offline_sale as o on o.product_id = p.product_id
group by product_code
order by sales desc, p.product_code                    
