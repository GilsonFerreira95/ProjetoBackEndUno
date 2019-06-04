CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  `foto` blob,
  `cargo` varchar(50) DEFAULT NULL,
  `endereco` varchar(100) DEFAULT NULL,
  `horariosTrabalho` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
