insert into categoria(id, nome, categoria_pai_id) values(1, 'padrao', 1);
insert into produto(descricao,nome,preco, data_criacao) values('cabo de aço padrão','cabo de aço padrão',25.00, current_date);  --data_sub(sysdate(), INTERVAL 1 DAY)

insert into cliente(id, nome) values(1, 'José Costa dos Santos');
insert into cliente(id, nome) values(2, 'Maria da silva');

insert into pedido(id, id_cliente, data_pedido, data_conclusao, total, status) values(1, 1, now(), now(), 500.00, 1);
--id_notafiscal

insert into item_pedido(id_pedido,id_produto,preco_produto,quantidade) values(1,1,50.04,3);
