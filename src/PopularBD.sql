--CRIA BANCO DE DADOS
DROP DATABASE IF EXISTS brinquefeliz;
CREATE DATABASE brinquefeliz;
\c brinquefeliz;
DROP SCHEMA IF EXISTS brinquefelizschema CASCADE;

CREATE SCHEMA brinquefelizschema;
SET search_path = 'brinquefelizschema';
--CRIA USUARIO ROOT PARA USAR NO NETBEANS
--CREATE ROLE root SUPERUSER CREATEDB CREATEROLE LOGIN PASSWORD 'root';
ALTER DATABASE brinquefeliz OWNER TO root;
ALTER SCHEMA brinquefelizschema OWNER TO root;

--CONECTAR COMO USUARIO ROOT NO BD BRINQUEFELIZ
--\q
--exit
--psql -h localhost -d brinquefeliz -U root
-- senha do usuário: root 
--SET search_path = 'brinquefelizschema';

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
    idCliente SERIAL PRIMARY KEY,
    nome varchar(100) NOT NULL,
    cpf numeric(11) NOT NULL, 
    telefone numeric(11),
    email varchar(100)
);

CREATE TABLE estoque (
    idEstoque SERIAL PRIMARY KEY,
    quantidade smallint NOT NULL
);

CREATE TABLE categoria (
    idCategoria SERIAL PRIMARY KEY,
    idEstoque integer NOT NULL,
    nomeCategoria varchar(50) NOT NULL,
    descricao text
);

CREATE TABLE produto (
    codigoBarras numeric(11) PRIMARY KEY,
    idCategoria integer NOT NULL,
    nomeProduto varchar(100) NOT NULL,
    descricao text,
    preco numeric(10,2) NOT NULL,
    qtdEstoque smallint NOT NULL
);

CREATE TABLE venda (
    idVenda SERIAL PRIMARY KEY,
    matriculaFuncionario numeric(11) NOT NULL,
    idCliente integer NOT NULL,
    valor numeric(10,2) NOT NULL,
    data date NOT NULL, 
    qtdProduto smallint NOT NULL
);

CREATE TABLE pagamento (
    idPagamento SERIAL PRIMARY KEY,
    idVenda integer NOT NULL,
    valor numeric(10,2) NOT NULL,
    tipoPgto varchar(20) NOT NULL
);

CREATE TABLE itemvenda (
    idItemVenda  SERIAL ,
    idVenda integer NOT NULL,
    codigoBarras numeric(11) NOT NULL,
    quantidade smallint NOT NULL,
    PRIMARY KEY (idItemVenda, idVenda, codigoBarras)
);

CREATE TABLE funcionarioendereco (
    matricula integer,
    idEndereco integer,
    PRIMARY KEY(matricula,idEndereco)
);

CREATE TABLE clienteendereco (
    idCliente integer,
    idEndereco integer,
    PRIMARY KEY(idCliente,idEndereco)
);

CREATE TABLE produtofornecedor (
    codigoBarrasProduto numeric(11),
    idEmpresa integer,
    PRIMARY KEY (codigoBarrasProduto, idEmpresa)
);

CREATE TABLE endereco (
    idEndereco  SERIAL  PRIMARY KEY,
    estado varchar(2),
    cidade varchar(100),
    rua varchar(100),
    bairro varchar(100),
    numero numeric(100),
    cep numeric(8) 
);

CREATE TABLE empresa (
    idEmpresa  SERIAL  PRIMARY KEY,
    cnpj numeric(14) NOT NULL UNIQUE,
    nomeFantasia varchar(100) NOT NULL,
    razaoSocial varchar(100),
    ehFornecedor boolean NOT NULL,
    telefone numeric(11) NOT NULL,
    email varchar(100)
);
-- INSERE RESTRIÇÕES DE CHAVE ESTRANGEIRA
ALTER TABLE ONLY      brinquefelizschema.categoria               ADD CONSTRAINT     estoquefk           FOREIGN KEY     (idEstoque)             REFERENCES      brinquefelizschema.estoque      (idEstoque);

