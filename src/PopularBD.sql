--CRIA BANCO DE DADOS
CREATE DATABASE brinquefeliz;
\c brinquefeliz;
CREATE SCHEMA brinquefelizschema;
SET search_path = 'brinquefelizschema';
--CRIA USUARIO ROOT PARA USAR NO NETBEANS
CREATE ROLE root SUPERUSER CREATEDB CREATEROLE LOGIN PASSWORD 'root';
ALTER DATABASE brinquefeliz OWNER TO root;
ALTER SCHEMA brinquefelizschema OWNER TO root;

--CONECTAR COMO USUARIO ROOT NO BD BRINQUEFELIZ
\q
exit
psql -h localhost -d brinquefeliz -U root
SET search_path = 'brinquefelizschema';

--CRIA TABELAS
CREATE TABLE funcionario (
    matricula numeric(11) PRIMARY KEY,
    nome varchar(100) NOT NULL,
    dataContratacao date NOT NULL,
    ehAdministrador boolean NOT NULL,
    senha varchar(60) NOT NULL,
    cpf numeric(11) NOT NULL,
    telefone numeric(11) NOT NULL,
    email varchar(100)
    );

CREATE TABLE cliente (
    idCliente numeric(11) PRIMARY KEY,
    nome varchar(100) NOT NULL,
    cpf numeric(11) NOT NULL, 
    telefone numeric(11),
    email varchar(100)
);

CREATE TABLE estoque (
    idEstoque smallint PRIMARY KEY,
    quantidade smallint NOT NULL
);

CREATE TABLE categoria (
    idCategoria smallint PRIMARY KEY,
    idEstoque smallint NOT NULL,
    nomeCategoria varchar(50) NOT NULL,
    descricao text
);

CREATE TABLE produto (
    codigoBarras numeric(11) PRIMARY KEY,
    idCategoria numeric(11) NOT NULL,
    nomeProduto varchar(100) NOT NULL,
    descricao text,
    preco money NOT NULL,
    qtdEstoque smallint NOT NULL
);

CREATE TABLE venda (
    idVenda smallint PRIMARY KEY,
    matriculaFuncionario numeric(11) NOT NULL,
    idCliente numeric(11) NOT NULL,
    valor money NOT NULL,
    data date NOT NULL, 
    qtdProduto smallint NOT NULL
);

CREATE TABLE pagamento (
    idPagamento smallint,
    idVenda smallint NOT NULL,
    valor money NOT NULL,
    tipoPgto varchar(20) NOT NULL
);

CREATE TABLE itemvenda (
    idItemVenda smallint,
    idVenda smallint NOT NULL,
    codigoBarras numeric(11) NOT NULL
    quantidade smallint NOT NULL,

    PRIMARY KEY 
);
--POPULA BD
INSERT INTO brinquefelizschema.funcionario 
( matricula, nome, dataContratacao, ehAdministrador, senha, cpf, telefone, email)
VALUES (123321,'Juvenal','2017-06-20',false,'juvenalarrasa',16516547458,99291002,'gatinho.juv@email.com');

INSERT INTO brinquefelizschema.funcionario 
( matricula, nome, dataContratacao, ehAdministrador, senha, cpf, telefone, email)
VALUES (321123,'Godofredo','2005-09-01', true,'bigboss',45775489865,81547858,'godoi.aiai@email.com');

INSERT INTO brinquefelizschema.cliente  (idCliente, nome, cpf, telefone, email) 
VALUES (10, 'Joilson', 69869857588, 96696363, 'jojoarrasa@email.com');

INSERT INTO brinquefelizschema.cliente  (idCliente, nome, cpf, telefone, email)
VALUES (20,'Juriema', 1616654822, 89985878, 'emaema@email.com');

INSERT INTO brinquefelizschema.endereco (idEndereco, estado, cidade, rua, bairro, numero, cep) 
VALUES (1, 'MS','Campo Grande','Rua Qualquer','Bairrin', 8798, 3626512);

INSERT INTO brinquefelizschema.endereco (idEndereco, estado, cidade, rua, bairro, numero, cep) 
VALUES (2, 'MS' ,'Campo Grande', 'Rua Sei Lá', 'Um bairro lá', 6985, 365659);

