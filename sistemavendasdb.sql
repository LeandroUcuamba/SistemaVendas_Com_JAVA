-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 05-Ago-2022 às 16:50
-- Versão do servidor: 10.4.24-MariaDB
-- versão do PHP: 8.0.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `sistemavendasdb`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_clientes`
--

CREATE TABLE `tb_clientes` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `telefone` varchar(30) DEFAULT NULL,
  `cep` varchar(100) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `numero` varchar(100) DEFAULT NULL,
  `complemento` varchar(200) DEFAULT NULL,
  `estado` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tb_clientes`
--

INSERT INTO `tb_clientes` (`id`, `nome`, `email`, `telefone`, `cep`, `endereco`, `numero`, `complemento`, `estado`) VALUES
(12, 'joao da silva', 'charlie@charliegmail.com', '(+244) 942583628', '11111-111', 'tv raimundinho', '1', 'casa', 'Luanda'),
(14, 'maria dos reis', '0000', '(+244) 942583628', '00000-000', '0000', '0', '00', 'Huambo'),
(24, 'charlie rodrigues', 'charlie@charlie', '(33) 3333 - 3333', '99999-999', 'tv raimundinho', '12', '', 'AM'),
(27, 'Leandro dos santos Ucuamba', 'leandrodossantos.lc5@gmail.com', '(+244) 942583628', '23454-545', 'Golf-2', '190737', 'É um programador', 'Luanda');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_fornecedores`
--

CREATE TABLE `tb_fornecedores` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `telefone` varchar(30) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `complemento` varchar(200) DEFAULT NULL,
  `estado` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tb_fornecedores`
--

INSERT INTO `tb_fornecedores` (`id`, `nome`, `email`, `telefone`, `endereco`, `numero`, `complemento`, `estado`) VALUES
(1, 'sang sung', 'ss@gmail.com', '(13) 2132 - 1212', 'tv raimundinho', 44, 'mobile', 'CE'),
(3, 'moto ', 'G@gmail.com', '(+244) 956544333', 'tv do beco2', 22, 'mobile', 'Luanda'),
(5, 'magazine luiza', 'magazine@yahoo.com.br', '(44) 4444 - 4444', 'joaquim dos santos', 78, 'empresa', 'CE'),
(7, 'Ucuamba', 'leandroUcuamba.lc5@gmail.com', '(+244) 942583628', 'Golf', 10012, 'programmer', 'Huambo');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_funcionarios`
--

CREATE TABLE `tb_funcionarios` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `senha` varchar(10) DEFAULT NULL,
  `cargo` varchar(100) DEFAULT NULL,
  `nivel_acesso` varchar(50) DEFAULT NULL,
  `telefone` varchar(30) DEFAULT NULL,
  `cep` varchar(100) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `complemento` varchar(200) DEFAULT NULL,
  `estado` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tb_funcionarios`
--

INSERT INTO `tb_funcionarios` (`id`, `nome`, `email`, `senha`, `cargo`, `nivel_acesso`, `telefone`, `cep`, `endereco`, `numero`, `complemento`, `estado`) VALUES
(7, 'charlie rodrigues', 'charlie@gmail.com', '000', 'gerente', 'Administrador', '(11) 1111 - 1111', '11231-321', 'travessa raimundinho', 45, '	tentando...', 'AP'),
(10, 'joana maria', 'roberto@charlie', '000', 'balconista', 'Usuário', '(77) 7777 - 7777', '11231-321', 'travessa manoel santoro', 77, '	tentando...', 'AP'),
(13, 'Tiago Sacala', 'tiago12lc5@gmail.com', '12345678', 'Gerente_stock', 'Usuario', '(+244) 932456378', '23456-788', 'Golf2', 190767, 'tentando', 'Moxico');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_itensvendas`
--

CREATE TABLE `tb_itensvendas` (
  `id` int(11) NOT NULL,
  `venda_id` int(11) DEFAULT NULL,
  `produto_id` int(11) DEFAULT NULL,
  `qtd` int(11) DEFAULT NULL,
  `subtotal` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tb_itensvendas`
--

INSERT INTO `tb_itensvendas` (`id`, `venda_id`, `produto_id`, `qtd`, `subtotal`) VALUES
(216, 269, 8, 2, '6000.00');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_parcelas`
--

CREATE TABLE `tb_parcelas` (
  `id` int(11) NOT NULL,
  `cliente_id` int(11) DEFAULT NULL,
  `data_venda` datetime DEFAULT NULL,
  `total` decimal(10,2) DEFAULT NULL,
  `parcela` decimal(10,2) DEFAULT NULL,
  `obs` varchar(100) DEFAULT NULL,
  `num_parcelas` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tb_parcelas`
