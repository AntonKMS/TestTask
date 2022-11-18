# Test task

# ����������

�	Java ������ >= 8 
�	Spring Boot (standalone ����������)
�	���� PostgreSQL (������ �� �����)
�	Liquibase ��� ��������������� ����� ��
�	������ ������� ����� Maven
�	������������ ���������� ����� application.yml

# ����������

1.	������� 2 ������� � �� ����� Liquibase:
	a.	Car {id: Long PK,  driver_name: String,  brand: String,  garage_id: Long FK}
	b.	Garage: {id: Long PK, name: String}
	2.	������� ��������� ������ REST API:
	a.	GET /api/garage � ���������� ������ ���� ������� �� ������� garage 
	b.	GET /api/garage/{id} � ���������� ������ Garage � ���� JSON � ��������� ������� ����� � ���
	c.	POST /api/garage � ��������� ����� ������� Garage, �������� �������� � ���� ������� � ���� JSON
	d.	GET /api/car � ���������� ������ ���� ������� �� ������� car 
	e.	GET /api/car/{id} � ���������� ������ Car � ���� JSON 
	f.	POST /api/car � ���������� ������ ������� Car, �������� ������ � ���� ������� � ���� JSON
	i.	������������ ������� ������ ����� driver_name � brand �� ������� ������ ����, ����� ���������� 400 BAD REQUEST � ��������� ����������� ����
		ii.	������������ id ������ ����� �����������, ���� ������ � ���� ���, ���������� 400
			iii.	 ����� ���������������� �������� �������������� ����������� ������, ��� ������� �������� ����� ������ � ������ ����� ���������� 400 � ��������� ������
