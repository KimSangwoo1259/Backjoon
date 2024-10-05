SELECT u.user_id, u.nickname, concat(concat(u.city, ' ', u.street_address1), ' ', u.street_address2) as 전체주소,CONCAT(SUBSTRING(u.TLNO, 1, 3), '-', 
              SUBSTRING(u.TLNO, 4, 4), '-', 
              SUBSTRING(u.TLNO, 8)) AS 전화번호
from used_goods_board as b
left outer join used_goods_user as u on u.user_id = b.writer_id
group by b.writer_id
having count(*) >= 3
order by user_id desc
