SELECT car_type, count(*) as cars
from car_rental_company_car
where options LIKE '%통풍시트%' 
    OR options LIKE '%열선시트%' 
    OR options LIKE '%가죽시트%'
group by car_type
order by car_type