ALTER TABLE ONLY      brinquefelizschema.produto                 ADD CONSTRAINT     categoriafk         FOREIGN KEY     (idCategoria)           REFERENCES      brinquefelizschema.categoria    (idCategoria);

ALTER TABLE ONLY      brinquefelizschema.itemvenda               ADD CONSTRAINT     vendafk             FOREIGN KEY     (idVenda)               REFERENCES      brinquefelizschema.venda        (idVenda);
ALTER TABLE ONLY      brinquefelizschema.itemvenda               ADD CONSTRAINT     produtofk           FOREIGN KEY     (codigoBarras)          REFERENCES      brinquefelizschema.produto      (codigoBarras);

ALTER TABLE ONLY      brinquefelizschema.venda                   ADD CONSTRAINT     funcionariofk       FOREIGN KEY     (matriculaFuncionario)  REFERENCES      brinquefelizschema.funcionario  (matricula);
ALTER TABLE ONLY      brinquefelizschema.venda                   ADD CONSTRAINT     clientefk           FOREIGN KEY     (idCliente)             REFERENCES      brinquefelizschema.cliente      (idCliente);

ALTER TABLE ONLY      brinquefelizschema.pagamento               ADD CONSTRAINT     vendafk             FOREIGN KEY     (idVenda)               REFERENCES      brinquefelizschema.venda        (idVenda);

ALTER TABLE ONLY      brinquefelizschema.clienteendereco         ADD CONSTRAINT     clienderecofk       FOREIGN KEY     (idCliente)             REFERENCES      brinquefelizschema.cliente      (idCliente);
ALTER TABLE ONLY      brinquefelizschema.clienteendereco         ADD CONSTRAINT     enderecoclifk       FOREIGN KEY     (idEndereco)            REFERENCES      brinquefelizschema.endereco     (idEndereco);

ALTER TABLE ONLY      brinquefelizschema.funcionarioendereco     ADD CONSTRAINT     enderecofuncfk      FOREIGN KEY     (matricula)             REFERENCES      brinquefelizschema.funcionario  (matricula);
ALTER TABLE ONLY      brinquefelizschema.funcionarioendereco     ADD CONSTRAINT     funcenderecofk      FOREIGN KEY     (idEndereco)            REFERENCES      brinquefelizschema.endereco     (idEndereco);

ALTER TABLE ONLY      brinquefelizschema.produtofornecedor       ADD CONSTRAINT     produtofornfk       FOREIGN KEY     (codigoBarrasProduto)   REFERENCES      brinquefelizschema.produto      (codigoBarras);
ALTER TABLE ONLY      brinquefelizschema.produtofornecedor       ADD CONSTRAINT     fornecedorprodfk    FOREIGN KEY     (idEmpresa)             REFERENCES      brinquefelizschema.empresa      (idEmpresa);


--POPULA BD

ALTER TABLE     brinquefelizschema.categoria            DISABLE TRIGGER ALL;
ALTER TABLE     brinquefelizschema.cliente              DISABLE TRIGGER ALL;
ALTER TABLE     brinquefelizschema.clienteendereco      DISABLE TRIGGER ALL;
ALTER TABLE     brinquefelizschema.empresa              DISABLE TRIGGER ALL;
ALTER TABLE     brinquefelizschema.endereco             DISABLE TRIGGER ALL;
ALTER TABLE     brinquefelizschema.estoque              DISABLE TRIGGER ALL;
ALTER TABLE     brinquefelizschema.funcionario          DISABLE TRIGGER ALL;
ALTER TABLE     brinquefelizschema.funcionarioendereco  DISABLE TRIGGER ALL;
ALTER TABLE     brinquefelizschema.itemvenda            DISABLE TRIGGER ALL;
ALTER TABLE     brinquefelizschema.pagamento            DISABLE TRIGGER ALL;
ALTER TABLE     brinquefelizschema.produto              DISABLE TRIGGER ALL;
ALTER TABLE     brinquefelizschema.produtofornecedor    DISABLE TRIGGER ALL;
ALTER TABLE     brinquefelizschema.venda                DISABLE TRIGGER ALL;

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

