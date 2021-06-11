
create table shoppingapp.product(
	product_id int primary key auto_increment
	, subcategory_id int
	, product_name varchar(30)
	, price int default 0
	, brand varchar(30)
	, detail text
	, filename varchar(40)
)default character set utf8;

elect product_id, sub_name, product_name, price, brand, detail,filename
