-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           11.3.2-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Copiando estrutura do banco de dados para folha_pagamento
CREATE DATABASE IF NOT EXISTS `folha_pagamento` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `folha_pagamento`;

-- Copiando estrutura para tabela folha_pagamento.adicionais
CREATE TABLE IF NOT EXISTS `adicionais` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) NOT NULL,
  `referencia` double NOT NULL,
  `provento` double NOT NULL,
  `desconto` double NOT NULL,
  `id_funcionario` int(11) NOT NULL,
  `id_folha_pagamento` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `Adicionais_fk5` (`id_funcionario`),
  KEY `Adicionais_fk6` (`id_folha_pagamento`),
  CONSTRAINT `Adicionais_fk5` FOREIGN KEY (`id_funcionario`) REFERENCES `funcionario` (`id`),
  CONSTRAINT `Adicionais_fk6` FOREIGN KEY (`id_folha_pagamento`) REFERENCES `folha_de_pagamento` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=133 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Copiando dados para a tabela folha_pagamento.adicionais: ~0 rows (aproximadamente)

-- Copiando estrutura para tabela folha_pagamento.atrasos
CREATE TABLE IF NOT EXISTS `atrasos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `atraso` int(11) NOT NULL DEFAULT 0,
  `id_beneficios_fixos` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `Atrasos_fk2` (`id_beneficios_fixos`),
  CONSTRAINT `Atrasos_fk2` FOREIGN KEY (`id_beneficios_fixos`) REFERENCES `beneficios_fixos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Copiando dados para a tabela folha_pagamento.atrasos: ~11 rows (aproximadamente)
INSERT IGNORE INTO `atrasos` (`id`, `atraso`, `id_beneficios_fixos`) VALUES
	(1, 5, 4),
	(2, 6, 4),
	(3, 7, 4),
	(4, 10, 12),
	(5, 5, 12),
	(6, 6, 21),
	(7, 7, 21),
	(8, 4, 30),
	(9, 6, 32),
	(10, 8, 55),
	(11, 9, 57);

-- Copiando estrutura para tabela folha_pagamento.banco_de_horas
CREATE TABLE IF NOT EXISTS `banco_de_horas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `horas_totais` double NOT NULL,
  `horas_extras_50%` double NOT NULL,
  `horas_extras_100%` double NOT NULL,
  `Horas_noturno` double NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Copiando dados para a tabela folha_pagamento.banco_de_horas: ~60 rows (aproximadamente)
INSERT IGNORE INTO `banco_de_horas` (`id`, `horas_totais`, `horas_extras_50%`, `horas_extras_100%`, `Horas_noturno`) VALUES
	(1, 160, 0, 0, 0),
	(2, 160, 0, 0, 0),
	(3, 180, 0, 0, 0),
	(4, 160, 0, 0, 0),
	(5, 160, 0, 0, 0),
	(6, 160, 0, 0, 0),
	(7, 180, 15, 2, 0),
	(8, 0, 0, 0, 0),
	(9, 0, 0, 0, 0),
	(10, 152, 0, 0, 10),
	(11, 160, 0, 0, 0),
	(12, 160, 0, 0, 0),
	(13, 0, 0, 0, 0),
	(14, 160, 0, 0, 0),
	(15, 160, 0, 0, 0),
	(16, 160, 0, 0, 0),
	(17, 84, 10, 2, 30),
	(18, 144, 0, 0, 0),
	(19, 160, 0, 0, 0),
	(20, 160, 0, 0, 0),
	(21, 0, 0, 0, 0),
	(22, 160, 0, 0, 0),
	(23, 160, 0, 0, 0),
	(24, 160, 0, 0, 80),
	(25, 160, 0, 0, 0),
	(26, 152, 0, 0, 40),
	(27, 0, 0, 0, 0),
	(28, 160, 0, 0, 0),
	(29, 160, 3, 1, 40),
	(30, 160, 0, 0, 0),
	(31, 152, 0, 0, 0),
	(32, 160, 0, 0, 0),
	(33, 160, 0, 0, 40),
	(34, 160, 1, 1, 0),
	(35, 160, 3, 2, 80),
	(36, 160, 6, 2, 0),
	(37, 160, 2, 1, 80),
	(38, 160, 7, 3, 0),
	(39, 160, 8, 2, 80),
	(40, 160, 4, 3, 0),
	(41, 160, 5, 4, 80),
	(42, 160, 5, 2, 0),
	(43, 160, 2, 1, 0),
	(44, 160, 8, 2, 80),
	(45, 160, 0, 0, 0),
	(46, 160, 9, 4, 0),
	(47, 160, 3, 1, 80),
	(48, 160, 0, 0, 0),
	(49, 160, 0, 0, 0),
	(50, 160, 0, 0, 0),
	(51, 160, 0, 0, 0),
	(52, 160, 12, 4, 0),
	(53, 160, 0, 0, 0),
	(54, 160, 15, 5, 90),
	(55, 160, 0, 0, 0),
	(56, 152, 12, 6, 30),
	(57, 160, 0, 0, 0),
	(58, 160, 0, 0, 0),
	(59, 160, 0, 0, 0),
	(60, 160, 0, 0, 0);

-- Copiando estrutura para tabela folha_pagamento.beneficiario
CREATE TABLE IF NOT EXISTS `beneficiario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `dataNascimento` date NOT NULL,
  `id_funcionario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `Beneficiário_fk3` (`id_funcionario`),
  CONSTRAINT `Beneficiário_fk3` FOREIGN KEY (`id_funcionario`) REFERENCES `funcionario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Copiando dados para a tabela folha_pagamento.beneficiario: ~21 rows (aproximadamente)
