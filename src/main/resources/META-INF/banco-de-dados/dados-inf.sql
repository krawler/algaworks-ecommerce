insert into categoria(id, nome, categoria_pai_id) values(1, 'padrao', 1);
insert into produto(nome, descricao, preco, data_criacao) values('cabo de aço padrão','cabo de aço padrão',25.00, current_date);  --data_sub(sysdate(), INTERVAL 1 DAY)
insert into produto(nome, descricao, preco, data_criacao) values('cadeado m10','cadeado de aluninio',25.00, current_date);  --data_sub(sysdate(), INTERVAL 1 DAY)

insert into cliente(id, nome) values(1, 'José Costa dos Santos');
insert into cliente(id, nome) values(2, 'Maria da silva');

insert into pedido(id, id_cliente, data_pedido, data_conclusao, total, status) values(1, 1, now(), now(), 500.00, 1);
insert into pedido(id, id_cliente, data_pedido, data_conclusao, total, status) values(2, 2, now(), now(), 300.00, 1);
--id_notafiscal

insert into item_pedido(id_pedido,id_produto,preco_produto,quantidade) values(1,1,50.04,3);
insert into item_pedido(id_pedido,id_produto,preco_produto,quantidade) values(1,1, 5.8,2);
insert into item_pedido(id_pedido,id_produto,preco_produto,quantidade) values(2,1, 5.8,2);
insert into item_pedido(id_pedido,id_produto,preco_produto,quantidade) values(2,1, 5.8,2);
insert into item_pedido(id_pedido,id_produto,preco_produto,quantidade) values(2,1, 5.8,2);

insert into pagamento_cartao(id, pedido_id, status,  numero) values(2, 1, 1, 'abc1123');
insert into pagamento_boleto(id, status, pedido_id, numero) values(1, 1,  1, 'abc1123');

insert into nota_fiscal(id, data_emissao, xml, id_pedido) values(1, now(), '<xml />', 2);
