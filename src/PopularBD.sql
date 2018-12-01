INSERT INTO brinquefelizschema.funcionario 
( matricula, nome, dataContratacao, ehAdministrador, senha, cpf, telefone, email, idEndereco )
VALUES (123321,'Juvenal','2017-06-20',false,'juvenalarrasa',16516547458,99291002,'gatinho.juv@email.com', 2);
INSERT INTO brinquefelizschema.funcionario 
( matricula, nome, dataContratacao, ehAdministrador, senha, cpf, telefone, email, idEndereco )
VALUES (321123,'Godofredo','2005-09-01', true,'bigboss',45775489865,81547858,'godoi.aiai@email.com', 1);

INSERT INTO brinquefelizschema.cliente  (idCliente, idEndereco, nome, cpf, telefone, email) VALUES (10, 3, 'Joilson', 69869857588, 96696363, 'jojoarrasa@email.com');
INSERT INTO brinquefelizschema.cliente  (idCliente, idEndereco, nome, cpf, telefone, email) VALUES (20, 4, 'Juriema', 1616654822, 89985878, 'emaema@email.com');

INSERT INTO brinquefelizschema.endereco (idEndereco, estado, cidade, rua, bairro, numero, cep) VALUES (1, 'MS','Campo Grande','Rua Qualquer','Bairrin', 8798, 3626512);
INSERT INTO brinquefelizschema.endereco (idEndereco, estado, cidade, rua, bairro, numero, cep) VALUES (2, 'MS' ,'Campo Grande', 'Rua Sei Lá', 'Um bairro lá', 6985, 365659);
INSERT INTO brinquefelizschema.endereco (idEndereco, estado, cidade, rua, bairro, numero, cep) VALUES (3, 'MS', 'Coxim', 'Avenida Passarinho', 'Samambaia', 121, 7958696);
INSERT INTO brinquefelizschema.endereco (idEndereco, estado, cidade, rua, bairro, numero, cep) VALUES (4, 'MS', 'Pedro Gomes', 'Avenida João de Barro', 'Pirulito', 363, 7959985);

INSERT INTO brinquefelizschema.empresa (idEmpresa, cnpj, nomeFantasia, razaoSocial, ehFornecedor, telefone,email) VALUES (99, 75845698700012, 'Brinque e seja feliz SA', 'EmpresaXX', true, 33696597, 'feliz@contato.com.br');

INSERT INTO brinquefelizschema.categoria (idCategoria, nomeCategoria, descricao) VALUES (6,'Bonecas','Bonecas Barbie, Poly,Monster High');
INSERT INTO brinquefelizschema.categoria (idCategoria, nomeCategoria, descricao) VALUES (7,'Carrinhos','Carrinhos Hot Wheels');
INSERT INTO brinquefelizschema.categoria (idCategoria, nomeCategoria, descricao) VALUES (8,'Arminhas', 'Nerf');

INSERT INTO brinquefelizschema.produto (codigoBarras, idCategoria,nomeProduto,descricao,preco,qtdEstoque) VALUES (77777777, 8, 'NERF Gun', 'NERF é uma linha de brinquedos desenvolvidos para serem jogados com segurança em ambientes fechados, produzidos com um material esponjoso macio e leve que evita acidentes', '384.90',150);
INSERT INTO brinquefelizschema.produto (codigoBarras, idCategoria,nomeProduto,descricao,preco,qtdEstoque) VALUES (88888888, 7,'Carrinho Hot Wheels Ultimate Garagem FTB69 - Mattel','Diversão garantida com o Carrinho Hot Wheels Ultimate Garagem, da Mattel, um carrinho para colecionar e brincar com uma reviravolta e um ataque surpresa de tubarões. Deixe voar a imaginação das crianças, com características surpreendentes que incluem espaço para armazenar mais de 80 carros. O playset inclui 2 veículos metálicos Hot Wheels. Personalizados para transformar as brincadeiras.','649.99',50);
INSERT INTO brinquefelizschema.produto (codigoBarras, idCategoria,nomeProduto,descricao,preco,qtdEstoque) VALUES (99999999,6,'Boneca Ladybug Baby Brink','Sabe aquela personagem da tv que sempre gostamos e queremos estar perto o tempo todo? Agora é possível! Com a "Boneca Ladybug" você pode não só apertar, mas beijar, brincar a toda hora e lugar. Confeccionada de plástico, vinil e Pvc, ela é perfeita para a brincadeira de chá, escolhinha, para levar ao parque ou brincar com suas amigas.','79.90',90);

INSERT INTO brinquefelizschema.estoque (idEstoque, idCategoria, categoria) VALUES (1,);