INSERT IGNORE INTO `beneficiario` (`id`, `nome`, `dataNascimento`, `id_funcionario`) VALUES
	(1, 'João Victor Alves', '2017-10-29', 13),
	(2, 'Bianca Fernanda Costa', '2018-03-14', 18),
	(3, 'Gustavo Felipe Oliveira', '2019-07-01', 18),
	(13, 'Mariana Luiza Santos', '2020-01-22', 16),
	(14, 'Felipe Vinicius Castro', '2021-08-09', 18),
	(15, 'Amanda Gabriela Lima', '2022-05-04', 20),
	(16, 'Julia Mariana Rodrigues', '2023-12-16', 22),
	(17, 'Leonardo Eduardo Ferreira', '2024-02-27', 24),
	(18, 'Manuela Isadora Costa', '2008-10-08', 31),
	(19, 'Arthur Rafael Lima', '2010-02-15', 32),
	(20, 'Sofia Valentina Oliveira', '2011-07-10', 33),
	(21, 'João Miguel Oliveira Santos', '2012-08-23', 35),
	(22, 'Sofia da Silva Pereira', '2013-04-06', 36),
	(23, 'Lucas Gabriel Souza Costa', '2014-09-18', 43),
	(24, 'Maria Clara Almeida Rodrigues', '2024-01-02', 43),
	(25, 'Pedro Henrique Cardoso Ferreira', '2016-11-11', 46),
	(26, 'Ana Luísa Pereira Gomes', '2024-03-26', 52),
	(27, 'Matheus Oliveira Martins', '2018-06-13', 53),
	(28, 'Lara Beatriz Castro Lima', '2019-12-30', 53),
	(29, 'Gabriel Santos Costa', '2020-08-07', 56),
	(30, 'Isabela Oliveira Lima', '2023-05-25', 57);

-- Copiando estrutura para tabela folha_pagamento.beneficios_fixos
CREATE TABLE IF NOT EXISTS `beneficios_fixos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `FGTS` tinyint(1) NOT NULL,
  `Adiantamento` tinyint(1) NOT NULL,
  `Descontos_Judiciais` tinyint(1) NOT NULL,
  `Vale_Transporte` tinyint(1) NOT NULL,
  `Vale_Alimentacao` tinyint(1) NOT NULL,
  `Adicional_Tempo_Servico` tinyint(1) NOT NULL,
  `Diaria_Viagem` tinyint(1) NOT NULL,
  `Faltas` tinyint(1) NOT NULL,
  `Atrasos` tinyint(1) NOT NULL,
  `Hora_Extra` tinyint(1) NOT NULL,
  `Comissao` tinyint(1) NOT NULL,
  `Salario_Familia` tinyint(1) NOT NULL,
  `DSR` tinyint(1) NOT NULL,
  `INSS` tinyint(1) NOT NULL,
  `CS` tinyint(1) NOT NULL,
  `IRRF` tinyint(1) NOT NULL,
  `Auxílio_creche` tinyint(1) NOT NULL,
  `Salario_maternidade` tinyint(1) NOT NULL,
  `Adicional_noturno` tinyint(1) NOT NULL,
  `Insalubridade` tinyint(1) NOT NULL,
  `Periculosidade` tinyint(1) NOT NULL,
  `id_banco_de_horas` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `Beneficios_fixos_fk22` (`id_banco_de_horas`),
  CONSTRAINT `Beneficios_fixos_fk22` FOREIGN KEY (`id_banco_de_horas`) REFERENCES `banco_de_horas` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Copiando dados para a tabela folha_pagamento.beneficios_fixos: ~60 rows (aproximadamente)
INSERT IGNORE INTO `beneficios_fixos` (`id`, `FGTS`, `Adiantamento`, `Descontos_Judiciais`, `Vale_Transporte`, `Vale_Alimentacao`, `Adicional_Tempo_Servico`, `Diaria_Viagem`, `Faltas`, `Atrasos`, `Hora_Extra`, `Comissao`, `Salario_Familia`, `DSR`, `INSS`, `CS`, `IRRF`, `Auxílio_creche`, `Salario_maternidade`, `Adicional_noturno`, `Insalubridade`, `Periculosidade`, `id_banco_de_horas`) VALUES
	(1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1),
	(2, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 2),
	(3, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 3),
	(4, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 4),
	(5, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 5),
	(6, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 6),
	(7, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 7),
	(8, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 8),
	(9, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 9),
	(10, 1, 1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 10),
	(11, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 11),
	(12, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 12),
	(13, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 13),
	(14, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 14),
	(15, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 15),
	(16, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 16),
	(17, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 17),
	(18, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 18),
	(19, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 19),
	(20, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 20),
	(21, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 21),
	(22, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 22),
	(23, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 23),
	(24, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 24),
	(25, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 25),
	(26, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 26),
	(27, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 27),
	(28, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 28),
	(29, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 29),
	(30, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 30),
	(31, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 31),
	(32, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 32),
	(33, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 33),
	(34, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 34),
	(35, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 35),
	(36, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 36),
	(37, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 37),
	(38, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 38),
	(39, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 39),
	(40, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 40),
	(41, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 41),
	(42, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 42),
	(43, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 43),
	(44, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 44),
	(45, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 45),
	(46, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 46),
	(47, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 47),
	(48, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 48),
	(49, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 49),
	(50, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 50),
	(51, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 51),
	(52, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 52),
	(53, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 53),
	(54, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 54),
	(55, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 55),
	(56, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 56),
	(57, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 57),
	(58, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 58),
	(59, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 59),
	(60, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 60);

-- Copiando estrutura para tabela folha_pagamento.dias_faltados
CREATE TABLE IF NOT EXISTS `dias_faltados` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data` date NOT NULL,
  `id_beneficios_fixos` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `dias_faltados_fk2` (`id_beneficios_fixos`),
  CONSTRAINT `dias_faltados_fk2` FOREIGN KEY (`id_beneficios_fixos`) REFERENCES `beneficios_fixos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Copiando dados para a tabela folha_pagamento.dias_faltados: ~6 rows (aproximadamente)
INSERT IGNORE INTO `dias_faltados` (`id`, `data`, `id_beneficios_fixos`) VALUES
	(1, '2024-03-18', 10),
	(2, '2024-03-19', 17),
	(3, '2024-03-22', 17),
	(4, '2024-03-22', 26),
	(5, '2024-03-25', 31),
	(6, '2024-03-27', 56);

-- Copiando estrutura para tabela folha_pagamento.empregador
CREATE TABLE IF NOT EXISTS `empregador` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `cnpj` varchar(255) NOT NULL,
  `id_endereco` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `Empregador_fk3` (`id_endereco`),
  CONSTRAINT `Empregador_fk3` FOREIGN KEY (`id_endereco`) REFERENCES `endereço` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Copiando dados para a tabela folha_pagamento.empregador: ~3 rows (aproximadamente)
INSERT IGNORE INTO `empregador` (`id`, `nome`, `cnpj`, `id_endereco`) VALUES
	(1, 'Rede JonasTelinhas de Televisão', '12.345.678/0001-90', 62),
	(2, 'RodoJonas LTDA', '98.765.432/0001-21', 63),
	(3, 'JonasAlturas Airlines S.A', '23.456.789/0001-54', 64);

-- Copiando estrutura para tabela folha_pagamento.endereço
CREATE TABLE IF NOT EXISTS `endereço` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rua` varchar(255) NOT NULL,
  `numero` int(11) NOT NULL,
  `bairro` varchar(255) NOT NULL,
  `complemento` varchar(255) NOT NULL,
  `cidade` varchar(255) NOT NULL,
  `estado` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Copiando dados para a tabela folha_pagamento.endereço: ~64 rows (aproximadamente)