--

INSERT INTO `tb_parcelas` (`id`, `cliente_id`, `data_venda`, `total`, `parcela`, `obs`, `num_parcelas`) VALUES
(46, 12, '2020-11-02 00:00:00', '240.00', '24.00', '', 5),
(47, 14, '2020-11-02 00:00:00', '16000.00', '1000.00', 'maior que quinze mil', 14),
(48, 14, '2020-11-02 00:00:00', '1100.00', '100.00', '', 9);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_produtos`
--

CREATE TABLE `tb_produtos` (
  `id` int(11) NOT NULL,
  `descricao` varchar(100) DEFAULT NULL,
  `preco` decimal(10,2) DEFAULT NULL,
  `qtd_estoque` int(11) DEFAULT NULL,
  `for_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tb_produtos`
--

INSERT INTO `tb_produtos` (`id`, `descricao`, `preco`, `qtd_estoque`, `for_id`) VALUES
(7, 'celular', '1100.00', 60, 1),
(8, 'computador de mesa', '3000.00', 60, 5),
(9, 'teclado de pc', '100.00', 77, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_vendas`
--

CREATE TABLE `tb_vendas` (
  `id` int(11) NOT NULL,
  `cliente_id` int(11) DEFAULT NULL,
  `data_venda` varchar(100) DEFAULT NULL,
  `total_venda` decimal(10,2) DEFAULT NULL,
  `observacoes` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tb_vendas`
--

INSERT INTO `tb_vendas` (`id`, `cliente_id`, `data_venda`, `total_venda`, `observacoes`) VALUES
(256, 24, '2020-12-09 00:00:00', '3200.00', 'tentando..'),
(257, 24, '2020-12-11 00:00:00', '100.00', 'tentando...'),
(262, 27, '2022-08-02', '9000.00', 'tentando...'),
(268, 12, '2022-08-02', '1800.00', ''),
(269, 27, '2022-08-02', '6000.00', '');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `tb_clientes`
--
ALTER TABLE `tb_clientes`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `tb_fornecedores`
--
ALTER TABLE `tb_fornecedores`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `tb_funcionarios`
--
ALTER TABLE `tb_funcionarios`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `tb_itensvendas`
--
ALTER TABLE `tb_itensvendas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `venda_id` (`venda_id`),
  ADD KEY `produto_id` (`produto_id`);

--
-- Índices para tabela `tb_parcelas`
--
ALTER TABLE `tb_parcelas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cliente_id` (`cliente_id`);

--
-- Índices para tabela `tb_produtos`
--
ALTER TABLE `tb_produtos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `for_id` (`for_id`);

--
-- Índices para tabela `tb_vendas`
--
ALTER TABLE `tb_vendas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cliente_id` (`cliente_id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `tb_clientes`
--
ALTER TABLE `tb_clientes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT de tabela `tb_fornecedores`
--
ALTER TABLE `tb_fornecedores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de tabela `tb_funcionarios`
--
ALTER TABLE `tb_funcionarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de tabela `tb_itensvendas`
--
ALTER TABLE `tb_itensvendas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=217;

--
-- AUTO_INCREMENT de tabela `tb_parcelas`
--
ALTER TABLE `tb_parcelas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;

--
-- AUTO_INCREMENT de tabela `tb_produtos`
--
ALTER TABLE `tb_produtos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de tabela `tb_vendas`
--
ALTER TABLE `tb_vendas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=270;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `tb_itensvendas`
--
ALTER TABLE `tb_itensvendas`
  ADD CONSTRAINT `tb_itensvendas_ibfk_1` FOREIGN KEY (`venda_id`) REFERENCES `tb_vendas` (`id`),
  ADD CONSTRAINT `tb_itensvendas_ibfk_2` FOREIGN KEY (`produto_id`) REFERENCES `tb_produtos` (`id`);

--
-- Limitadores para a tabela `tb_parcelas`
--
ALTER TABLE `tb_parcelas`
  ADD CONSTRAINT `tb_parcelas_ibfk_1` FOREIGN KEY (`cliente_id`) REFERENCES `tb_clientes` (`id`);

--
-- Limitadores para a tabela `tb_produtos`
--
ALTER TABLE `tb_produtos`
  ADD CONSTRAINT `tb_produtos_ibfk_1` FOREIGN KEY (`for_id`) REFERENCES `tb_fornecedores` (`id`);

--
-- Limitadores para a tabela `tb_vendas`
--
ALTER TABLE `tb_vendas`
  ADD CONSTRAINT `tb_vendas_ibfk_1` FOREIGN KEY (`cliente_id`) REFERENCES `tb_clientes` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