INSERT INTO brinquefelizschema.empresa (idEmpresa, cnpj, nomeFantasia, razaoSocial, ehFornecedor, telefone, email) 
VALUES (99, 75845698700012, 'ToySTORE', 'ToySTOREEmpresaXX', true, 33696597, 'feliz@contato.com.br');

INSERT INTO brinquefelizschema.categoria (idEstoque,idCategoria, nomeCategoria, descricao) 
VALUES (1,6,'Bonecas','Bonecas Barbie, Poly,Monster High');

INSERT INTO brinquefelizschema.categoria (idEstoque,idCategoria, nomeCategoria, descricao) 
VALUES (1,7,'Carrinhos','Carrinhos Hot Wheels');

INSERT INTO brinquefelizschema.categoria (idEstoque,idCategoria, nomeCategoria, descricao) 
VALUES (1, 8,'Arminhas', 'Nerf');

INSERT INTO brinquefelizschema.produto (codigoBarras, idCategoria,nomeProduto,descricao,preco,qtdEstoque) 
VALUES (123, 8, 'NERF Gun', 'NERF é uma linha de brinquedos desenvolvidos para serem jogados com segurança em ambientes fechados, produzidos com um material esponjoso macio e leve que evita acidentes', '384,90',150);

INSERT INTO brinquefelizschema.produto (codigoBarras, idCategoria,nomeProduto,descricao,preco,qtdEstoque) 
VALUES (654, 7,'Carrinho Hot Wheels Ultimate Garagem FTB69 - Mattel','Diversão garantida com o Carrinho Hot Wheels Ultimate Garagem, da Mattel, um carrinho para colecionar e brincar com uma reviravolta e um ataque surpresa de tubarões. Deixe voar a imaginação das crianças, com características surpreendentes que incluem espaço para armazenar mais de 80 carros. O playset inclui 2 veículos metálicos Hot Wheels. Personalizados para transformar as brincadeiras.','649,99',50);

INSERT INTO brinquefelizschema.produto (codigoBarras, idCategoria,nomeProduto,descricao,preco,qtdEstoque) 
VALUES (987,6,'Boneca Ladybug Baby Brink','Sabe aquela personagem da tv que sempre gostamos e queremos estar perto o tempo todo? Agora é possível! Com a "Boneca Ladybug" você pode não só apertar, mas beijar, brincar a toda hora e lugar. Confeccionada de plástico, vinil e Pvc, ela é perfeita para a brincadeira de chá, escolhinha, para levar ao parque ou brincar com suas amigas.','79,90',90);

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

INSERT INTO brinquefelizschema.produtofornecedor (codigoBarrasProduto, idEmpresa)
VALUES (123,99);

INSERT INTO brinquefelizschema.produtofornecedor (codigoBarrasProduto, idEmpresa)
VALUES (654,99);

INSERT INTO brinquefelizschema.produtofornecedor (codigoBarrasProduto, idEmpresa)
VALUES (987,99);

ALTER TABLE     brinquefelizschema.categoria           ENABLE TRIGGER ALL;
ALTER TABLE     brinquefelizschema.cliente             ENABLE TRIGGER ALL;
ALTER TABLE     brinquefelizschema.clienteendereco     ENABLE TRIGGER ALL;
ALTER TABLE     brinquefelizschema.empresa             ENABLE TRIGGER ALL;
ALTER TABLE     brinquefelizschema.endereco            ENABLE TRIGGER ALL;
ALTER TABLE     brinquefelizschema.estoque             ENABLE TRIGGER ALL;
ALTER TABLE     brinquefelizschema.funcionario         ENABLE TRIGGER ALL;
ALTER TABLE     brinquefelizschema.funcionarioendereco ENABLE TRIGGER ALL;
ALTER TABLE     brinquefelizschema.itemvenda           ENABLE TRIGGER ALL;
ALTER TABLE     brinquefelizschema.pagamento           ENABLE TRIGGER ALL;
ALTER TABLE     brinquefelizschema.produto             ENABLE TRIGGER ALL;
ALTER TABLE     brinquefelizschema.produtofornecedor   ENABLE TRIGGER ALL;
ALTER TABLE     brinquefelizschema.venda               ENABLE TRIGGER ALL;