INSERT IGNORE INTO `endereço` (`id`, `rua`, `numero`, `bairro`, `complemento`, `cidade`, `estado`) VALUES
	(1, 'Rua das Flores', 100, 'Jardim Esplanada', 'Apto 101', 'São José dos Campos', 'SP'),
	(2, 'Avenida do Sol', 500, 'Jardim das Indústrias', 'Casa 2', 'São José dos Campos', 'SP'),
	(3, 'Praça da Liberdade', 300, 'Vila Ema', 'Sala 202', 'São José dos Campos', 'SP'),
	(4, 'Travessa dos Cedros', 700, 'Urbanova', 'Loja 1', 'São José dos Campos', 'SP'),
	(5, 'Rua dos Girassóis', 1, 'Vila Betânia', 'Sala 10', 'São José dos Campos', 'SP'),
	(6, 'Avenida dos Ipês', 250, 'Bosque dos Eucaliptos', 'Fundos', 'São José dos Campos', 'SP'),
	(7, 'Alameda das Acácias', 1500, 'Jardim América', 'Bloco B', 'São José dos Campos', 'SP'),
	(8, 'Rua das Palmeiras', 800, 'Jardim Oriente', 'Galpão 3', 'São José dos Campos', 'SP'),
	(9, 'Praça Central', 450, 'Jardim Alvorada', 'Casa 3', 'São José dos Campos', 'SP'),
	(10, 'Travessa das Margaridas', 600, 'Vila Industrial', 'Apartamento 404', 'São José dos Campos', 'SP'),
	(11, 'Rua dos Pinheiros', 901, 'Vila Tesouro', 'Flat 207', 'São José dos Campos', 'SP'),
	(12, 'Avenida das Rosas', 5432, 'Jardim Uirá', 'Próximo a igreja', 'São José dos Campos', 'SP'),
	(13, 'Rua das Violetas', 9876, 'Santa Mônica', 'Sala Comercial 12', 'Uberlândia', 'MG'),
	(14, 'Praça São Pedro', 210, 'Jardim América', 'Sobrado Amarelo', 'Uberlândia', 'MG'),
	(15, 'Alameda dos Flamboyants', 7654, 'Lídice', 'Casa dos Sonhos', 'Uberlândia', 'MG'),
	(16, 'Rua das Orquídeas', 234, 'Morada da Colina', 'Apartamento Vista Mar', 'Uberlândia', 'MG'),
	(17, 'Avenida das Magnólias', 8902, 'Tibery', 'Sobrado dos Pinheiros', 'Uberlândia', 'MG'),
	(18, 'Travessa das Hortênsias', 9870, 'Martins', 'Edifício Primavera', 'Uberlândia', 'MG'),
	(19, 'Rua dos Lírios', 543, 'Fundinho', 'Loft Moderno', 'Uberlândia', 'MG'),
	(20, 'Praça dos Bandeirantes', 876, 'Granada', 'Casa de Campo', 'Uberlândia', 'MG'),
	(21, 'Avenida das Gaivotas', 9012, 'Umuarama', 'Sobrado Azul', 'Uberlândia', 'MG'),
	(22, 'Rua das Begônias', 6780, 'Custódio Pereira', 'Galpão Industrial', 'Uberlândia', 'MG'),
	(23, 'Alameda dos Jacarandás', 5430, 'Umuarama', 'Apartamento Luxo', 'Uberlândia', 'MG'),
	(24, 'Rua das Margaridas', 2109, 'Vila Americana', 'Casa A', 'Volta Redonda', 'RJ'),
	(25, 'Avenida Brasil', 765, 'Vila Santa Maria', 'Apto 2', 'Volta Redonda', 'RJ'),
	(26, 'Rua dos Girassóis', 432, 'Vila Santa Rita', 'Loja 3', 'Volta Redonda', 'RJ'),
	(27, 'Alameda das Acácias', 7890, 'Conforto', 'Sala 4', 'Volta Redonda', 'RJ'),
	(28, 'Rua das Orquídeas', 9871, 'Monte Castelo', 'Casa 5', 'Volta Redonda', 'RJ'),
	(29, 'Avenida das Palmeiras', 2346, 'Vila Brasília', 'Fundos', 'Volta Redonda', 'RJ'),
	(30, 'Praça da Matriz', 2108, 'Três Poços', 'Bloco B', 'Volta Redonda', 'RJ'),
	(31, 'Rua Niterói', 9875, 'Santo Agostinho', 'Galpão 6', 'Volta Redonda', 'RJ'),
	(32, 'Avenida dos Sabiás', 8903, 'Jardim Paraíba', 'Casa 7', 'Volta Redonda', 'RJ'),
	(33, 'Avenida dos Ipês', 8765, 'Vila Elmira', 'Apartamento 8', 'Volta Redonda', 'RJ'),
	(34, 'Rua dos Antúrios', 4320, 'Vila Julieta', 'Edifício do Centro', 'Volta Redonda', 'RJ'),
	(35, 'Praça das Oliveiras', 6781, 'Vila São João', 'Sobrado Vermelho', 'Volta Redonda', 'RJ'),
	(36, 'Alameda dos Colibris', 5431, 'Retiro', 'Apartamento do Bosque', 'Volta Redonda', 'RJ'),
	(37, 'Rua das Margaridas', 9872, 'São Geraldo', 'Residencial das Águas', 'Volta Redonda', 'RJ'),
	(38, 'Avenida das Hortênsias', 7891, 'Niterói', 'Chalé da Floresta', 'Volta Redonda', 'RJ'),
	(39, 'Travessa dos Girassóis', 6543, 'Jardim Amália', 'Loft Urbano', 'Volta Redonda', 'RJ'),
	(40, 'Rua dos Ipês', 8904, 'Sessenta', 'Casa da Cidade', 'Volta Redonda', 'RJ'),
	(41, 'Praça das Palmeiras', 7650, 'Vila Mury', 'Sobrado da Praia', 'Volta Redonda', 'RJ'),
	(42, 'Alamedadas Azaléias', 5433, 'Vila Americana', 'Apartamento das Colinas', 'Volta Redonda', 'RJ'),
	(43, 'Rua dos Crisântemos', 8760, 'Vila Santa Maria', 'Casa do Riacho', 'Volta Redonda', 'RJ'),
	(44, 'Avenida das Acácias', 4329, 'Vila Santa Rita', 'Residencial das Pedras', 'Volta Redonda', 'RJ'),
	(45, 'Travessa das Dálias', 6782, 'Conforto', 'Loft Contemporâneo', 'Volta Redonda', 'RJ'),
	(46, 'Rua dos Lírios', 7892, 'Monte Castelo', 'Kitnet do Largo', 'Volta Redonda', 'RJ'),
	(47, 'Praça das Rosas', 5434, 'Vila Brasília', 'Sobrado do Campo', 'Volta Redonda', 'RJ'),
	(48, 'Alameda das Bromélias', 8761, 'Três Poços', 'Casa do Jardim', 'Volta Redonda', 'RJ'),
	(49, 'Rua das Begônias', 8905, 'Santo Agostinho', 'Edifício do Mar', 'Volta Redonda', 'RJ'),
	(50, 'Avenida das Violetas', 654, 'Jardim Paraíba', 'Apartamento dos Coqueiros', 'Volta Redonda', 'RJ'),
	(51, 'Travessa dos Pinheiros', 8762, 'Vila Elmira', 'Loft Industrial Chic', 'Volta Redonda', 'RJ'),
	(52, 'Rua das Orquídeas', 5435, 'Vila Julieta', 'Casa da Estrada', 'Volta Redonda', 'RJ'),
	(53, 'Praça dos Jacarandás', 4323, 'Vila São João', 'Residencial da Serra', 'Volta Redonda', 'RJ'),
	(54, 'Alameda dos Ciprestes', 7893, 'Vila Rica', 'Sobrado do Lago', 'Volta Redonda', 'RJ'),
	(55, 'Rua dos Girassóis', 9873, 'São Luiz', 'Loft Rústico', 'Volta Redonda', 'RJ'),
	(56, 'Avenida das Margaridas', 6783, 'Vila Coringa', 'Kitnet do Vale', 'Volta Redonda', 'RJ'),
	(57, 'Travessa das Papoulas', 8906, 'Jardim Amália', 'Casa do Sol', 'Volta Redonda', 'RJ'),
	(58, 'Rua das Hortênsias', 7651, 'Sessenta', 'Apartamento das Flores', 'Volta Redonda', 'RJ'),
	(59, 'Rua das Begônias', 233, 'Santo Agostinho', 'Kitnet do Leandro', 'Volta Redonda', 'RJ'),
	(60, 'Avenida das Violetas', 765, 'Jardim Paraíba', 'Sobrado do Lago', 'Volta Redonda', 'RJ'),
	(61, 'Avenida Marcal', 321, 'Jardim Satélite', 'Sala 58', 'Volta Redonda', 'RJ'),
	(62, 'Avenida Anchieta', 123, 'Jardim Satélite', 'Sala 56', 'São José dos Campos', 'SP'),
	(63, 'Avenida João Naves de Ávila', 1234, 'Centro', 'Sala 101', 'Uberelândia', 'MG'),
	(64, 'Rua Niterói', 456, 'Vila Santa Cecília', 'Sala 106', 'Volta Redonda', 'RJ');

