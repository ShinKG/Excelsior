-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 25, 2019 at 05:58 AM
-- Server version: 10.1.35-MariaDB
-- PHP Version: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `webtechfinals_jspquiz`
--

-- --------------------------------------------------------

--
-- Table structure for table `questions`
--

CREATE TABLE `questions` (
  `question_id` int(8) NOT NULL,
  `topic` enum('HTML','CSS','JS') NOT NULL,
  `question` text NOT NULL,
  `option_a` varchar(512) NOT NULL,
  `option_b` varchar(512) NOT NULL,
  `option_c` varchar(512) NOT NULL,
  `option_d` varchar(512) NOT NULL,
  `option_e` varchar(512) NOT NULL,
  `answer` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `questions`
--

INSERT INTO `questions` (`question_id`, `topic`, `question`, `option_a`, `option_b`, `option_c`, `option_d`, `option_e`, `answer`) VALUES
(1, 'HTML', 'Designed to enable communication between the client and a server.', 'HTML', 'HTTP', 'DOCTYPE', 'FTP', 'RFC', 'B'),
(2, 'HTML', 'The first official default character set in the Windows OS.', 'ANSI', 'ASCII', 'ASSI', 'ASKI', 'ASNI', 'A'),
(3, 'HTML', 'The language used in mark up documents.', 'XML', 'XHTML', 'MathML', 'HTML', 'PHP', 'D'),
(4, 'HTML', 'Used to draw graphics via scripting.', 'HTML5 Canvas', 'HTML5 Context', 'HTML5 Draw', 'HTML5 Graphics', 'HTML5 Art', 'A'),
(5, 'HTML', 'Specifies the visible width of a text area.', 'border', 'cite', 'borderspan', 'colspan', 'cols', 'E'),
(6, 'HTML', 'Declarative header section that contains the document metadata.', 'DOCTYPE', 'Attributes', 'Root Element', 'Values', 'HEAD', 'C'),
(7, 'HTML', 'Specifies the title of the text track.', '', 'list', 'ismap', 'lang', 'title', 'A'),
(8, 'HTML', 'Defines information about the document.', '<title>', '<head>', '<html>', '<body>', '<header>', 'B'),
(9, 'HTML', 'Typically provided as key=value pairs with ampersand (&) separators between key/value pairs.', 'Path', 'Scheme', 'Authority', 'Query', 'Metadata', 'D'),
(10, 'HTML', 'Specifies extra information about an element.', 'translate', 'meta', 'spellcheck', 'tabindex', 'title', 'E'),
(11, 'HTML', 'Returns the URL of the current audio/video resource.', 'crossOrigin', 'controls', 'currentSrc', 'Controller', 'model', 'C'),
(12, 'HTML', 'Removes the association between the target resource and its current functionality.', 'DELETE', 'REMOVE', 'POST', 'GET', 'REM', 'A'),
(13, 'HTML', 'Another term for message body.', 'Empty Line', 'Request Target', 'Status Code', 'Payload', 'Body', 'D'),
(14, 'HTML', 'Defines a thematic change in the content.', '<br>', '<h1>', '<hr>', '<h6>', '<tr>', 'C'),
(15, 'HTML', 'Represents the title of an original work.', '<citation>', '<ref>', '<caption>', '<reference>', '<cite>', 'E'),
(16, 'CSS', 'Another term for custom properties.', 'CSS Wide Keywords', 'CSS Values', 'CSS Variables', 'CSS Methods', 'CSS Functions', 'C'),
(17, 'CSS', 'Delimited by single quotes (\') or double quotes (\").', 'Strings', 'Functions', 'Processors', 'Keywords', 'Comments', 'A'),
(18, 'CSS', 'A CSS property that sets the length of time an animation, transition, and other related properties will take to complete.', 'Completion Units', 'Duration', 'Length Units', 'Frequency Units', 'Runtime', 'B'),
(19, 'CSS', 'Provides features that developers expect browsers to provide natively.', 'Framework', 'Polyfill', 'Preprocessor', 'Variable', 'API', 'B'),
(20, 'CSS', 'What does the acronym CSS stand for?', 'Common Style Sheets', 'Control Style Sheets', 'Custom Style Sheets', 'Creativity Style Sheets', 'Cascading Style Sheets', 'E'),
(21, 'CSS', 'The CSS code is written directly within a tag of an HTML document.', 'Inline Styles', 'External Styles', 'Embedded Styles', 'Inner Styles', 'Inter Styles', 'A'),
(22, 'CSS', 'A modern CSS framework with built-in responsiveness.', 'CSS3', 'W.CSS', 'CSS2', 'W3.CSS', 'CSS', 'D'),
(23, 'CSS', 'Specifies a length relative to another length property.', 'Absolute Length', 'Alternative Length', 'Relative Length', 'Counter Length', 'Relational Length', 'C'),
(24, 'CSS', 'Language used to specify the presentation of structurally marked up documents.', 'CSS', 'SSL', 'W3C', 'CSL', 'PHP', 'A'),
(25, 'CSS', 'Another term for vendor specific extensions.', 'Vendor Properties', 'Vendor Values', 'Vendor Types', 'Vendor Variables', 'Vendor Prefixes', 'E'),
(26, 'CSS', 'Integers or real numbers in decimal notation.', 'Numbers', 'Values', 'Units', 'Time', 'Decimals', 'A'),
(27, 'CSS', 'CSS code that is separated and filled with CSS instructions.', 'Outer Style Sheet', 'Internal Style Sheet', 'External Style Sheet', 'Inline Style Sheet', 'Extended Style Sheet', 'C'),
(28, 'CSS', 'Relative to the font size of the root element.', 'ex', 'em', 'rem', 'vmin', 'remx', 'C'),
(29, 'CSS', 'Creates or resets a counter.', 'reset', 'counter-reset', 'counter-increment', 'counter-remove', 'restart', 'B'),
(30, 'CSS', 'This property will add space inside a text field.', 'float', 'align', 'overflow', 'spacing', 'padding', 'E');

-- --------------------------------------------------------

--
-- Table structure for table `results`
--

CREATE TABLE `results` (
  `result_id` int(8) NOT NULL,
  `topic` varchar(256) NOT NULL,
  `category` enum('5','10','15') NOT NULL,
  `score` int(4) NOT NULL,
  `evaluation` enum('PASS','FAIL') NOT NULL,
  `user` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `questions`
--
ALTER TABLE `questions`
  ADD PRIMARY KEY (`question_id`);

--
-- Indexes for table `results`
--
ALTER TABLE `results`
  ADD PRIMARY KEY (`result_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `questions`
--
ALTER TABLE `questions`
  MODIFY `question_id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `results`
--
ALTER TABLE `results`
  MODIFY `result_id` int(8) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
