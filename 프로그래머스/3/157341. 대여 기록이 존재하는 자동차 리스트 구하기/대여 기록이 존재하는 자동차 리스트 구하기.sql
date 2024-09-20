SELECT distinct c.car_id
from CAR_RENTAL_COMPANY_CAR as c
join CAR_RENTAL_COMPANY_RENTAL_HISTORY as r on r.car_id = c.car_id
where c.car_type = '세단' and r.start_date BETWEEN '2022-10-01' AND '2022-10-31'
order by c.car_id desc