-- Copiando estrutura para tabela folha_pagamento.folha_de_pagamento
CREATE TABLE IF NOT EXISTS `folha_de_pagamento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `FGTS_do_mes` double NOT NULL,
  `Salario_base` double NOT NULL,
  `Base_calculo_INSS` double NOT NULL,
  `Base_calculo_FGTS` double NOT NULL,
  `Base_calculo_IRRF` double NOT NULL,
  `Faixa_IRRF` int(11) NOT NULL,
  `Data_folha` date NOT NULL,
  `Total_vencimento` double NOT NULL,
  `Total_desconto` double NOT NULL,
  `Total_liquido` double NOT NULL,
  `id_funcionario` int(11) NOT NULL,
  `id_empregador` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `Folha_de_pagamento_fk11` (`id_funcionario`),
  KEY `Folha_de_pagamento_fk12` (`id_empregador`),
  CONSTRAINT `Folha_de_pagamento_fk11` FOREIGN KEY (`id_funcionario`) REFERENCES `funcionario` (`id`),
  CONSTRAINT `Folha_de_pagamento_fk12` FOREIGN KEY (`id_empregador`) REFERENCES `empregador` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Copiando dados para a tabela folha_pagamento.folha_de_pagamento: ~60 rows (aproximadamente)
INSERT IGNORE INTO `folha_de_pagamento` (`id`, `FGTS_do_mes`, `Salario_base`, `Base_calculo_INSS`, `Base_calculo_FGTS`, `Base_calculo_IRRF`, `Faixa_IRRF`, `Data_folha`, `Total_vencimento`, `Total_desconto`, `Total_liquido`, `id_funcionario`, `id_empregador`) VALUES
	(1, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 1, 1),
	(2, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 2, 1),
	(3, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 3, 1),
	(4, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 4, 1),
	(5, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 5, 1),
	(6, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 6, 1),
	(7, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 7, 1),
	(8, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 8, 1),
	(9, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 9, 1),
	(10, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 10, 1),
	(11, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 11, 1),
	(12, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 12, 1),
	(13, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 13, 2),
	(14, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 14, 2),
	(15, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 15, 2),
	(16, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 16, 2),
	(17, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 17, 2),
	(18, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 18, 2),
	(19, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 19, 2),
	(20, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 20, 2),
	(21, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 21, 2),
	(22, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 22, 2),
	(23, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 23, 3),
	(24, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 24, 3),
	(25, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 25, 3),
	(26, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 26, 3),
	(27, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 27, 3),
	(28, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 28, 3),
	(29, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 29, 3),
	(30, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 30, 3),
	(31, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 31, 3),
	(32, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 32, 3),
	(33, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 33, 3),
	(34, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 34, 3),
	(35, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 35, 3),
	(36, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 36, 3),
	(37, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 37, 3),
	(38, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 38, 3),
	(39, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 39, 3),
	(40, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 40, 3),
	(41, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 41, 3),
	(42, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 42, 3),
	(43, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 43, 3),
	(44, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 44, 3),
	(45, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 45, 3),
	(46, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 46, 3),
	(47, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 47, 3),
	(48, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 48, 3),
	(49, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 49, 3),
	(50, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 50, 3),
	(51, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 51, 3),
	(52, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 52, 3),
	(53, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 53, 3),
	(54, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 54, 3),
	(55, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 55, 3),
	(56, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 56, 3),
	(57, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 57, 3),
	(58, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 58, 3),
	(59, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 59, 3),
	(60, 0, 0, 0, 0, 0, 0, '2024-04-17', 0, 0, 0, 60, 3);

-- Copiando estrutura para tabela folha_pagamento.funcionario
CREATE TABLE IF NOT EXISTS `funcionario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `genero` char(255) NOT NULL,
  `cbo` int(11) NOT NULL,
  `cargo` varchar(255) NOT NULL,
  `funcao` varchar(255) NOT NULL,
  `categoria` varchar(255) NOT NULL,
  `admissao` date NOT NULL,
  `salario_base` double NOT NULL,
  `data_nascimento` date NOT NULL,
  `id_beneficios_fixos` int(11) NOT NULL,
  `id_empregador` int(11) NOT NULL,
  `id_endereco` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `Funcionario_fk10` (`id_beneficios_fixos`),
  KEY `Funcionario_fk11` (`id_empregador`),
  KEY `Funcionario_fk12` (`id_endereco`),
  CONSTRAINT `Funcionario_fk10` FOREIGN KEY (`id_beneficios_fixos`) REFERENCES `beneficios_fixos` (`id`),
  CONSTRAINT `Funcionario_fk11` FOREIGN KEY (`id_empregador`) REFERENCES `empregador` (`id`),
  CONSTRAINT `Funcionario_fk12` FOREIGN KEY (`id_endereco`) REFERENCES `endereço` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Copiando dados para a tabela folha_pagamento.funcionario: ~60 rows (aproximadamente)
