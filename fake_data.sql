-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3307
-- Generation Time: Dec 19, 2022 at 09:42 AM
-- Server version: 5.7.24
-- PHP Version: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;


CREATE TABLE `qcm` (
  `id` int(11) NOT NULL,
  `theme` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `question` (
  `id` int(11) NOT NULL,
  `question` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `id_qcm` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `response` (
  `id` int(11) NOT NULL,
  `content` varchar(255) NOT NULL,
  `is_correct` tinyint(1) NOT NULL,
  `id_question` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `score` (
  `id` int(11) NOT NULL,
  `score` varchar(255) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_qcm` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE `qcm`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `question`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_qcm` (`id_qcm`);

ALTER TABLE `response`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_question` (`id_question`);

ALTER TABLE `score`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_user` (`id_user`),
  ADD KEY `fk_id_qcm` (`id_qcm`);

ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `qcm`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `question`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `response`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `score`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `question`
  ADD CONSTRAINT `fk_qcm` FOREIGN KEY (`id_qcm`) REFERENCES `qcm` (`id`);

ALTER TABLE `response`
  ADD CONSTRAINT `fk_question` FOREIGN KEY (`id_question`) REFERENCES `question` (`id`);

ALTER TABLE `score`
  ADD CONSTRAINT `fk_id_qcm` FOREIGN KEY (`id_qcm`) REFERENCES `qcm` (`id`),
  ADD CONSTRAINT `fk_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

INSERT INTO  `user` (`name`)
VALUES
  ('tran'),
  ('anisse'),
  ('theo');

INSERT INTO `qcm` (`theme`)
VALUES
  ('logique'),
  ('français'),
  ('java');

INSERT INTO `question` (`question`, `type`, `id_qcm`)
VALUES
  ('Quelle est la valeur de `true | false` ?', 'text', '1'),
  ("Combien d'itérations sont réalisées avec cette boucle : `for (i=0, i+=3, i< 7)`", 'text', '1'),
  ('Quelles conditions vérifient que text1 contient plus de caractères que text2', 'text', '1'),
  ('', 'text', '1'),
  ('Quelle est la faute dans la phrase: `Un espèce de bonimenteur ment tellement bizarrement`', 'text', '2'),
  ('Quelle est la bonne orthographe de ce mot', 'text', '2'),
  ('Quel(s) est/sont le(s) synonyme(s) de nonobstant', 'text', '2'),
  ('Conjuguez savoir à la première personne du passé antérieur', 'text', '2'),
  ('Quel est le rôle du repository', 'text', '3'),
  ("Où sont définies les dépendances d'un projet Spring", 'text', '3'),
  ("Comment initialiser une liste d'entiers", 'text', '3');
  
INSERT INTO `response` (`content`, `is_correct`, `id_question`)
VALUES

  ("true", "1", "1"),
  ("false", "0", "1"),
  ("undefined", "0", "1"),

  ("2", "0", "2"),
  ("3", "1", "2"),
  ("4", "0", "2"),
  ("Une infinité", "0", "2"),

  ("text1.length >= text2.length", "0", "3"),
  ("text1.length > text2.length", "1", "3"),
  ("new Array(text1).length >= new Array(text2).length", "0", "3"),
  ("new Array(text1).length > new Array(text2).length", "1", "3"),

  ("a", "text", "4"),
  ("b", "text", "4"),
  ("c", "text", "4"),
  ("d", "text", "4"),

  ("bonimenteur", "0", "5"),
  ("bizarrement", "0", "5"),
  ("tellement", "0", "5"),
  ("autre", "1", "5"),

  ("conjestioner", "0", "6"),
  ("conjestionner", "0", "6"),
  ("congestioner", "0", "6"),
  ("congestionner", "1", "6"),

  ("À cause de", "0", "7"),
  ("Cependant", "1", "7"),
  ("À l'image de", "0", "7"),
  ("Malgré", "1", "7"),

  ("j'eus su", "1", "8"),
  ("j'aurais su", "0", "8"),
  ("je sus", "0", "8"),
  ("que j'eusse su", "0", "8"),

  ("Pouvoir acceder aux différentes version de Java", "0", "9"),
  ("Associer à un modèle les méthodes classiques dans le contexte d'un MVC", "1", "9"),
  ("Le mot n'a pas de sens pour Java", "1", "9"),
  ("aucune des réponses ci-dessus", "0", "9"),

  ("dans le pom.xml", "0", "10"),
  ("dans un fichier json", "0", "10"),
  ("dans n'importe quel fichier xml en précisant le chemin dans java", "0", "10"),
  ("celà dépend de l'outil bundler utilisé", "1", "10"),

  ("ArrayList<Integer> mon_tableau;", "1", "11"),
  ("Integer[] mon_tableau;", "1", "11"),
  ("int[] mon_tableau;", "1", "11"),
  ("mon_tableau = [0,1,2];", "0", "11");
        