INSERT INTO brinquefelizschema.endereco (idEndereco, estado, cidade, rua, bairro, numero, cep) 
VALUES (3, 'MS', 'Coxim', 'Avenida Passarinho', 'Samambaia', 121, 7958696);

INSERT INTO brinquefelizschema.endereco (idEndereco, estado, cidade, rua, bairro, numero, cep) 
VALUES (4, 'MS', 'Pedro Gomes', 'Avenida João de Barro', 'Pirulito', 363, 7959985);

INSERT INTO brinquefelizschema.endereco (idEndereco, estado, cidade, rua, bairro, numero, cep) 
VALUES (5, 'SP', 'Brinquedópolis', 'Avenida São João de Barro', 'Toy', 9845, 8859985);

INSERT INTO brinquefelizschema.empresa (idEmpresa, cnpj, nomeFantasia, razaoSocial, ehFornecedor, telefone, email, idEndereco) 
VALUES (99, 75845698700012, 'ToySTORE', 'ToySTOREEmpresaXX', true, 33696597, 'feliz@contato.com.br',5);

INSERT INTO brinquefelizschema.categoria (idEstoque,idCategoria, nomeCategoria, descricao) 
VALUES (1,6,'Bonecas','Bonecas Barbie, Poly,Monster High');

INSERT INTO brinquefelizschema.categoria (idEstoque,idCategoria, nomeCategoria, descricao) 
VALUES (1,7,'Carrinhos','Carrinhos Hot Wheels');

INSERT INTO brinquefelizschema.categoria (idEstoque,idCategoria, nomeCategoria, descricao) 
VALUES (1, 8,'Arminhas', 'Nerf');

INSERT INTO brinquefelizschema.produto (codigoBarras, idCategoria,nomeProduto,descricao,preco,qtdEstoque) 
VALUES (77777777, 8, 'NERF Gun', 'NERF é uma linha de brinquedos desenvolvidos para serem jogados com segurança em ambientes fechados, produzidos com um material esponjoso macio e leve que evita acidentes', '384.90',150);

INSERT INTO brinquefelizschema.produto (codigoBarras, idCategoria,nomeProduto,descricao,preco,qtdEstoque) 
VALUES (88888888, 7,'Carrinho Hot Wheels Ultimate Garagem FTB69 - Mattel','Diversão garantida com o Carrinho Hot Wheels Ultimate Garagem, da Mattel, um carrinho para colecionar e brincar com uma reviravolta e um ataque surpresa de tubarões. Deixe voar a imaginação das crianças, com características surpreendentes que incluem espaço para armazenar mais de 80 carros. O playset inclui 2 veículos metálicos Hot Wheels. Personalizados para transformar as brincadeiras.','649.99',50);

INSERT INTO brinquefelizschema.produto (codigoBarras, idCategoria,nomeProduto,descricao,preco,qtdEstoque) 
VALUES (99999999,6,'Boneca Ladybug Baby Brink','Sabe aquela personagem da tv que sempre gostamos e queremos estar perto o tempo todo? Agora é possível! Com a "Boneca Ladybug" você pode não só apertar, mas beijar, brincar a toda hora e lugar. Confeccionada de plástico, vinil e Pvc, ela é perfeita para a brincadeira de chá, escolhinha, para levar ao parque ou brincar com suas amigas.','79.90',90);

INSERT INTO brinquefelizschema.estoque (idEstoque, quantidade)
VALUES (1,290);

INSERT INTO brinquefelizschema.funcionarioendereco (matricula, idEndereco)
VALUES (123321,1);

INSERT INTO brinquefelizschema.funcionarioendereco (matricula, idEndereco)
VALUES (321123,2);

INSERT INTO brinquefelizschema.clienteendereco (idCliente, idEndereco)
VALUES (10,3);

INSERT INTO brinquefelizschema.clienteendereco (idCliente, idEndereco)
VALUES (20,4);

INSERT INTO brinquefelizschema.produtofornecedor (codigoBarras, idEmpresa)
VALUES (77777777,99);

INSERT INTO brinquefelizschema.produtofornecedor (codigoBarras, idEmpresa)
VALUES (88888888,99);

INSERT INTO brinquefelizschema.produtofornecedor (codigoBarras, idEmpresa)
VALUES (99999999,99);