INSERT IGNORE INTO `funcionario` (`id`, `nome`, `genero`, `cbo`, `cargo`, `funcao`, `categoria`, `admissao`, `salario_base`, `data_nascimento`, `id_beneficios_fixos`, `id_empregador`, `id_endereco`) VALUES
	(1, 'Aurora Valentina Ribeiro', 'F', 261210, 'Apresentador de Telejornal', 'Apresentar Notícias', 'empregado_contratado', '2012-08-01', 10000, '1989-03-10', 1, 1, 1),
	(2, 'Enzo Gabriel Pereira', 'M', 262415, 'Editor de Vídeo', 'Edição de material audiovisual', 'empregado_contratado', '2016-06-15', 7500, '1995-09-14', 2, 1, 2),
	(3, 'Isadora Beatriz da Silva', 'F', 261105, 'Repórter de Campo', 'Entrevistar', 'empregado_contratado', '2017-03-22', 6000, '1988-12-28', 3, 1, 3),
	(4, 'Dante Matheus Oliveira', 'M', 262410, 'Produtor de Programas', 'Planejamento de conteúdo', 'empregado_contratado', '2016-10-10', 8000, '1981-08-22', 4, 1, 4),
	(5, 'Catarina Luna Barbosa', 'F', 262310, 'Diretor de Fofocas', 'Intrometer-se na vida dos outros', 'segurado_empregado', '2014-12-05', 12000, '1993-06-01', 5, 1, 5),
	(6, 'Valentim Augusto Santos', 'M', 521110, 'Vendedor de Propagandas', 'Vender Propagandas', 'empregado_contratado', '2018-05-03', 8500, '1998-01-11', 6, 1, 6),
	(7, 'Ayla Giovanna Almeida', 'F', 214305, 'Engenheiro de Transmissão', 'Manutenção de equipamentos de transmissão', 'empregado_contratado', '2013-11-20', 7800, '1990-11-23', 7, 1, 7),
	(8, 'Leandro Rafael Costa', 'M', 261105, 'Reporter Investigativo', 'Investigação jornalística', 'contribuinte_individual', '2016-09-08', 6500, '1986-02-05', 8, 1, 8),
	(9, 'Elisa Mariana Carvalho', 'F', 142320, 'Segurança', 'Vigiar entrada e saída de pessoas', 'trabalhador_avulso', '2017-07-04', 7200, '1984-05-21', 9, 1, 9),
	(10, 'Gael Henrique Fernandes', 'M', 254105, 'Assistente de Produção', 'Suporte administrativo', 'empregado_contratado', '2018-02-12', 4500, '1996-10-09', 10, 1, 10),
	(11, 'Joel Leandro da Mata', 'M', 519120, 'Instalador de Antenas', 'Instalar antenas em torres', 'empregado_contratado', '2011-11-11', 5000, '1997-04-18', 11, 1, 11),
	(12, 'Anabele Medeiros Schmidt', 'F', 375110, 'Técnico de Iluminação', 'Organizar os Equipamentos de Iluminação', 'empregado_contratado', '2012-12-12', 1500, '1980-07-04', 12, 1, 12),
	(13, 'Bianca Rafaela Cardoso', 'F', 782305, 'Motorista de Caminhão', 'Condução de caminhões', 'contribuinte_individual', '2019-04-30', 7000, '1992-03-06', 13, 2, 13),
	(14, 'Leonardo Xavier Gomes', 'M', 521110, 'Vendedor de Cargas', 'Organização de cargas', 'empregado_contratado', '2019-08-18', 4500, '1999-12-02', 14, 2, 14),
	(15, 'Estela Isabela Lima', 'F', 142125, 'Coordenador de Frota', 'Gestão da frota de caminhões', 'empregado_contratado', '2017-10-09', 1412, '1987-09-15', 15, 2, 15),
	(16, 'Cristiano Matias Castro', 'M', 313205, 'Técnico de Manutenção', 'Manutenção preventiva e corretiva de veículos', 'empregado_contratado', '2015-04-25', 3500, '1994-08-17', 16, 2, 16),
	(17, 'Jonas Maciel Vieira', 'M', 848410, 'Testador de Pisca-Alerta', 'Testar todos os piscas-alertas', 'empregado_contratado', '2020-01-07', 1600, '1991-01-19', 17, 2, 17),
	(18, 'Thalia Otávia Rocha', 'F', 782510, 'Operador de Empilhadeira', 'Movimentação de cargas nos armazéns', 'empregado_contratado', '2019-11-16', 6000, '1983-11-27', 18, 2, 18),
	(19, 'Elara Sabrina Santos', 'F', 241005, 'Analista de Rotas', 'Planejamento de rotas eficientes', 'segurado_empregado', '2017-09-22', 6500, '1985-06-29', 19, 2, 19),
	(20, 'Davi Luca Martins', 'M', 354220, 'Mecânico', 'Manutenção de Veículos', 'empregado_contratado', '2016-07-13', 10000, '1990-04-24', 20, 2, 20),
	(21, 'Melina Fernanda Moreira', 'F', 142320, 'Segurança', 'Implementação de medidas de segurança', 'trabalhador_avulso', '2018-05-29', 15000, '1982-10-30', 21, 2, 21),
	(22, 'Luca Giovanni Faria', 'M', 214105, 'Gerente de Operações', 'Gerenciamento geral das operações da transportadora', 'empregado_contratado', '2012-11-03', 5000, '1998-08-12', 22, 2, 22),
	(23, 'Thaís Camila Rodrigues', 'F', 514205, 'Piloto Comandante', 'Operação segura da aeronave', 'empregado_contratado', '2010-09-04', 8000, '1981-05-13', 23, 3, 23),
	(24, 'Gabriel Enrico Souza', 'M', 314105, 'Comissário de Bordo', 'Atendimento aos passageiros', 'empregado_contratado', '2013-07-17', 3500, '1988-01-31', 24, 3, 24),
	(25, 'Marina Aparecida Menezes', 'F', 517210, 'Técnico de Manutenção de Aeronaves', 'Realização de manutenção preventiva e corretiva nas aeronaves', 'empregado_contratado', '2011-05-28', 6500, '1999-06-27', 25, 3, 25),
	(26, 'Luca Samuel Pereira', 'M', 411010, 'Agente de Aeroporto', 'Atendimento ao cliente', 'empregado_contratado', '2014-11-19', 10000, '1993-07-08', 26, 3, 26),
	(27, 'Rafaella Juliana Santana', 'F', 142320, 'Segurança', 'Vigiar entrada e saída de pessoas', 'empregado_contratado', '2019-06-06', 32500, '1986-09-05', 27, 3, 27),
	(28, 'Lucas Davi Mendes', 'M', 521110, 'Vendedor de Aeronaves', 'Coordenação das operações no aeroporto', 'empregado_contratado', '2008-12-23', 6000, '1991-12-26', 28, 3, 28),
	(29, 'Marcelo Moreno', 'M', 519110, 'Limpador de Para-Brisas Externo', 'Limpar o para-brisa externo do avião enquanto está voando', 'empregado_contratado', '2018-10-27', 14000, '1997-02-25', 29, 3, 29),
	(30, 'Joaquim Antônio Pereira', 'M', 222505, 'Despachante de Voo', 'Preparação de documentação e autorizações para voos', 'empregado_contratado', '2015-06-14', 9000, '1982-08-07', 30, 3, 30),
	(31, 'Rafaela Isabela Duarte', 'F', 51530, 'Gerente de Serviços de Bordo', 'Gestão da equipe de comissários de bordo', 'empregado_contratado', '2011-05-03', 10000, '1995-03-16', 31, 3, 31),
	(32, 'Tomás Henrique Lopes', 'M', 214210, 'Especialista em Navegação Aérea', 'Monitoramento do tráfego aéreo', 'segurado_empregado', '2009-01-02', 8000, '1987-10-03', 32, 3, 32),
	(33, 'Laura Manuela Silva', 'F', 514205, 'Piloto Comandante', 'Operação segura da aeronave', 'empregado_contratado', '2003-04-12', 5000, '1984-12-09', 33, 3, 33),
	(34, 'Camila Gabriela Santos', 'F', 514205, 'Piloto Comandante', 'Operação segura da aeronave', 'empregado_contratado', '2005-09-25', 5000, '1983-02-04', 34, 3, 34),
	(35, 'Mariana Beatriz Lima', 'F', 514205, 'Piloto Comandante', 'Operação segura da aeronave', 'empregado_contratado', '2008-07-08', 5000, '1992-05-30', 35, 3, 35),
	(36, 'Amanda Vitória Costa', 'F', 512305, 'Comissária de Bordo', 'Atender Passageiros Durante o Voo', 'empregado_contratado', '2010-01-19', 5000, '1985-07-20', 36, 3, 36),
	(37, 'Letícia Juliana Oliveira', 'F', 512305, 'Comissária de Bordo', 'Atender Passageiros Durante o Voo', 'empregado_contratado', '2012-08-03', 5000, '1994-09-07', 37, 3, 37),
	(38, 'Isabella Sofia Pereira', 'F', 512305, 'Comissária de Bordo', 'Atender Passageiros Durante o Voo', 'empregado_contratado', '2014-03-17', 5000, '1996-01-28', 38, 3, 38),
	(39, 'Ana Luiza Fernandes', 'F', 512305, 'Comissária de Bordo', 'Atender Passageiros Durante o Voo', 'empregado_contratado', '2016-11-29', 5000, '1980-03-26', 39, 3, 39),
	(40, 'Clara Heloísa Almeida', 'F', 512305, 'Comissária de Bordo', 'Atender Passageiros Durante o Voo', 'empregado_contratado', '2018-06-06', 5000, '1990-10-15', 40, 3, 40),
	(41, 'Eduarda Alice Ribeiro', 'F', 512305, 'Comissária de Bordo', 'Atender Passageiros Durante o Voo', 'empregado_contratado', '2004-02-23', 5000, '1998-06-03', 41, 3, 41),
	(42, 'Sophia Yasmin Cardoso', 'F', 512305, 'Comissária de Bordo', 'Atender Passageiros Durante o Voo', 'empregado_contratado', '2006-10-10', 5000, '1989-04-16', 42, 3, 42),
	(43, 'Giovanna Valentina Gomes', 'F', 512305, 'Comissária de Bordo', 'Atender Passageiros Durante o Voo', 'empregado_contratado', '2009-05-01', 5000, '1993-11-06', 43, 3, 43),
	(44, 'Lorena Raquel Martins', 'F', 512305, 'Comissária de Bordo', 'Atender Passageiros Durante o Voo', 'empregado_contratado', '2011-12-14', 5000, '1988-07-01', 44, 3, 44),
	(45, 'Bianca Bruna Rodrigues', 'F', 512305, 'Comissária de Bordo', 'Atender Passageiros Durante o Voo', 'empregado_contratado', '2013-08-27', 5000, '1981-09-12', 45, 3, 45),
	(46, 'Cecília Beatriz Dias', 'F', 512305, 'Comissária de Bordo', 'Atender Passageiros Durante o Voo', 'empregado_contratado', '2015-04-09', 5000, '1986-12-20', 46, 3, 46),
	(47, 'Carolina Eloá Sousa', 'F', 512305, 'Comissária de Bordo', 'Atender Passageiros Durante o Voo', 'empregado_contratado', '2017-11-20', 5000, '1995-05-25', 47, 3, 47),
	(48, 'Fernanda Isabela Costa', 'F', 514320, 'Zeladora', 'Realizar a Limpeza dos Estabelecimentos', 'empregado_contratado', '2003-04-12', 2000, '1991-03-31', 48, 3, 48),
	(49, 'Natália Gabriela Lima', 'F', 514320, 'Zeladora', 'Realizar a Limpeza dos Estabelecimentos', 'empregado_contratado', '2005-09-25', 2000, '1997-10-21', 49, 3, 49),
	(50, 'Eloah Manuela Santos', 'F', 514320, 'Zeladora', 'Realizar a Limpeza dos Estabelecimentos', 'empregado_contratado', '2008-07-08', 2000, '1982-04-13', 50, 3, 50),
	(51, 'Vanessa Rafaela Oliveira', 'F', 514320, 'Zeladora', 'Realizar a Limpeza dos Estabelecimentos', 'empregado_contratado', '2010-01-19', 2000, '1999-08-30', 51, 3, 51),
	(52, 'Heloísa Eduarda Silva', 'F', 513405, 'Cozinheira de Bordo', 'Fazer Refeição para os Passageiros', 'empregado_contratado', '2012-08-03', 3500, '1987-01-08', 52, 3, 52),
	(53, 'Marina Bianca Pereira', 'F', 513405, 'Cozinheira de Bordo', 'Fazer Refeição para os Passageiros', 'empregado_contratado', '2014-03-17', 3500, '1992-08-18', 53, 3, 53),
	(54, 'Bruna Lorena Almeida', 'F', 422105, 'Recepcionista', 'Recepcionar os viajantes', 'empregado_contratado', '2016-11-29', 2500, '1984-11-14', 54, 3, 54),
	(55, 'Valentina Sophia Ribeiro', 'F', 422105, 'Recepcionista', 'Recepcionar os viajantes', 'segurado_empregado', '2018-06-06', 2500, '1997-10-09', 55, 3, 55),
	(56, 'Letícia Beatriz Gomes', 'F', 422105, 'Recepcionista', 'Recepcionar os viajantes', 'empregado_contratado', '2004-02-23', 2500, '1996-12-22', 56, 3, 56),
	(57, 'Isadora Carolina Martins', 'F', 422105, 'Recepcionista', 'Recepcionar os viajantes', 'empregado_contratado', '2006-10-10', 2500, '1985-02-01', 57, 3, 57),
	(58, 'Júlia Amanda Rodrigues', 'F', 354125, 'Agente de Viagens', 'Auxiliar os clientes a realizar viagens', 'empregado_contratado', '2009-05-01', 4000, '1994-06-11', 58, 3, 58),
	(59, 'Vitoria Fagundes', 'F', 354125, 'Agente de Viagens', 'Auxiliar os clientes a realizar viagens', 'empregado_contratado', '2004-02-23', 4000, '1993-02-19', 59, 3, 59),
	(60, 'Dioga Alveres', 'F', 354125, 'Agente de Viagens', 'Auxiliar os clientes a realizar viagens', 'empregado_contratado', '2004-02-23', 4000, '1992-12-17', 60, 3, 60);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
